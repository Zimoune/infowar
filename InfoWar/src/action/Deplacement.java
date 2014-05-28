//********************************************************************* 
// Programmeur : Hanquez Remy
// Programmeur : Fack Vincent
// Programmeur : Delplace Gautier
// Programmeur : Lorthios Ludovic
// Programmeur : Lepeltier Damien
// Programmeur : Le Pallac Simon
// Date : 08/05/2014
// Fichier : Deplacement.java
// 
// Herite de Action. Gere les deplacement des differents robots
//*********************************************************************

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
			
			//on verifie que le robot est un char
			if(this.getRobot().getType().substring(0, 1).equalsIgnoreCase("c")){
				
				if(this.getRobot().getVue().getContenu(getObjectif()) == null && !this.getRobot().getVue().estObstacle(getObjectif())){
					this.getRobot().getVue().deplaceSur(this.getObjectif(), this.getRobot());
					
					if(this.getRobot().getVue().getContenu(new Coordonnees(this.getRobot().getCoordonnees().getLargeur()+this.getDirection().getLargeur(),this.getRobot().getCoordonnees().getHauteur()+this.getDirection().getHauteur())) == null && !this.getRobot().getVue().estObstacle(new Coordonnees(this.getRobot().getCoordonnees().getLargeur()+this.getDirection().getLargeur(),this.getRobot().getCoordonnees().getHauteur()+this.getDirection().getHauteur()))){
						
						this.getRobot().getVue().deplaceSur(new Coordonnees(this.getRobot().getCoordonnees().getLargeur()+this.getDirection().getLargeur(),this.getRobot().getCoordonnees().getHauteur()+this.getDirection().getHauteur()), this.getRobot());
					}
				}
			} else if(this.getRobot().getVue().getContenu(this.getObjectif()) == null && !this.getRobot().getVue().estObstacle(this.getObjectif())){
				this.getRobot().getVue().deplaceSur(this.getObjectif(), this.getRobot());
			}
			
			//Que la case soit vide ou pas on enleve l'energie au robot
			this.getRobot().setEnergie(this.getRobot().getEnergie()-this.getRobot().getCoutDep());
			System.out.println("Vous avez perdu " + this.getRobot().getCoutDep() + " point d'energie");
		}		
	}
}
