public class Coordonnees {

  private int largeur;

  private int hauteur;

        
  public Coordonnees(int largeur, int hauteur) {
	  this.largeur = largeur;
	  this.hauteur = hauteur;
  }

  public int getLargeur() {
  return largeur;
  }

  public int getHauteur() {
  return hauteur;
  }

  public String toString() {
  return "Largeur : " + largeur + " Hauteur : " + hauteur;
  }

  public Coordonnees ajout(Coordonnees coord) {
	  return coord = new Coordonnees(this.largeur + coord.largeur, this.hauteur + coord.hauteur);
  }

}