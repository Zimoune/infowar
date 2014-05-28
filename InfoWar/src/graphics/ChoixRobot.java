package graphics;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ChoixRobot extends JPanel implements ActionListener {
	PanelRobot PRobot[] = new PanelRobot[5];
	String robot_choisi[] = new String[5];
	private final JLabel titre = new JLabel(
			"Choix du pays et des robots de l'equipe n�1 :");
	private final JPanel Panel_titre = new JPanel();
	private final JPanel Panel_Pays = new JPanel();
	private final JLabel Label_Pays = new JLabel("Pays :");
	private final String Pays[] = { " Aleatoire", "France", "Allemagne", "USA",
			"Angleterre", "Irak", "Syrie", "Iran", "Irlande",
			"Afrique du Sud", "Australie", "Portugal", "Suede", "Belgique",
			"Pologne", "Chine", "Japon" };
	private final JList Liste_pays = new JList(Pays);
	private JScrollPane scroll = new JScrollPane(Liste_pays);
	private final JPanel Panel_Robot = new JPanel();
	private final JPanel Panel_Robot_Pays = new JPanel();
	private final JPanel Panel_Bouton = new JPanel();
	private final JButton Precedent = new JButton();
	private final JButton Suivant = new JButton();
	private final int nbRobot;
	
	private boolean suivant = false;
	private boolean precedant = false;
	private String pays = "";

	public ChoixRobot(int nbRobot) {
		this.nbRobot = nbRobot;
		this.setPreferredSize(new Dimension(580, 300));
		// this.setBackground(Color.green);
		Panel_Robot();
		Panel_titre();
		this.add(Panel_titre);
		Panel_Pays();
		this.add(Panel_Robot_Pays);
		Panel_Robot_Pays();
		this.add(Panel_Bouton);
		Panel_Bouton();
		Suivant.addActionListener(new B_Suivant());
		Precedent.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent event){
				  precedant = true;
					System.out.println("precedant" + precedant);
			  }	  
		});
		Liste_pays.addListSelectionListener(new L_pays());
		
		System.out.println(PRobot[1].getNbRobot());
	}
	public void Panel_Robot() {
		//Panel_Robot.setBackground(Color.white);
		Panel_Robot.setPreferredSize(new Dimension(300, 600));
		for (int i = 1; i < nbRobot; i++) {
			Panel_Robot.add(PRobot[i] = new PanelRobot(i));
		}
	}

	public void Panel_titre() {
		titre.setFont(new Font("Serif", Font.BOLD, 40));
		Panel_titre.add(titre);
		Panel_titre.setPreferredSize(new Dimension(1300, 150));
	}

	public void Panel_Pays() {
		Label_Pays.setFont(new Font("serif", Font.BOLD, 25));
		//Label_Pays.setBackground(Color.white);
		 //Panel_Pays.setBackground(Color.blue);
		Liste_pays.setVisibleRowCount(7);
		Liste_pays.setSelectedIndex(0);
		scroll.add(Liste_pays);
		scroll.setViewportView(Liste_pays);
		Panel_Pays.add(scroll);
		scroll.setPreferredSize(new Dimension(200, 300));
		Panel_Pays.setPreferredSize(new Dimension(200, 600));
		Liste_pays.setFont(new Font("Serif", Font.BOLD, 18));
		Liste_pays.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,
				Color.black));
	}

	public void Panel_Robot_Pays() {
		//Panel_Robot_Pays.setBackground(Color.orange);
		Panel_Robot_Pays.add(Panel_Pays);
		Panel_Robot_Pays.add(Panel_Robot);
		Panel_Robot_Pays.setPreferredSize(new Dimension(1000, 400));

	}

	public void Panel_Bouton() {
		//Panel_Bouton.setLayout(new BorderLayout());
		Panel_Bouton.setPreferredSize(new Dimension(1600, 50));
		//Panel_Bouton.setBackground(Color.CYAN);
		Panel_Bouton.add(Precedent/*,BorderLayout.WEST*/);
		Panel_Bouton.add(Suivant/*, BorderLayout.EAST*/);
		Suivant.setText("Suivant");
		Precedent.setText("Precedent");
		Suivant.setPreferredSize(new Dimension(150, 38));
		Precedent.setPreferredSize(new Dimension(150, 38));
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("j'adore");
		
	}
	
	class B_Suivant implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("suivant");
			suivant = true;
			System.out.println(suivant);
		}
	}
	class L_pays implements ListSelectionListener{

		@Override
		public void valueChanged(ListSelectionEvent e) {	
		pays = (String)Liste_pays.getSelectedValue();
		System.out.println("pays : " + pays);
			
		}		
	}
	public boolean getSuivant() {   // return true si le bouton a �t� apuyer 
		return suivant;
	}
	public boolean Precedant() {   // return true si le bouton a �t� appuyer 
		return precedant;
	}
	public String getPays() { // retourne le pays selectionner
		return pays;
	}
	
	
}
