
package ProjetJava;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.text.DecimalFormat;
import java.text.ParseException;

import Jama.Matrix;

public class Courbe {
	double courbeNivLoc;
	DecimalFormat format = new DecimalFormat("#.##");
	
	public void paintComponent(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		double pas = PlacerPoints.echelle;
		g2d.setColor(Color.BLACK);
		
		try {
			 courbeNivLoc = format.parse(Recuperateur.CN).doubleValue();
		 } catch (ParseException e) {
			 e.printStackTrace();
		 }
		
		 for(int i=0; i < ChargerMNT.m.ncols-1; i++) {
			 for(int j=0; j < ChargerMNT.m.nline-1; j++) {
				 
				 Point pt1 = ChargerMNT.tab[i][j];
				 Point pt2 = ChargerMNT.tab[i][j+1];
				 Point pt3 = ChargerMNT.tab[i+1][j];
				 Point pt4 = ChargerMNT.tab[i+1][j+1];
				 
				 
				 double[][] array1 = {{pt1.getX(), pt1.getY(), 1},{pt2.getX(), pt2.getY(), 1},{pt3.getX(), pt3.getY(), 1}};
				 Matrix A = new Matrix(array1);
				 double[][] array2 = {{pt1.getZ(), pt2.getZ(), pt3.getZ()}};
				 Matrix B = new Matrix(array2);
				 Matrix InvA = A.inverse();
				 Matrix X = InvA.solve(B);
				 double a = X.get(0, 0);
				 double b = X.get(1, 0);
				 double c = X.get(2, 0);
				 double xa = i * pas ;
				 double xb = (i + 1) * pas; 
				 
				 double ya = j * pas + (a*xa)/b + c/b - courbeNivLoc/b;
				 if (ya > j * pas ) {
					 double yb = j*pas + (a*xb)/b + c/b - courbeNivLoc/b;
					 if (yb > j * pas) {
						 double xc = i*pas + (b/(2*a) + c/(2*a) - courbeNivLoc/(2*a));
						 double yc = j*pas + (1 - xc);
						 
						 g2d.drawLine((int) xa, (int) ya, (int) xc, (int) yc);
					 }
					 else {
						 double yc = j*pas;
						 double xc = i*pas + (courbeNivLoc-c)/a;
						 
						 g2d.drawLine((int) xa, (int) ya, (int) xc, (int) yc);
					 }
				 }
				 if (ya < j * pas) {
					 double yc = j * pas;
					 double xc = i*pas + (courbeNivLoc-c)/a;
					 double xd = i*pas + ( b/(2*a) + c/(2*a) - courbeNivLoc/(2*a));
					 double yd = j*pas + (1 - xd);
					 
					 g2d.drawLine((int) xc, (int) yc, (int) xd, (int) yd);
					 
				 }
				 
				 
				 //finir la même chose pour l'autre triangle
				 double[][] array3 = {{pt4.getX(), pt4.getY(), 1},{pt2.getX(), pt2.getY(), 1},{pt3.getX(), pt3.getY(), 1}};
				 Matrix Abis = new Matrix(array3);
				 double[][] array4 = {{pt1.getZ(), pt2.getZ(), pt3.getZ()}};
				 Matrix Bbis = new Matrix(array4);
				 Matrix InvAbis = Abis.inverse();
				 Matrix Xbis = InvAbis.solve(Bbis);
				 double abis = Xbis.get(0, 0);
				 double bbis = Xbis.get(1, 0);
				 double cbis = Xbis.get(2, 0);
				 double xabis = i * pas ;
				 double xbbis = (i + 1) * pas;
				 double yabis = j * pas + (a*xabis)/bbis + cbis/bbis - courbeNivLoc/bbis;
				 
				 if(yabis < j*pas) {
					 double ybbis = j*pas + (abis*xbbis)/bbis + cbis/bbis - courbeNivLoc/bbis;
					 if (ybbis < j*pas) {
						 double xcbis = i*pas + ( bbis/(2*abis) + cbis/(2*abis) - courbeNivLoc/(2*abis));
						 double ycbis = 1 - xcbis;
						 
						 g2d.drawLine((int) xcbis, (int) ycbis, (int) xbbis, (int) ybbis);
					 }
					 if(ybbis > j*pas) {
						 double yc = j*pas;
						 double xc = (courbeNivLoc - cbis)/abis;
						 
						 g2d.drawLine((int) xc, (int) yc, (int) xbbis, (int) ybbis);
					 }
				 }
				 else {
					 double yc = j*pas;
					 double xc = (courbeNivLoc - cbis)/abis;
					 double xd = i*pas + ( bbis/(2*abis) + cbis/(2*abis) - courbeNivLoc/(2*abis));
					 double yd = 1 - xc;
					 
					 g2d.drawLine((int) xc, (int) yc, (int) xd, (int) yd);
				 }
				 
			 }
		 }
		
		 

	}

}