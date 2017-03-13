package ProjetJava;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PlacerPoints extends JPanel {
	 
	
	//On initialise le min au MAX et le max au MIN pour mieux récupérer le min et le max du tableau
	double maxVal = Double.MIN_VALUE;
    double minVal = Double.MAX_VALUE;
    
public PlacerPoints() {    
 
}
	 
	 @Override
	 public void paintComponent(Graphics g) {
	 
		 Graphics2D g2d = (Graphics2D) g;
		 
		 // On teste quelles sont les valeurs min et max du tableau
		 for(int k = 0; k < ChargerMNT.tab.length; k++){
				for(int l = 0; l < ChargerMNT.tab.length; l++){
			
					if(ChargerMNT.tab[k][l].getZ() > maxVal){
						this.maxVal = ChargerMNT.tab[k][l].getZ();
					}
						
					else if(ChargerMNT.tab[k][l].getZ() < minVal){
						this.minVal = ChargerMNT.tab[k][l].getZ();
					}
						
				}
			}
		 
		 //On crée des carrés 
		// System.out.println(ChargerMNT.m.ncols+" "+ ChargerMNT.m.nline);
		 for(int i=0; i < ChargerMNT.m.nline-1; i++) {
			 for(int j=0; j < ChargerMNT.m.ncols-1; j++) {

				 //On crée les couleurs en fonction du Z
				 
				 Point pt1 = ChargerMNT.tab[i][j];
				 //Point pt2 = ChargerMNT.tab[i][j+1];
				 //Point pt3 = ChargerMNT.tab[i+1][j];
				 
				 //inutile?
				 //int width = (int) (pt2.X - pt1.X);
				 //int height = (int) (pt3.Y - pt1.Y);;
				 // g2d.setPaint(Color.black);
				 // g2d.drawRect(pt1.i, pt1.j, 20, 20);
				 
				 double n = ChargerMNT.tab[i][j].getZ();
				// System.out.println(i + " " + j + " " +n);
				 
					
					//On fais la dif entre la valeur min et la valeur max pour savoir combien de couleurs on va mettre
					double dif = this.maxVal - this.minVal;
					
					
					 if (dif < 25) {
						 if (n < this.minVal + 5) {
							 g2d.setColor(Color.green);
						 } else if (n >= this.minVal + 5 && n < this.minVal + 10){
							 g2d.setColor(Color.yellow);
						 } else if (n >= this.minVal + 10 && n <this.minVal + 15){
							 g2d.setColor(Color.orange);
						 } else if (n >= this.minVal + 15 && n < this.minVal + 20){
							 g2d.setColor(Color.red);
						 }	else if (n >= this.minVal + 20){
							 g2d.setColor(Color.black);
						 }
					 }
					 
					 if (dif >= 50) {
						 if (n < minVal + 15) {
							 Color Niveau0 = new Color(0,255,0);
							 g2d.setColor(Niveau0);
						 } else if (n >= minVal + 15 && n < minVal + 30){
							 Color Niveau1 = new Color(194,247,50);
							 g2d.setColor(Niveau1);
						 } else if (n >= minVal + 30 && n <minVal + 45){
							 Color Niveau2 = new Color(255,255,107);
							 g2d.setColor(Niveau2);
						 } else if (n >= minVal + 45 && n < minVal + 60){
							 Color Niveau3 = new Color(255,255,0);
							 g2d.setColor(Niveau3);
						 } else if (n >= minVal + 60 && n < minVal + 75){
							 Color Niveau4 = new Color(243,214,23);
							 g2d.setColor(Niveau4);
					 	 } else if (n >= minVal + 75 && n < minVal + 90){
					 		Color Niveau5 = new Color(237,127,16);
					 		 g2d.setColor(Niveau5);
					 	 } else if (n >= minVal + 90 && n < minVal + 105){
					 		Color Niveau6 = new Color(244,102,27);
					 		 g2d.setColor(Niveau6);
					 	 } else if (n >= minVal + 105 && n < minVal + 120){
					 		Color Niveau7 = new Color(255,0,0);
					 		 g2d.setColor(Niveau7);
					 	 } else if (n >= minVal + 120 && n < minVal + 135){
					 		Color Niveau8 = new Color(63,34,4);
					 		 g2d.setColor(Niveau8);
					 	 } else if (n >= minVal + 135 && n < minVal + 150){
					 		Color Niveau9 = new Color(45,36,30);
					 		 g2d.setColor(Niveau9);
					 	 }
					 }
						 
						 
						 
				 g2d.fillRect(pt1.j, pt1.i, 1, 1);
	    					 

			 }
		 }	 
	 }

}
