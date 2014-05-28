package graphics;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;

import plateau.Plateau;

public class Map extends JPanel {

	
	
	public Map(Plateau p){
		this.setLayout(new GridLayout(p.getHauteur(),p.getLargeur()));
		for(int i = 0; i < p.getHauteur();i++){
			for( int j = 0; j < p.getLargeur();j++){
				JPanel cellule = new JPanel();
				if(p.estObstacle(j, i))
					cellule.setBackground(Color.BLACK);
				else if(p.getContenu(j, i) != null)
					cellule.setBackground(Color.BLUE);
				else if(p.estBase(j, i) > 0)
					cellule.setBackground(Color.YELLOW);
				this.add(cellule);
			}
		}
	}

}
