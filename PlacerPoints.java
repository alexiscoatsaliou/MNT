package ProjetJava;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PlacerPoints extends JPanel {

	
	
	
public PlacerPoints() {    
 
}
	 
	 @Override
	 public void paintComponent(Graphics g) {
		 
		 System.out.println("a");
	 
		 Graphics2D g2d = (Graphics2D) g;
		 
		 System.out.println(ChargerMNT.m.ncols+" "+ ChargerMNT.m.nline);
		 
		 for(int i=0; i < ChargerMNT.m.nline-1; i++) {
			 for(int j=0; j < ChargerMNT.m.ncols-1; j++) {

				 //On crée les couleurs en fonction du Z
				 
		
				 Point pt1 = ChargerMNT.tab[i][j];
				 Point pt2 = ChargerMNT.tab[i][j+1];
				 Point pt3 = ChargerMNT.tab[i+1][j];
				 
				 int width = (int) (pt2.X - pt1.X);
				 int height = (int) (pt3.Y - pt1.Y);;
				 
				 
				 
				// g2d.setPaint(Color.black);
				// g2d.drawRect(pt1.i, pt1.j, 20, 20);
				 
				 double n = ChargerMNT.tab[i][j].getZ();
				 if (n < 10) {
					 g2d.setPaint(Color.green);
				 } else if (n >= 10 && n < 15){
					 g2d.setPaint(Color.yellow);
				 } else if (n >= 15 && n < 20){
					 g2d.setPaint(Color.orange);
				 } else if (n >= 20 && n < 25){
					 g2d.setPaint(Color.red);
				 } else if (n >= 25){
					 g2d.setPaint(Color.darkGray);
				 }
				 g2d.drawRect(pt1.i, pt1.j, 50, 50);
				 System.out.println(pt1.i + " " + pt1.j);
	    					 
				// g2d.fillRect(pt1.i, pt1.j, 20, 20);
		

			 }
	
		 }	 
	 }
}
