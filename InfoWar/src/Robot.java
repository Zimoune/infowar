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

	/**
	 * Retourne la coordonnees du robot
	 * 
	 * @return
	 */
	public Coordonnees getCoord() {
		return this.coord;
	}

	public abstract boolean peutTirer();

	/**
	 * Renvoie true si le robot est dans la base
	 * 
	 * @return
	 */
	public boolean estSurBase() {
		return this.getCoord().equals(
				this.getVue().plateau.getBase(this.getEquipe()));
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
		this.vue = vue;
	}

	/**
	 * Affiche le robot
	 */
	public String toString() {
		if (this instanceof Tireur) {
			if (this.equipe == 1) {
				return " T ";
			} else {
				return " t ";
			}
		}

		else if (this instanceof Piegeur) {
			if (this.equipe == 1) {
				return " P ";
			} else {
				return " p ";
			}
		} else {
			System.out.println("Un robot n'a pas d'équipe");
			return " ? ";
		}

	}

	public String stats() {
		if (this instanceof Tireur)
			return "Tireur : " + this.energie + " points d'énergie(s)";
		else {
			return "Piegeur : " + this.energie + " points d'énergie(s)";
		}
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