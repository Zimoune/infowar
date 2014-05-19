//********************************************************************* 
// Programmeur : Hanquez Remy
// Date : 08/05/2014
// Fichier : Case.java
// 
// Herite de Cellule. Gere le comportement d'une case
//*********************************************************************

package plateau;

import robot.Robot;

public class Case extends Cellule {
	
	public Case(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

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

	@Override
	public void videCase() {
		this.mine = 0;
		this.image = "  ";
		this.setContenu(null);
	}

	@Override
	public void ajoutObstacle() {
		// TODO Stub de la methode genere automatiquement
		if (this.getContenu() == null) {
			this.obstacle = true;
			this.image = "O ";
		}
	}

}
