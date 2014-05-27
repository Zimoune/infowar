package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JPanel;

import plateau.Cellule;

public class GraphicsPlateau extends JPanel{
	private int tailleX, tailleY;
	private GridLayout gl;
	private Cellule[][] plateau;
	
	public GraphicsPlateau(int tailleX, int tailleY, Cellule[][] plateau){
		this.plateau = plateau;
		this.tailleX = tailleX;
		this.tailleY = tailleY;
		gl = new GridLayout(tailleX, tailleY);
		this.setLayout(gl);
	}
	
	public void recuperationImages(){
	}
	
	public void paint(Graphics g){
		int x = 50, y = 50, z = x+(10*50);
		for(int i = 0 ; i < 10; i++){
			g.setColor(Color.black);
			g.fillRect(x, y, x*10, 2);
			for(int j = 0; j < 10; j++){
				g.fillRect(x+(j*50), y, 2, 50);
				//On affiche la l'image correspondant à la cellule
				
			}
			y = y + 50;
			}
		g.fillRect(z, x, 2, 10*50);
		g.fillRect(x, y, x*10, 2);
		
	}
	
	
}