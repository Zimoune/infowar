//********************************************************************* 
// Programmeur : Hanquez Rémy
// Date : 08/05/2014
// Fichier : Coordonnees.java
// 
// Gère les Coordonnées et les initialises. Cela permet de placer les robots 
//*********************************************************************

package plateau;

public class Coordonnees {
	
	int x, y;
	
	public Coordonnees(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getLargeur() {
		return this.x;
	}
	
	public int getHauteur() {
		return this.y;
	}
	
	public Coordonnees ajoutCoordonnees(Coordonnees coord){
		return new Coordonnees(this.getLargeur()+coord.getLargeur(),this.getHauteur()+coord.getHauteur());
	}

}
