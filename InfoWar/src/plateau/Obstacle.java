package plateau;

import robot.Robot;

public class Obstacle extends Cellule{
	
	/**
	 * Constructeur de la classe Cellule
	 * @param x, correspond a la largeur du plateau
	 * @param y, correspond a la hauteur du plateau
	 */

	public Obstacle(int x, int y) {
		super(x, y);
		this.image = "O ";
		this.setObstacle(true);
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * (non-Javadoc)
	 * @see plateau.Cellule#deplaceSur(robot.Robot)
	 * Affiche un message d'erreur
	 */

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
