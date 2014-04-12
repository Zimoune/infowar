import java.util.List;

public class Piegeur extends Robot {
	private Coordonnees coord;

	public Piegeur(Vue vue, int l, int h, int equipe) {
		super(vue, l, h, equipe);
	}

	@Override
	public boolean peutTirer() {
		return false;
	}

	@Override
	public int getCoutAction() {
		return 2;
	}

	@Override
	public int getCoutDep() {
		return 2;
	}

	@Override
	public int getDegatTir() {
		return 2;
	}

	@Override
	public int getDegatMine() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public String getType() {
		return "Piegeur";
	}

	@Override
	public List<Coordonnees> getDeplacements() {
		return Constante.dep;
	}

}