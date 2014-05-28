//********************************************************************* 
// Programmeur : Hanquez Remy
// Programmeur : Fack Vincent
// Programmeur : Delplace Gautier
// Programmeur : Lorthios Ludovic
// Programmeur : Lepeltier Damien
// Programmeur : Le Pallac Simon
// Date : 08/05/2014
// Fichier : Plateau.java
// 
// Gere le plateau de jeu tels que l'affichage 
//*********************************************************************

package plateau;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import robot.Robot;

public class Plateau {

	private Cellule[][] plateau;
	private int largeur, hauteur;
	
	/**
	 * Constructeur de la classe Plateau
	 * @param largeur, correspond a la largeur du plateau
	 * @param hauteur, correspond a la hauteur du plateau
	 */

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
	
	/*
	 * retourne la largeur du plateau
	 */

	public int getLargeur() {
		return this.largeur;
	}
	
	/*
	 * retourne la hauteur du plateau
	 */

	public int getHauteur() {
		return this.hauteur;
	}
	
	/*
	 * permet de deplace le robot sur une case
	 */

	public void deplaceSur(int x, int y, Robot r) {
		if(y >= 0 && y < hauteur  && x >= 0 && x < largeur)
			this.plateau[y][x].deplaceSur(r);
	}
	
	/*
	 * permet d'ajouter
	 */

	public void ajout(int x, int y, int equipe) {
		if(y >= 0 && y < hauteur  && x >= 0 && x < largeur)
			this.plateau[y][x].ajout(equipe);
	}
	
	/*
	 * permet de vider une case
	 */

	public void videCase(int x, int y) {
		if(y >= 0 && y < hauteur && x >= 0 && x < largeur)
			this.plateau[y][x].videCase();
	}
	
	/*
	 * permet de savoir si une case est une base ou pas
	 */

	public int estBase(int x, int y) {
		if(y >= 0 && y < hauteur  && x >= 0 && x < largeur)
			return this.plateau[y][x].estBase();
		return -1;
	}
	
	/*
	 * permet de savoir si la case est un obstacle
	 */
	
	public boolean estObstacle(int x, int y){
		if(y >= 0 && y < hauteur  && x >= 0 && x < largeur)
			return this.plateau[y][x].estObstacle();
		return false;
	}

	/*
	 * permet de savoir si une case contient une mine
	 */
	
	public int contientMine(int x, int y) {
		if(y >= 0 && y < hauteur  && x >= 0 && x < largeur)
			return this.plateau[y][x].contientMine();
		return -1;
	}
	
	/*
	 * retourne les coordonee d'une case
	 */

	public Coordonnees getCoordonnees(int x, int y) {
		if(y >= 0 && y < hauteur  && x >= 0 && x < largeur)
			return this.plateau[y][x].getCoordonnees();
		return null;
	}
	
	/*
	 * retourne le contenu d'une case : le robot
	 */

	public Robot getContenu(int x, int y) {
		if(y >= 0 && y < hauteur  && x >= 0 && x < largeur)
			return this.plateau[y][x].getContenu();
		return null;
	}
	
	/*
	 * permet d'afficher le plateau
	 */

	public void afficherPlateau(Robot r) {
		for(int i=0; i<plateau.length; i++) {
			for (int j=0; j<plateau[0].length; j++) {
				System.out.print("|");
				if(plateau[i][j].contientMine() > 0) {
					if (plateau[i][j].contientMine() != r.getEquipe())
						System.out.print(plateau[i][j]);
					else 
						System.out.print("  ");
				}
				else
					System.out.print(plateau[i][j]);

			}
			System.out.print("|");
			if(i == 2)
				System.out.print("	Deplacement = d et Attaque = a");
			if(i == 3)
				System.out.print("		a=haut-gauche, z=haut, e=haut-droite");
			if(i == 4)
				System.out.print("		q=gauche, d=droite");
			if(i == 5){
				System.out.print("		w=bas-gauche, s=bas, c=bas-droite");
			}
			System.out.println();
		}

		System.out.println();
	}
	
	/*
	 * Genere un chemin entre la base B et la base b
	 */

	public void genererchemin() {
		Random hauteur1 = new Random();
		Random longueur2 = new Random();
		Random choix = new Random();
		ArrayList chemin = new ArrayList();
		System.out.println(this.getHauteur());
		System.out.println(this.getLargeur());
		int milieu = getLargeur() / 2;
		//System.out.println(milieu);
		Coordonnees c = new Coordonnees(milieu, hauteur1.nextInt(
				getLargeur()));
		chemin.add(c);
		chemin.add(new Coordonnees(0, 0));
		chemin.add(new Coordonnees(getLargeur() - 1, getHauteur() - 1));
		Coordonnees droite = new Coordonnees(milieu + 1, c.getHauteur());
		chemin.add(droite);
		Coordonnees gauche = new Coordonnees(milieu - 1, c.getHauteur());
		chemin.add(gauche);
		Coordonnees base1 = new Coordonnees(0, 0);
		Coordonnees base2 =new Coordonnees(getLargeur() - 1, getHauteur() - 1);

		while (!gauche.equals(base1)) {
			if (gauche.getLargeur() == 0) {
				gauche = new Coordonnees(0, gauche.getHauteur() - 1);
				chemin.add(gauche);
			} else if (gauche.getHauteur() == 0) {
				gauche = new Coordonnees(gauche.getLargeur() - 1, 0);
				chemin.add(gauche);
			}
			else if (choix.nextInt(2) == 0) {
				gauche = new Coordonnees(gauche.getLargeur() - 1, 
						gauche.getHauteur());
				chemin.add(gauche);
			} else {
				gauche = new Coordonnees(gauche.getLargeur(), 
						gauche.getHauteur() - 1);
				chemin.add(gauche);
			}
		}

		while (!droite.equals(base2)) {
			if (droite.getLargeur() == (this.largeur -1)) {
				droite = new Coordonnees(droite.getLargeur(), 
						droite.getHauteur() + 1);
				chemin.add(droite);

			} else if (droite.getHauteur() == (this.hauteur -1)) {
				droite = new Coordonnees(droite.getLargeur() + 1, 
						droite.getHauteur());
				chemin.add(droite);
				//System.out.println("fais chier");
			}
			else if (choix.nextInt(2) == 0) {
				droite = new Coordonnees(droite.getLargeur() + 1, 
						droite.getHauteur());
				chemin.add(droite);
			} else {
				droite = new Coordonnees(droite.getLargeur(), 
						droite.getHauteur() + 1);
				chemin.add(droite);
			}
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("Quel est le pourcentage d'obstacle souhaite :");
		int pourcentage = sc.nextInt();
		int ctp = getHauteur() * getLargeur() * pourcentage / 100;
		while(ctp >0){
			Coordonnees obstacle = new Coordonnees(longueur2.nextInt(getLargeur()), 
					hauteur1.nextInt(getHauteur()));
			//System.out.println(!chemin.contains(obstacle));
			if (!chemin.contains(obstacle)) {
				this.plateau[obstacle.getHauteur()][obstacle.getLargeur()] = new Obstacle(
						obstacle.getHauteur(), obstacle.getLargeur());
				ctp--;
			} else {
				//System.out.println(obstacle + "est sur le chemin");
			}
		}
	}
}