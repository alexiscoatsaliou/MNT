package ProjetJava;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.event.MouseInputAdapter;

public class AffichageMNT extends JFrame implements MouseListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AffichageMNT() {
	
		JFrame MNT = new JFrame();
	    PlacerPoints panelJava2D = new PlacerPoints();
	 	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	 	MNT.setExtendedState(Frame.MAXIMIZED_BOTH);
	 	MNT.add(panelJava2D);
	 	ChargerMNT.m = new MNT(ChargerMNT.chemin);
		ChargerMNT.tab = ChargerMNT.m.LireMNT();
	 	MNT.setVisible(true);


	}

	
	private int Yini;							// Stocker le MNT en image puis faire ceci. (A faire en fin de projet)
	private int Xini;
	public void mousePressed(MouseEvent arg0) {
	 	this.Xini = arg0.getX();
        this.Yini = arg0.getY();
	}
	
	private int Yfinal;
	private int Xfinal;
	private int Ydiff;
	private int Xdiff;
	public void mouseReleased(MouseEvent arg0) {
	 	this.Xfinal = arg0.getX();
        this.Yfinal = arg0.getY();
		this.Ydiff = Yfinal - Yini;
		this.Xdiff = Xfinal - Xini;
		System.out.println("Diff x " + Xdiff + " Diff Y " + Ydiff);
	}
	
	 public void mouseClicked(MouseEvent event) {  
	 }

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {	
	}
//
// 
//	public void mouseWheelMoved(MouseWheelEvent e) {
//  int notches = e.getWheelRotation();
//  if (notches < 0) {
//  	System.out.println("haut");
//  } else {
//		System.out.println("bas");
//  }
//} 

}