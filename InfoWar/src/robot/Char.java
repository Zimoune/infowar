package robot;

import java.util.List;

import plateau.Constante;
import plateau.Coordonnees;
import plateau.Vue;

public class Char extends Robot{

	public Char(Vue vue, int l, int h, int equipe) {
		super(vue, l, h, equipe);
		this.setEnergie(60);
		// TODO Stub du constructeur généré automatiquement
	}

	@Override
	public boolean peutTirer() {
		// TODO Stub de la méthode généré automatiquement
		return false;
	}

	@Override
	public int getCoutAction() {
		// TODO Stub de la méthode généré automatiquement
		return 1;
	}

	@Override
	public int getCoutDep() {
		// TODO Stub de la méthode généré automatiquement
		return 5;
	}

	@Override
	public int getDegatTir() {
		// TODO Stub de la méthode généré automatiquement
		return 6;
	}

	@Override
	public int getDegatMine() {
		// TODO Stub de la méthode généré automatiquement
		return 0;
	}

	@Override
	public String getType() {
		// TODO Stub de la méthode généré automatiquement
		if (this.getEquipe() == 1) {
			return "C";
		}
		return "c";
	}

	@Override
	public List<Coordonnees> getDeplacements() {
		// TODO Stub de la méthode généré automatiquement
		return Constante.dep;
	}
	
	

}