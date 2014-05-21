//********************************************************************* 
// Programmeur : Hanquez Remy
// Date : 08/05/2014
// Fichier : Attaque.java
// 
// Herite de Action. Gere les attaques des differents robots
//*********************************************************************

package action;

import plateau.Coordonnees;

import robot.Robot;

public class Attaque extends Action {
/**
 * Constructeur de la classe Attaque
 * @param r , Robot concerne
 * @param direction , direction de l'action
 */
	public Attaque(Robot r, Coordonnees direction) {
		super(r, direction);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Methode agit()
	 * Elle effectue l'attaque en verifiant tout les parametres de l'action
	 */
	@Override
	public void agit() {
		//On verifie que la direction selectionne n'est pas null
		if (this.getDirection() != null) {

			//On verifie que le robot peut tirer
			if (this.getRobot().peutTirer()) {

				//On verifie que l'endroit ou le robot doit tirer n'est pas vide
				if (this.getRobot().getVue().getContenu(this.getObjectif()) != null) {
					if(this.getRobot().getVue().getContenu(this.getObjectif()).getEquipe() != this.getRobot().getEquipe())
						//On retire l'energie au robot qui se fait attaquer
						this.getRobot().getVue().getContenu(this.getObjectif()).subitTir();
				}
			}
			else{
				/*Si le robot est ia inutile d'afficher le message d'erreur
				if(!this.getRobot().estIa())
					System.out.println("Vous ne pouvez pas effectuer cette action");*/
				this.getRobot().getVue().ajout(this.getObjectif(), this.getRobot().getEquipe());
			}		
			//On retire au robot attaquant l'energie de l'attaque que la case soit vide ou pas
			this.getRobot().setEnergie(this.getRobot().getEnergie()-1);
		}
	}
}
