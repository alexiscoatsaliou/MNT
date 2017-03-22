package ProjetJava;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AffichageMNT extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static BufferedImage im;

	public AffichageMNT() throws IOException  {
	

	
	PlacerPoints panelJava2D = new PlacerPoints(); 
//	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	this.setSize(new Dimension (1280,1024));
	this.add(panelJava2D);

	// Création de l'image du MNT à partir de panelJava2D
	this.setVisible(true); 
	im = new BufferedImage(1280, 1024, BufferedImage.TYPE_INT_ARGB); // Ajuster à la taille de la fenêtre
	panelJava2D.paint(im.getGraphics());
	ImageIO.write(im, "PNG", new File("MNT.png"));
	this.setVisible(false);
	  
	// Apelle de la classe Navbis
	JFrame Navbis = new JFrame();
	Navbis.setContentPane(new IHMImages());
	Navbis.setSize(1280,1024);
	Navbis.setTitle("Modélisation de MNT");
	Navbis.setVisible(true);
	}


}