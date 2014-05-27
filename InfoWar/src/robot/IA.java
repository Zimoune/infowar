package robot;

import java.util.ArrayList;
import java.util.Random;

import plateau.Plateau;

public class IA {
	private int niveaudeDifficulte;
	private Random alea = new Random();
	private ArrayList<Robot> listeRobotEquipe = new ArrayList<Robot>();
	private int equipe;

	public IA(int niveaudeDifficulte, ArrayList<Robot> listRobot){
		this.niveaudeDifficulte = niveaudeDifficulte;
		for(Robot r2d2 : listRobot){
			this.listeRobotEquipe.add(r2d2);
		}
	}

	public String choixAction(Robot r, Plateau p, ArrayList<Robot> liste){
		String actionName;
		int nbRobotSurBase = 0;
		int nbPossibilte;
		int cpt = 1;
		boolean test = false;
		boolean testObstacle1 = false;
		boolean testObstacle2 = false;
		boolean testObstacle3 = false;
		boolean testObstacle4 = false;

		for(Robot rob : liste){
			if(rob.estSurBase()){
				nbRobotSurBase++;
			}
		}
		if(nbRobotSurBase == liste.size()){
			actionName = "d";
		}
		else if(niveaudeDifficulte == 1){
			nbPossibilte = alea.nextInt(2);

			if(nbPossibilte == 0){
				actionName = "a";
			}
			else{
				actionName = "d";
			}
		}
		//ici vient l'IA intelligente
		else{
			if(r.getType().substring(0, 1).equals("c") || r.getType().substring(0, 1).equals("C")){
				do{
					if(p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()+cpt) != null && p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()+cpt).getEquipe() != r.getEquipe() && testObstacle1 == false
							|| p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()-cpt) != null &&  p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()-cpt).getEquipe() != r.getEquipe() && testObstacle2 == false
							|| p.getContenu(r.getCoordonnees().getLargeur()-cpt, r.getCoordonnees().getHauteur()) != null && p.getContenu(r.getCoordonnees().getLargeur()-cpt, r.getCoordonnees().getHauteur()).getEquipe() != r.getEquipe() && testObstacle3 == false
							|| p.getContenu(r.getCoordonnees().getLargeur()+cpt, r.getCoordonnees().getHauteur()) != null && p.getContenu(r.getCoordonnees().getLargeur()+cpt, r.getCoordonnees().getHauteur()).getEquipe() != r.getEquipe() && testObstacle4 == false){

						if(p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()+cpt).estSurObstacle()){
							testObstacle1 = true;
						}
						if(p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()-cpt).estSurObstacle()){
							testObstacle2 = true;
						}

						if(p.getContenu(r.getCoordonnees().getLargeur()-cpt, r.getCoordonnees().getHauteur()).estSurObstacle()){
							testObstacle3 = true;
						}
						if(p.getContenu(r.getCoordonnees().getLargeur()+cpt, r.getCoordonnees().getHauteur()).estSurObstacle()){
							testObstacle4 = true;
						}
						actionName = "a";
						System.out.println("peut tirer");
						test = true;
					}
					else{
						actionName = "d";
					}
					cpt++;
				}while(cpt < 11 && test == false);
			}
			else{
				if(p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()+1) != null && p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()+1).getEquipe() != r.getEquipe()
						|| p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()-1) != null &&  p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()-1).getEquipe() != r.getEquipe()
						|| p.getContenu(r.getCoordonnees().getLargeur()-1, r.getCoordonnees().getHauteur()) != null && p.getContenu(r.getCoordonnees().getLargeur()-1, r.getCoordonnees().getHauteur()).getEquipe() != r.getEquipe()
						|| p.getContenu(r.getCoordonnees().getLargeur()+1, r.getCoordonnees().getHauteur()) != null && p.getContenu(r.getCoordonnees().getLargeur()+1, r.getCoordonnees().getHauteur()).getEquipe() != r.getEquipe()){

					actionName = "a";
				}
				else{
					actionName = "d";
				}
			}		
		}

		return actionName;
	}

	public String choixDeplacement(Robot r, Plateau p, String actionName){
		String deplacementName;
		int nbRobotSurBase = 0;
		int nbPossibilite;
		int cpt = 1;
		boolean test = false;
		boolean testObstacle1 = false;
		boolean testObstacle2 = false;
		boolean testObstacle3 = false;
		boolean testObstacle4 = false;

		if(niveaudeDifficulte == 1){
			for(Robot rob : listeRobotEquipe){
				if(rob.estSurBase()){
					nbRobotSurBase++;
				}
			}
			if(nbRobotSurBase == listeRobotEquipe.size()){
				if(equipe == 0){
					if(!p.getContenu(r.getCoordonnees().getLargeur()+1, r.getCoordonnees().getHauteur()).estSurObstacle())
						deplacementName = "d";	
					else if(!p.getContenu(r.getCoordonnees().getLargeur()+1, r.getCoordonnees().getHauteur()+1).estSurObstacle())
						deplacementName = "c";
					else
						deplacementName = "s";
				}
				else{
					if(!p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()-1).estSurObstacle())
						deplacementName = "z";	
					else if(!p.getContenu(r.getCoordonnees().getLargeur()-1, r.getCoordonnees().getHauteur()-1).estSurObstacle())
						deplacementName = "a";
					else
						deplacementName = "q";
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
				if(r.getType().substring(0, 1).equals("c") || r.getType().substring(0, 1).equals("C")){
					do{
						if(p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()+cpt).estSurObstacle()){
							testObstacle1 = true;
						}
						if(p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()-cpt).estSurObstacle()){
							testObstacle2 = true;
						}

						if(p.getContenu(r.getCoordonnees().getLargeur()-cpt, r.getCoordonnees().getHauteur()).estSurObstacle()){
							testObstacle3 = true;
						}
						if(p.getContenu(r.getCoordonnees().getLargeur()+cpt, r.getCoordonnees().getHauteur()).estSurObstacle()){
							testObstacle4 = true;
						}
						if(p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()+cpt) != null && p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()+cpt).getEquipe() != r.getEquipe() && testObstacle1 == false){
							deplacementName = "s";
							System.out.println("teeeessst z");
							test = true;
						}
						else if(p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()-cpt) != null &&  p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()-cpt).getEquipe() != r.getEquipe() && testObstacle2 == false){
							deplacementName = "z";
							System.out.println("teeeessst s");
							test = true;
						}
						else if(p.getContenu(r.getCoordonnees().getLargeur()-cpt, r.getCoordonnees().getHauteur()) != null && p.getContenu(r.getCoordonnees().getLargeur()-cpt, r.getCoordonnees().getHauteur()).getEquipe() != r.getEquipe() && testObstacle3 == false){
							deplacementName = "q";
							System.out.println("teeeessst q");
							test = true;
						}
						else if (p.getContenu(r.getCoordonnees().getLargeur()+cpt, r.getCoordonnees().getHauteur()) != null && p.getContenu(r.getCoordonnees().getLargeur()+cpt, r.getCoordonnees().getHauteur()).getEquipe() != r.getEquipe() && testObstacle4 == false){
							System.out.println("teeeessst d");
							deplacementName = "d";
							test = true;
						}
						else{
							deplacementName = null;
						}
						System.out.println(cpt);
						cpt++;
					}while(cpt < 11 && test == false);
				}
				else{
					if(p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()+cpt).estSurObstacle()){
						testObstacle1 = true;
					}
					if(p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()-cpt).estSurObstacle()){
						testObstacle2 = true;
					}

					if(p.getContenu(r.getCoordonnees().getLargeur()-cpt, r.getCoordonnees().getHauteur()).estSurObstacle()){
						testObstacle3 = true;
					}
					if(p.getContenu(r.getCoordonnees().getLargeur()+cpt, r.getCoordonnees().getHauteur()).estSurObstacle()){
						testObstacle4 = true;
					}
					if(p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()+1) != null && p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()+1).getEquipe() != r.getEquipe() && testObstacle1 == false){
						deplacementName = "s";
					}
					else if(p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()-1) != null && p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()-1).getEquipe() != r.getEquipe() && testObstacle2 == false){
						deplacementName = "z";
					}
					else if(p.getContenu(r.getCoordonnees().getLargeur()-1, r.getCoordonnees().getHauteur()) != null && p.getContenu(r.getCoordonnees().getLargeur()-1, r.getCoordonnees().getHauteur()).getEquipe() != r.getEquipe() && testObstacle3 == false){
						deplacementName = "q";
					}
					else if(p.getContenu(r.getCoordonnees().getLargeur()+1, r.getCoordonnees().getHauteur()) != null && p.getContenu(r.getCoordonnees().getLargeur()+1, r.getCoordonnees().getHauteur()).getEquipe() != r.getEquipe() && testObstacle3 == false){
						deplacementName = "d";
					}
					else{
						deplacementName = null;
					}
				}

			}
			else{
				for(Robot rob : listeRobotEquipe){
					equipe = rob.getEquipe();
					if(rob.estSurBase()){
						nbRobotSurBase++;
					}
				}
				if(r.estSurBase()){
					if(r.getEquipe() == 1){
						if(r.getType().equals("C")){
							if(!p.getContenu(r.getCoordonnees().getLargeur()+1, r.getCoordonnees().getHauteur()).estSurObstacle())
								deplacementName = "d";	
							else
								deplacementName = "c";
						}
						else{
							if(!p.getContenu(r.getCoordonnees().getLargeur()+1, r.getCoordonnees().getHauteur()).estSurObstacle())
								deplacementName = "d";	
							else if(!p.getContenu(r.getCoordonnees().getLargeur()+1, r.getCoordonnees().getHauteur()+1).estSurObstacle())
								deplacementName = "c";
							else
								deplacementName = "s";
						}

					}
					else{
						if(r.getType().equals("c")){
							if(!p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()-1).estSurObstacle())
								deplacementName = "z";	
							else
								deplacementName = "q";
						}
						else{
							if(!p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()-1).estSurObstacle())
								deplacementName = "z";	
							else if(!p.getContenu(r.getCoordonnees().getLargeur()-1, r.getCoordonnees().getHauteur()-1).estSurObstacle())
								deplacementName = "a";
							else
								deplacementName = "q";
						}						
					}
				}
				else{
					if(r.getType().substring(0, 1).equals("c") || r.getType().substring(0, 1).equals("C")){
						if(r.getCoordonnees().getHauteur() == p.getHauteur() && r.getCoordonnees().getLargeur() != p.getLargeur() && p.getLargeur() != 0){
							if(!p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()-1).estSurObstacle())
								deplacementName = "z";
							else if(!p.getContenu(r.getCoordonnees().getLargeur()+1, r.getCoordonnees().getHauteur()).estSurObstacle())
								deplacementName = "d";	
							else
								deplacementName = "q";
						}

						else if(r.getCoordonnees().getLargeur() == p.getLargeur() && r.getCoordonnees().getHauteur() != p.getHauteur() && p.getHauteur() != 0){
							if(!p.getContenu(r.getCoordonnees().getLargeur()-1, r.getCoordonnees().getHauteur()).estSurObstacle())
								deplacementName = "q";
							else if(!p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()-1).estSurObstacle())
								deplacementName = "z";
							else
								deplacementName = "s";
						}
						else if(r.getCoordonnees().getHauteur() == 0 && r.getCoordonnees().getLargeur() != p.getLargeur() && p.getLargeur() != 0){
							if(!p.getContenu(r.getCoordonnees().getLargeur()-1, r.getCoordonnees().getHauteur()).estSurObstacle())
								deplacementName = "q";
							else if(!p.getContenu(r.getCoordonnees().getLargeur()+1, r.getCoordonnees().getHauteur()).estSurObstacle())
								deplacementName = "d";	
							else
								deplacementName = "s";
						}
						else if(r.getCoordonnees().getLargeur() == 0 && r.getCoordonnees().getHauteur() != p.getHauteur() && p.getHauteur() != 0){
							if(!p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()-1).estSurObstacle())
								deplacementName = "z";
							else if(!p.getContenu(r.getCoordonnees().getLargeur()+1, r.getCoordonnees().getHauteur()).estSurObstacle())
								deplacementName = "d";	
							else
								deplacementName = "s";
						}
						else if(r.getCoordonnees().getLargeur() == 0 && r.getCoordonnees().getHauteur() == p.getHauteur()){
							if(!p.getContenu(r.getCoordonnees().getLargeur()-1, r.getCoordonnees().getHauteur()).estSurObstacle())
								deplacementName = "q";
							else
								deplacementName = "s";
						}
						else if(r.getCoordonnees().getHauteur() == p.getHauteur() && r.getCoordonnees().getLargeur() == 0){
							if(!p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()-1).estSurObstacle())
								deplacementName = "z";
							else
								deplacementName = "d";	
						}
						else{
							if(!p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()-1).estSurObstacle())
								deplacementName = "z";
							else if(!p.getContenu(r.getCoordonnees().getLargeur()-1, r.getCoordonnees().getHauteur()).estSurObstacle())
								deplacementName = "q";
							else if(!p.getContenu(r.getCoordonnees().getLargeur()+1, r.getCoordonnees().getHauteur()).estSurObstacle())
								deplacementName = "d";	
							else
								deplacementName = "s";
						}
					}
					else{
						if(r.getCoordonnees().getHauteur() == p.getHauteur() && r.getCoordonnees().getLargeur() != p.getLargeur() && p.getLargeur() != 0){
							if(!p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()-1).estSurObstacle())
								deplacementName = "z";
							else if(!p.getContenu(r.getCoordonnees().getLargeur()-1, r.getCoordonnees().getHauteur()-1).estSurObstacle())
								deplacementName = "a";
							else if(!p.getContenu(r.getCoordonnees().getLargeur()+1, r.getCoordonnees().getHauteur()-1).estSurObstacle())
								deplacementName = "e";
							else if(!p.getContenu(r.getCoordonnees().getLargeur()-1, r.getCoordonnees().getHauteur()).estSurObstacle())
								deplacementName = "q";
							else
								deplacementName = "d";
						}
						
						else if(r.getCoordonnees().getLargeur() == p.getLargeur() && r.getCoordonnees().getHauteur() != p.getHauteur() && p.getHauteur() != 0){
							if(!p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()-1).estSurObstacle())
								deplacementName = "z";
							else if(!p.getContenu(r.getCoordonnees().getLargeur()-1, r.getCoordonnees().getHauteur()-1).estSurObstacle())
								deplacementName = "a";
							else if(!p.getContenu(r.getCoordonnees().getLargeur()-1, r.getCoordonnees().getHauteur()).estSurObstacle())
								deplacementName = "q";
							else if(!p.getContenu(r.getCoordonnees().getLargeur()-1, r.getCoordonnees().getHauteur()+1).estSurObstacle())
								deplacementName = "w";
							else
								deplacementName = "s";
							
						}
						else if(r.getCoordonnees().getHauteur() == 0 && r.getCoordonnees().getLargeur() != p.getLargeur() && p.getLargeur() != 0){
							if(!p.getContenu(r.getCoordonnees().getLargeur()-1, r.getCoordonnees().getHauteur()).estSurObstacle())
								deplacementName = "q";
							else if(!p.getContenu(r.getCoordonnees().getLargeur()-1, r.getCoordonnees().getHauteur()+1).estSurObstacle())
								deplacementName = "w";
							else if(!p.getContenu(r.getCoordonnees().getLargeur()+1, r.getCoordonnees().getHauteur()).estSurObstacle())
								deplacementName = "d";
							else if(!p.getContenu(r.getCoordonnees().getLargeur()+1, r.getCoordonnees().getHauteur()+1).estSurObstacle())
								deplacementName = "c";
							else
								deplacementName = "s";
						}
						else if(r.getCoordonnees().getLargeur() == 0 && r.getCoordonnees().getHauteur() != p.getHauteur() && p.getHauteur() != 0){
							if(!p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()-1).estSurObstacle())
								deplacementName = "z";
							else if(!p.getContenu(r.getCoordonnees().getLargeur()+1, r.getCoordonnees().getHauteur()-1).estSurObstacle())
								deplacementName = "e";
							else if(!p.getContenu(r.getCoordonnees().getLargeur()+1, r.getCoordonnees().getHauteur()).estSurObstacle())
								deplacementName = "d";
							else if(!p.getContenu(r.getCoordonnees().getLargeur()+1, r.getCoordonnees().getHauteur()+1).estSurObstacle())
								deplacementName = "c";
							else
								deplacementName = "s";
						}
						else if(r.getCoordonnees().getLargeur() == 0 && r.getCoordonnees().getHauteur() == p.getHauteur()){
							if(!p.getContenu(r.getCoordonnees().getLargeur()-1, r.getCoordonnees().getHauteur()).estSurObstacle())
								deplacementName = "q";
							else if(!p.getContenu(r.getCoordonnees().getLargeur()-1, r.getCoordonnees().getHauteur()+1).estSurObstacle())
								deplacementName = "w";
							else
								deplacementName = "s";
						}
						else if(r.getCoordonnees().getHauteur() == p.getHauteur() && r.getCoordonnees().getLargeur() == 0){
							if(!p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()-1).estSurObstacle())
								deplacementName = "z";
							else if(!p.getContenu(r.getCoordonnees().getLargeur()+1, r.getCoordonnees().getHauteur()-1).estSurObstacle())
								deplacementName = "e";
							else
								deplacementName = "d";
						}
						else{
							if(!p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()-1).estSurObstacle())
								deplacementName = "z";
							else if(!p.getContenu(r.getCoordonnees().getLargeur()-1, r.getCoordonnees().getHauteur()-1).estSurObstacle())
								deplacementName = "a";
							else if(!p.getContenu(r.getCoordonnees().getLargeur()-1, r.getCoordonnees().getHauteur()).estSurObstacle())
								deplacementName = "q";
							else if(!p.getContenu(r.getCoordonnees().getLargeur()-1, r.getCoordonnees().getHauteur()+1).estSurObstacle())
								deplacementName = "w";
							else if(!p.getContenu(r.getCoordonnees().getLargeur()+1, r.getCoordonnees().getHauteur()-1).estSurObstacle())
								deplacementName = "e";
							else if(!p.getContenu(r.getCoordonnees().getLargeur()+1, r.getCoordonnees().getHauteur()).estSurObstacle())
								deplacementName = "d";
							else if(!p.getContenu(r.getCoordonnees().getLargeur()+1, r.getCoordonnees().getHauteur()+1).estSurObstacle())
								deplacementName = "c";
							else
								deplacementName = "s";
						}
					}
				}
			}
		}
		return deplacementName;
	}
}
