package ProjetJava;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChargerMNT extends JButton implements ActionListener {

	String chemin;
	private JLabel label;
	
	public ChargerMNT(String msg, JLabel label) {
		super(msg);
		this.label = label;
		this.addActionListener(this);
	}
	
	
	public void actionPerformed(ActionEvent e) { 		// Ouvre une fenêtre pour séléctionner le MNT
	
		 JFileChooser chooser = new JFileChooser();
		    chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);   
		    int returnVal = chooser.showOpenDialog(null);
		    if(returnVal == JFileChooser.APPROVE_OPTION) 
		    {
		    	 File folder = chooser.getSelectedFile();
		         chemin = folder.getPath();
		         this.label.setText("Fichier MNT selecionné : " + chemin);
		    } 
	}

}


