import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Partie {
	
	ArrayList<Vue> listVu = new ArrayList<Vue>();
	Plateau p;
	
	public Partie(){
		//2 Joueurs et 1 robot
		this.initPartie(2, 1);
		p.afficherPlateau(this.listVu.get(1));;
		if(this.p.tableau[p.getBase(1).getLargeur()][p.getBase(1).getHauteur()] instanceof Base){
			
		}
			
	}
	
	/**
	 * Ajout le robots dans la base de l'équipe
	 * @param choixRobot
	 * @param equipe
	 */
	private void actionChoixRobot(int choixRobot, int equipe) {
		switch (choixRobot) {
		//Si le choix est Tireur
		case 1:
			int x, y;
			x = p.getBase(equipe).getLargeur();
			y = p.getBase(equipe).getHauteur();
			p.tableau[x][y].setRobot(new Tireur(listVu.get(equipe-1), x, y, equipe));
			break;
		//Si le choix est Piegeur
		case 2:
			x = p.getBase(equipe).getLargeur();
			y = p.getBase(equipe).getHauteur();
			p.tableau[x][y].setRobot(new Piegeur(listVu.get(equipe-1), x, y, equipe));
			break;
		//Sinon mauvais choix.
		default:
			System.out.println("Entrer une valeur correcte");
			actionChoixRobot(choixRobot(), equipe);
			break;
		}

	}

	/**
	 * Renvoie le choix de robot
	 * @return
	 */
	private int choixRobot() {
		do{
			try{
				return new Scanner(System.in).nextInt();
			}
			catch(InputMismatchException e){
				System.out.println("Entrer une valeur correcte");
			}
		}while(true);
	}

	/**
	 * Initialise la partie en fonction du nombre de joueur et de robot par équipe
	 * @param nmbDeJoueur
	 * @param nmbRobotParEquipe
	 */
	public void initPartie(int nmbDeJoueur, int nmbRobotParEquipe){
		p = new Plateau();
		p.initPlateau();
		//Pour chaque joueur
		for(int i = 1; i <= nmbDeJoueur; i++){
			this.listVu.add(new Vue(i, this.p));
			//Choix des types de tout les robots
			for(int j = 0; j < nmbRobotParEquipe ; j++){
				System.out.println("Choisissez un type de robot :");
				System.out.println("1. Tireur");
				System.out.println("2. Piegeur");
				this.actionChoixRobot(choixRobot(), i);
			}

		}
		
	}
	
}
