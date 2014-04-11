import java.util.List;

public abstract class Robot {

	private int energie;

	private int equipe;

	private Vue vue;

	private Coordonnees coord;

	public Robot(Vue vue, int l, int h, int equipe) {
		this.vue = vue;
		this.equipe = equipe;
		coord = new Coordonnees(l, h);
	}

	public abstract boolean peutTirer();

	/**
	 * Renvoie true si le robot est dans la base
	 * 
	 * @return
	 */
	public boolean estSurBase() {
		return false;
	}

	/**
	 * Attribue la Coordonnée au robot
	 * 
	 * @param coordonnees
	 */
	public void setCoordonnees(Coordonnees coordonnees) {
		this.coord = coordonnees;
	}

	/**
	 * Renvoie la vue
	 * 
	 * @return
	 */
	public Vue getVue() {
		return vue;
	}

	/**
	 * Renvoie l'énergie du robot
	 * 
	 * @return
	 */
	public int getEnergie() {
		return energie;
	}

	/**
	 * Attribue l'énergie au robot
	 * 
	 * @param energie
	 */
	public void setEnergie(int energie) {
		this.energie = energie;
	}

	/**
	 * Retourne le numéro d'équipe auquel appartient le robot
	 * 
	 * @return
	 */
	public int getEquipe() {
		return equipe;
	}

	public abstract int getCoutAction();

	public abstract int getCoutDep();

	public abstract int getDegatTir();

	public abstract int getDegatMine();

	public abstract String getType();

	public abstract List<Coordonnees> getDeplacements();

	/**
	 * Attribue la vue
	 * 
	 * @param vue
	 */
	public void setVue(Vue vue) {
	}

	/**
	 * Affiche le robot
	 */
	public String toString() {
		return null;
	}

	/**
	 * Enleve l'energie en tirant
	 */
	public void subitTir() {
		this.energie -= 3;
	}

	/**
	 * Enleve l'energie en posant une mine
	 */
	public void subitMine() {
		this.energie -= 2;
	}

}