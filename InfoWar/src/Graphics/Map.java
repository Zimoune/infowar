package Graphics;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;

import plateau.Plateau;

public class Map extends JPanel {

	
	
	public Map(Plateau p){
		this.setLayout(new GridLayout(p.getLargeur(),p.getHauteur()));
		for(int i = 0; i < p.getHauteur();i++){
			for( int j = 0; j < p.getLargeur();j++){
				JPanel cellule = new JPanel();
				cellule.setBackground(Color.WHITE);
				if((i+j)%2 == 0)
				cellule.setBackground(Color.BLACK);
				this.add(cellule);
			}
		}
	}

}
