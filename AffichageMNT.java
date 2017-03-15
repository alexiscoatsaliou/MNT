package ProjetJava;

import java.awt.Dimension;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AffichageMNT extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AffichageMNT() {
	

	
	JFrame MNT = new JFrame();
    PlacerPoints panelJava2D = new PlacerPoints();
    Courbe c = new Courbe();
 	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
 	MNT.setExtendedState(Frame.MAXIMIZED_BOTH);
 	MNT.add(panelJava2D);
	MNT.add(c);
	MNT.setVisible(true);

	}


}