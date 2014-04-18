/**
 * Classe : Base
 */

package plateau;

import robot.Robot;

public class Base extends Cellule {
/**
 * Constructeur de la classe Base
 * @param x
 * @param y
 * @param equipe
 */
	public Base(int x, int y, int equipe) {
		super(x, y);
		this.base = equipe;
		if (this.base == 1)
			this.image = "B";
		else
			this.image = "b";
	}
/**
 * deplace le robot sur cette base
 */
	@Override
	public void deplaceSur(Robot r) {
		if (this.getContenu() == null) {
			r.getVue().videCase(r.getCoordonnees());
			r.setCoordonnees(this.getCoordonnees());
			this.setContenu(r);
		}
		
	}

	@Override
	public void ajout(int equipe) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void videCase() {
		this.setContenu(null);
		
	}

	@Override
	public void ajoutObstacle() {
		// TODO Stub de la méthode généré automatiquement
		
	}

}
