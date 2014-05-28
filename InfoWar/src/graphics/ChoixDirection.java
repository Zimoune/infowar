package graphics;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import plateau.Constante;

import action.Attaque;
import action.Deplacement;

import robot.Robot;

public class ChoixDirection extends JFrame implements ActionListener{
	
	JButton haut;
	JButton bas;
	JButton droite;
	JButton gauche;
	String mode;
	Robot robot;
	PanelParty panel;
	
	public ChoixDirection(Robot robot, String mode, PanelParty panel){
		
		this.mode = mode;
		this.panel = panel;
		
		this.haut = new JButton("Haut");
		this.bas = new JButton("Bas");
		this.droite = new JButton("Droite");
		this.gauche = new JButton("Gauche");
		
		this.setLayout(new BorderLayout());
		
		this.add(haut, BorderLayout.NORTH);
		this.add(bas, BorderLayout.SOUTH);
		this.add(droite, BorderLayout.EAST);
		this.add(gauche, BorderLayout.WEST);
		
		this.bas.addActionListener(this);
		this.haut.addActionListener(this);
		this.droite.addActionListener(this);
		this.gauche.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Stub de la méthode généré automatiquement
		if(mode.equals("Attaque")){
			if(e.getSource() == haut){
				//new Attaque(robot,Constante.HAUT).agit();	
				System.out.println("merde");
			} else if(e.getSource() == bas){
				new Attaque(robot,Constante.BAS).agit();
			} else if(e.getSource() == droite){
				new Attaque(robot,Constante.DROITE).agit();
			} else {
				new Attaque(robot,Constante.GAUCHE).agit();
			}
		} else {
			if(e.getSource() == haut){
				new Deplacement(robot,Constante.HAUT).agit();
			} else if(e.getSource() == bas){
				new Deplacement(robot,Constante.BAS).agit();
			} else if(e.getSource() == droite){
				new Deplacement(robot,Constante.DROITE).agit();
			} else {
				new Deplacement(robot,Constante.GAUCHE).agit();
			}
		}
		
		this.dispose();
	}

}
