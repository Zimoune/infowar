package graphics;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class ChoixRobots extends JPanel{

	private int nmbRobot;
	public ChoixRobots(int nmbRobot){
		this.nmbRobot = nmbRobot;
		this.setPreferredSize(new Dimension(300, 300));
		this.setBounds(600, 100, 100, 70);
		this.setBackground(Color.blue);
	}
	
}
