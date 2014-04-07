
public abstract class Cellule {

  protected int mine = 0;

  protected int base = 0;

  String image;

  public Cellule(int largeur, int hauteur) {
  }

  public int contientMine() {
  return 0;
  }

  public int estBase() {
  return 0;
  }

  public Coordonnees getCoordonnees() {
  return null;
  }

  public Robot getContenu() {
  return null;
  }

  public String toString() {
  return null;
  }

  public abstract void deplaceSur();

  public abstract void ajoute(int equipe);

  public abstract void videCase();

}