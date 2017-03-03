package ProjetJava;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PlacerPoints extends JFrame {
	double ncols;
	double nline;
	
	public PlacerPoints(double a, double b){
		this.ncols = a;
		this.nline = b;
	}
	
public Grille(){
	
	 this.setTitle("GridBagLayout");
	    this.setSize(300, 160);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    
	    //On crée nos différents conteneurs de couleur différente
	    
	    for(int i=0; i < this.ncols * this.nline; i++) {
	    JPanel  = new JPanel();
	   	i.setPreferredSize(new Dimension(60, 40));
	    }
}
		
		
	}
	
	
