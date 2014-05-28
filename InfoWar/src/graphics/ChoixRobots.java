package graphics;

import java.util.ArrayList;

import javax.swing.JPanel;

import outilsGraphic.ListRobots;
import robot.Robot;

public class ChoixRobots extends JPanel{

	private final String[] listRobot = {"Tireur", "Char", "Piegeur"};
	private int nmbRobot;
	ArrayList<ListRobots> combo = new ArrayList<ListRobots>();
	private ArrayList<Robot> listRobotEquipe = new ArrayList<Robot>();
	//private final listRobots listeRobot = new JList(listPays);
//	private JScrollPane scroll = new JScrollPane(liste_pays);
	public ChoixRobots(int equipe, int nmbRobot){


		this.nmbRobot = nmbRobot;
		this.setBounds(650, 150, 250, 350);
		//this.setBackground(Color.blue);
		//this.setLayout(new GridLayout(3, 1));
		creerComboBox();
		attribuerRobot();
	}
	private void creerComboBox() {	
		for(int i=0; i<nmbRobot; i++){
			combo.add(new ListRobots(i+1, listRobot));
		}
		int y = 0;
		for(ListRobots cb:combo){
			cb.setBounds(0, y, 50, 60);
			
			this.add(cb);
			y = y + 50;
		}	
	}
	public void attribuerRobot(){
		
	}
}
