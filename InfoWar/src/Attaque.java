public class Attaque extends Action {

	public Attaque(Robot robot, Coordonnees direction) {
		super(robot, direction);
	}

	@Override
	public void agit() {
		// TODO Auto-generated method stub
		if (this.getRobot().peutTirer()
				&& this.getRobot().getVue().plateau.estRobot(this.getObjectif()
						.getLargeur(), this.getObjectif().getHauteur()))
			this.getRobot().getVue().plateau.tableau[this.getObjectif()
					.getLargeur()][this.getObjectif().getHauteur()]
					.getContenu().subitTir();
		else
			System.out.println("Pas assez d'energie");
	}
}