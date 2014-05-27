package robot;

import java.util.ArrayList;
import java.util.Random;

import plateau.Plateau;

public class IaFinal {
	private int niveauDeDifficulte;
	private ArrayList<Robot> listeRobotEquipe = new ArrayList<Robot>();
	private Random alea = new Random();
	private int equipe;
	private int poidsObstacle = 0;
	private int poidsRobotMemeEquipe = 0;
	private int poidsRobotDifferent = 20;
	private int poidsBaseInutile = 5;
	private int poidsCaseVide = 10;
	private int poidsBaseUtile = 15;
	private int cpt = 1;

	public IaFinal(int niveaudeDifficulte, ArrayList<Robot> listRobot){
		this.niveauDeDifficulte = niveaudeDifficulte;
		for(Robot r2d2 : listRobot){
			this.listeRobotEquipe.add(r2d2);
		}
	}

	/*
	 * methode pour choisir l'action
	 */
	public String choixAction(Robot r, Plateau p, ArrayList<Robot> liste){
		int nbRobotSurBase = 0;
		String actionName;
		int nbPossibilte;
		boolean testPassage = false;

		//On test si il y a au moins un robot dehors
		for(Robot rob : liste){
			if(rob.estSurBase()){
				nbRobotSurBase++;
			}
		}

		//Si il n'y a pas de robot on en sors un
		if(nbRobotSurBase == liste.size()){
			actionName = "d";
		}

		//Ia aleatoire
		else if(niveauDeDifficulte == 1){
			nbPossibilte = alea.nextInt(1);

			if(nbPossibilte == 0){
				actionName = "a";
			}
			else{
				actionName = "d";
			}
		}

		//Ia intelligente
		else{
			if(r.getType().substring(0, 1).equals("c") || r.getType().substring(0, 1).equals("C")){
				do{
					if(p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()+cpt) != null
							&& !p.estObstacle(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()+cpt)
							&& p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()+cpt).getEquipe() != r.getEquipe()){
						
						actionName = "a";
						testPassage = true;
					}
					else if(p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()-cpt) != null
							&& !p.estObstacle(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()-cpt)
							&& p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()-cpt).getEquipe() != r.getEquipe()){
						
						actionName = "a";
						testPassage = true;
					}
					else if(p.getContenu(r.getCoordonnees().getLargeur()+cpt, r.getCoordonnees().getHauteur()) != null
							&& !p.estObstacle(r.getCoordonnees().getLargeur()+cpt, r.getCoordonnees().getHauteur())
							&& p.getContenu(r.getCoordonnees().getLargeur()+cpt, r.getCoordonnees().getHauteur()).getEquipe() != r.getEquipe()){
						
						actionName = "a";
						testPassage = true;
					}
					else if(p.getContenu(r.getCoordonnees().getLargeur()-cpt, r.getCoordonnees().getHauteur()) != null
							&& !p.estObstacle(r.getCoordonnees().getLargeur()-cpt, r.getCoordonnees().getHauteur())
							&& p.getContenu(r.getCoordonnees().getLargeur()-cpt, r.getCoordonnees().getHauteur()).getEquipe() != r.getEquipe()){
						
						actionName = "a";
						testPassage = true;
					}
					else{
						actionName = "d";
					}
				}while(cpt < 11 && testPassage == false);
			}
			else{
				if(p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()+1) != null && p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()+1).getEquipe() != r.getEquipe() && !p.estObstacle(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()+1)
						|| p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()-1) != null &&  p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()-1).getEquipe() != r.getEquipe() && !p.estObstacle(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()-1)
						|| p.getContenu(r.getCoordonnees().getLargeur()-1, r.getCoordonnees().getHauteur()) != null && p.getContenu(r.getCoordonnees().getLargeur()-1, r.getCoordonnees().getHauteur()).getEquipe() != r.getEquipe() && !p.estObstacle(r.getCoordonnees().getLargeur()-1, r.getCoordonnees().getHauteur())
						|| p.getContenu(r.getCoordonnees().getLargeur()+1, r.getCoordonnees().getHauteur()) != null && p.getContenu(r.getCoordonnees().getLargeur()+1, r.getCoordonnees().getHauteur()).getEquipe() != r.getEquipe() && !p.estObstacle(r.getCoordonnees().getLargeur()+1, r.getCoordonnees().getHauteur())){

					actionName = "a";
				}
				else{
					actionName = "d";
				}
			}	
		}

		return actionName;		
	}

	/*
	 * methode pour choisir le deplacement
	 */
	public String choixDeplacement(Robot r, Plateau p, String actionName){
		String deplacementName;
		int nbRobotSurBase = 0;
		int nbPossibilite;

		//On verifie que au moins un robot est dehors
		for(Robot rob : listeRobotEquipe){
			if(rob.estSurBase()){
				nbRobotSurBase++;
			}
		}
		if(nbRobotSurBase == listeRobotEquipe.size()){
			if(equipe == 0){
				if(!p.estObstacle(r.getCoordonnees().getLargeur()+1, r.getCoordonnees().getHauteur()))
					deplacementName = "d";	
				else if(!p.estObstacle(r.getCoordonnees().getLargeur()+1, r.getCoordonnees().getHauteur()+1))
					deplacementName = "c";
				else
					deplacementName = "s";
			}
			else{
				if(!p.estObstacle(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()-1))
					deplacementName = "z";	
				else if(!p.estObstacle(r.getCoordonnees().getLargeur()-1, r.getCoordonnees().getHauteur()-1))
					deplacementName = "a";
				else
					deplacementName = "q";
			}
		}

		//Ia aleatoire
		else if(niveauDeDifficulte == 1){
			if(actionName == "d"){
				if(r.getType().substring(0, 1).equals("c") || r.getType().substring(0, 1).equals("C")){
					nbPossibilite = alea.nextInt(2);
					switch (nbPossibilite) {
					case 0:
						deplacementName = "z";
						break;
					case 1:
						deplacementName = "q";
						break;
					case 2:
						deplacementName = "s";
						break;
					default:
						deplacementName = "d";
						break;
					}
				}
				else{
					nbPossibilite = alea.nextInt(7);
					switch (nbPossibilite) {
					case 0:
						deplacementName = "z";
						break;
					case 1:
						deplacementName = "q";
						break;
					case 2:
						deplacementName = "s";
						break;
					case 3:
						deplacementName = "d";
						break;
					case 4:
						deplacementName = "a";
						break;
					case 5:
						deplacementName = "e";
						break;
					case 6:
						deplacementName = "w";
						break;

					default:
						deplacementName = "c";
						break;
					}
				}

			}
			else{
				nbPossibilite = alea.nextInt(3);
				switch (nbPossibilite) {
				case 0:
					deplacementName = "z";
					break;
				case 1:
					deplacementName = "q";
					break;
				case 2:
					deplacementName = "s";
					break;
				default:
					deplacementName = "d";
					break;
				}
			}
		}

		//IA intelligente
		else{
			deplacementName = "z";
		}

		return deplacementName;		
	}
}
