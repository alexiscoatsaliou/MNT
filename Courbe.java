package ProjetJava;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.text.DecimalFormat;
import java.text.ParseException;

import Jama.Matrix; 

public class Courbe extends PlacerPoints{
	double courbeNivLoc;
	DecimalFormat format = new DecimalFormat("#.##");
	static int tabinter[];
	
	public Courbe(){
		tabinter = new int[4];
		if (Recuperateur.CN != null | Recuperateur.CN != "") {
		
			System.out.println("Je suis dedans");
			double pas = echelle;
			
			try {
				 courbeNivLoc = format.parse(Recuperateur.CN).doubleValue();
			 } catch (ParseException e) {
				 e.printStackTrace();
			 }
			
			 for(int i = 0; i < ChargerMNT.m.nline-1; i++) {
				 for(int j = 0 ; j < ChargerMNT.m.ncols-1; j++) {
					 
					 Point pt1 = ChargerMNT.tab[i][j];
					 Point pt2 = ChargerMNT.tab[i][j+1];
					 Point pt3 = ChargerMNT.tab[i+1][j];
					 Point pt4 = ChargerMNT.tab[i+1][j+1];
					 
					 double Xpt1 = j*pas;
					 double Ypt1 = i*pas;
					 double Xpt2 = (j+1) * pas;
					 double Ypt2 = i*pas;
					 double Xpt3 = j*pas;
					 double Ypt3 = (i+1)*pas;
					 double Xpt4 = (j+1) * pas;
					 double Ypt4 = (i+1)*pas;

					 //On crée un triangle que l'
					 double[][] array1 = {{Xpt1, Ypt1, 1},{Xpt2, Ypt2, 1},{Xpt3, Ypt3, 1}};
					 Matrix A = new Matrix(array1);
					 double[][] array2 = {{pt1.getZ()},{ pt2.getZ()}, {pt3.getZ()}};
					 Matrix B = new Matrix(array2);
					 Matrix InvA = A.inverse();
					 Matrix X = InvA.solve(B);
					 double a = X.get(0, 0);
					 double b = X.get(1, 0);
					 double c = X.get(2, 0);
					 double xa = j * pas ;
					 double xb =(j + 1) * pas; 
					 
					 double ya = i * pas + (a*xa)/b + c/b - courbeNivLoc/b;
					 if (ya > i * pas ) {
						 double yb = i*pas + (a*xb)/b + c/b - courbeNivLoc/b;
						 if (yb > i * pas) {
							 double xc = j*pas + (b/(2*a) + c/(2*a) - courbeNivLoc/(2*a));
							 double yc = i*pas + (1 - xc);
							 
							 //g2d.drawLine((int) xa, (int) ya, (int) xc, (int) yc);
							 tabinter[0]= (int)xa; 
							 tabinter[1]= (int)ya;
							 tabinter[2]= (int)xc;
							 tabinter[3]= (int)yc;
						 }
						 else {
							 double yc = i*pas;
							 double xc = j*pas + (courbeNivLoc-c)/a;
							 
							 //g2d.drawLine((int) xa, (int) ya, (int) xc, (int) yc);
							 
							 tabinter[0]= (int)xa; 
							 tabinter[1]= (int)ya;
							 tabinter[2]= (int)xc;
							 tabinter[3]= (int)yc;
						 }
					 }
					 if (ya < i * pas) {
						 double yc = i * pas;
						 double xc = j*pas + (courbeNivLoc-c)/a;
						 double xd = j*pas + ( b/(2*a) + c/(2*a) - courbeNivLoc/(2*a));
						 double yd = i*pas + (1 - xd);
						 
						 //g2d.drawLine((int) xc, (int) yc, (int) xd, (int) yd);
						 
						 tabinter[0]= (int)xc; 
						 tabinter[1]= (int)yc;
						 tabinter[2]= (int)xd;
						 tabinter[3]= (int)yd;
						 
					 }
					 
					 
					 //faire la même chose pour l'autre triangle
					 double[][] array3 = {{Xpt4, Ypt4, 1},{Xpt2, Ypt2, 1},{Xpt3, Ypt3, 1}};
					 Matrix Abis = new Matrix(array3);
					 double[][] array4 = {{pt4.getZ()}, {pt2.getZ()}, {pt3.getZ()}};
					 Matrix Bbis = new Matrix(array4);
					 Matrix InvAbis = Abis.inverse();
					 Matrix Xbis = InvAbis.solve(Bbis);
					 double abis = Xbis.get(0, 0);
					 double bbis = Xbis.get(1, 0);
					 double cbis = Xbis.get(2, 0);
					 double xabis = j * pas ;
					 double xbbis = (j + 1) * pas;
					 double yabis = i * pas + (abis*xabis)/bbis + cbis/bbis - courbeNivLoc/bbis;
					 
					 if(yabis < i*pas) {
						 double ybbis = i*pas + (abis*xbbis)/bbis + cbis/bbis - courbeNivLoc/bbis;
						 if (ybbis < i*pas) {
							 double xcbis = j*pas + ( bbis/(2*abis) + cbis/(2*abis) - courbeNivLoc/(2*abis));
							 double ycbis = i*pas * (1 - xcbis);
							 
							 //g2d.drawLine((int) xcbis, (int) ycbis, (int) xbbis, (int) ybbis);
							 tabinter[0]= (int)xbbis; 
							 tabinter[1]= (int)ybbis;
							 tabinter[2]= (int)xcbis;
							 tabinter[3]= (int)ycbis;
						 }
						 if(ybbis > i*pas) {
							 
							 double xcbis = j*pas + ( bbis/(2*abis) + cbis/(2*abis) - courbeNivLoc/(2*abis));
							 double ycbis = i*pas * (1 - xcbis);							 
							 double ydbis = i*pas;
							 double xdbis = j*pas * (courbeNivLoc - cbis)/abis;
							 
							 //g2d.drawLine((int) xc, (int) yc, (int) xbbis, (int) ybbis);
							 tabinter[0]= (int)xcbis; 
							 tabinter[1]= (int)ycbis;
							 tabinter[2]= (int)xdbis;
							 tabinter[3]= (int)ydbis;
							 
						 }
					 }
					 else {
						 double ydbis = i*pas;
						 double xdbis = j*pas * (courbeNivLoc - cbis)/abis;
						 double ybbis = i*pas + (abis*xbbis)/bbis + cbis/bbis - courbeNivLoc/bbis;
						 
						 //g2d.drawLine((int) xc, (int) yc, (int) xd, (int) yd);
						 
						 tabinter[0]= (int)xbbis; 
						 tabinter[1]= (int)ybbis;
						 tabinter[2]= (int)xdbis;
						 tabinter[3]= (int)ydbis;
						 
						 
					 }
					 
				 }
			 }
			
			 

		}
		this.tabinter = tabinter;
	}
	
	
}