/**
 * Classe : Char
 * Elle correspont à un robot de type Char
 * Avec tous ses attributs d'energie
 */

package robot;

import java.util.List;

import plateau.Constante;
import plateau.Coordonnees;
import plateau.Vue;

public class Char extends Robot{
	
	
	/**
	 * Constructeur de la classe Char
	 * @param vue
	 * @param largeur
	 * @param hauteur
	 * @param equipe
	 */
	public Char(Vue vue, int l, int h, int equipe) {
		super(vue, l, h, equipe);
		this.setEnergie(60);
		// TODO Stub du constructeur généré automatiquement
	}

	/**
	 * @return true si le robot a la capacite de tirer
	 */
	@Override
	public boolean peutTirer() {
		// TODO Stub de la méthode généré automatiquement
		return true;
	}

	/**
	 * @return cout de l'attaque
	 */
	@Override
	public int getCoutAction() {
		// TODO Stub de la méthode généré automatiquement
		return 1;
	}
/**
 * @return cout du deplacement
 */
	@Override
	public int getCoutDep() {
		// TODO Stub de la méthode généré automatiquement
		return 5;
	}
/**
 * @return les degats du tir du robot
 */
	@Override
	public int getDegatTir() {
		// TODO Stub de la méthode généré automatiquement
		return 6;
	}
/**
 * @return les degats des mines posées par le robot
 */
	@Override
	public int getDegatMine() {
		// TODO Stub de la méthode généré automatiquement
		return 0;
	}
/**
 * @return le type du robot
 */
	@Override
	public String getType() {
		// TODO Stub de la méthode généré automatiquement
		if (this.getEquipe() == 1) {
			return "C";
		}
		return "c";
	}
/**
 * Renvoie la liste de coordonnees de deplacement du robot
 * @return List<Coordonnees>
 */
	@Override
	public List<Coordonnees> getDeplacements() {
		// TODO Stub de la méthode généré automatiquement		
		return Constante.dep;
	}
}
