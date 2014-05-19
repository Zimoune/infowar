//********************************************************************* 
// Programmeur : Hanquez Remy
// Date : 08/05/2014
// Fichier : Vue.java
// 
// Gere la vue des different robot. Deux robots de différentes equipse ne doivent pas avoir la meme vue
//*********************************************************************

package plateau;

import robot.Robot;

public class Vue {
	
	private Plateau p;
	private int equipe;
	
	public Vue(int equipe, Plateau p) {
		this.p = p;
		this.equipe = equipe;
	}
	
	public int getEquipe() {
		return this.equipe;
	}

	public int contientMine(Coordonnees c) {
		return this.p.contientMine(c.getLargeur(), c.getHauteur());
	}

	public int estBase(Coordonnees c) {
		return this.p.estBase(c.getLargeur(), c.getHauteur());
	}
	
	public Coordonnees getCoordonnes(Coordonnees c) {
		return this.p.getCoordonnees(c.getLargeur(), c.getHauteur());
	}
	
	public Robot getContenu(Coordonnees c) {
		return this.p.getContenu(c.getLargeur(), c.getHauteur());
	}
	
	public void deplaceSur(Coordonnees c, Robot r) {
		this.p.deplaceSur(c.getLargeur(), c.getHauteur(), r);
	}
	
	public void ajout(Coordonnees c, int equipe) {
		this.p.ajout(c.getLargeur(), c.getHauteur(), equipe);
	}

	public void videCase(Coordonnees c) {
		this.p.videCase(c.getLargeur(), c.getHauteur());
	}

}
