import java.util.ArrayList;

public class Base extends Cellule {
	
	ArrayList<Robot> listRobot = new ArrayList<Robot>();
	
	public Base(int largeur, int hauteur) {
		super(largeur, hauteur);
	}

	@Override
	public void ajoute(int equipe) {
		this.base = equipe;
	}

	@Override
	public void videCase() {
		this.base = 0;
	}

	@Override
	public void deplaceSur(Robot r) {
		// TODO Auto-generated method stub
		
	}
	
	public String toString(){
		if(this.estBase() == 1)
		return " B ";
		else{
			return " b ";
		}
	}
}