package action;

import plateau.Coordonnees;

import robot.Robot;

public class Deplacement extends Action {
	/**
	 * Constructeur de la classe Deplacement
	 * @param r , Robot concerne
	 * @param direction, direction de l'action
	 */
	public Deplacement(Robot r, Coordonnees direction) {
		super(r, direction);
		// TODO Auto-generated constructor stub
	}
	/**
	 * Methode agit() Elle effectue le deplacement et verifie les parametres
	 */
	@Override
	public void agit() {
		//On verifie que la direction est differente de null
		if (this.getDirection() != null) {
			
			//On verifie que la case choisi est bien vide
			if (this.getRobot().getVue().getContenu(this.getObjectif()) == null) {
				
				//On deplace le robot sur cette case
				this.getRobot().getVue().deplaceSur(this.getObjectif(), this.getRobot());
			}
			
			//Que la case soit vide ou pas on enleve l'energie au robot
			this.getRobot().setEnergie(this.getRobot().getEnergie()-1);
			System.out.println("Vous avez perdu 1 point d'energie");
		}		
	}
}
