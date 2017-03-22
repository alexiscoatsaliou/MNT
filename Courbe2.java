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
		tab1 = new int [4];
		tab2 = new int [4];
		
		if (Recuperateur.CN != null && Recuperateur.CN != ""){
			System.out.println("Je suis dedans");
			try {
				 courbeNivLoc = format.parse(Recuperateur.CN).doubleValue();
			} catch (ParseException e) {
				 e.printStackTrace();
			}
			
			

						
			if (courbeNivLoc <= pt1.getZ() || courbeNivLoc <= pt2.getZ() || courbeNivLoc <= pt3.getZ() || courbeNivLoc <= pt4.getZ()) {	
				if (courbeNivLoc > pt1.getZ() || courbeNivLoc > pt2.getZ() || courbeNivLoc > pt3.getZ() || courbeNivLoc > pt4.getZ()) {	
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
							 double xa = Xpt3 ;
							 double xb = Xpt2; 

							 
							 double ya = Ypt3 + (a*xa)/b + c/b - courbeNivLoc/b;
							 if (ya >= Ypt3 ) {
								 double yb = Ypt1 + (a*xb)/b + c/b - courbeNivLoc/b;
								 if (yb >= Ypt3) {
									 double xd = Xpt3 + (b/(a+b) + c/(a+b) - courbeNivLoc/(a+b));
									 double yd = Ypt3 + (1 - xd);
									 
									 this.tab1[0] = (int) xa;
									 this.tab1[1] = (int) ya;
									 this.tab1[2] = (int) xd;
									 this.tab1[3] = (int) yd;
								 }
								 else {
									 double yc = Ypt3;
									 double xc = Xpt3 + (courbeNivLoc-c)/a;
									 
									 this.tab1[0] = (int) xa;
									 this.tab1[1] = (int) ya;
									 this.tab1[2] = (int) xc;
									 this.tab1[3] = (int) yc;
								 }
							 }
							 if (ya < Ypt3) {
								 double yc = Ypt3;
								 double xc = Xpt3 + (courbeNivLoc-c)/a;
								 double xd = Xpt3 + ( b/(a+b) + c/(a+b) - courbeNivLoc/(a+b));
								 double yd = Ypt3 + (1 - xd);
								 
								 
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
							 
							 if(yabis <= Ypt1) {
								 double ybbis = Ypt1 + (abis*xbbis)/bbis + cbis/bbis - courbeNivLoc/bbis;
								 if (ybbis <= Ypt1) {
									 double xdbis = Xpt1 + ( bbis/(abis + bbis) + cbis/(abis + bbis) - courbeNivLoc/(abis + bbis));
									 double ydbis = Ypt1 * (1 - xdbis);
									 
									 
									 this.tab2[0] = (int) xdbis;
									 this.tab2[1] = (int) ydbis;
									 this.tab2[2] = (int) xbbis;
									 this.tab2[3] = (int) ybbis;
								 }
								 if(ybbis >= Ypt1) {
									 double xdbis = Xpt1 + ( bbis/(abis + bbis) + cbis/(abis + bbis) - courbeNivLoc/(abis + bbis));
									 double ydbis = Ypt1 + (1- xdbis);
									 double ycbis = Ypt1;
									 double xcbis = Xpt1 + (courbeNivLoc - cbis)/abis;
									 
									 
									 
									 this.tab2[0] = (int) xcbis;
									 this.tab2[1] = (int) ycbis;
									 this.tab2[2] = (int) xdbis;
									 this.tab2[3] = (int) ydbis;
								 }
							 }
							 else {
								 double ycbis = Ypt1;
								 double xcbis = Xpt1 * (courbeNivLoc - cbis)/abis;
								 double ybbis = Ypt1 + (abis*xabis)/bbis + cbis/bbis - courbeNivLoc/bbis;
								
								 
								 this.tab2[0] = (int) xbbis;
								 this.tab2[1] = (int) ybbis;
								 this.tab2[2] = (int) xcbis;
								 this.tab2[3] = (int) ycbis;
					 }
				}
			}
		}				
	}	
} 
