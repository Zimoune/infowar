//********************************************************************* 
// Programmeur : Hanquez Remy
// Programmeur : Fack Vincent
// Programmeur : Delplace Gautier
// Programmeur : Lorthios Ludovic
// Programmeur : Lepeltier Damien
// Programmeur : Le Pallac Simon
// Date : 08/05/2014
// Fichier : Base.java
// 
// Gere la base des robots
//*********************************************************************

package plateau;

import java.util.ArrayList;

import robot.Robot;

public class Base extends Cellule {
	private ArrayList<Robot> robotDansBase = new ArrayList<Robot>(); 
	
/**
 * Constructeur de la classe Base
 * @param x
 * @param y
 * @param equipe
 */	
	public Base(int x, int y, int equipe) {
		super(x, y);
		this.base = equipe;
		if (this.base == 1)
			this.image = "B ";
		else
			this.image = "b ";
	}
/**
 * deplace le robot sur cette base
 */
	@Override
	public void deplaceSur(Robot r) {
		if (this.getContenu() == null) {
			r.getVue().videCase(r.getCoordonnees());
			r.setCoordonnees(this.getCoordonnees());
			this.setContenu(r);
		}
		
	}
	
	/*
	 * Ajout d'un robot dans la base
	 */
	
	public void addRobot(Robot r){
		this.robotDansBase.add(r);
	}
	
	/*
	 * Affiche les robots dans la base
	 */
	
	public String getRobot(){
		return this.robotDansBase.toString();
	}
	
	/*
	 * Supprime un robot de la base
	 */
	
	public void removeRobot(Robot r){
		for(Robot r2 : this.robotDansBase){
			if(r.equals(r2)){
				this.robotDansBase.remove(r);
			}
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see plateau.Cellule#ajout(int)
	 */

	@Override
	public void ajout(int equipe) {
		// TODO Auto-generated method stub
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see plateau.Cellule#videCase()
	 */

	@Override
	public void videCase() {
		this.setContenu(null);		
	}
	
	/*
	 * (non-Javadoc)
	 * @see plateau.Cellule#ajoutObstacle()
	 */

	@Override
	public void ajoutObstacle() {
		// TODO Stub de la methode genere automatiquement
		
	}
}
