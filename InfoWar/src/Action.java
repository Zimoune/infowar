public abstract class Action {
	private Coordonnees coord;
	private Robot robot;
	
	public Action(Robot robot, Coordonnees direction) {

	}

	public Robot getRobot() {
		return this.robot;
	}

	public Coordonnees getDirection() {
		return null;
	}

	public Coordonnees getObjectif() {
		return null;
	}

	public abstract void agit();

}