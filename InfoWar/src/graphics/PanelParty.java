package graphics;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import plateau.Plateau;
import robot.Robot;

public class PanelParty extends JPanel implements ActionListener {

	JLabel auTourde ;
	JButton deplacement;
	JButton attaque;
	JButton quitter;
	
	Map map;
	JPanel panelButton;
	Plateau p;
	int equipe;
	
	public PanelParty(Plateau p, int equipe, ArrayList<Robot> equipe1, ArrayList<Robot> equipe2){
		
		this.p = p;
		this.equipe = equipe;
		
		this.setLayout(new BorderLayout());
		
		this.auTourde = new JLabel("Au tour de #equipe"); // A CHANGER
		this.deplacement = new JButton("Deplacer");
		this.attaque = new JButton("Attaquer");
		this.quitter = new JButton("Quitter");
		this.map = new Map(new Plateau(5,10),equipe); // A CHANGER
		this.panelButton = new JPanel();
		
		//AJOUT SANS LAYOUT
		this.panelButton.add(auTourde);
		this.panelButton.add(attaque);
		this.panelButton.add(deplacement);
		this.panelButton.add(quitter);
		this.add(panelButton,BorderLayout.NORTH);
		this.add(map,BorderLayout.SOUTH);
		
		this.attaque.addActionListener(this);
		this.deplacement.addActionListener(this);
		this.quitter.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Stub de la méthode généré automatiquement
		JFrame choixdeplacement;
		if(arg0.getSource() == attaque){
			choixdeplacement = new ChoixDirection(null, "Attaque",this);
			choixdeplacement.setVisible(true);
			choixdeplacement.pack();
		} else if( arg0.getSource() == deplacement){
			choixdeplacement = new ChoixDirection(null, "Deplacement",this);
			choixdeplacement.setVisible(true);
			choixdeplacement.pack();
		} else {
			System.exit(0);
		} 
	}
	
	public static void main(String[] args){
		JFrame f = new JFrame();
		f.setVisible(true);
		f.setContentPane(new PanelParty(null,0,null,null)); // A CHANGER
		f.pack();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void setEquipe(int equipeActuel){
		this.equipe = 3 - equipeActuel;
		this.repaint();
	}
	
}
