package plateau;

import robot.Robot;

public class Base extends Cellule {

	public Base(int x, int y, int equipe) {
		super(x, y);
		this.base = equipe;
		if (this.base == 1)
			this.image = "B";
		else
			this.image = "b";
	}

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

}
