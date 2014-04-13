public class Attaque extends Action {

	public Attaque(Robot robot, Coordonnees direction) {
		super(robot, direction);
	}

	@Override
	public void agit() {
		// TODO Auto-generated method stub
		if(this.getRobot() instanceof Tireur){ // Le robot est un tireur
		if (this.getRobot().peutTirer() && this.getRobot().getVue().plateau.estRobot(this.getObjectif().getLargeur(), this.getObjectif().getHauteur()) //Verifie si le robot peut tirer et si l'objectif est correcte
						){
			this.getRobot().getVue().plateau.tableau[this.getObjectif()
					.getLargeur()][this.getObjectif().getHauteur()]
					.getContenu().subitTir(); // Fait des degat au robot toucher
			this.getRobot().setEnergie(this.getRobot().getEnergie()-this.getRobot().getCoutAction()); // Enleve l'energie du tireur
		}
		else if (this.getRobot().getEnergie() < this.getRobot().getCoutAction()) { // Si le robot ne peut pas tirer
			System.out.println("Pas assez d'energie");
	}
		else {
			System.out.println("Vous ne pouvez pas tirer ici"); // Si la cible n'est pas possible
		}
	}
		
		if (this.getRobot() instanceof Piegeur){ // Le robot est un piegeur
			if(this.getRobot().getEnergie() > this.getRobot().getCoutAction()){ // Verifie si il peut poser une mine
				if(!this.getRobot().getVue().estMine(this.getObjectif()) && this.getRobot().getVue().plateau.estRobot(this.getObjectif().getLargeur(),this.getObjectif().getHauteur()))
						{ //Verifie si la case est libre
							this.getRobot().getVue().setMine(getObjectif(), this.getRobot().getEquipe()); // pose la mine
				}
				else {
					System.out.println("Vous ne pouvez pas posez de mine ici");
				}
			}
			else {
				System.out.println("Vous n'avez pas assez d'energie");
			}
		}
	}
}