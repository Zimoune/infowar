import java.util.List;

public abstract class Robot {

  private int energie;

  private int equipe;

  
  public Robot(Vue vue, int l, int h, int equipe) {
  }

  public abstract boolean peutTirer();

  public boolean estSurBase() {
  return false;
  }

  public void setCoordonnees(Coordonnees coordonnees) {
  }

  public Vue getVue() {
  return null;
  }

  public int getEnergie() {
  return 0;
  }

  public void setEnergie(int energie) {
  }

  public int getEquipe() {
  return 0;
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
  }

  public void subitMine() {
  }

}