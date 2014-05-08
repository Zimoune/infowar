//********************************************************************* 
// Programmeur : Hanquez R�my
// Date : 08/05/2014
// Fichier : Base.java
// 
// G�re la base des robots
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
	
	public void addRobot(Robot r){
		this.robotDansBase.add(r);
	}
	
	public String getRobot(){
		return this.robotDansBase.toString();
	}
	
	public void removeRobot(Robot r){
		for(Robot r2 : this.robotDansBase){
			if(r.equals(r2)){
				this.robotDansBase.remove(r);
			}
		}
	}

	@Override
	public void ajout(int equipe) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void videCase() {
		this.setContenu(null);
		
	}

	@Override
	public void ajoutObstacle() {
		// TODO Stub de la méthode généré automatiquement
		
	}

}
