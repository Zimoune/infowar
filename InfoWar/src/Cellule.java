
public abstract class Cellule{

  protected int mine = 0;

  protected int base = 0;
  
  private Coordonnees coord;

  String image;
  
  protected Robot robot;

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
   * Retire le robot
   */
  public void retirerRobot(){
	  this.robot = null;
  }

  /**
   * Place un robot
   * @param r
   */
  public void setRobot(Robot r){
	  this.robot = r;
  }
  
  /**
   * Affiche le contenu de la cellule
   */
  public String toString() {
	  if(this.robot != null)
	  return this.robot.toString();
	  else if(this.mine == 1){
		 return " 1 ";
	  }
	  else if(this.mine == 2){
		  return " 2 ";
	  }
	  else if(this.base == 1){
		  return " B ";
	  }
	  else if(this.base == 2){
		  return " b ";
	  }
	  else{
		  return "   ";
	  }
}

  public abstract void deplaceSur(Robot r);

  public abstract void ajoute(int equipe);

  public abstract void videCase();

}