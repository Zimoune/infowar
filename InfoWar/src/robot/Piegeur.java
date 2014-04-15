package robot;

import java.util.List;

import plateau.Coordonnees;
import plateau.Vue;

public class Piegeur extends Robot {

	public Piegeur(Vue vue, int l, int h, int equipe) {
		super(vue, l, h, equipe);
		this.setEnergie(60);
	}

	@Override
	public boolean peutTirer() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getCoutAction() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public int getCoutDep() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int getDegatTir() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getDegatMine() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public String getType() {
		if (this.getEquipe() == 1) {
			return "P";
		}
		return "p";
	}

	@Override
	public List<Coordonnees> getDeplacements() {
		// TODO Auto-generated method stub
		return null;
	}

}
