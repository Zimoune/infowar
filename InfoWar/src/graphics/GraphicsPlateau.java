package graphics;

import java.awt.GridLayout;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JPanel;

import plateau.Cellule;

public class GraphicsPlateau extends JPanel{
	private int tailleX, tailleY;
	private GridLayout gl;
	private Cellule[][] plateau;
	private MenuPrincipal frame;
	public GraphicsPlateau(MenuPrincipal frame){
		//Récupèration et attribution des options
		loadOptions();
		this.frame = frame;
		//this.plateau = plateau;
		this.tailleX = 10;
		this.tailleY = 12;
		gl = new GridLayout(tailleX, tailleY);
		this.setLayout(gl);
		this.frame.revalidate();
	}
	
	private int stringToInt(String s){
		int n = 0;
		int nb = 1;
		for(int i=s.length(); i>0;i--){
			n = n + ((s.charAt(i-1)-48) * nb);
			nb = nb*10;
		}
		return n;
	}
	private void loadOptions() {
		String configPath="src/res/config";
		Properties properties = new Properties();
		try{
			FileInputStream in = new FileInputStream(configPath);
			properties.load(in);
			this.tailleX = stringToInt(properties.getProperty("tailleX"));
			this.tailleY = stringToInt(properties.getProperty("tailleY"));
			System.out.println(tailleX + "  et " + tailleY);
			in.close();
		} catch(IOException e){
			System.out.println("Impossible de charger le fichier de config");
		}
		
		
	}

	public void recuperationImages(){
	}
	/*
	public void paint(Graphics g){
		System.out.println("bou");
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
		
	}*/
	
	
}