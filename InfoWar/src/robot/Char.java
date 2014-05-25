//********************************************************************* 
// Programmeur : Hanquez Remy
// Date : 08/05/2014
// Fichier : Char.java
// 
// Char herite de robot. Gere le robot de type Char tels que son energie ou son attaque 
//*********************************************************************

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
	public Char(Vue vue, int l, int h, int equipe,String nom) {
		super(vue, l, h, equipe,nom);
		this.setEnergie(60);
		// TODO Stub du constructeur genere automatiquement
	}
	
	public int getEnergieDeBase(){
		return 60;
	}

	/**
	 * @return true si le robot a la capacite de tirer
	 */
	@Override
	public boolean peutTirer() {
		// TODO Stub de la methode genere automatiquement
		return true;
	}

	/**
	 * @return cout de l'attaque
	 */
	@Override
	public int getCoutAction() {
		// TODO Stub de la methode genere automatiquement
		return 1;
	}
/**
 * @return cout du deplacement
 */
	@Override
	public int getCoutDep() {
		// TODO Stub de la methode genere automatiquement
		return 5;
	}
/**
 * @return les degats du tir du robot
 */
	@Override
	public int getDegatTir() {
		// TODO Stub de la methode genere automatiquement
		return 6;
	}
/**
 * @return les degats des mines posées par le robot
 */
	@Override
	public int getDegatMine() {
		// TODO Stub de la methode genere automatiquement
		return 0;
	}
/**
 * @return le type du robot
 */
	@Override
	public String getType() {
		// TODO Stub de la methode genere automatiquement
		if (this.getEquipe() == 1) {
			return "C"+ this.getNom().substring(this.getNom().length()-1);
		}
		return "c"+ this.getNom().substring(this.getNom().length()-1);
	}
/**
 * Renvoie la liste de coordonnees de deplacement du robot
 * @return List<Coordonnees>
 */
	@Override
	public List<Coordonnees> getDeplacements() {
		// TODO Stub de la methode genere automatiquement		
		return Constante.dep;
	}
}
