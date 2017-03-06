package ProjetJava;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Fenetre extends JFrame {
	
	String chemin;
	
	  public Fenetre(){							//Création de la fenêtre principale
	    this.setTitle("Modélisation de MNT");
	    this.setSize(500, 500);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
	    this.setVisible(true);
	    JPanel panel = new JPanel();
	    JLabel label = new JLabel("Fichier MNT selecionné : ...");
	    JButton bouton = new ChargerMNT("Chargez vôtre MNT", label);
	    panel.add(label);
	    panel.add(bouton);
	    this.add(panel);
	  }
	 	
	  public static void main(String[] args){       
	    Fenetre fen = new Fenetre();
	  }
	
}
