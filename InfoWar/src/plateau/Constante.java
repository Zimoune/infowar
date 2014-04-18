package plateau;

import java.util.ArrayList;
import java.util.List;

public class Constante {
	
	public static final List<Coordonnees> dep = new ArrayList<Coordonnees>();
	public static final List<Coordonnees> depChar = new ArrayList<Coordonnees>();
	public static final Coordonnees Haut = new Coordonnees(0, -1);
	public static final Coordonnees Bas = new Coordonnees(0, 1);
	public static final Coordonnees Gauche = new Coordonnees(-1, 0);
	public static final Coordonnees Droite = new Coordonnees(1, 0);
	public static final Coordonnees diaHautDroite = new Coordonnees(1, -1);
	public static final Coordonnees diaBasDroite = new Coordonnees(1, 1);
	public static final Coordonnees diaHautGauche = new Coordonnees(-1, -1);
	public static final Coordonnees diaBasGauche = new Coordonnees(-1, 1);
	public static final Coordonnees HautChar = new Coordonnees(0, -2);
	public static final Coordonnees BasChar = new Coordonnees(0, 2);
	public static final Coordonnees GaucheChar = new Coordonnees(-2, 0);
	public static final Coordonnees DroiteChar = new Coordonnees(2, 0);

	static {
		dep.add(Haut);
		dep.add(Bas);
		dep.add(Gauche);
		dep.add(Droite);
		dep.add(diaBasDroite);
		dep.add(diaBasGauche);
		dep.add(diaHautDroite);
		dep.add(diaHautGauche);
	}
	
	static {
		depChar.add(HautChar);
		depChar.add(BasChar);
		depChar.add(GaucheChar);
		depChar.add(DroiteChar);
	}
	
}
