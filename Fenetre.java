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
	
	  public Fenetre(){							//Cr�ation de la fen�tre principale
	    JPanel panel = new JPanel(); 
	    JLabel label = new JLabel("Fichier MNT selecionn� : ...");
	    JButton bouton = new ChargerMNT("Chargez v�tre MNT", label);
	    panel.add(label);
	    panel.add(bouton);
	    this.add(panel, BorderLayout.NORTH);
	    this.setTitle("Mod�lisation de MNT");
	    this.setExtendedState(Frame.MAXIMIZED_BOTH);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	    this.pack();
	    this.setVisible(true);
	  }
	 	
	  public static void main(String[] args){       
	    Fenetre f = new Fenetre();
	  }
	
}
