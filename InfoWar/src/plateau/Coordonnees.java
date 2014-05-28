//********************************************************************* 
// Programmeur : Hanquez Remy
// Programmeur : Fack Vincent
// Programmeur : Delplace Gautier
// Programmeur : Lorthios Ludovic
// Programmeur : Lepeltier Damien
// Programmeur : Le Pallac Simon
// Date : 08/05/2014
// Fichier : Coordonnees.java
// 
// Gere les Coordonnées et les initialises. Cela permet de placer les robots 
//*********************************************************************

package plateau;

public class Coordonnees {
	
	int x, y;
	
	/**
	 * Constructeur de la classe Coordonnees
	 * @param x , correspond a la largeur du plateau
	 * @param y , correspond a la hauteur du plateau
	 */
	
	public Coordonnees(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/*
	 * retourne la largeur du plateau
	 */
	
	public int getLargeur() {
		return this.x;
	}
	
	/*
	 * retourne la hauteur du plateau
	 */
	
	public int getHauteur() {
		return this.y;
	}
	
	/*
	 * permet d'ajouter de nouvelle coordonee
	 */
	
	public Coordonnees ajoutCoordonnees(Coordonnees coord){
		return new Coordonnees(this.getLargeur()+coord.getLargeur(),this.getHauteur()+coord.getHauteur());
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 * test l'egalite
	 */
	
	public boolean equals(Object o){
		return ((o instanceof Coordonnees) && (((Coordonnees)o).getHauteur() == this.getHauteur()) && (((Coordonnees)o).getLargeur() == this.getLargeur())); 
		
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * permet d'afficher
	 */
	
	public String toString() {
		return "x : " +x + "y" + y;
	}
}
