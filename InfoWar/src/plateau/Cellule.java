//********************************************************************* 
// Programmeur : Hanquez R�my
// Date : 08/05/2014
// Fichier : Cellule.java
// 
// Classe m�re de Case. G�re le comportement d'une Cellule
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
	
	public Cellule(int x, int y) {
		coord = new Coordonnees(x,y);
	}
	
	public int estBase() {
		return this.base;
	}
	
	public int contientMine() {
		return this.mine;
	}
	
	public Coordonnees getCoordonnees() {
		return this.coord;
	}
	
	public Robot getContenu() {
		return this.robot;
	}
	
	public void setContenu(Robot r) {
		this.robot = r;
	}
	
	public String toString() {
		return this.image;
	}
	
	public abstract void deplaceSur(Robot r);
	
	public abstract void ajout(int equipe);
	
	public abstract void videCase();
	
	public abstract void ajoutObstacle();
	
	public boolean estObstacle(){
		return this.obstacle;
	}

}
