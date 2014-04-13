public class Deplacement extends Action {

	public Deplacement(Robot robot, Coordonnees direction) {
		super(robot, direction);
	}

	@Override
	public void agit() {
		if (this.getObjectif().getHauteur() < 10
				&& this.getObjectif().getHauteur() > 0
				&& this.getObjectif().getLargeur() < 5
				&& this.getObjectif().getLargeur() > 0) { // Verifie que le
														// deplacement est dans
														// le plateau
			this.getRobot().setCoordonnees(this.getObjectif());// Change les
																// coordonnees
																// du robot
		this.getRobot().setEnergie(this.getRobot().getEnergie() - this.getRobot().getCoutDep());// Enleve les point d'energie necessaire pour effectuer le deplacement
			
		}
		else {
			this.getRobot().setEnergie(this.getRobot().getEnergie() - this.getRobot().getCoutDep());// Enleve les points d'energie nécessaire pour éffectuer le deplacement
		}
	}
}