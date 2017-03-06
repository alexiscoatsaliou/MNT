package ProjetJava;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PlacerPointsBis extends JFrame {
	double ncols;
	double nline;
	Point[][] tab;
	MNT m = new MNT(ChargerMNT.chemin);
	
public PlacerPoints() {
	 this.setTitle("GridBagLayout");
	 this.setSize(300, 160);	    
	 //On crée nos différents conteneurs de couleur différente
	 tab = m.LireMNT();
	 GridLayout gl = new GridLayout(m.ncols,m.nline);
	    for(int i=0; i < m.ncols; i++) {
	    	for(int j=0; i < m.nline; j++) {
	    		
	    		JPanel panel  = new JPanel();
	    		panel.setPreferredSize(new Dimension(60, 40));
	    		double n = tab[i][j].getZ();
	    		if (n < 30) {
	    			panel.setBackground(Color.green);
	    		} else if (n >30 && n < 40){
	    			panel.setBackground(Color.yellow);
	    		} else if (n > 40 && n < 50){
	    			panel.setBackground(Color.orange);
	    		} else if (n > 50 && n < 60){
	    			panel.setBackground(Color.red);
	    		} else if (n > 60){
	    			panel.setBackground(Color.darkGray);
	    		}
	    		
	    }
	
	 }	    
}
		
}
