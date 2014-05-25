package robot;

import java.util.ArrayList;
import java.util.Random;

import plateau.Plateau;

public class IA {
	private int niveaudeDifficulte;
	private Random alea = new Random();
	private ArrayList<Robot> listeRobotEquipe = new ArrayList<Robot>();

	public IA(int niveaudeDifficulte, ArrayList<Robot> listRobot){
		this.niveaudeDifficulte = niveaudeDifficulte;
		for(Robot r2d2 : listRobot){
			this.listeRobotEquipe.add(r2d2);
		}		
	}

	public void calculChemin(Plateau p, Robot r){
		Robot rob;
		int testDistanceRobot = 10000;

		//On trouve le robot le plus proche
		for(Robot r2d2 : listeRobotEquipe){
			if(testDistanceRobot > (r2d2.getCoordonnees().getHauteur()+r2d2.getCoordonnees().getLargeur())){
				rob = r2d2;
			}
		}		
	}

	public String choixAction(Robot r, Plateau p, ArrayList<Robot> liste){
		String actionName;
		int nbRobotSurBase = 0;
		int nbPossibilte;

		if(niveaudeDifficulte == 1){
			for(Robot rob : liste){
				if(rob.estSurBase()){
					nbRobotSurBase++;
				}
			}
			if(nbRobotSurBase == liste.size()){
				actionName = "d";
			}
			else{
				nbPossibilte = alea.nextInt(2);

				if(nbPossibilte == 0){
					actionName = "a";
				}
				else{
					actionName = "d";
				}
			}


		}
		//ici vient l'IA intelligente
		else{
			if(!p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()+1).equals(null)
					|| !p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()-1).equals(null)
					|| !p.getContenu(r.getCoordonnees().getLargeur()-1, r.getCoordonnees().getHauteur()).equals(null)
					|| !p.getContenu(r.getCoordonnees().getLargeur()+1, r.getCoordonnees().getHauteur()).equals(null)){

				actionName = "a";
			}
			else{
				actionName = "d";
			}
		}		
		return actionName;
	}

	public String choixDeplacement(Robot r, Plateau p, String actionName, ArrayList<Robot> liste, int equipe){
		String deplacementName;
		int nbRobotSurBase = 0;
		int nbPossibilite = alea.nextInt(7);

		if(niveaudeDifficulte == 1){
			for(Robot rob : liste){
				if(rob.estSurBase()){
					nbRobotSurBase++;
				}
			}
			if(nbRobotSurBase == liste.size()){
				nbPossibilite = alea.nextInt(2);
				if(equipe == 0){
					switch (nbPossibilite) {
					case 0:
						deplacementName = "d";
						break;
					case 1:
						deplacementName = "c";
						break;
					default:
						deplacementName = "s";
						break;
					}
				}
				else{
					switch (nbPossibilite) {
					case 0:
						deplacementName = "z";
						break;
					case 1:
						deplacementName = "a";
						break;
					default:
						deplacementName = "q";
						break;
					}
				}

			}
			else{
				nbPossibilite = alea.nextInt(7);
				if(actionName == "d"){
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
		}

		//ici vient l'IA intelligente
		else{
			if(actionName == "a"){
				if(!p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()+1).equals(null)){
					deplacementName = "z";
				}
				else if(!p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()-1).equals(null)){
					deplacementName = "s";
				}
				else if(!p.getContenu(r.getCoordonnees().getLargeur()-1, r.getCoordonnees().getHauteur()).equals(null)){
					deplacementName = "q";
				}
				else{
					deplacementName = "d";
				}
			}
			else{
				deplacementName = "z";
			}			
		}
		return deplacementName;
	}
}
