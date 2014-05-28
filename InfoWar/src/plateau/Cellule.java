//********************************************************************* 
// Programmeur : Hanquez Remy
// Programmeur : Fack Vincent
// Programmeur : Delplace Gautier
// Programmeur : Lorthios Ludovic
// Programmeur : Lepeltier Damien
// Programmeur : Le Pallac Simon
// Date : 08/05/2014
// Fichier : Cellule.java
// 
// Classe mere de Case. Gere le comportement d'une Cellule
//*********************************************************************

package plateau;

import robot.Robot;

public abstract class Cellule {
	
	protected int base = 0;
	protected int mine = 0;
	String image = "  ";
	private Robot robot;
	private Coordonnees coord;
	protected boolean obstacle = false;
	
	/**
	 * Constructeur de la classe Cellule
	 * @param x, correspond a la largeur du plateau
	 * @param y, correspond a la hauteur du plateau
	 */
	
	public Cellule(int x, int y) {
		coord = new Coordonnees(x,y);
	}
	
	/*
	 * retourne si une cellule est une base ou pas
	 */
	
	public int estBase() {
		return this.base;
	}
	
	/*
	 * permet de definir une cellule en tant qu'obstacle
	 */	

	public void setObstacle(boolean obstacle) {
		this.obstacle = obstacle;
	}
	
	/*
	 * retourne si la cellule contient une mine ou pas
	 */

	public int contientMine() {
		return this.mine;
	}
	
	/*
	 * retourne les coordonnees
	 */
	
	public Coordonnees getCoordonnees() {
		return this.coord;
	}
	
	/*
	 * retourne le robot qui se trouve sur cette cellule si il y a bien un robot
	 */
	
	public Robot getContenu() {
		return this.robot;
	}
	
	/*
	 * Permet de mettre un robot sur une cellule
	 */
	
	public void setContenu(Robot r) {
		this.robot = r;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * affiche ce qui se trouve dans la cellule
	 */
	
	public String toString() {
		return this.image;
	}
	
	/*
	 * retourne l'obstacle 
	 */
	
	public boolean estObstacle(){
		return this.obstacle;
	}
	
	public abstract void deplaceSur(Robot r);
	
	public abstract void ajout(int equipe);
	
	public abstract void videCase();
	
	public abstract void ajoutObstacle();
}
