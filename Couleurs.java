package ProjetJava;

import java.awt.Color;
import java.awt.Graphics2D;

public class Couleurs {
	
	 double maxVal = Double.MAX_VALUE;
     double minVal = Double.MIN_VALUE;
     
     Point[][] tab2 = ChargerMNT.tab;
     
     public Graphics2D Couleurs(double n) {
	for(int i = 0; i < tab2.length; i++){
		for(int j = 0; j < tab2.length; j++){
	
			if(tab2[i][j].getZ() < maxVal)
				maxVal = tab2[i][j].getZ();
			if(tab2[i][j].getZ() > minVal)
				minVal = tab2[i][j].getZ();
		}
	}
	
	double dif = maxVal - minVal;
	
	 if (dif < 50) {
		 if (n < minVal + 10) {
		 g2d.setColor(Color.green);
	 } else if (n >= minVal + 10 && n < minVal + 20){
		 g2d.setColor(Color.yellow);
	 } else if (n >= minVal + 20 && n <minVal + 30){
		 g2d.setColor(Color.orange);
	 } else if (n >= minVal + 30 && n < minVal + 40){
		 g2d.setColor(Color.red);
	 }	else if (n >= minVal + 40){
		 g2d.setColor(Color.red);
	 }
		 
    }
	return null;
	 		
}
     
}     

