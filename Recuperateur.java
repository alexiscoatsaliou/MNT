package ProjetJava;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JTextField;

public class Recuperateur implements ActionListener {
	
	JTextField CourbeNiv = null;
	JTextField Echelle = null;
	static String CN = null;
	static String Ech = null;
	
	public Recuperateur(JTextField courbeNiv, JTextField echelle) {
		this.CourbeNiv = courbeNiv;
		this.Echelle = echelle;
	}
	

	public void actionPerformed(ActionEvent e) { 
		
		CN = CourbeNiv.getText();
		Ech = Echelle.getText();
    	
		//Calcule le MNT et crée le tableau de point
		ChargerMNT.m = new MNT(ChargerMNT.chemin);
    	ChargerMNT.tab = ChargerMNT.m.LireMNT();
    	
    	
        try {
			AffichageMNT affiche = new AffichageMNT();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 		//Afficher le MNT

	}

}
