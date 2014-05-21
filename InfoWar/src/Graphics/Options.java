package Graphics;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Options extends JPanel implements ActionListener {

	JLabel titre = new JLabel("Options");
	JLabel nbRobot = new JLabel("Nombre de robots par équipe :");
	JLabel perCentObs = new JLabel("Pourcentage d'obstacle :");
	JLabel taillePlateau = new JLabel("Taille du plateau :");
	JLabel niveauDifficulte = new JLabel("Niveau de difficulté :");
	JLabel musique = new JLabel("Musique");
	JSpinner choixNbRobot = new JSpinner();
	JSpinner choixObs = new JSpinner();
	JTextField hauteur = new JTextField("15", 2);
	JTextField largeur = new JTextField("12",2);
	JSpinner choixDifficutle = new JSpinner();
	JSlider volume = new JSlider(0, 100);
	JPanel core = new JPanel();
	JPanel taille = new JPanel();
	
	
	public Options(){
		this.setLayout(null);
		core.setLayout(new GridLayout(5,2));
		
		taille.add(hauteur);
		taille.add(largeur);
		
		core.add(nbRobot);
		core.add(choixNbRobot);
		core.add(perCentObs);
		core.add(choixObs);
		core.add(taillePlateau);
		core.add(taille);
		core.add(niveauDifficulte);
		core.add(choixDifficutle);
		core.add(musique);
		core.add(volume);
		
		this.add(titre);
		titre.setBounds(200, 10, 100, 10);
		this.add(core);
		core.setBounds(100,100,300,300);
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Stub de la méthode généré automatiquement
		
	}
	
}
