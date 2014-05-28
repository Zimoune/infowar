package graphics;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class PanelRobot extends JPanel {
	private final JLabel Nb_Robot = new JLabel("Robot n�: ");
	String Type_Robot[] = { "Aleatoire", "Tireur", "Piegeur", "Char" };
	private final JComboBox combo = new JComboBox(Type_Robot);
	int nbRobot; 
	private String robot[] = new String[nbRobot];
	String robot_choisi[] = new String[5];




	public PanelRobot(int i) {
		nbRobot = i;
		this.setBackground(Color.white);
		Nb_Robot.setText(Nb_Robot.getText() + "" + i);
		this.setPreferredSize(new Dimension(300, 50));
		this.setLayout(new BorderLayout());
		this.add(Nb_Robot, BorderLayout.WEST);
		this.add(combo, BorderLayout.EAST);
		combo.setPreferredSize(new Dimension(150, 40));
		combo.setFont((new Font("serif", Font.BOLD, 15)));
		Nb_Robot.setFont((new Font("serif", Font.BOLD, 15)));
		combo.setBackground(Color.white);
		this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		combo.addActionListener(new ItemState());
	}
	
	public int getNbRobot() { // c'est un get pour la classe ChoixRobot jpence pas besoin pour toi
		return nbRobot;
	}
	
	public String get_robot_choisi(int i){ // i correspond au numero du robot genre robot 1,2... et sa retourne un string du genre char aleatoire ....s
			return robot_choisi[i];
		}
	
	
	class ItemState implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			//System.out.println("ActionListener : action sur " +
					//combo.getSelectedItem());
			switch(nbRobot){
			case 1:
				robot_choisi[1]= (String) combo.getSelectedItem();
				System.out.println(robot_choisi[1]);
				break;
			case 2:
				robot_choisi[2]= (String) combo.getSelectedItem();
				System.out.println(robot_choisi[2]);
				break;
			case 3:
				robot_choisi[3]= (String) combo.getSelectedItem();
				System.out.println(robot_choisi[3]);
				break;
			case 4:
				robot_choisi[4]= (String) combo.getSelectedItem();
				System.out.println(robot_choisi[4]);
				break;
			case 5:
				robot_choisi[5]= (String) combo.getSelectedItem();
				System.out.println(robot_choisi[5]);
				break;
			}
			
		}
	}

}
