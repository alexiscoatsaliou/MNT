package ProjetJava;

import java.awt.Dimension;
import java.awt.Frame;

import javax.swing.JFrame;

public class AffichageMNT extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AffichageMNT() {
	
	JFrame MNT = new JFrame();
	//JPanel panel2 = new JPanel();
    PlacerPoints panelJava2D = new PlacerPoints();
 	panelJava2D.setPreferredSize(new Dimension(1200,1000));
 	//panel2.add(panelJava2D);
 	MNT.setExtendedState(Frame.MAXIMIZED_BOTH);
 	MNT.setVisible(true);
 	MNT.setContentPane(panelJava2D);
 	//panel2.setVisible(true);
 	this.pack();
 	
 	
	}

}
