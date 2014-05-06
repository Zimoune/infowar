package plateau;


import robot.Robot;

public class Plateau {
	
	private Cellule[][] plateau;
	private int largeur, hauteur;
	
	public Plateau(int largeur, int hauteur) {
		plateau = new Cellule[hauteur][largeur];
		int equipe = 1;
		for (int i=0; i<hauteur; i++) {
			for (int j=0; j<largeur; j++) {
				if ((i == 0 && j == 0) || (i == hauteur-1 && j == largeur -1))
					plateau[i][j] = new Base(j,i,equipe++);
				else
					plateau[i][j] = new Case(j,i);
			}
		}
		this.hauteur = hauteur;
		this.largeur = largeur;
	}
	
	public int getLargeur() {
		return this.largeur;
	}
	
	public int getHauteur() {
		return this.hauteur;
	}
	
	public void deplaceSur(int x, int y, Robot r) {
		if(y >= 0 && y < hauteur  && x >= 0 && x < largeur)
			this.plateau[y][x].deplaceSur(r);
	}
	
	public void ajout(int x, int y, int equipe) {
		if(y >= 0 && y < hauteur  && x >= 0 && x < largeur)
			this.plateau[y][x].ajout(equipe);
	}
	
	public void videCase(int x, int y) {
		if(y >= 0 && y < hauteur && x >= 0 && x < largeur)
			this.plateau[y][x].videCase();
	}
	
	public int estBase(int x, int y) {
		if(y >= 0 && y < hauteur  && x >= 0 && x < largeur)
			return this.plateau[y][x].estBase();
		return -1;
	}
	
	public int contientMine(int x, int y) {
		if(y >= 0 && y < hauteur  && x >= 0 && x < largeur)
			return this.plateau[y][x].contientMine();
		return -1;
	}
	
	public Coordonnees getCoordonnees(int x, int y) {
		if(y >= 0 && y < hauteur  && x >= 0 && x < largeur)
			return this.plateau[y][x].getCoordonnees();
		return null;
	}
	
	public Robot getContenu(int x, int y) {
		if(y >= 0 && y < hauteur  && x >= 0 && x < largeur)
			return this.plateau[y][x].getContenu();
		return null;
	}
	
	public void afficherPlateau(Robot r) {
		for(int i=0; i<plateau.length; i++) {
			for (int j=0; j<plateau[0].length; j++) {
				System.out.print("|");
				if(plateau[i][j].contientMine() > 0) {
					if (plateau[i][j].contientMine() == r.getEquipe())
						System.out.print(plateau[i][j]);
					else
						System.out.print(" ");
				}
				else
					System.out.print(plateau[i][j]);
					
			}
			System.out.print("|");
			if(i == 2)
				System.out.print("     Deplacement = d et Attaque = a");
			if(i == 3)
				System.out.print("	   a=haut-gauche, z=haut, e=haut-droite");
			if(i == 4)
				System.out.print("        q=gauche, d=droite");
			if(i == 5){
				System.out.print("        w=bas-gauche, s=bas, c=bas-droite");
			}
			System.out.println();
		}

		System.out.println(r);
	}
	
}

