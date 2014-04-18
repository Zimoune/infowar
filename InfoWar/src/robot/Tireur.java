package robot;

import java.util.List;

import plateau.Constante;
import plateau.Coordonnees;
import plateau.Vue;

public class Tireur extends Robot {

	public Tireur(Vue vue, int l, int h, int equipe) {
		super(vue, l, h, equipe);
		this.setEnergie(40);
	}

	@Override
	public boolean peutTirer() {
		return true;
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
		return 3;
	}

	@Override
	public int getDegatMine() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getType() {
		if (this.getEquipe() == 1)
			return "T";
		return "t";
	}

	@Override
	public List<Coordonnees> getDeplacements() {
		// TODO Auto-generated method stub
		return Constante.dep;
	}

}
