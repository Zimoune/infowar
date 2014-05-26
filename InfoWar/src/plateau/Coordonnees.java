//********************************************************************* 
// Programmeur : Hanquez Remy
// Date : 08/05/2014
// Fichier : Coordonnees.java
// 
// Gere les Coordonnées et les initialises. Cela permet de placer les robots 
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
	
	public boolean equals(Object o){
		return ((o instanceof Coordonnees) && (((Coordonnees)o).getHauteur() == this.getHauteur()) && (((Coordonnees)o).getLargeur() == this.getLargeur())); 
		
		
	}
	
	public String toString() {
		return "x : " +x + "y" + y;
	}
}
