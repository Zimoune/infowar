package graphics;



import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class Options extends JPanel implements ActionListener, KeyListener {

	JLabel titre, nbRobot, perCentObs, taillePlateau, niveauDifficulte, musique;
	JSpinner choixNbRobot, choixObs, hauteur, largeur, choixDifficutle;
	JSlider volume;
	JPanel core, taille;
	JButton retour, setDefautValues;
	boolean valeurCorrecte = true;
	JFrame frame;
	//Emplacement du fichier de config
	String configPath="src/res/config";
	//Config par default
	Properties properties = new Properties();
	int tailleX = 15, tailleY = 12, obstacle = 20, nmbRobot = 1, difficulte = 1, tauxMusique = 50;

	public Options(JFrame frame) {
		//On charge les valeurs d�j� dans la config
		this.loadConfig();
		this.frame = frame;
		this.taille = new JPanel();
		this.core = new JPanel();
		this.volume = new JSlider(0, 100, this.tauxMusique);
		this.choixDifficutle = new JSpinner(new SpinnerNumberModel(this.difficulte, 0, 5, 1));
		this.largeur = new JSpinner(new SpinnerNumberModel(this.tailleX, 5, 20, 1));
		this.hauteur = new JSpinner(new SpinnerNumberModel(this.tailleY, 5, 20, 1));
		this.choixObs = new JSpinner(new SpinnerNumberModel(this.obstacle, 20, 80, 10));
		this.choixNbRobot = new JSpinner(new SpinnerNumberModel(this.nmbRobot, 1, 5, 1));
		this.musique = new JLabel("Musique");
		this.niveauDifficulte = new JLabel("Niveau de difficult� :");
		this.taillePlateau = new JLabel("Taille du plateau :");
		this.perCentObs = new JLabel("Pourcentage d'obstacle :");
		this.nbRobot = new JLabel("Nombre de robots par �quipe :");
		this.titre = new JLabel("Options");
		this.retour = new JButton("Retour");
		this.setDefautValues = new JButton("Valeurs par d�fault");
		this.titre.setFont(new Font("Serif", Font.BOLD, 48));
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.core.setLayout(new GridLayout(5, 4, 200, 100));
		this.taille.add(hauteur);
		this.taille.add(largeur);
		this.retour.addActionListener(this);
		this.core.add(Box.createRigidArea(new Dimension(30, 0)));
		this.core.add(nbRobot);
		this.core.add(choixNbRobot);
		this.core.add(Box.createRigidArea(new Dimension(30, 0)));
		this.core.add(Box.createRigidArea(new Dimension(30, 0)));
		this.core.add(perCentObs);
		this.core.add(choixObs);
		this.core.add(Box.createRigidArea(new Dimension(30, 0)));
		this.core.add(Box.createRigidArea(new Dimension(30, 0)));
		this.core.add(taillePlateau);
		this.core.add(taille);
		this.core.add(Box.createRigidArea(new Dimension(30, 0)));
		this.core.add(Box.createRigidArea(new Dimension(30, 0)));
		this.core.add(niveauDifficulte);
		this.core.add(choixDifficutle);
		this.core.add(Box.createRigidArea(new Dimension(30, 0)));
		this.core.add(Box.createRigidArea(new Dimension(30, 0)));
		this.core.add(musique);
		this.core.add(volume);

		this.add(titre);
		this.titre.setAlignmentX(CENTER_ALIGNMENT);
		this.add(Box.createRigidArea(new Dimension(0, 100)));
		this.add(core);
		this.core.setAlignmentX(CENTER_ALIGNMENT);
		this.add(retour);
		this.retour.setAlignmentX(CENTER_ALIGNMENT);
		this.add(setDefautValues);
		this.setDefautValues.setAlignmentX(CENTER_ALIGNMENT);
		this.add(Box.createRigidArea(new Dimension(0, 100)));

	}		
				
	private void setDefautValues() {
		
		FileOutputStream out;
		try{
			properties.setProperty("taillex", "15");
			properties.setProperty("tailley", "12");
			properties.setProperty("obstacle", "20");
			properties.setProperty("nmbrobot", "1");
			properties.setProperty("difficulte", "1");
			properties.setProperty("tauxmusique", "50");
			
			out = new FileOutputStream(configPath);
			this.properties.store(out, "----config----");
			out.close();
			
		}catch(Exception e){
			System.out.println("Impossible d'�crire dans la config");
			e.printStackTrace();
		}
	}

	private void loadConfig() {
		try{
			FileInputStream in = new FileInputStream(configPath);
			this.properties.load(in);
			this.tailleX = stringToInt(properties.getProperty("taillex"));
			this.tailleY = stringToInt(properties.getProperty("tailley"));
			this.obstacle = stringToInt(properties.getProperty("obstacle"));
			this.nmbRobot = stringToInt(properties.getProperty("nmbrobot"));
			this.difficulte = stringToInt(properties.getProperty("difficulte"));
			this.tauxMusique = stringToInt(properties.getProperty("tauxmusique"));
			
			
			in.close();
		
	} catch(Exception e){
			e.printStackTrace();
			System.out.println("Impossible de charger le fichier de config");
			System.out.println("Chargement des configs par defaut...");
		}
	}

	private int stringToInt(String s){
		int n = 0;
		int nb = 1;
		for(int i=s.length(); i>0;i--){
			n = n + ((s.charAt(i-1)-48) * nb);
			nb = nb*10;
		}
		return n;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == retour){
			this.frame.setContentPane(new MenuPanel(frame));
			this.saveChange();
			this.frame.revalidate();

		}
		else if(e.getSource() == setDefautValues){
			this.frame.setContentPane(new MenuPanel(frame));
			this.setDefautValues();
			this.frame.revalidate();
		}
		
	}

	private void saveChange() {
		FileOutputStream out;
		try{
			properties.setProperty("taillex", ""+this.largeur.getValue());
			properties.setProperty("tailley", ""+this.hauteur.getValue());
			properties.setProperty("obstacle", ""+this.choixObs.getValue());
			properties.setProperty("nmbrobot", ""+this.choixNbRobot.getValue());
			properties.setProperty("difficulte", ""+this.choixDifficutle.getValue());
			properties.setProperty("tauxmusique", ""+this.volume.getValue());
			
			out = new FileOutputStream(configPath);
			this.properties.store(out, "----config----");
			out.close();
			
		}catch(Exception e){
			System.out.println("Impossible d'�crire dans la config");
			e.printStackTrace();
		}
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
