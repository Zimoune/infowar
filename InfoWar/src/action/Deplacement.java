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
			if(this.getRobot().getType().equalsIgnoreCase("c")){
				if(this.getRobot().getVue().getContenu(getObjectif()) != null && !this.getRobot().getVue().estObstacle(getObjectif())){
					this.getRobot().getVue().deplaceSur(this.getObjectif(), this.getRobot());
					if(this.getRobot().getVue().getContenu(new Coordonnees(this.getObjectif().getLargeur()+this.getDirection().getLargeur(),this.getObjectif().getHauteur()+this.getDirection().getHauteur())) != null && !this.getRobot().getVue().estObstacle(new Coordonnees(this.getObjectif().getLargeur()+this.getDirection().getLargeur(),this.getObjectif().getHauteur()+this.getDirection().getHauteur()))){
						this.getRobot().getVue().deplaceSur(new Coordonnees(this.getObjectif().getLargeur()+this.getDirection().getLargeur(),this.getObjectif().getHauteur()+this.getDirection().getHauteur()), this.getRobot());
					}
				}
			}
			
			//On verifie que la case choisi est bien vide
			if (this.getRobot().getVue().getContenu(this.getObjectif()) == null && !this.getRobot().getVue().estObstacle(this.getObjectif())) {
				//On deplace le robot sur cette case
				this.getRobot().getVue().deplaceSur(this.getObjectif(), this.getRobot());
			}
			
			//Que la case soit vide ou pas on enleve l'energie au robot
			this.getRobot().setEnergie(this.getRobot().getEnergie()-this.getRobot().getCoutDep());
			System.out.println("Vous avez perdu " + this.getRobot().getCoutDep() + " point d'energie");
		}		
	}
}
