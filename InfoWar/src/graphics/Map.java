package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;

import plateau.Plateau;

public class Map extends JPanel {

	
	
	public Map(Plateau p, int equipe){
		this.setPreferredSize(new Dimension(500,500));
		this.setLayout(new GridLayout(p.getHauteur(),p.getLargeur(),5,5));
		for(int i = 0; i < p.getHauteur();i++){
			for( int j = 0; j < p.getLargeur();j++){
				JPanel cellule = new JPanel();
				if(p.estObstacle(j, i))
					cellule.setBackground(Color.BLACK);
				else if(p.getContenu(j, i) != null)
					cellule.add(new JLabel(p.getContenu(j, i).getNom()));
				else if(p.estBase(j, i) > 0)
					cellule.setBackground(Color.YELLOW);
				else if(p.contientMine(j, i) > 0)
					cellule.setBackground(Color.GRAY);
				this.add(cellule);
			}
		}
	}

}
