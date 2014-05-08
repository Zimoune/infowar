//********************************************************************* 
// Programmeur : Hanquez Rémy
// Date : 08/05/2014
// Fichier : Constante.java
// 
// Initialise des constantes de déplacement
//*********************************************************************

package plateau;

import java.util.ArrayList;
import java.util.List;

public class Constante {
	
	public static final List<Coordonnees> dep = new ArrayList<Coordonnees>();
	public static final Coordonnees HAUT = new Coordonnees(0, -1);
	public static final Coordonnees BAS = new Coordonnees(0, 1);
	public static final Coordonnees GAUCHE = new Coordonnees(-1, 0);
	public static final Coordonnees DROITE = new Coordonnees(1, 0);
	public static final Coordonnees DIAHAUTDROITE = new Coordonnees(1, -1);
	public static final Coordonnees DIABASDROITE = new Coordonnees(1, 1);
	public static final Coordonnees DIAHAUTGAUCHE = new Coordonnees(-1, -1);
	public static final Coordonnees DIABASGAUCHE = new Coordonnees(-1, 1);

	static{
		dep.add(HAUT);
		dep.add(BAS);
		dep.add(DROITE);
		dep.add(GAUCHE);
		dep.add(DIAHAUTGAUCHE);
		dep.add(DIAHAUTDROITE);
		dep.add(DIABASGAUCHE);
		dep.add(DIABASDROITE);
	}
}
