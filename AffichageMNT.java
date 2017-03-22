package ProjetJava;


import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class AffichageMNT extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AffichageMNT() throws IOException {

    PlacerPoints panelJava2D = new PlacerPoints(); 
//  Courbe c = new Courbe();
// 	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	this.setSize(new Dimension (1280,1024));
 	this.add(panelJava2D);
//	MNT.add(c);
 	
 	// Cr�ation de l'image du MNT � partir de panelJava2D
 	this.setVisible(true); 
    BufferedImage im = new BufferedImage(1280, 1024, BufferedImage.TYPE_INT_ARGB); // Ajuster � la taille de la fen�tre
    panelJava2D.paint(im.getGraphics());
    ImageIO.write(im, "PNG", new File("MNT.png"));
    this.setVisible(false);
    
    // Apelle de la classe Navbis
	JFrame Navbis = new JFrame();
	Navbis.setContentPane(new IHMImages());
	Navbis.setSize(1280,1024);
	Navbis.setTitle("Mod�lisation de MNT");
	Navbis.setVisible(true);
	
	
	}
	
	




}