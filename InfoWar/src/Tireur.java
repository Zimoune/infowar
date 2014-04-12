import java.util.List;

public class Tireur extends Robot {
	private Coordonnees coord;

	public Tireur(Vue vue, int l, int h, int equipe) {
		super(vue, l, h, equipe);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean peutTirer() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getCoutAction() {
		return 2;
	}

	@Override
	public int getCoutDep() {
		return 1;
	}

	@Override
	public int getDegatTir() {
		return 3;
	}

	@Override
	public int getDegatMine() {
		return 3;
	}

	@Override
	public String getType() {
		return "Tireur";
	}

	@Override
	public List<Coordonnees> getDeplacements() {
		// TODO Auto-generated method stub
		return Constante.dep;
	}

}