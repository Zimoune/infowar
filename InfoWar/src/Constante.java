import java.util.ArrayList;
import java.util.List;

public class Constante {
	private Coordonnees coord;
	
	public static final List<Coordonnees> dep = new ArrayList<Coordonnees>();
	public static final Coordonnees Haut = new Coordonnees(0, -1);
	public static final Coordonnees Bas = new Coordonnees(0, 1);
	public static final Coordonnees Gauche = new Coordonnees(-1, 0);
	public static final Coordonnees Droite = new Coordonnees(1, 0);

	static {
		dep.add(Haut);
		dep.add(Bas);
		dep.add(Gauche);
		dep.add(Droite);
	}

}