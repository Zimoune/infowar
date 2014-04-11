import java.util.List;

public abstract class Robot {

  private int energie;

  private int equipe;
  
  private Vue vue;
  
  private Coordonnees coord;

  
  public Robot(Vue vue, int l, int h, int equipe) {
	  this.vue = vue;
	  this.equipe = equipe;
	  coord = new Coordonnees(l,h);
  }

  public abstract boolean peutTirer();

  public boolean estSurBase() {
  return false;
  }

  public void setCoordonnees(Coordonnees coordonnees) {
	  this.coord = coordonnees;
  }

  public Vue getVue() {
  return vue;
  }

  public int getEnergie() {
  return energie;
  }

  public void setEnergie(int energie) {
	  this.energie = energie;
  }

  public int getEquipe() {
  return equipe;
  }

  public abstract int getCoutAction();

  public abstract int getCoutDep();

  public abstract int getDegatTir();

  public abstract int getDegatMine();

  public abstract String getType();

  public abstract List<Coordonnees> getDeplacements();

  public void setVue(Vue vue) {
  }

  public String toString() {
  return null;
  }

  public void subitTir() {
	  this.energie -= 3;
  }

  public void subitMine() {
	  this.energie -= 2;
  }

}