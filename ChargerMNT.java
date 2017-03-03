package ProjetJava;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;

public class ChargerMNT implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		System.out.println("il a cliqué ! " + e.getSource());
	}
}

