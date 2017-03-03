package ProjetJava;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;


public class Fenetre extends JFrame {
	
	String chemin;
	
	  public Fenetre(String c){
		this.chemin = c;
	    this.setTitle("Modélisation de MNT");
	    this.setSize(500, 500);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
	    this.setVisible(true);
	    JPanel panel = new JPanel();
	    JButton bouton = new JButton("Chargez vôtre MNT");
	    JLabel label = new JLabel(c);
	    panel.add(label);
	    panel.add(bouton);
	    panel.add(bouton, BorderLayout.NORTH);
	    
	    ChargerMNT monListener = new ChargerMNT();
	    bouton.addActionListener(monListener );
	    this.add(panel);
	  }
	  
	  public static void main(String[] args){       
	    Fenetre fen = new Fenetre();
	  }
	
}
