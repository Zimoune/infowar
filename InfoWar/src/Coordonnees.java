public class Coordonnees {

  private int largeur;

  private int hauteur;

        
  public Coordonnees(int largeur, int hauteur) {
	  this.largeur = largeur;
	  this.hauteur = hauteur;
  }

  /**
   * Renvoie la position en x
   */
  public int getLargeur() {
	  return largeur;
  }

  /**
   * Renvoie la position en y
   * @return
   */
  public int getHauteur() {
	  return hauteur;
  }

  /**
   * Affiche la position
   */
  public String toString() {
	  return "Largeur : " + largeur + " Hauteur : " + hauteur;
  }

  /**
   * Additionne la coordonnée avec une autre
   * @param coord
   * @return
   */
  public Coordonnees ajout(Coordonnees coord) {
	  return coord = new Coordonnees(this.largeur + coord.largeur, this.hauteur + coord.hauteur);
  }

}