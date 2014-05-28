package graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import plateau.Plateau;

public class PanelParty extends JPanel implements ActionListener {

	JLabel auTourde ;
	JButton deplacement;
	JButton attaque;
	JButton quitter;
	
	Map map;
	JPanel panelButton;
	
	public PanelParty(Plateau p){
		
		this.auTourde = new JLabel("Au tour de #equipe"); // A CHANGER
		this.deplacement = new JButton("Deplacer");
		this.attaque = new JButton("Attaquer");
		this.quitter = new JButton("Quitter");
		this.map = new Map(new Plateau(5,10)); // A CHANGER
		
		//AJOUT SANS LAYOUT
		this.add(auTourde);
		this.add(attaque);
		this.add(deplacement);
		this.add(quitter);
		this.add(map);
		
		this.attaque.addActionListener(this);
		this.deplacement.addActionListener(this);
		this.quitter.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Stub de la méthode généré automatiquement
		JFrame choixdeplacement;
		if(arg0.getSource() == attaque){
			choixdeplacement = new ChoixDirection(null, "Attaque");
			choixdeplacement.setVisible(true);
			choixdeplacement.pack();
		} else if( arg0.getSource() == deplacement){
			choixdeplacement = new ChoixDirection(null, "Deplacement");
			choixdeplacement.setVisible(true);
			choixdeplacement.pack();
		} else {
			System.exit(0);
		} 
	}
	
	public static void main(String[] args){
		JFrame f = new JFrame();
		f.setVisible(true);
		f.setContentPane(new PanelParty(null)); // A CHANGER
		f.pack();
	}
	
}
