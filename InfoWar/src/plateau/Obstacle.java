package plateau;

import robot.Robot;

public class Obstacle extends Cellule{

	public Obstacle(int x, int y) {
		super(x, y);
		this.image = "O ";
		// TODO Auto-generated constructor stub
	}

	@Override
	public void deplaceSur(Robot r) {
		System.out.println("Impossible de se deplacer ici");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ajout(int equipe) {
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void videCase() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void ajoutObstacle() {
		// TODO Auto-generated method stub
		
	}
	
}
