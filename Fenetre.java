package ProjetJava; 

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Fenetre extends JFrame {
	
	String chemin;
	
	  public Fenetre(){							//Création de la fenêtre principale
	    JPanel panel = new JPanel(); 
	    JLabel label = new JLabel("Fichier MNT selectionné : ...");
	    JButton bouton = new ChargerMNT("Chargez votre MNT", label);
	    panel.add(bouton);
	    this.setSize(450, 100);
	    this.add(panel);
	    panel.add(label);
	    this.setTitle("Modélisation de MNT");
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	    this.setVisible(true);
	  }
	 	
	  public static void main(String[] args){       
	    Fenetre f = new Fenetre();
	  }
	
}
