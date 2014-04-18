package robot;
import java.util.ArrayList;
import java.util.List;

import plateau.Coordonnees;
import plateau.Vue;


public abstract class Robot {
	
	private int energie;
	private int equipe;
	private Vue vue;
	private Coordonnees coord;
	public List<Coordonnees> deplacements;
	
	public Robot(Vue vue, int l, int h, int equipe) {
		this.vue = vue;
		this.equipe = equipe;
		this.coord = new Coordonnees(l,h);
		this.deplacements = new ArrayList<Coordonnees>();
		this.vue.deplaceSur(coord, this);
	}
	
	public boolean estSurBase() {
		return this.vue.estBase(this.coord) == this.equipe;
	}
	
	public Vue getVue() {
		return this.vue;
	}
	
	public int getEnergie() {
		return this.energie;
	}
	
	public int getEquipe() {
		return this.equipe;
	}
	
	public Coordonnees getCoordonnees() {
		return this.coord;
	}
	
	public void setVue(Vue vue) {
		this.vue = vue;
	}
	
	public void setEnergie(int energie) {
		this.energie = energie;
	}
	
	public void setCoordonnees(Coordonnees coord) {
		this.coord = coord;
	}
	
	public void subitTir() {
		this.setEnergie(this.getEnergie()-3);
	}
	
	public void subitMine() {
		this.setEnergie(this.getEnergie()-2);
	}
	
	public abstract boolean peutTirer();
	
	public abstract int getCoutAction();
	
	public abstract int getCoutDep();
	
	public abstract int getDegatTir();
	
	public abstract int getDegatMine();
	
	public abstract String getType();

	public abstract List<Coordonnees> getDeplacements();
	
	public String toString(){
		return "\n" + getType() + " niveau d'énergie: " + this.energie;
	}
}
