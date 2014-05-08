package action;

import plateau.Coordonnees;
import robot.Robot;

public class Deplacement extends Action {

	public Deplacement(Robot r, Coordonnees direction) {
		super(r, direction);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void agit() {
		//On vérifie que la direction est differente de null
		if (this.getDirection() != null) {
			
			//On vérifie que la case choisi est bien vide
			if (this.getRobot().getVue().getContenu(this.getObjectif()) == null) {
				
				//On déplace le robot sur cette case
				this.getRobot().getVue().deplaceSur(this.getObjectif(), this.getRobot());
			}
			
			//Que la case soit vide ou pas on enleve l'energie au robot
			this.getRobot().setEnergie(this.getRobot().getEnergie()-1);
			System.out.println("Vous avez perdu 1 point d'energie");
		}		
	}
}
