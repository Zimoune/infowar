package graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import outilsGraphic.MyJButton;

public class ChoixRobot extends JPanel implements ActionListener {
	PanelRobot PRobot[] = new PanelRobot[5];
	String robot_choisi[] = new String[5];
	private final JLabel titre;
	private final JPanel panel_titre = new JPanel();
	private final JPanel panel_Pays = new JPanel();
	private final JLabel label_Pays = new JLabel("Pays :");
	private final String[] listPays = { " Aleatoire", "France", "Allemagne", "USA",
			"Angleterre", "Irak", "Syrie", "Iran", "Irlande",
			"Afrique du Sud", "Australie", "Portugal", "Suede", "Belgique",
			"Pologne", "Chine", "Japon" };
	private final JList liste_pays = new JList(listPays);
	private JScrollPane scroll = new JScrollPane(liste_pays);
	private final JPanel panel_Robot = new JPanel();
	private final JPanel panel_Robot_Pays = new JPanel();
	private final JPanel panel_Bouton = new JPanel();
	private final JButton precedent = new JButton();
	private ChoixRobots choixRobots;
	private final JButton suivant = new JButton();
	private final int nbRobot;
	private MenuPrincipal frame;
	private boolean isSuivant = false;
	private boolean isPrecedent = false;
	private String pays = "";
	private int equipe;
	private MyJButton nextButton;

	public ChoixRobot(int nbRobot, int equipe, MenuPrincipal frame){
		this.equipe = equipe;
		this.frame = frame;
		this.titre = new JLabel(
				"Choix du pays et des robots de l'equipe numero "+this.equipe);
		this.nbRobot = nbRobot;
		this.setLayout(null);
		//Ajout du bouton suivant
		this.nextButton = new MyJButton("Suivant");
		this.nextButton.setBounds(400, 500, 150, 50);
		this.nextButton.addActionListener(this);
		this.add(this.nextButton);
		this.choixRobots = new ChoixRobots(1, this.nbRobot);
		this.add(this.choixRobots);
		this.titre.setBounds(90, 10, 800, 60);
		this.titre.setFont(new Font("Serif", Font.BOLD, 30));
		this.add(titre);
		this.setPreferredSize(new Dimension(580, 300));
		
		// this.setBackground(Color.green);
		//Panel_Robot();
		//Panel_titre();
		//this.add(panel_Robot);
		//this.add(panel_titre);
		Panel_Pays();
		
		panel_Robot_Pays.setBounds(50, 150, 200, 350);
		//panel_Robot_Pays.setBackground(Color.green);
		panel_Robot_Pays.add(panel_Pays);
		panel_Pays.setBounds(0, 0, 150, 300);
		//panel_Pays.setBackground(Color.red);
		this.add(panel_Robot_Pays);
		Panel_Robot_Pays();
		//this.add(panel_Bouton);
		//Panel_Bouton();
		//suivant.addActionListener(this);
		//precedent.addActionListener(this);
		liste_pays.addListSelectionListener(new L_pays());
		
		//System.out.println(PRobot[1].getNbRobot());
	}

	public void Panel_Robot() {
		//Panel_Robot.setBackground(Color.white);
		panel_Robot.setPreferredSize(new Dimension(300, 600));
		for (int i = 1; i < nbRobot; i++) {
			panel_Robot.add(PRobot[i] = new PanelRobot(i));
			
		}
	}

	public void Panel_titre() {
		
		panel_titre.add(titre);
		panel_titre.setPreferredSize(new Dimension(1300, 150));
		this.frame.revalidate();
	}

	public void Panel_Pays() {
		label_Pays.setFont(new Font("serif", Font.BOLD, 25));
		//Label_Pays.setBackground(Color.white);
		 //Panel_Pays.setBackground(Color.blue);
		liste_pays.setVisibleRowCount(7);
		liste_pays.setSelectedIndex(0);
		scroll.add(liste_pays);
		scroll.setViewportView(liste_pays);
		panel_Pays.add(scroll);
		scroll.setPreferredSize(new Dimension(200, 300));
		panel_Pays.setPreferredSize(new Dimension(200, 600));
		liste_pays.setFont(new Font("Serif", Font.BOLD, 18));
		liste_pays.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,
				Color.black));
	}

	public void Panel_Robot_Pays() {
		//Panel_Robot_Pays.setBackground(Color.orange);
		panel_Robot_Pays.add(panel_Pays);
		panel_Robot_Pays.add(panel_Robot);

	}

	public void Panel_Bouton() {
		//Panel_Bouton.setLayout(new BorderLayout());
		panel_Bouton.setPreferredSize(new Dimension(1600, 50));
		//Panel_Bouton.setBackground(Color.CYAN);
		//panel_Bouton.add(precedent/*,BorderLayout.WEST*/);
		panel_Bouton.add(suivant/*, BorderLayout.EAST*/);
		suivant.setText("Suivant");
		precedent.setText("Precedent");
		suivant.setPreferredSize(new Dimension(150, 38));
		precedent.setPreferredSize(new Dimension(150, 38));
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == nextButton){
			if(this.equipe == 1){
				this.frame.setContentPane(new ChoixRobot(this.nbRobot, 2, this.frame));
				this.frame.getMap();
				this.frame.revalidate();
			}
		}
		else{
			
		}
		
	}
	
	class L_pays implements ListSelectionListener{

		@Override
		public void valueChanged(ListSelectionEvent e) {	
		pays = (String)liste_pays.getSelectedValue();
		System.out.println("pays : " + pays);
			
		}		
	}
	
}
