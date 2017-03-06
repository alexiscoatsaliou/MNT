package ProjetJava;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Fenetre extends JFrame {
	
	String chemin;
	
	  public Fenetre(){							//Cr�ation de la fen�tre principale
	    this.setTitle("Mod�lisation de MNT");
	    this.setSize(500, 500);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
	    this.setVisible(true);
	    JPanel panel = new JPanel();
	    JLabel label = new JLabel("Fichier MNT selecionn� : ...");
	    JButton bouton = new ChargerMNT("Chargez v�tre MNT", label);
	    panel.add(label);
	    panel.add(bouton);
	    this.add(panel);
	  }
	 	
	  public static void main(String[] args){       
	    Fenetre fen = new Fenetre();
	  }
	
}
