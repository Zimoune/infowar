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
	
	/**
	 * Constructeur de la classe Action
	 * @param robot , Robot qui effectue l'action
	 * @param direction , Coordonnee indiquant la direction
	 */
	public Action(Robot robot, Coordonnees direction) {
		this.robot = robot;
		this.coord = direction;
	}
	
	/**
	 * Retourne le robot qui effectue l'action
	 * @return robot
	 */
	public Robot getRobot() {
		return this.robot;
	}
	
	/**
	 * Retourne la direction de l'action
	 * @return coord
	 */
	public Coordonnees getDirection() {
		return this.coord;
	}
	
	/**
	 * Retourne la cible de l'action du robot
	 * @return objectif
	 */
	public Coordonnees getObjectif() {
		return new Coordonnees(robot.getCoordonnees().getLargeur()+coord.getLargeur(),
				robot.getCoordonnees().getHauteur()+coord.getHauteur());
	}
	
	public abstract void agit();

}
