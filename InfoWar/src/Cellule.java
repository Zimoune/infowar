
public abstract class Cellule {

  protected int mine = 0;

  protected int base = 0;
  
  Coordonnees coord;

  String image;
  
  Robot robot;

  public Cellule(int largeur, int hauteur) {
	  coord = new Coordonnees(largeur,hauteur);  
  }

  /**
   * Renvoie le numéro de l'équipe à qui appartient la mine
   * 0 si ce n'est pas une mine
   * @return
   */
  public int contientMine() {
	  return mine;
  }
  
  /**
   * Renvoie le numéro de l'équipe de la base
   * 0 si ce n'est pas une base
   * @return
   */
  public int estBase() {
	  return base;
  }

  /**
   * Renvoie la coordonnée de la cellule
   * @return
   */
  public Coordonnees getCoordonnees() {
	  return coord;
  }

  /**
   * Renvoie le robot que la cellule contient
   * @return
   */
  public Robot getContenu() {
	  return robot;
  }


  /**
   * Affiche le contenu de la cellule
   */
  public String toString() {
	  return "Cellule [mine=" + mine + ", base=" + base + ", coord=" + coord
			+ ", image=" + image + ", robot=" + robot + "]";
}

  public abstract void deplaceSur();

  public abstract void ajoute(int equipe);

  public abstract void videCase();

}