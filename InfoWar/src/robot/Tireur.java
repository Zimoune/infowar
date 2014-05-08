//********************************************************************* 
// Programmeur : Hanquez Rémy
// Date : 08/05/2014
// Fichier : Tireur.java
// 
// Tireur herite de robot. Gére le robot de type Tireur tels que son energie ou son attaque 
//*********************************************************************

package robot;

import java.util.List;

import plateau.Constante;
import plateau.Coordonnees;
import plateau.Vue;

public class Tireur extends Robot {
/**
 * Constructeur du Tireur
 * @param vue
 * @param l
 * @param h
 * @param equipe
 */
	public Tireur(Vue vue, int l, int h, int equipe, String nom) {
		super(vue, l, h, equipe,nom);
		this.setEnergie(40);
	}
/**
 * @return true si le robot peut tirer
 */
	@Override
	public boolean peutTirer() {
		return true;
	}
/**
 * @return le cout de son attaque
 */
	@Override
	public int getCoutAction() {
		// TODO Auto-generated method stub
		return 2;
	}
/**
 * @return les degats de son tir
 */
	@Override
	public int getCoutDep() {
		// TODO Auto-generated method stub
		return 1;
	}
/**
 * @return les degats de son tir
 */
	@Override
	public int getDegatTir() {
		// TODO Auto-generated method stub
		return 3;
	}
	/**
	 * @return les degats de sa mine
	 */
	@Override
	public int getDegatMine() {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 * @return le type du robot
	 */
	@Override
	public String getType() {
		if (this.getEquipe() == 1)
			return "T" + this.getNom().substring(this.getNom().length()-1);
		return "t"+ this.getNom().substring(this.getNom().length()-1);
	}
/**
 * @return une liste de deplcament
 */
	@Override
	public List<Coordonnees> getDeplacements() {
		// TODO Auto-generated method stub
		return Constante.dep;
	}

}
