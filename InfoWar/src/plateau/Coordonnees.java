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
