/**
 * Classe : Robot
 */

package robot;
import java.util.ArrayList;
import java.util.List;

import plateau.Coordonnees;
import plateau.Vue;


public abstract class Robot {
	
	private int energie;
	private int equipe;
	private Vue vue;
	private Coordonnees coord;
	public List<Coordonnees> deplacements;
	/**
	 * Constructeur du robot
	 * @param vue
	 * @param l
	 * @param h
	 * @param equipe
	 */
	public Robot(Vue vue, int l, int h, int equipe) {
		this.vue = vue;
		this.equipe = equipe;
		this.coord = new Coordonnees(l,h);
		this.deplacements = new ArrayList<Coordonnees>();
		this.vue.deplaceSur(coord, this);
	}
	/**
	 * 
	 * @return true si le robot est sur sa base
	 */
	public boolean estSurBase() {
		return this.vue.estBase(this.coord) == this.equipe;
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
	}
	/**
	 * Ce robot subit des degats d'une mine
	 */
	public void subitMine() {
		this.setEnergie(this.getEnergie()-2);
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
