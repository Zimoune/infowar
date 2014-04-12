import java.util.ArrayList;
import java.util.List;

public class Constante {
	private Coordonnees coord;
	
	public static final List<Coordonnees> dep = new ArrayList<Coordonnees>();
	public static final Coordonnees Haut = new Coordonnees(0, -1);
	public static final Coordonnees Bas = new Coordonnees(0, 1);
	public static final Coordonnees Gauche = new Coordonnees(1, 0);
	public static final Coordonnees Droite = new Coordonnees(-1, 0);
	public static final Coordonnees HAUTGAUCHE = new Coordonnees(-1, -1);
	public static final Coordonnees HAUTDROITE = new Coordonnees(1,-1);
	public static final Coordonnees BASGAUCHE = new Coordonnees(-1, 1);
	public static final Coordonnees BASDROITE = new Coordonnees(1, 1);

	static {
		dep.add(Haut);
		dep.add(Bas);
		dep.add(Gauche);
		dep.add(Droite);
		dep.add(HAUTGAUCHE);
		dep.add(HAUTDROITE);
		dep.add(BASGAUCHE);
		dep.add(BASDROITE);
	}

}