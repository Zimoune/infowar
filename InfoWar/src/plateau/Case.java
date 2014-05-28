//********************************************************************* 
// Programmeur : Hanquez Remy
// Programmeur : Fack Vincent
// Programmeur : Delplace Gautier
// Programmeur : Lorthios Ludovic
// Programmeur : Lepeltier Damien
// Programmeur : Le Pallac Simon
// Date : 08/05/2014
// Fichier : Case.java
// 
// Herite de Cellule. Gere le comportement d'une case
//*********************************************************************

package plateau;

import robot.Robot;

public class Case extends Cellule {
	
	/**
	 * Constructeur de la classe Case
	 * @param x , correspond a la largeur du plateau
	 * @param y , correspond a al hauteur du plateau
	 */
	
	public Case(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * (non-Javadoc)
	 * @see plateau.Cellule#deplaceSur(robot.Robot)
	 * Deplace le robot sur une case
	 */

	@Override
	public void deplaceSur(Robot r) {
		if (this.getContenu() == null) {
			r.getVue().videCase(r.getCoordonnees());
			r.setCoordonnees(this.getCoordonnees());
			this.setContenu(r);
			if (this.mine > 0) {
				r.subitMine();
				this.mine = 0;
			}
			this.image = r.getType();
		}
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see plateau.Cellule#ajout(int)
	 * Ajoute une mine
	 */

	@Override
	public void ajout(int equipe) {
		if (this.getContenu() == null && this.mine == 0) {
			this.mine = equipe;
			if (equipe == 1)
				this.image = "X ";
			else
				this.image = "x ";
		}
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see plateau.Cellule#videCase()
	 * Permet de vider la case
	 */

	@Override
	public void videCase() {
		this.mine = 0;
		this.image = "  ";
		this.setContenu(null);
	}
	
	/*
	 * (non-Javadoc)
	 * @see plateau.Cellule#ajoutObstacle()
	 * Ajoute un obstacle
	 */

	@Override
	public void ajoutObstacle() {
		// TODO Stub de la methode genere automatiquement
		if (this.getContenu() == null) {
			this.obstacle = true;
			this.image = "O ";
		}
	}

}
