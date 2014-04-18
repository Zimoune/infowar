package plateau;

import robot.Robot;

public abstract class Cellule {
	
	protected int base = 0;
	protected int mine = 0;
	String image = " ";
	private Robot robot;
	private Coordonnees coord;
	private boolean obstacle;
	
	public Cellule(int x, int y) {
		coord = new Coordonnees(x,y);
	}
	
	public int estBase() {
		return this.base;
	}
	
	public int contientMine() {
		return this.mine;
	}
	
	public Coordonnees getCoordonnees() {
		return this.coord;
	}
	
	public Robot getContenu() {
		return this.robot;
	}
	
	public void setContenu(Robot r) {
		this.robot = r;
	}
	
	public String toString() {
		return this.image;
	}
	
	public abstract void deplaceSur(Robot r);
	
	public abstract void ajout(int equipe);
	
	public abstract void videCase();
	
	public boolean estObstacle(){
		return this.obstacle;
	}

}
