//********************************************************************* 
// Programmeur : Hanquez RÈmy
// Date : 08/05/2014
// Fichier : Piegeur.java
// 
// Char herite de robot. GÈre le robot de type Piegeur tels que son energie ou son attaque 
//*********************************************************************

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
	public Piegeur(Vue vue, int l, int h, int equipe, String nom) {
		super(vue, l, h, equipe,nom);
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
	 * @return les degats des mines pos√©es par le robot
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
			return "P" + this.getNom().substring(this.getNom().length()-1);
		}
		return "p" + this.getNom().substring(this.getNom().length()-1);
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
