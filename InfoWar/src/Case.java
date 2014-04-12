public class Case extends Cellule {

	public Case(int largeur, int hauteur) {
		super(largeur, hauteur);
	}

	/**
	 * Deplace le robot r
	 */
	@Override
	public void deplaceSur(Robot r) {
		r.getVue().plateau.tableau[r.getCoord().getLargeur()][r.getCoord().getHauteur()].retirerRobot();
		this.robot = r;
		this.robot.setCoordonnees(this.getCoordonnees());
	}

	/**
	 * Attribut une base à l'équipe passé en paramètre
	 */
	@Override
	public void ajoute(int equipe) {
		this.base = equipe;
	}

	/**
	 * Vide la case
	 */
	@Override
	public void videCase() {
		this.mine = 0;
		this.base = 0;
		this.robot = null;
	}
}