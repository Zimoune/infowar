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
		if (this.getDirection() != null) {
			if (this.getRobot().getVue().getContenu(this.getObjectif()) == null) {
				this.getRobot().getVue().deplaceSur(this.getObjectif(), this.getRobot());
			}
			this.getRobot().setEnergie(this.getRobot().getEnergie()-1);
		}
		
	}

}
