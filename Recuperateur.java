package ProjetJava;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class Recuperateur implements ActionListener {
	
	JTextField CourbeNiv = null;
	JTextField Echelle = null;
	
	public Recuperateur(JTextField courbeNiv, JTextField echelle) {
		this.CourbeNiv = courbeNiv;
		this.Echelle = echelle;
	}
	

	public void actionPerformed(ActionEvent e) { 
		
		System.out.println(CourbeNiv.getText());
		System.out.println(Echelle.getText());
		
	}

}
