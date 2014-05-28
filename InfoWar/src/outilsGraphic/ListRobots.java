package outilsGraphic;

import javax.swing.JComboBox;

public class ListRobots extends JComboBox{

	private int numRobot;
	public ListRobots(int numRobot, String[] listRobot){
		super(listRobot);
		this.numRobot = numRobot;
	}
	
	public int getNumRobot(){
		return this.numRobot;
	}
	
}
