
public class Vue {

	int equipe;
	Plateau plateau;
	
	public Vue(int equipe, Plateau t){
		this.plateau = t;
		this.equipe = equipe;
	}
	
	/**
	 * Pose le robot r à la coordonnées c
	 * @param r
	 * @param c
	 */
	public void poserRobot(Robot r, Coordonnees c){
		this.plateau.tableau[c.getLargeur()][c.getHauteur()].setRobot(r);
	}
	
	/**
	 * Vérifie si la coordonnées c est valide
	 * @param c
	 * @return
	 */
	public boolean estOk(Coordonnees c){
		if((c.getLargeur() <= this.plateau.getLargeur() && c.getHauteur() <= this.plateau.getHauteur()) && (c.getLargeur() > 0 && c.getHauteur() > 0))
			return true;
		return false;
	}
	
	/**
	 * Vide la case à la coordonnées c
	 * @param c
	 */
	public void setLibre(Coordonnees c){
		this.plateau.tableau[c.getLargeur()][c.getHauteur()].videCase();
	}
	
	/**
	 * Retourne true si il y a une mine à la coordonnees c
	 * @param c
	 * @return
	 */
	public boolean estMine(Coordonnees c){
		if(this.plateau.tableau[c.getLargeur()][c.getHauteur()].mine != 0)
			return true;
		return false;
	}
	
	/**
	 * Pose une mine à la coordonnée c appartenant à l'équipe equipe
	 * @param c
	 * @param equipe
	 */
	public void setMine(Coordonnees c, int equipe){
		this.plateau.tableau[c.getLargeur()][c.getHauteur()].mine = equipe;
	}
	
	

	
}