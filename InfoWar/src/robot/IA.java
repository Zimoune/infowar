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

	/*public void calculChemin(Plateau p, Robot r){
		Robot rob;
		int testDistanceRobot = 10000;

		//On trouve le robot le plus proche
		for(Robot r2d2 : listeRobotEquipe){
			if(testDistanceRobot > (r2d2.getCoordonnees().getHauteur()+r2d2.getCoordonnees().getLargeur())){
				rob = r2d2;
			}
		}		
	}*/

	public String choixAction(Robot r, Plateau p, ArrayList<Robot> liste){
		String actionName;
		int nbRobotSurBase = 0;
		int nbPossibilte;
		int cpt = 1;
		boolean test = false;
		
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
			if(r.getType().equals("C") || r.getType().equals("c")){
				do{
					if(p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()+cpt) != null && p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()+cpt).getEquipe() != r.getEquipe()
							|| p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()-cpt) != null &&  p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()-cpt).getEquipe() != r.getEquipe()
							|| p.getContenu(r.getCoordonnees().getLargeur()-cpt, r.getCoordonnees().getHauteur()) != null && p.getContenu(r.getCoordonnees().getLargeur()-cpt, r.getCoordonnees().getHauteur()).getEquipe() != r.getEquipe()
							|| p.getContenu(r.getCoordonnees().getLargeur()+cpt, r.getCoordonnees().getHauteur()) != null && p.getContenu(r.getCoordonnees().getLargeur()+cpt, r.getCoordonnees().getHauteur()).getEquipe() != r.getEquipe()){

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

		if(niveaudeDifficulte == 1){
			for(Robot rob : listeRobotEquipe){
				if(rob.estSurBase()){
					nbRobotSurBase++;
				}
			}
			if(nbRobotSurBase == listeRobotEquipe.size()){
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
				if(r.getType().equals("C") || r.getType().equals("c")){
					do{
						if(p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()+1+cpt) != null && p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()+1+cpt).getEquipe() != r.getEquipe()){
							deplacementName = "z";
						}
						else if(p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()-1-cpt) != null &&  p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()-1-cpt).getEquipe() != r.getEquipe()){
							deplacementName = "s";
						}
						else if(p.getContenu(r.getCoordonnees().getLargeur()-1-cpt, r.getCoordonnees().getHauteur()) != null && p.getContenu(r.getCoordonnees().getLargeur()-1-cpt, r.getCoordonnees().getHauteur()).getEquipe() != r.getEquipe()){
							deplacementName = "q";
						}
						else{
							deplacementName = "d";
						}
						cpt++;
					}while(cpt < 11);
				}
				else{
					if(p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()+1) != null && p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()+1).getEquipe() != r.getEquipe()){
						deplacementName = "z";
					}
					else if(p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()-1) != null && p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()-1).getEquipe() != r.getEquipe()){
						deplacementName = "s";
					}
					else if(p.getContenu(r.getCoordonnees().getLargeur()-1, r.getCoordonnees().getHauteur()) != null && p.getContenu(r.getCoordonnees().getLargeur()-1, r.getCoordonnees().getHauteur()).getEquipe() != r.getEquipe()){
						deplacementName = "q";
					}
					else{
						deplacementName = "d";
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
							nbPossibilite = alea.nextInt(1);
							switch (nbPossibilite) {
							case 0:
								deplacementName = "d";
								break;
							default:
								deplacementName = "s";
								break;
							}
						}
						else{
							nbPossibilite = alea.nextInt(2);
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

					}
					else{
						if(r.getType().equals("c")){
							nbPossibilite = alea.nextInt(1);
							switch (nbPossibilite) {
							case 0:
								deplacementName = "z";
								break;
							default:
								deplacementName = "q";
								break;
							}
						}
						else{
							nbPossibilite = alea.nextInt(2);
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
				}
				else{
					System.out.println("c'est deja sa");
					if(r.getType().equals("c") || r.getType().equals("C")){
						if(r.getCoordonnees().getHauteur() == p.getHauteur() && r.getCoordonnees().getLargeur() != p.getLargeur() && p.getLargeur() != 0){
							nbPossibilite = alea.nextInt(2);
							switch (nbPossibilite) {
							case 0:
								deplacementName = "z";
								break;
							case 1:
								deplacementName = "q";
								break;
							default:
								deplacementName = "d";
								break;
							}
						}

						else if(r.getCoordonnees().getLargeur() == p.getLargeur() && r.getCoordonnees().getHauteur() != p.getHauteur() && p.getHauteur() != 0){
							nbPossibilite = alea.nextInt(2);
							switch (nbPossibilite) {
							case 0:
								deplacementName = "z";
								break;
							case 1:
								deplacementName = "q";
								break;
							default:
								deplacementName = "s";
								break;
							}
						}
						else if(r.getCoordonnees().getHauteur() == 0 && r.getCoordonnees().getLargeur() != p.getLargeur() && p.getLargeur() != 0){
							nbPossibilite = alea.nextInt(2);
							switch (nbPossibilite) {
							case 0:
								deplacementName = "q";
								break;
							case 1:
								deplacementName = "s";
								break;
							default:
								deplacementName = "d";
								break;
							}
						}
						else if(r.getCoordonnees().getLargeur() == 0 && r.getCoordonnees().getHauteur() != p.getHauteur() && p.getHauteur() != 0){
							nbPossibilite = alea.nextInt(2);
							switch (nbPossibilite) {
							case 0:
								deplacementName = "z";
								break;
							case 1:
								deplacementName = "d";
								break;
							default:
								deplacementName = "s";
								break;
							}
						}
						else if(r.getCoordonnees().getLargeur() == 0 && r.getCoordonnees().getHauteur() == p.getHauteur()){
							nbPossibilite = alea.nextInt(1);
							switch (nbPossibilite) {
							case 0:
								deplacementName = "q";
								break;
							default:
								deplacementName = "s";
								break;
							}
						}
						else if(r.getCoordonnees().getHauteur() == p.getHauteur() && r.getCoordonnees().getLargeur() == 0){
							nbPossibilite = alea.nextInt(1);
							switch (nbPossibilite) {
							case 0:
								deplacementName = "z";
								break;
							default:
								deplacementName = "d";
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
					else{
						if(r.getCoordonnees().getHauteur() == p.getHauteur() && r.getCoordonnees().getLargeur() != p.getLargeur() && p.getLargeur() != 0){
							nbPossibilite = alea.nextInt(4);
							switch (nbPossibilite) {
							case 0:
								deplacementName = "a";
								break;
							case 1:
								deplacementName = "z";
								break;
							case 2:
								deplacementName = "e";
								break;
							case 3:
								deplacementName = "q";
								break;
							default:
								deplacementName = "d";
								break;
							}
						}
						else if(r.getCoordonnees().getLargeur() == p.getLargeur() && r.getCoordonnees().getHauteur() != p.getHauteur() && p.getHauteur() != 0){
							nbPossibilite = alea.nextInt(4);
							switch (nbPossibilite) {
							case 0:
								deplacementName = "z";
								break;
							case 1:
								deplacementName = "a";
								break;
							case 2:
								deplacementName = "q";
								break;
							case 3:
								deplacementName = "w";
								break;
							default:
								deplacementName = "s";
								break;
							}
						}
						else if(r.getCoordonnees().getHauteur() == 0 && r.getCoordonnees().getLargeur() != p.getLargeur() && p.getLargeur() != 0){
							nbPossibilite = alea.nextInt(4);
							switch (nbPossibilite) {
							case 0:
								deplacementName = "q";
								break;
							case 1:
								deplacementName = "w";
								break;
							case 2:
								deplacementName = "s";
								break;
							case 3:
								deplacementName = "c";
								break;
							default:
								deplacementName = "d";
								break;
							}
						}
						else if(r.getCoordonnees().getLargeur() == 0 && r.getCoordonnees().getHauteur() != p.getHauteur() && p.getHauteur() != 0){
							nbPossibilite = alea.nextInt(4);
							switch (nbPossibilite) {
							case 0:
								deplacementName = "z";
								break;
							case 1:
								deplacementName = "e";
								break;
							case 2:
								deplacementName = "d";
								break;
							case 3:
								deplacementName = "c";
								break;
							default:
								deplacementName = "s";
								break;
							}
						}
						else if(r.getCoordonnees().getLargeur() == 0 && r.getCoordonnees().getHauteur() == p.getHauteur()){
							nbPossibilite = alea.nextInt(2);
							switch (nbPossibilite) {
							case 0:
								deplacementName = "q";
								break;
							case 1:
								deplacementName = "w";
							default:
								deplacementName = "s";
								break;
							}
						}
						else if(r.getCoordonnees().getHauteur() == p.getHauteur() && r.getCoordonnees().getLargeur() == 0){
							nbPossibilite = alea.nextInt(2);
							switch (nbPossibilite) {
							case 0:
								deplacementName = "z";
								break;
							case 1:
								deplacementName = "e";
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
				}
			}
		}
		System.out.println(r.getNom() + " : " + deplacementName);
		return deplacementName;
	}
}
