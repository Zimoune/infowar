//********************************************************************* 
// Programmeur : Hanquez Remy
// Programmeur : Fack Vincent
// Programmeur : Delplace Gautier
// Programmeur : Lorthios Ludovic
// Programmeur : Lepeltier Damien
// Programmeur : Le Pallac Simon
// Date : 08/05/2014
// Fichier : Vue.java
// 
// Gere la vue des different robot. Deux robots de différentes equipse ne doivent pas avoir la meme vue
//*********************************************************************

package plateau;

import robot.Robot;

public class Vue {
	
	private Plateau p;
	private int equipe;
	
	/**
	 * Constructeur de la classe Vue
	 * @param equipe, correspond a qu'elle equipe on joue
	 * @param p, correspond au plateau
	 */
	
	public Vue(int equipe, Plateau p) {
		this.p = p;
		this.equipe = equipe;
	}
	
	/*
	 * retourne qu'elle equipe on joue
	 */
	
	public int getEquipe() {
		return this.equipe;
	}
	
	/*
	 * retourne si une case contient une mine
	 */

	public int contientMine(Coordonnees c) {
		return this.p.contientMine(c.getLargeur(), c.getHauteur());
	}
	
	/*
	 * retourne si une cellule est une base ou non
	 */

	public int estBase(Coordonnees c) {
		return this.p.estBase(c.getLargeur(), c.getHauteur());
	}
	
	/*
	 * retourne si une cellule est un obstacle ou non
	 */
	
	public boolean estObstacle(Coordonnees c){
		return this.p.estObstacle(c.getLargeur(), c.getHauteur());
	}
	
	/*
	 * retourne les coordonne d'une cellule
	 */
	
	public Coordonnees getCoordonnes(Coordonnees c) {
		return this.p.getCoordonnees(c.getLargeur(), c.getHauteur());
	}
	
	/*
	 * retourne le contenu d'une cellule
	 */
	
	public Robot getContenu(Coordonnees c) {
		return this.p.getContenu(c.getLargeur(), c.getHauteur());
	}
	
	/*
	 * deplace le robot sur une cellule
	 */
	
	public void deplaceSur(Coordonnees c, Robot r) {
		this.p.deplaceSur(c.getLargeur(), c.getHauteur(), r);
	}
	
	/*
	 * permet d'ajouter
	 */
	
	public void ajout(Coordonnees c, int equipe) {
		this.p.ajout(c.getLargeur(), c.getHauteur(), equipe);
	}

	/*
	 * Vide une cellule
	 */
	
	public void videCase(Coordonnees c) {
		this.p.videCase(c.getLargeur(), c.getHauteur());
	}

}
