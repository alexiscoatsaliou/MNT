
package ProjetJava;

import java.text.DecimalFormat;
import java.text.ParseException;

import Jama.Matrix;

public class Courbe2 extends PlacerPoints{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	double courbeNivLoc;
	DecimalFormat format = new DecimalFormat("#.##");
	int tab1[] = null;
	int tab2[] = null;
	
	
	public Courbe2(Point pt1, Point pt2, Point pt3, Point pt4, int echelle){
		
		
		
		if (Recuperateur.CN != null && Recuperateur.CN != ""){
			System.out.println("Je suis dedans");
			
			try {
				 courbeNivLoc = format.parse(Recuperateur.CN).doubleValue();
			 } catch (ParseException e) {
				 e.printStackTrace();
			 }
			
			
			 double Xpt1 = pt1.getj();
			 double Ypt1 = pt1.geti();
			 double Xpt2 = pt2.getj();
			 double Ypt2 = pt2.geti();
			 double Xpt3 = pt3.getj();
			 double Ypt3 = pt3.geti();
			 double Xpt4 = pt4.getj();
			 double Ypt4 = pt4.geti();
			 
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
			 double xa = Xpt1 ;
			 double xb = Xpt2; 
			 
			 double ya = Ypt1 + (a*Xpt1)/b + c/b - courbeNivLoc/b;
			 if (ya > Ypt1 ) {
				 double yb = Ypt1 + (a*xb)/b + c/b - courbeNivLoc/b;
				 if (yb > Ypt1) {
					 double xd = Xpt1 + (b/(2*a) + c/(2*a) - courbeNivLoc/(2*a));
					 double yd = Ypt1 + (1 - xd);
					 
					 this.tab1[0] = (int) xa;
					 this.tab1[1] = (int) ya;
					 this.tab1[2] = (int) xd;
					 this.tab1[3] = (int) yd;
				 }
				 else {
					 double yc = Ypt1;
					 double xc = Xpt1 + (courbeNivLoc-c)/a;
					 
					 this.tab1[0] = (int) xa;
					 this.tab1[1] = (int) ya;
					 this.tab1[2] = (int) xc;
					 this.tab1[3] = (int) yc;
				 }
			 }
			 if (ya < Ypt1) {
				 double yc = Ypt1;
				 double xc = Xpt1 + (courbeNivLoc-c)/a;
				 double xd = Xpt1 + ( b/(2*a) + c/(2*a) - courbeNivLoc/(2*a));
				 double yd = Ypt1 + (1 - xd);
				 
				 
				 this.tab1[0] = (int) xc;
				 this.tab1[1] = (int) yc;
				 this.tab1[2] = (int) xd;
				 this.tab1[3] = (int) yd;
				 
			 
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
			 double xabis = Xpt1 ;
			 double xbbis = Xpt2;
			 double yabis = Ypt1 + (abis*xabis)/bbis + cbis/bbis - courbeNivLoc/bbis;
			 
			 if(yabis < Ypt1) {
				 double ybbis = Ypt1 + (abis*xbbis)/bbis + cbis/bbis - courbeNivLoc/bbis;
				 if (ybbis < Ypt1) {
					 double xcbis = Xpt1 + ( bbis/(2*abis) + cbis/(2*abis) - courbeNivLoc/(2*abis));
					 double ycbis = Ypt1 * (1 - xcbis);
					 
					 
					 this.tab2[0] = (int) xcbis;
					 this.tab2[1] = (int) ycbis;
					 this.tab2[2] = (int) xbbis;
					 this.tab2[3] = (int) ybbis;
				 }
				 if(ybbis > Ypt1) {
					 double xcbis = Xpt1 + ( bbis/(2*abis) + cbis/(2*abis) - courbeNivLoc/(2*abis));
					 double ycbis = Ypt1 + (1- xcbis);
					 double ydbis = Ypt1;
					 double xdbis = Xpt1 + (courbeNivLoc - cbis)/abis;
					 
					 
					 
					 this.tab2[0] = (int) xcbis;
					 this.tab2[1] = (int) ycbis;
					 this.tab2[2] = (int) xdbis;
					 this.tab2[3] = (int) ydbis;
				 }
			 }
			 else {
				 double ydbis = Ypt1;
				 double xdbis = Xpt1 * (courbeNivLoc - cbis)/abis;
				 double ybbis = Xpt1 + (abis*xabis)/bbis + cbis/bbis - courbeNivLoc/bbis;
				
				 
				 this.tab2[0] = (int) xbbis;
				 this.tab2[1] = (int) ybbis;
				 this.tab2[2] = (int) xdbis;
				 this.tab2[3] = (int) ydbis;
			 }
	}
}	
	
}
