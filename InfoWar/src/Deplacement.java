public class Deplacement extends Action {

	public Deplacement(Robot robot, Coordonnees direction) {
		super(robot, direction);
	}

	@Override
	public void agit() {
		if (this.getObjectif().getHauteur() < 10   // Verifie les dimensions du plateau 
				&& this.getObjectif().getHauteur() > 0
				&& this.getObjectif().getLargeur() < 5
				&& this.getObjectif().getLargeur() > 0
				&& (this.getRobot().getVue().plateau.getBase(this.getRobot().getEquipe()).equals(this.getObjectif()) ||
						this.getRobot().getVue().plateau.tableau[this.getObjectif()
						.getLargeur()][this.getObjectif().getHauteur()]
						.estBase() == 0)  // Verifie si le deplacement ne s'effectue pas sur la base adverse
				&& !this.getRobot().getVue().plateau.estRobot(this.getObjectif().getLargeur(), this.getObjectif().getHauteur())) { // Verifie que le
											// Verifie si le deplacement ne s'effectue pas sur un autre robot
											// 
			this.getRobot().setCoordonnees(this.getObjectif());// Change les
																// coordonnees
																// du robot
			this.getRobot()
					.setEnergie(
							this.getRobot().getEnergie()
									- this.getRobot().getCoutDep());// Enleve
																	// les point
																	// d'energie
																	// necessaire
																	// pour
																	// effectuer
																	// le
																	// deplacement
			
			if(this.getRobot().getVue().estMine(this.getObjectif())){
				this.getRobot().setEnergie(this.getRobot().getEnergie() - this.getRobot().getDegatMine());// Cas ou la case selectionné est une mine
				this.getRobot().getVue().setMine(this.getObjectif(), 0);
			}
			
			

		} else {
			this.getRobot()
					.setEnergie(
							this.getRobot().getEnergie()
									- this.getRobot().getCoutDep());// Enleve
																	// les
																	// points
																	// d'energie
																	// nï¿½cessaire
																	// pour
																	// ï¿½ffectuer
																	// le
																	// deplacement
		}
	}
}