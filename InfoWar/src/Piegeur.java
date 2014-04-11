import java.util.List;

public class Piegeur extends Robot {
	private Coordonnees coord;

	public Piegeur(Vue vue, int l, int h, int equipe) {
		super(vue, l, h, equipe);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean peutTirer() {
		return false;
	}

	@Override
	public int getCoutAction() {
		// TODO Auto-generated method stub
		return 0;
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
		return -2;
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