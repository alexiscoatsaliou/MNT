package ProjetJava; 

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Fenetre extends JFrame implements ActionListener {
	
	public static Object panel2;
	String chemin;
	int CourbeNiv;
	
	  public Fenetre(){							//Création de la fenêtre principale
	    JPanel panel = new JPanel(); 
	    JLabel label = new JLabel("Fichier MNT selecionné : ...");
	    JButton bouton = new ChargerMNT("Chargez vôtre MNT", label);
	    panel.add(bouton);
	    this.setSize(700, 150);
	    this.add(panel, BorderLayout.NORTH);
	    panel.add(label);
	    this.setTitle("Modélisation de MNT");
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	    this.setVisible(true);
	        
	    JPanel panel2 = new JPanel();
	    JLabel label3 = new JLabel("Altitude de la courbe de niveau à tracer : ");
	    JTextField CourbeNiv = new JTextField("      "); 
	    panel2.add(label3);
	    panel2.add(CourbeNiv);
        JLabel label2 = new JLabel("Echelle du MNT : ");
        JTextField echelle = new JTextField("      ");
        panel2.add(label2);
        panel2.add(echelle);
        this.add(panel2, BorderLayout.CENTER);
        panel2.setVisible(true);
        
	    JPanel panel3 = new JPanel();
	    JButton Recharger = new JButton("Lancer la modélisation");
	    panel3.add(Recharger);
	    this.add(panel3, BorderLayout.SOUTH);
	    this.pack();
	    
	    Recuperateur monListener = new Recuperateur(CourbeNiv, echelle);
	    Recharger.addActionListener(monListener);
	    panel3.setVisible(true);
	    
	  }
	
}
