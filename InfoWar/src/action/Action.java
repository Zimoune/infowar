//********************************************************************* 
// Programmeur : Hanquez R�my
// Date : 08/05/2014
// Fichier : Action.java
// 
// Classe m�re de Attaque et d�placement. G�re Toute les actions des robots 
//*********************************************************************

package action;

import plateau.Coordonnees;

import robot.Robot;

public abstract class Action {
	
	private Robot robot;
	private Coordonnees coord;
	
	public Action(Robot r, Coordonnees direction) {
		this.robot = r;
		this.coord = direction;
	}
	
	public Robot getRobot() {
		return this.robot;
	}
	
	public Coordonnees getDirection() {
		return this.coord;
	}
	
	public Coordonnees getObjectif() {
		return new Coordonnees(robot.getCoordonnees().getLargeur()+coord.getLargeur(),
				robot.getCoordonnees().getHauteur()+coord.getHauteur());
	}
	
	public abstract void agit();

}
