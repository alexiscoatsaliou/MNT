
package ProjetJava;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

public class ChargerMNT extends JButton implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	static String chemin;
	private JLabel label;
	static Point[][] tab;
	static MNT m;
	
	public ChargerMNT(String msg, JLabel label) {
		super(msg);
		this.label = label;
		this.addActionListener(this);
		
	}
	
	
	public void actionPerformed(ActionEvent e) { 		// Ouvre une fenêtre pour sélectionner le MNT
	
		 JFileChooser chooser = new JFileChooser();
		    chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);   
		    int returnVal = chooser.showOpenDialog(null);
		    if(returnVal == JFileChooser.APPROVE_OPTION) 
		    {
		    	File folder = chooser.getSelectedFile();
		        chemin = folder.getPath();
		        this.label.setText("Fichier MNT sélectionné : " + chemin);
		        
		        ChargerMNT.m = new MNT(ChargerMNT.chemin);
		    	ChargerMNT.tab = ChargerMNT.m.LireMNT();

		    } 
	}

}






