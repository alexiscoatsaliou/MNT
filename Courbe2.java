package ProjetJava;

import java.text.DecimalFormat;
import java.text.ParseException;

import Jama.Matrix;

public class Courbe2 extends PlacerPoints{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	double h0;
	DecimalFormat format = new DecimalFormat("#.##");
	double tab1[] = null;
	double tab2[] = null;
	
	
	public Courbe2(Point pt1, Point pt2, Point pt3, Point pt4, int echelle){
		tab1 = new double [4];
		tab2 = new double [4];
		
		if (Recuperateur.CN != null && Recuperateur.CN != ""){
			try {
				 h0 = format.parse(Recuperateur.CN).doubleValue();
			} catch (ParseException e) {
				 e.printStackTrace();
			}
			
	
			if ((h0 <= pt1.getZ() || h0 <= pt3.getZ() || h0 <= pt4.getZ()) 
					&& (h0 >= pt1.getZ() || h0 >= pt3.getZ() || h0 >= pt4.getZ())) {		
				 double Xpt1 = pt1.getj();
				 double Ypt1 = pt1.geti();
				 double Xpt3 = pt3.getj();
				 double Ypt3 = pt3.geti();
				 double Xpt4 = pt4.getj();
				 double Ypt4 = pt4.geti();
				 
				//On fait le calcul pour le premier triangle	
				 double[][] array1 = {{Xpt1, Ypt1, 1},{Xpt3, Ypt3, 1},{Xpt4, Ypt4, 1}};
				 Matrix A = new Matrix(array1);
				 double[][] array2 = {{pt1.getZ()},{ pt3.getZ()}, {pt4.getZ()}};
				 Matrix B = new Matrix(array2);
				 Matrix X = A.solve(B);
				 
				 double a, b, c; // paramètres du plan z=ax+by+c
				 a = X.get(0, 0);
				 b = X.get(1, 0);
				 c = X.get(2, 0);
				 double xa, ya; // coordonnées de l'intersections de la droite avec (pt1, pt3)
				 double xb, yb; // coordonnées de l'intersections de la droite avec (pt3, pt4)
				 double xc, yc; // coordonnées de l'intersections de la droite avec (pt1, pt4)
				 ya = h0/b - a*Xpt3/b - c/b;
				 if (ya <= Ypt3 && ya >= Ypt1) {
					 // A entre pt3 et pt1
					 xa = Xpt3;
					 xb = h0/a - b*Ypt3/a - c/a;
					 if (xb >= Xpt3 && xb <= Xpt4) {
						 // B entre pt3 et pt4
						 yb = Ypt3;
						
						this.tab1[0] = xa;
						this.tab1[1] = ya;
						this.tab1[2] = xb;
						this.tab1[3] = yb;	 
					
					 }
					 else {
						 // B en dehors de [pt3, pt4]
						 xc = (h0 - b * (Xpt1 + Ypt1) - c) / (a - b);
						 yc =  Xpt1 + Ypt1 - xc;
						 
						this.tab1[0] = xa;
						this.tab1[1] = ya;
						this.tab1[2] = xc;
						this.tab1[3] = yc;
						
					 }
				 }
				 else {
					// A en dehors de [pt1, pt3]
					xb = h0/a - b*Ypt3/a - c/a;
					yb = Ypt3;
					xc = (h0 - b * (Xpt1 + Ypt1) - c) / (a - b);
					yc =  Xpt1 + Ypt1 - xc;
					
					this.tab1[0] = xb;
					this.tab1[1] = yb;
					this.tab1[2] = xc;
					this.tab1[3] = yc;
					
				 }
			}
			
			if ((h0 <= pt1.getZ() || h0 <= pt2.getZ() || h0 <= pt4.getZ()) 
					&& (h0 >= pt1.getZ() || h0 >= pt2.getZ() || h0 >= pt4.getZ())) {		
				double Xpt1 = pt1.getj();
				double Ypt1 = pt1.geti();
				double Xpt2 = pt2.getj();
				double Ypt2 = pt2.geti();
				double Xpt4 = pt4.getj();
				double Ypt4 = pt4.geti();
				
				//On fait le calcul pour le 2e triangle
				double[][] array3 = {{Xpt4, Ypt4, 1},{Xpt2, Ypt2, 1},{Xpt1, Ypt1, 1}};
				Matrix A = new Matrix(array3);
				double[][] array4 = {{pt4.getZ()}, {pt2.getZ()}, {pt1.getZ()}};
				Matrix B = new Matrix(array4);
				Matrix X = A.solve(B);

				double a, b, c; // paramètres de la droite h0=ax+by+c
				a = X.get(0, 0);
				b = X.get(1, 0);
				c = X.get(2, 0);
				double xa, ya; // coordonnées de l'intersections de la droite avec (pt2, pt4)
				double xb, yb; // coordonnées de l'intersections de la droite avec (pt1, pt2)
				double xc, yc; // coordonnées de l'intersections de la droite avec (pt1, pt4)
				 
				ya = h0/b - a*Xpt2/b - c/b;
				if (ya <= Ypt4 && ya >= Ypt2) {
					//A est entre pt2 et pt4
					xa = Xpt2;
					xb = h0/a - b*Ypt2/a - c/a;
					if (xb >= Xpt1 && xb <= Xpt2) {
						// B entre pt1 et pt2
						yb = Ypt2;
						
						this.tab2[0] = xa;
						this.tab2[1] = ya;
						this.tab2[2] = xb;
						this.tab2[3] = yb;
					}
					else {
						// B en dehors de [pt1, pt2]
						xc = (h0 - b * (Xpt1 + Ypt1) - c) / (a - b);
						yc =  Xpt1 + Ypt1 - xc;					
						
					    this.tab2[0] = xa;
						this.tab2[1] = ya;
						this.tab2[2] = xc;
						this.tab2[3] = yc;
				}
				}
				else {
					// A en dehors de [pt2, pt4]
					xb = h0/a - b*Ypt2/a - c/a;
					yb = Ypt2;
					xc = (h0 - b * (Xpt1 + Ypt1) - c) / (a - b);
					yc =  Xpt1 + Ypt1 - xc;					
					
					this.tab2[0] = xb;
					this.tab2[1] = yb;
					this.tab2[2] = xc;
					this.tab2[3] = yc;
					
					
				}
			} 
		}				
	}	
} 