public abstract class Action {
	private Coordonnees coord;
	private Robot robot;
	
	public Action(Robot robot, Coordonnees direction) {
		this.robot = robot;
		this.coord = direction;
	}

	public Robot getRobot() {
		return this.robot;
	}

	public Coordonnees getDirection() {
		return coord;
	}

	public Coordonnees getObjectif() {
		return new Coordonnees(this.robot.getCoord().getLargeur()+this.getDirection().getLargeur(), this.robot.getCoord().getHauteur()+this.getDirection().getHauteur());
	}

	public abstract void agit();

}