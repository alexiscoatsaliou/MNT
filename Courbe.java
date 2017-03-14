package ProjetJava;

import java.awt.Graphics;

import Jama.Matrix;

public class Courbe {
	
	public void paintComponent(Graphics g) {
		
		 for(int i=0; i < ChargerMNT.m.nline-1; i++) {
			 for(int j=0; j < ChargerMNT.m.ncols-1; j++) {
				 
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
				 System.out.println(X);
				 
				 
				 
			 }
		 }
		
	}

}
