
public class Plateau {
	protected Cellule[][] tableau;
	private int x = 10, y = 5;
	
	public Plateau(){
		this.tableau = new Cellule[x][y];
		initPlateau();
	}
	
	/**
	 * Initialise toutes les cases du plateau avec une nouvelle cellule
	 * Ajoute les bases
	 */
	public void initPlateau(){
		for (int i = 0;  i< this.x; i++) {
			for (int j = 0; j < this.y; j++) {
				this.tableau[i][j] = new Case(i, j);
			}
		}
		this.tableau[0][0] = new Base(0,0);
		this.tableau[0][0].ajoute(1);
		this.tableau[x-1][y-1] = new Base(x-1, y-1);
		this.tableau[x-1][y-1].ajoute(2);
		this.tableau[4][3].mine = 1;
	}
	
	/**
	 * Retourn la coordonnee de la base de l'Ã©quipe passÃ© en paramÃ¨tre
	 * @return
	 */
	public Coordonnees getBase(int equipe){
		for(int i = 0; i < this.x; i++){
			for (int j = 0; j < this.y; j++) {
				if(this.tableau[i][j].estBase() == equipe){
					return new Coordonnees(i, j);
				}
			}
		}
		return null;
	}
	
	/** 
	 * Affiche le plateau
	 */
	public void afficherPlateau(Vue vue){
		System.out.println("  1   2   3   4   5  x/y");
		for (int i = 0; i < this.x; i++) {
			System.out.println("---------------------");
			for(int j = 0; j < this.y; j++){
				System.out.print("¦");
				if(this.tableau[i][j].contientMine() != vue.equipe && this.tableau[i][j].contientMine() != 0)
					if(this.tableau[i][j].robot == null){
						System.out.print("   ");
					}
					else{
						System.out.print(this.tableau[i][j].robot);
					}
				else if(this.tableau[i][j].contientMine() == vue.equipe){
					System.out.print(" M ");
				}
				else{
					System.out.print(this.tableau[i][j].toString());
				}
					
				
			}
			System.out.println("¦ " + (i+1));
		}
		System.out.println("---------------------");
	}
	
	
	/**
	 * Retourne vrai si la case est un robot
	 */
	public boolean estRobot(int x, int y){
		if(this.tableau[x][y].robot != null)
			return true;
		return false;
	}
	
	/**
	 * Vide la case
	 */
	public void setLibre(int x, int y){
		this.tableau[x][y].videCase();
	}
	
	/**
	 * Renvoie la largeur du plateau
	 * @return
	 */
	public int getLargeur(){
		return this.x;
	}
	
	/**
	 * Renvoie la hauteur du plateau
	 * @return
	 */
	public int getHauteur(){
		return this.y;
	}
}