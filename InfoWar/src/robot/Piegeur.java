/**
 * Classe : Piegeur
 * Elle correspont à un robot de type Piegeur
 * Avec tous ses attributs d'energie
 */

package robot;

import java.util.List;

import plateau.Constante;
import plateau.Coordonnees;
import plateau.Vue;

public class Piegeur extends Robot {

	/**
	 * Constructeur de la classe Piegeur
	 * @param vue
	 * @param largeur
	 * @param hauteur
	 * @param equipe
	 */
	public Piegeur(Vue vue, int l, int h, int equipe) {
		super(vue, l, h, equipe);
		this.setEnergie(50);
	}
	/**
	 * @return true si le robot a la capacite de tirer
	 */
	@Override
	public boolean peutTirer() {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * @return cout de l'attaque
	 */
	@Override
	public int getCoutAction() {
		// TODO Auto-generated method stub
		return 2;
	}
	/**
	 * @return cout du deplacement
	 */
	@Override
	public int getCoutDep() {
		// TODO Auto-generated method stub
		return 1;
	}

/**
* @return les degats du tir du robot
*/
	@Override
	public int getDegatTir() {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 * @return les degats des mines posées par le robot
	 */
	@Override
	public int getDegatMine() {
		// TODO Auto-generated method stub
		return 2;
	}
	/**
	 * @return le type du robot
	 */
	@Override
	public String getType() {
		if (this.getEquipe() == 1) {
			return "P";
		}
		return "p";
	}
	/**
	 * Renvoie la liste de coordonnees de deplacement du robot
	 * @return List<Coordonnees>
	 */
	@Override
	public List<Coordonnees> getDeplacements() {
		// TODO Auto-generated method stub
		
		return Constante.dep;
	}

}
