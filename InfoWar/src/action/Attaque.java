package action;

import plateau.Coordonnees;
import robot.Robot;

public class Attaque extends Action {

	public Attaque(Robot r, Coordonnees direction) {
		super(r, direction);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void agit() {
		if (this.getDirection() != null) {
			if (this.getRobot().peutTirer()) {
				if (this.getRobot().getVue().getContenu(this.getObjectif()) != null) {
					this.getRobot().getVue().getContenu(this.getObjectif()).subitTir();
				}
			}
			else
				this.getRobot().getVue().ajout(this.getObjectif(), this.getRobot().getEquipe());
			this.getRobot().setEnergie(this.getRobot().getEnergie()-1);
		}
		
	}

}
