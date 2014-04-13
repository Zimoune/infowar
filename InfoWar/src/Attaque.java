public class Attaque extends Action {

	public Attaque(Robot robot, Coordonnees direction) {
		super(robot, direction);
	}

	@Override
	public void agit() {
		// TODO Auto-generated method stub
		if(this.getRobot() instanceof Tireur){
		if (this.getRobot().peutTirer()
				&& this.getRobot().getVue().plateau.estRobot(this.getObjectif()
						.getLargeur(), this.getObjectif().getHauteur())){
			this.getRobot().getVue().plateau.tableau[this.getObjectif()
					.getLargeur()][this.getObjectif().getHauteur()]
					.getContenu().subitTir();
			this.getRobot().setEnergie(this.getRobot().getEnergie()-this.getRobot().getCoutAction());
		}
		else if (this.getRobot().getEnergie() < this.getRobot().getCoutAction()) {
			System.out.println("Pas assez d'energie");
	}
		else {
			System.out.println("Vous ne pouvez pas tirer ici");
		}
	}
		
		if (this.getRobot() instanceof Piegeur){
			if(this.getRobot().getEnergie() > this.getRobot().getCoutAction()){
				if(!this.getRobot().getVue().estMine(this.getObjectif()) && this.getRobot().getVue().plateau.estRobot(this.getObjectif().getLargeur(),this.getObjectif().getHauteur()))
						{
							this.getRobot().getVue().setMine(getObjectif(), this.getRobot().getEquipe());
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