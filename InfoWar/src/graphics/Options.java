package graphics;



import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Options extends JPanel implements ActionListener, KeyListener {

	JLabel titre;
	JLabel nbRobot;
	JLabel perCentObs;
	JLabel taillePlateau;
	JLabel niveauDifficulte;
	JLabel musique;
	JSpinner choixNbRobot;
	JSpinner choixObs;
	JSpinner hauteur;
	JSpinner largeur;
	JSpinner choixDifficutle;
	JSlider volume;
	JPanel core;
	JPanel taille;
	JButton retour;

	public Options() {

		taille = new JPanel();
		core = new JPanel();
		volume = new JSlider(0, 100);
		choixDifficutle = new JSpinner(new SpinnerNumberModel(0, 0, 5, 1));
		largeur = new JSpinner(new SpinnerNumberModel(15, 5, 20, 1));
		hauteur = new JSpinner(new SpinnerNumberModel(12, 5, 20, 1));
		choixObs = new JSpinner(new SpinnerNumberModel(20, 20, 80, 10));
		choixNbRobot = new JSpinner(new SpinnerNumberModel(1, 1, 5, 1));
		musique = new JLabel("Musique");
		niveauDifficulte = new JLabel("Niveau de difficulté :");
		taillePlateau = new JLabel("Taille du plateau :");
		perCentObs = new JLabel("Pourcentage d'obstacle :");
		nbRobot = new JLabel("Nombre de robots par équipe :");
		titre = new JLabel("Options");
		retour = new JButton("Retour");

		titre.setFont(new Font("Serif", Font.BOLD, 48));

		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		core.setLayout(new GridLayout(5, 4, 200, 100));

		largeur.addKeyListener(this);

		taille.add(hauteur);
		taille.add(largeur);

		retour.addActionListener(this);

		core.add(Box.createRigidArea(new Dimension(30, 0)));
		core.add(nbRobot);
		core.add(choixNbRobot);
		core.add(Box.createRigidArea(new Dimension(30, 0)));
		core.add(Box.createRigidArea(new Dimension(30, 0)));
		core.add(perCentObs);
		core.add(choixObs);
		core.add(Box.createRigidArea(new Dimension(30, 0)));
		core.add(Box.createRigidArea(new Dimension(30, 0)));
		core.add(taillePlateau);
		core.add(taille);
		core.add(Box.createRigidArea(new Dimension(30, 0)));
		core.add(Box.createRigidArea(new Dimension(30, 0)));
		core.add(niveauDifficulte);
		core.add(choixDifficutle);
		core.add(Box.createRigidArea(new Dimension(30, 0)));
		core.add(Box.createRigidArea(new Dimension(30, 0)));
		core.add(musique);
		core.add(volume);

		this.add(titre);
		titre.setAlignmentX(CENTER_ALIGNMENT);
		this.add(Box.createRigidArea(new Dimension(0, 100)));
		this.add(core);
		core.setAlignmentX(CENTER_ALIGNMENT);
		this.add(retour);
		retour.setAlignmentX(CENTER_ALIGNMENT);
		this.add(Box.createRigidArea(new Dimension(0, 100)));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Stub de la méthode généré automatiquement
		// Sauvegarde des changements
		JOptionPane jop = new JOptionPane();
		jop.showMessageDialog(null, "Message d'erreur", "Erreur",
				JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Stub de la méthode généré automatiquement
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Stub de la méthode généré automatiquement

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Stub de la méthode généré automatiquement

	}

}
