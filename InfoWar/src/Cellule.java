
public abstract class Cellule {

  protected int mine = 0;

  protected int base = 0;
  
  Coordonnees coord;

  String image;
  
  Robot robot;

  public Cellule(int largeur, int hauteur) {
	  coord = new Coordonnees(largeur,hauteur);  }

  public int contientMine() {
  return mine;
  }

  public int estBase() {
  return base;
  }

  public Coordonnees getCoordonnees() {
  return coord;
  }

  public Robot getContenu() {
  return robot;
  }


  public String toString() {
	  return "Cellule [mine=" + mine + ", base=" + base + ", coord=" + coord
			+ ", image=" + image + ", robot=" + robot + "]";
}

  public abstract void deplaceSur();

  public abstract void ajoute(int equipe);

  public abstract void videCase();

}