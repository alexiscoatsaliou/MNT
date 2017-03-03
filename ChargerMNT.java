package ProjetJava;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JTextField;


public class ChargerMNT implements ActionListener {

	private JTextField _textField;
	String chemin;
	
	public void actionPerformed(ActionEvent e) { 
	
		 JFileChooser chooser = new JFileChooser();
		    chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);   
		    int returnVal = chooser.showOpenDialog(null);
		    if(returnVal == JFileChooser.APPROVE_OPTION) 
		    {
		    	 File folder = chooser.getSelectedFile();
		         chemin = folder.getPath();
		    } 
	}
	
	Fenetre d = new Fenetre(chemin);

	
}


