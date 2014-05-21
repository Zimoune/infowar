//********************************************************************* 
// Programmeur : Hanquez Remy
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
	
	/*public void genererchemin(){
		Random hauteur1 = new Random();
		Random longueur2 = new Random();
		Random choix = new Random();
		ArrayList<Coordonnees> chemin = new ArrayList<Coordonnees>();
		int milieu = (int)(this.getLargeur()/2);
		System.out.println(milieu);
		Coordonnees c = new Coordonnees(milieu,hauteur1.nextInt(this.getHauteur()));
		chemin.add(c);
		chemin.add(new Coordonnees(0,0));
		chemin.add(new Coordonnees(this.getLargeur(),this.getHauteur()));
		Coordonnees droite = new Coordonnees(milieu +1,c.getHauteur());
		Coordonnees gauche = new Coordonnees(milieu -1,c.getHauteur());
		System.out.println(gauche);
		chemin.add(droite);
		chemin.add(gauche);
		System.out.println( droite);
		Coordonnees base1 = new Coordonnees(0,0);
		Coordonnees base2 = new Coordonnees(this.getLargeur(),this.getHauteur());
		Obstacle obs;
		while(!(gauche.estEgale(base1))){
			if (gauche.getLargeur() == 0){	
				gauche = new Coordonnees(0,gauche.getHauteur() -1);
				chemin.add(gauche);
			}
			else if(gauche.getHauteur() == 0){
				gauche = new Coordonnees(gauche.getLargeur() -1 , 0);
				chemin.add(gauche);
			}
			else {
				if(choix.nextInt(2) == 0){
					gauche = new Coordonnees(gauche.getLargeur() - 1, gauche.getHauteur());
					chemin.add(gauche);
				}
				else {
					gauche = new Coordonnees(gauche.getLargeur(),gauche.getHauteur() -1);
					chemin.add(gauche);
				}
			}
		}
		while(!(droite.estEgale(base2))){
			if (droite.getLargeur() == this.getLargeur()){
				droite = new Coordonnees(droite.getLargeur(),droite.getHauteur() + 1);
				chemin.add(droite);
			}
			else if (droite.getHauteur() == this.getHauteur()){
				droite = new Coordonnees(droite.getLargeur() +1, droite.getHauteur());
				chemin.add(droite);
			}
			else {
				if(choix.nextInt(2) == 0){
					droite = new Coordonnees(droite.getLargeur() +1, droite.getHauteur());
					chemin.add(droite);
				}
				else {
					droite = new Coordonnees(droite.getLargeur(),droite.getHauteur()+1);
					chemin.add(droite);
				}
			}
		}
		System.out.println(chemin);
		Scanner sc = new Scanner(System.in);
		System.out.println("Quel est le pourcentage d'obstacle souhaite :");
		int pourcentage = sc.nextInt();
		int ctp =this.getHauteur()*this.getLargeur()*pourcentage/100;
		Coordonnees obstacle;
		do {
			obstacle = new Coordonnees(longueur2.nextInt(this.getLargeur()),hauteur1.nextInt(this.getHauteur()));
			System.out.println(!chemin.contains(obstacle));
			if (!chemin.contains(obstacle)) {
				System.out.println("Rentrer" + obstacle);
				this.plateau[obstacle.getLargeur()][obstacle.getHauteur()] = new Obstacle(obstacle.getLargeur(),obstacle.getHauteur());
				ctp--;
			}
			else {
				System.out.println(obstacle + "est sur le chemin");
			}
		} while(ctp > 0);
	}*/
	
}

