package ProjetJava;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PlacerPoints extends JFrame {
	double ncols;
	double nline;
	

	
public Grille(){
	
	 this.setTitle("GridBagLayout");
	    this.setSize(300, 160);
	    MNT m = new MNT(ChargerMNT.chemin);
	    Point[][] tab = m.LireMNT();

	    //On crée nos différents conteneurs de couleur différente
	    
	    for(int i=0; i < m.ncols; i++) {
	    	for(int j=0; j < m.nline; j++) {
	    int n = tab[i][j].GetNum();
	    String nom = "Cellelu" + n;
	    JPanel nom  = new JPanel();
	   	nom.setPreferredSize(new Dimension(60, 40));
	    }
	    	}
	  //Le conteneur principal
	    JPanel content = new JPanel();
	    content.setPreferredSize(new Dimension(300, 120));
	    
	    //L'objet servant à positionner les composants
	    GridBagConstraints gbc = new GridBagConstraints();
	    
	    //On définit le layout manager
	    content.setLayout(new GridBagLayout());
	    
	    //On positionne la case de départ du composant
	    gbc.gridx = 0;
	    gbc.gridy = 0;

	    //La taille en hauteur et en largeur
	    gbc.gridheight = 1;
	    gbc.gridwidth = 1;
	    content.add(cell1, gbc);

	   

	    gbc.gridx = 1;
	    content.add(cell2, gbc);
	  

	    gbc.gridx = 2;      

	    content.add(cell3, gbc);
}
		
		
	}	
