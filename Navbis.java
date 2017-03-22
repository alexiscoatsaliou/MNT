package ProjetJava;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

class IHMImages extends JPanel implements MouseListener, MouseWheelListener {
	private static final long serialVersionUID = 1L;
	Image MNT;

	//Affichage de l'image du MNT
	int x = 0, y = 0, Height = 630, Width = 420;
	public IHMImages() {				
		try {
			MNT = ImageIO.read(new File("MNT.png"));
		}
		catch(IOException exc) {
			exc.printStackTrace();
		}
		setPreferredSize(new Dimension(1080, 1024));
		setBackground(Color.WHITE);
		this.addMouseListener(this);
		this.addMouseWheelListener(this);
	}
		
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(MNT, x, y, Height, Width, this);
	}

	// récupération de la différence de pixel entre le clique et le relachement du clique pour le cliqué glissé
	private int Yini;			
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
		x = this.x + Xdiff;
		y = this.y + Ydiff;
		this.repaint();
	}
	public void mouseClicked(MouseEvent arg0) {  
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {	
	}
	 
	// récupère l'action de la molette pour gérer le zoom
	public void mouseWheelMoved(MouseWheelEvent arg0) {	
	  int notches = arg0.getWheelRotation();
	  if (notches < 0) {
		Height = this.Height + 100;
		Width = this.Width + 100;
		this.repaint();
	  } else {
		Height = this.Height - 100;
		Width = this.Width - 100;
		this.repaint();
	  }
	}


	
	
}