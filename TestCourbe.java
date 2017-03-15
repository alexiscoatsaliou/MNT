package ProjetJava;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.text.DecimalFormat;
import java.text.ParseException;

import Jama.Matrix;

public class TestCourbe extends PlacerPoints {
	Point pt1 = new Point(0,0,10,0,0);
	Point pt2 = new Point(0,1,11,0,0);
	Point pt3 = new Point(1,0,10,0,0);
	
	DecimalFormat format = new DecimalFormat("#.##");
	double courbeNivLoc = 0;
	

	
	public void paintComponent(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		
		double[][] array1 = {{pt1.getX(), pt1.getY(), 1},{pt2.getX(), pt2.getY(), 1},{pt3.getX(), pt3.getY(), 1}};
		Matrix A = new Matrix(array1);
		double[][] array2 = {{pt1.getZ()},{ pt2.getZ()}, {pt3.getZ()}};
		Matrix B = new Matrix(array2);
		Matrix InvA = A.inverse();
		Matrix X = InvA.solve(B);
		double a = X.get(0, 0);
		double b = X.get(1, 0);
		double c = X.get(2, 0);
		double xa = 0;
		double xb = 1; 
	
		try {
			this.courbeNivLoc = format.parse(Recuperateur.CN).doubleValue();
		 } catch (ParseException e) {
			 e.printStackTrace();
		}
		
		double ya = 0 + (a*xa)/b + c/b - courbeNivLoc/b;
		if (ya > 0 ) {
			double yb = 1 + (a*xb)/b + c/b - courbeNivLoc/b;
			if (yb > 0) {
				double xc = 0 + (b/(2*a) + c/(2*a) - courbeNivLoc/(2*a));
				double yc = 0 + (1 - xc);
			 
				g2d.drawLine((int) xa, (int) ya, (int) xc, (int) yc);
			}
			else {
				double yc = 0;
				double xc = 0 + (courbeNivLoc-c)/a;
				 
				g2d.drawLine((int) xa, (int) ya, (int) xc, (int) yc);
			}
		 }
		 if (ya < 0) {
			 double yc = 0;
			 double xc = 0 + (courbeNivLoc-c)/a;
			 double xd = 0 + ( b/(2*a) + c/(2*a) - courbeNivLoc/(2*a));
			 double yd = 0 + (1 - xd);
			 
			 g2d.drawLine((int) xc, (int) yc, (int) xd, (int) yd);
			 
		 }
	}
}
