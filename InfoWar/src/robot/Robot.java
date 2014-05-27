//********************************************************************* 
// Programmeur : Hanquez Remy
// Date : 08/05/2014
// Fichier : Robot.java
// 
// Robot est la classe mere de Char, Tireur et piegeur. Gere ce qui est commun a tous les robots
//*********************************************************************

package robot;

import java.util.ArrayList;
import java.util.List;

import plateau.Coordonnees;
import plateau.Vue;


public abstract class Robot {
	
	private String nom;
	
	private int energie;
	private int equipe;
	private Vue vue;
	private Coordonnees coord;
	public List<Coordonnees> deplacements;
	private boolean estIa = false;
	/**
	 * Constructeur du robot
	 * @param vue
	 * @param l
	 * @param h
	 * @param equipe
	 */
	public Robot(Vue vue, int l, int h, int equipe, String nom) {
		this.vue = vue;
		this.equipe = equipe;
		this.coord = new Coordonnees(l,h);
		this.deplacements = new ArrayList<Coordonnees>();
		this.vue.deplaceSur(coord, this);
		this.nom = nom;
	}
	
	public boolean estMort(){
		if(this.getEnergie() <= 0){
			return true;
		}
		else{
			return false;
		}
	}
	
	public int getEnergieDeBase(){
		return this.getEnergieDeBase();
	}
	
	public String getNom(){
		return this.nom;
	}
	/**
	 * 
	 * @return true si le robot est sur sa base
	 */
	public boolean estSurBase() {
		return this.vue.estBase(this.coord) == this.equipe;
	}
	
	public boolean estSurObstacle(){
		return this.vue.estObstacle(this.coord);
	}
	
	/**
	 * 
	 * @return la vue du robot
	 */
	public Vue getVue() {
		return this.vue;
	}
	/**
	 * 
	 * @return l'energie du robot
	 */
	public int getEnergie() {
		return this.energie;
	}
	/**
	 * 
	 * @return l'equipe du robot
	 */
	public int getEquipe() {
		return this.equipe;
	}
	/**
	 * 
	 * @return les coordonnees du robot
	 */
	public Coordonnees getCoordonnees() {
		return this.coord;
	}
	/**
	 * Defini la vue du robot
	 * @param vue
	 */
	public void setVue(Vue vue) {
		this.vue = vue;
	}
	/**
	 * Mets l'energie du robot
	 * @param energie
	 */
	public void setEnergie(int energie) {
		this.energie = energie;
	}
	/**
	 * Mets les coordonnees de ce robot avec de nouvelles coordonnees
	 * @param coord
	 */
	public void setCoordonnees(Coordonnees coord) {
		this.coord = coord;
	}
	/**
	 * Ce robot subit les degats d'un tir
	 */
	public void subitTir() {
		this.setEnergie(this.getEnergie()-3);
		System.out.println(this.getType().toString() + " a perdu 3 point d'energie par un tir");
	}
	/**
	 * Ce robot subit des degats d'une mine
	 */
	public void subitMine() {
		this.setEnergie(this.getEnergie()-2);
		System.out.println(this.getType().toString() + " a perdu 2 point d'energie par une mine");
	}
	
	/**
	 * Definie si le robot est un IA
	 */
	public void setIa()	{
		this.estIa = true;
	}
	
	/**
	 * Retourne true si le robot est un IA
	 * @return
	 */
	public boolean estIa(){
		return this.estIa;
	}
	/**
	 * @return true si le robot a la capacite de tirer
	 */
	public abstract boolean peutTirer();
	
	/**
	 * @return cout de l'attaque
	 */
	public abstract int getCoutAction();
	
	/**
	 * @return cout du deplacement
	 */
	public abstract int getCoutDep();
	
	/**
	* @return les degats du tir du robot
	*/
	public abstract int getDegatTir();
	
	/**
	 * @return les degats des mines posées par le robot
	 */
	public abstract int getDegatMine();
	
	/**
	 * @return le type du robot
	 */
	public abstract String getType();
	/**
	 * Renvoie la liste de coordonnees de deplacement du robot
	 * @return la liste de deplacement
	 */
	public abstract List<Coordonnees> getDeplacements();
	
	public String toString(){
		return "\n" + getType() + " niveau d'energie: " + this.energie;
	}
}
