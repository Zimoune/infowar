//********************************************************************* 
// Programmeur : Hanquez R�my
// Date : 08/05/2014
// Fichier : Attaque.java
// 
// H�rite de Action. G�re les attaques des diff�rents robots
//*********************************************************************

package action;

import plateau.Coordonnees;
import robot.Robot;

public class Attaque extends Action {

	public Attaque(Robot r, Coordonnees direction) {
		super(r, direction);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void agit() {
		//On v�rifie que la direction selectionn� n'est pas null
		if (this.getDirection() != null) {

			//On v�rifie que le robot peut tirer
			if (this.getRobot().peutTirer()) {
				
				//On v�rifie que l'endroit ou le robot doit tirer n'est pas vide
				if (this.getRobot().getVue().getContenu(this.getObjectif()) != null) {
					//On retire l'energie au robot qui se fait attaquer
					this.getRobot().getVue().getContenu(this.getObjectif()).subitTir();
				}
			}
			else{
				this.getRobot().getVue().ajout(this.getObjectif(), this.getRobot().getEquipe());
			}		
			//On retire au robot attaquant l'energie de l'attaque que la case soit vide ou pas
			this.getRobot().setEnergie(this.getRobot().getEnergie()-1);
		}
	}
}
