package ProjetJava; 

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Fenetre extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Object panel2;
	String chemin;
	int CourbeNiv;
	
	  // Création de la fenêtre principale
	  public Fenetre(){	
		  
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		this.setVisible(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\workspace\\ProjetJava\\src\\ProjetJava\\MNT.jpg")); 
		 
		JPanel panel = new JPanel(); 
		JLabel label = new JLabel("Fichier MNT selecionné : ...");
		JButton bouton = new ChargerMNT("Chargez votre MNT", label);
		panel.add(bouton);
		this.setSize(600, 200);
		this.add(panel);
		panel.add(label);
		this.setTitle("Modélisation de MNT");
		
		JPanel panel2 = new JPanel();
		JLabel label3 = new JLabel("Altitude de la courbe de niveau à tracer : ");
		JTextField CourbeNiv = new JTextField("");
		CourbeNiv.setPreferredSize(new Dimension(25,20));
		panel2.add(label3);
		panel2.add(CourbeNiv);
	    JLabel label2 = new JLabel("Echelle du MNT : ");
	    JTextField echelle = new JTextField("");
		echelle.setPreferredSize(new Dimension(20,20));
	    panel2.add(label2);
	    panel2.add(echelle);
	    this.add(panel2);
	    panel2.setVisible(true);

	    JPanel panel3 = new JPanel();
	    JButton Recharger = new JButton("Lancer la modélisation");
	    panel3.add(Recharger);
	    this.add(panel3);

	    JPanel panel4 = new JPanel();
	    JButton Save = new JButton("Enregistrer");
	    panel4.add(Save);
	    panel4.setVisible(true);
	    this.add(panel4);
	        
	    Container boxV = Box.createVerticalBox();
	    boxV.add(Box.createHorizontalGlue());
	    boxV.add(panel);
	    boxV.add(panel2);
	    boxV.add(panel3);
	    boxV.add(panel4);
	    this.add(boxV);

	    Recuperateur monListener = new Recuperateur(CourbeNiv, echelle);
	    Recharger.addActionListener(monListener);	
	    
	    Save.addActionListener(this);
	  }
	  
	  // Ouvre une fenêtre pour enregistrer le MNT généré
	  public void actionPerformed(ActionEvent e) { 
		  
		  		JFileChooser chooser = new JFileChooser();
			    chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);   			    
			    int returnVal = chooser.showSaveDialog(null);
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			    	String lien = chooser.getSelectedFile().getAbsolutePath();			    	
			    	File f = null;
			    	try {
			    		f = new File(lien);
			    		ImageIO.write(AffichageMNT.im, "png", f);
			    	}catch(IOException u) {
			    		System.out.println("L'image n'a pas été enregistré ");
			    	}
			    	
			    } 
		}

}