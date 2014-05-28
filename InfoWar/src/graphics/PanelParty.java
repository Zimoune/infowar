package graphics;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import plateau.Plateau;
import plateau.Vue;
import robot.Char;
import robot.Robot;
import robot.Tireur;

public class PanelParty extends JPanel implements ActionListener {

	JLabel auTourde ;
	JButton deplacement;
	JButton attaque;
	JButton quitter;
	
	Map map;
	JPanel panelButton;
	Plateau p;
	int equipe;
	
	String nomPays1 = "France";
	String nomPays2 = "Allemagne";
	ArrayList<Robot> equipe1;
	ArrayList<Robot> equipe2;
	public PanelParty(Plateau p, int equipe, ArrayList<Robot> equipe1, ArrayList<Robot> equipe2){
		
		this.p = p;
		this.equipe = equipe;
		this.equipe1 = equipe1;
		this.equipe2 = equipe2;
		
		this.setLayout(new BorderLayout());
		
		this.auTourde = new JLabel(); // A CHANGER
		if(equipe == 1)
			this.auTourde.setText(nomPays1);
		else
			this.auTourde.setText(nomPays2);
		this.deplacement = new JButton("Deplacer");
		this.attaque = new JButton("Attaquer");
		this.quitter = new JButton("Quitter");
		this.map = new Map(p,this.equipe); // A CHANGER
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
			choixdeplacement = new ChoixDirection(equipe1.get(1), "Attaque",this);
			choixdeplacement.setVisible(true);
			choixdeplacement.pack();
		} else if( arg0.getSource() == deplacement){
			choixdeplacement = new ChoixDirection(equipe1.get(1), "Deplacement",this);
			choixdeplacement.setVisible(true);
			choixdeplacement.pack();
		} else {
			System.exit(0);
		} 
	}
	
	public static void main(String[] args){
		
		Plateau p = new Plateau(15,12);
		Vue v1 = new Vue(1,p);
		Vue v2 = new Vue(2,p);
		ArrayList<Robot> listeRobotEquipe1 = new ArrayList<Robot>();
		ArrayList<Robot> listeRobotEquipe2 = new ArrayList<Robot>();
		listeRobotEquipe1.add(new Tireur(v1,0,0,1,"Tireur"));
		listeRobotEquipe1.add(new Tireur(v1,0,0,1,"Tireur1"));
		listeRobotEquipe1.add(new Char(v1,0,0,1,"Char"));
		listeRobotEquipe2.add(new Tireur(v2,0,0,1,"Tireur2"));
		listeRobotEquipe2.add(new Tireur(v2,0,0,1,"Tireur3"));
		listeRobotEquipe2.add(new Char(v2,0,0,1,"Char2"));
		p.genererchemin();

		JFrame f = new JFrame();
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setContentPane(new PanelParty(p,0,listeRobotEquipe1,listeRobotEquipe2)); // A CHANGER
		f.pack();
	}
	
	public void setEquipe(int equipeActuel){
		this.equipe = 3 - equipeActuel;
		this.repaint();
	}
	
}
