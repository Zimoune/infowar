package robot;

import java.util.ArrayList;
import java.util.Random;

import plateau.Constante;
import plateau.Plateau;

public class IaFinal {
	private int niveauDeDifficulte;
	private ArrayList<Robot> listeRobotEquipe = new ArrayList<Robot>();
	private Random alea = new Random();
	private int equipe;
	private int cpt = 1;
	private ArrayList<String> deplacementPossible = new ArrayList<String>();

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
					cpt++;
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
		boolean testObstacle1 = false;
		boolean testObstacle2 = false;
		boolean testObstacle3 = false;
		boolean testObstacle4 = false;
		boolean test = false;

		equipe = r.getEquipe();

		//On verifie que au moins un robot est dehors
		for(Robot rob : listeRobotEquipe){
			if(rob.estSurBase()){
				nbRobotSurBase++;
			}
		}
		if(nbRobotSurBase == listeRobotEquipe.size()){
			if(equipe == 1){
				if(r.getType().substring(0, 1).equals("c") || r.getType().substring(0, 1).equals("C")){
					if(!p.estObstacle(r.getCoordonnees().getLargeur()+1, r.getCoordonnees().getHauteur()))
						deplacementName = "d";
					else
						deplacementName = "s";
				}
				else{
					if(!p.estObstacle(r.getCoordonnees().getLargeur()+1, r.getCoordonnees().getHauteur()))
						deplacementName = "d";	
					else if(!p.estObstacle(r.getCoordonnees().getLargeur()+1, r.getCoordonnees().getHauteur()+1))
						deplacementName = "c";
					else
						deplacementName = "s";
				}				
			}
			else{
				if(r.getType().substring(0, 1).equals("c") || r.getType().substring(0, 1).equals("C")){
					if(!p.estObstacle(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()-1))
						deplacementName = "z";	
					else
						deplacementName = "q";
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
			if(actionName == "d"){
				if(r.getType().substring(0, 1).equals("c") || r.getType().substring(0, 1).equals("C")){
					if(r.getCoordonnees().getHauteur() == p.getHauteur()-1 && r.getCoordonnees().getLargeur() != p.getLargeur()-1 && r.getCoordonnees().getLargeur() != 0){
						if(!p.estObstacle(r.getCoordonnees().getLargeur()+Constante.HAUT.getLargeur(), r.getCoordonnees().getHauteur()+Constante.HAUT.getHauteur()))
							deplacementPossible.add("z");
						//deplacementName = "z";
						if(!p.estObstacle(r.getCoordonnees().getLargeur()+Constante.DROITE.getLargeur(), r.getCoordonnees().getHauteur()+Constante.DROITE.getHauteur()))
							deplacementPossible.add("d");
						//deplacementName = "d";	
						if(!p.estObstacle(r.getCoordonnees().getLargeur()+Constante.GAUCHE.getLargeur(), r.getCoordonnees().getHauteur()+Constante.HAUT.getHauteur()))
							deplacementPossible.add("q");
						//deplacementName = "q";

						int nbAlea = alea.nextInt(deplacementPossible.size());
						deplacementName = deplacementPossible.get(nbAlea);
					}
					else if(r.getCoordonnees().getLargeur() == p.getLargeur()-1 && r.getCoordonnees().getHauteur() != p.getHauteur()-1 && r.getCoordonnees().getHauteur() != 0){
						if(!p.estObstacle(r.getCoordonnees().getLargeur()+Constante.GAUCHE.getLargeur(), r.getCoordonnees().getHauteur()+Constante.HAUT.getHauteur()))
							deplacementPossible.add("q");
						if(!p.estObstacle(r.getCoordonnees().getLargeur()+Constante.HAUT.getLargeur(), r.getCoordonnees().getHauteur()+Constante.HAUT.getHauteur()))
							deplacementPossible.add("z");
						if(!p.estObstacle(r.getCoordonnees().getLargeur()+Constante.BAS.getLargeur(), r.getCoordonnees().getHauteur()+Constante.BAS.getHauteur()))
							deplacementPossible.add("z");

						int nbAlea = alea.nextInt(deplacementPossible.size());
						deplacementName = deplacementPossible.get(nbAlea);
					}
					else if(r.getCoordonnees().getHauteur() == 0 && r.getCoordonnees().getLargeur() != p.getLargeur()-1 && r.getCoordonnees().getLargeur() != 0){
						if(!p.estObstacle(r.getCoordonnees().getLargeur()+Constante.DROITE.getLargeur(), r.getCoordonnees().getHauteur()+Constante.DROITE.getHauteur()))
							deplacementPossible.add("d");
						if(!p.estObstacle(r.getCoordonnees().getLargeur()+Constante.BAS.getLargeur(), r.getCoordonnees().getHauteur()+Constante.BAS.getHauteur()))
							deplacementPossible.add("s");
						if(!p.estObstacle(r.getCoordonnees().getLargeur()+Constante.GAUCHE.getLargeur(), r.getCoordonnees().getHauteur()+Constante.HAUT.getHauteur()))
							deplacementPossible.add("q");

						int nbAlea = alea.nextInt(deplacementPossible.size());
						deplacementName = deplacementPossible.get(nbAlea);
					}
					else if(r.getCoordonnees().getLargeur() == 0 && r.getCoordonnees().getHauteur() != p.getHauteur()-1 && r.getCoordonnees().getHauteur() != 0){
						if(!p.estObstacle(r.getCoordonnees().getLargeur()+Constante.HAUT.getLargeur(), r.getCoordonnees().getHauteur()+Constante.HAUT.getHauteur()))
							deplacementPossible.add("z");
						if(!p.estObstacle(r.getCoordonnees().getLargeur()+Constante.DROITE.getLargeur(), r.getCoordonnees().getHauteur()+Constante.DROITE.getHauteur()))
							deplacementPossible.add("d");
						if(!p.estObstacle(r.getCoordonnees().getLargeur()+Constante.BAS.getLargeur(), r.getCoordonnees().getHauteur()+Constante.BAS.getHauteur()))
							deplacementPossible.add("s");

						int nbAlea = alea.nextInt(deplacementPossible.size());
						deplacementName = deplacementPossible.get(nbAlea);
					}
					else if(r.getCoordonnees().getLargeur() == 0 && r.getCoordonnees().getHauteur() == p.getHauteur()-1){
						if(!p.estObstacle(r.getCoordonnees().getLargeur()+Constante.GAUCHE.getLargeur(), r.getCoordonnees().getHauteur()+Constante.HAUT.getHauteur()))
							deplacementPossible.add("q");
						if(!p.estObstacle(r.getCoordonnees().getLargeur()+Constante.BAS.getLargeur(), r.getCoordonnees().getHauteur()+Constante.BAS.getHauteur()))
							deplacementPossible.add("s");

						int nbAlea = alea.nextInt(deplacementPossible.size());
						deplacementName = deplacementPossible.get(nbAlea);
					}
					else if(r.getCoordonnees().getHauteur() == p.getHauteur()-1 && r.getCoordonnees().getLargeur() == 0){
						if(!p.estObstacle(r.getCoordonnees().getLargeur()+Constante.HAUT.getLargeur(), r.getCoordonnees().getHauteur()+Constante.HAUT.getHauteur()))
							deplacementPossible.add("z");
						if(!p.estObstacle(r.getCoordonnees().getLargeur()+Constante.DROITE.getLargeur(), r.getCoordonnees().getHauteur()+Constante.DROITE.getHauteur()))
							deplacementPossible.add("d");

						int nbAlea = alea.nextInt(deplacementPossible.size());
						deplacementName = deplacementPossible.get(nbAlea);
					}
					else{
						if(!p.estObstacle(r.getCoordonnees().getLargeur()+Constante.HAUT.getLargeur(), r.getCoordonnees().getHauteur()+Constante.HAUT.getHauteur()))
							deplacementPossible.add("z");
						if(!p.estObstacle(r.getCoordonnees().getLargeur()+Constante.GAUCHE.getLargeur(), r.getCoordonnees().getHauteur()+Constante.HAUT.getHauteur()))
							deplacementPossible.add("q");
						if(!p.estObstacle(r.getCoordonnees().getLargeur()+Constante.DROITE.getLargeur(), r.getCoordonnees().getHauteur()+Constante.DROITE.getHauteur()))
							deplacementPossible.add("d");	
						if(!p.estObstacle(r.getCoordonnees().getLargeur()+Constante.BAS.getLargeur(), r.getCoordonnees().getHauteur()+Constante.BAS.getHauteur()))
							deplacementPossible.add("s");

						int nbAlea = alea.nextInt(deplacementPossible.size());
						deplacementName = deplacementPossible.get(nbAlea);
					}				
				}

				/*
				 * robot t et p
				 */
				else{
					if(r.getCoordonnees().getHauteur() == p.getHauteur()-1 && r.getCoordonnees().getLargeur() != p.getLargeur()-1 && r.getCoordonnees().getLargeur() != 0){
						System.out.println("YOLLLO 1");
						if(!p.estObstacle(r.getCoordonnees().getLargeur()+Constante.HAUT.getLargeur(), r.getCoordonnees().getHauteur()+Constante.HAUT.getHauteur()))
							deplacementPossible.add("z");
						//deplacementName = "z";
						if(!p.estObstacle(r.getCoordonnees().getLargeur()+Constante.DIAHAUTGAUCHE.getLargeur(), r.getCoordonnees().getHauteur()+Constante.DIAHAUTGAUCHE.getLargeur()))
							deplacementPossible.add("a");
						//deplacementName = "a";
						if(!p.estObstacle(r.getCoordonnees().getLargeur()+Constante.DIAHAUTDROITE.getLargeur(), r.getCoordonnees().getHauteur()+Constante.DIAHAUTDROITE.getHauteur()))
							deplacementPossible.add("e");
						//deplacementName = "e";
						if(!p.estObstacle(r.getCoordonnees().getLargeur()+Constante.GAUCHE.getLargeur(), r.getCoordonnees().getHauteur()+Constante.HAUT.getHauteur()))
							deplacementPossible.add("q");
						//deplacementName = "q";
						if(!p.estObstacle(r.getCoordonnees().getLargeur()+Constante.DROITE.getLargeur(), r.getCoordonnees().getHauteur()+Constante.DROITE.getHauteur()))
							deplacementPossible.add("d");	
						//deplacementName = "d";

						int nbAlea = alea.nextInt(deplacementPossible.size());
						deplacementName = deplacementPossible.get(nbAlea);

					}

					else if(r.getCoordonnees().getLargeur() == p.getLargeur()-1 && r.getCoordonnees().getHauteur() != p.getHauteur()-1 && r.getCoordonnees().getHauteur() != 0){
						System.out.println("YOLLLO 2");
						if(!p.estObstacle(r.getCoordonnees().getLargeur()+Constante.HAUT.getLargeur(), r.getCoordonnees().getHauteur()+Constante.HAUT.getHauteur()))
							deplacementPossible.add("z");
						//deplacementName = "z";
						if(!p.estObstacle(r.getCoordonnees().getLargeur()+Constante.DIAHAUTGAUCHE.getLargeur(), r.getCoordonnees().getHauteur()+Constante.DIAHAUTGAUCHE.getHauteur()))
							deplacementPossible.add("a");
						//deplacementName = "a";
						if(!p.estObstacle(r.getCoordonnees().getLargeur()+Constante.GAUCHE.getLargeur(), r.getCoordonnees().getHauteur()+Constante.GAUCHE.getHauteur()))
							deplacementPossible.add("q");
						//deplacementName = "q";
						if(!p.estObstacle(r.getCoordonnees().getLargeur()+Constante.DIABASGAUCHE.getLargeur(), r.getCoordonnees().getHauteur()+Constante.DIABASGAUCHE.getHauteur()))
							deplacementPossible.add("w");
						//deplacementName = "w";
						if(!p.estObstacle(r.getCoordonnees().getLargeur()+Constante.BAS.getLargeur(), r.getCoordonnees().getHauteur()+Constante.BAS.getHauteur()))
							deplacementPossible.add("s");
						//deplacementName = "s";

						int nbAlea = alea.nextInt(deplacementPossible.size());
						deplacementName = deplacementPossible.get(nbAlea);
					}
					else if(r.getCoordonnees().getHauteur() == 0 && r.getCoordonnees().getLargeur() != p.getLargeur()-1 && r.getCoordonnees().getLargeur() != 0){
						System.out.println("YOLLLO 3");
						if(!p.estObstacle(r.getCoordonnees().getLargeur()+Constante.DROITE.getLargeur(), r.getCoordonnees().getHauteur()+Constante.DROITE.getHauteur()))
							deplacementPossible.add("d");
						//deplacementName = "d";
						if(!p.estObstacle(r.getCoordonnees().getLargeur()+Constante.DIABASDROITE.getLargeur(), r.getCoordonnees().getHauteur()+Constante.DIABASDROITE.getLargeur()))
							deplacementPossible.add("c");
						//deplacementName = "c";
						if(!p.estObstacle(r.getCoordonnees().getLargeur()+Constante.BAS.getLargeur(), r.getCoordonnees().getHauteur()+Constante.BAS.getHauteur()))
							deplacementPossible.add("s");
						//deplacementName = "s";
						if(!p.estObstacle(r.getCoordonnees().getLargeur()+Constante.GAUCHE.getLargeur(), r.getCoordonnees().getHauteur()+Constante.GAUCHE.getHauteur()))
							deplacementPossible.add("q");
						//deplacementName = "q";
						if(!p.estObstacle(r.getCoordonnees().getLargeur()+Constante.DIABASGAUCHE.getLargeur(), r.getCoordonnees().getHauteur()+Constante.DIABASGAUCHE.getHauteur()))
							deplacementPossible.add("w");
						//deplacementName = "w";

						int nbAlea = alea.nextInt(deplacementPossible.size());
						deplacementName = deplacementPossible.get(nbAlea);
					}
					else if(r.getCoordonnees().getLargeur() == 0 && r.getCoordonnees().getHauteur() != p.getHauteur()-1 && r.getCoordonnees().getHauteur() != 0){
						System.out.println("YOLLLO 4");
						if(!p.estObstacle(r.getCoordonnees().getLargeur()+Constante.BAS.getLargeur(), r.getCoordonnees().getHauteur()+Constante.BAS.getHauteur()))
							deplacementPossible.add("s");
						//deplacementName = "s";
						if(!p.estObstacle(r.getCoordonnees().getLargeur()+Constante.DROITE.getLargeur(), r.getCoordonnees().getHauteur()+Constante.DROITE.getHauteur()))
							deplacementPossible.add("d");
						//deplacementName = "d";
						if(!p.estObstacle(r.getCoordonnees().getLargeur()+Constante.DIAHAUTDROITE.getLargeur(), r.getCoordonnees().getHauteur()+Constante.DIAHAUTDROITE.getHauteur()))
							deplacementPossible.add("e");
						//deplacementName = "e";
						if(!p.estObstacle(r.getCoordonnees().getLargeur()+Constante.DIABASDROITE.getLargeur(), r.getCoordonnees().getHauteur()+Constante.DIABASDROITE.getLargeur()))
							deplacementPossible.add("c");
						//deplacementName = "c";
						if(!p.estObstacle(r.getCoordonnees().getLargeur()+Constante.HAUT.getLargeur(), r.getCoordonnees().getHauteur()+Constante.HAUT.getHauteur()))
							deplacementPossible.add("z");
						//deplacementName = "z";

						int nbAlea = alea.nextInt(deplacementPossible.size());
						deplacementName = deplacementPossible.get(nbAlea);
					}
					else if(r.getCoordonnees().getLargeur() == 0 && r.getCoordonnees().getHauteur() == p.getHauteur()-1){
						System.out.println("YOLLLO 5");
						if(!p.estObstacle(r.getCoordonnees().getLargeur()+Constante.HAUT.getLargeur(), r.getCoordonnees().getHauteur()+Constante.HAUT.getHauteur()))
							deplacementPossible.add("z");
						//deplacementName = "z";
						if(!p.estObstacle(r.getCoordonnees().getLargeur()+Constante.DIAHAUTDROITE.getLargeur(), r.getCoordonnees().getHauteur()+Constante.DIAHAUTDROITE.getHauteur()))
							deplacementPossible.add("e");
						//deplacementName = "e";
						if(!p.estObstacle(r.getCoordonnees().getLargeur()+Constante.DROITE.getLargeur(), r.getCoordonnees().getHauteur()+Constante.DROITE.getHauteur()))
							deplacementPossible.add("d");
						//deplacementName = "d";

						int nbAlea = alea.nextInt(deplacementPossible.size());
						deplacementName = deplacementPossible.get(nbAlea);
					}
					else if(r.getCoordonnees().getHauteur() == 0 && r.getCoordonnees().getLargeur() == p.getLargeur()-1){
						System.out.println("YOLLLO 6");
						if(!p.estObstacle(r.getCoordonnees().getLargeur()+Constante.GAUCHE.getLargeur(), r.getCoordonnees().getHauteur()+Constante.GAUCHE.getHauteur()))
							deplacementPossible.add("q");
						//deplacementName = "q";
						if(!p.estObstacle(r.getCoordonnees().getLargeur()+Constante.DIABASGAUCHE.getLargeur(), r.getCoordonnees().getHauteur()+Constante.DIABASGAUCHE.getHauteur()))
							deplacementPossible.add("w");
						//deplacementName = "w";
						if(!p.estObstacle(r.getCoordonnees().getLargeur()+Constante.BAS.getLargeur(), r.getCoordonnees().getHauteur()+Constante.BAS.getHauteur()))
							deplacementPossible.add("s");
						//deplacementName = "s";

						int nbAlea = alea.nextInt(deplacementPossible.size());
						deplacementName = deplacementPossible.get(nbAlea);
					}
					else{
						System.out.println("YOLLLO 7");
						if(!p.estObstacle(r.getCoordonnees().getLargeur()+Constante.HAUT.getLargeur(), r.getCoordonnees().getHauteur()+Constante.HAUT.getHauteur()))
							deplacementPossible.add("z");
						//deplacementName = "z";
						if(!p.estObstacle(r.getCoordonnees().getLargeur()+Constante.DIABASDROITE.getLargeur(), r.getCoordonnees().getHauteur()+Constante.DIABASDROITE.getHauteur()))
							deplacementPossible.add("c");
						//deplacementName = "c";
						if(!p.estObstacle(r.getCoordonnees().getLargeur()+Constante.DROITE.getLargeur(), r.getCoordonnees().getHauteur()+Constante.DROITE.getHauteur()))
							deplacementPossible.add("d");
						//deplacementName = "d";
						if(!p.estObstacle(r.getCoordonnees().getLargeur()+Constante.DIABASGAUCHE.getLargeur(), r.getCoordonnees().getHauteur()+Constante.DIABASGAUCHE.getHauteur()))
							deplacementPossible.add("w");
						//deplacementName = "w";
						if(!p.estObstacle(r.getCoordonnees().getLargeur()+Constante.DIAHAUTDROITE.getLargeur(), r.getCoordonnees().getHauteur()+Constante.DIAHAUTDROITE.getHauteur()))
							deplacementPossible.add("e");
						//deplacementName = "e";
						if(!p.estObstacle(r.getCoordonnees().getLargeur()+Constante.GAUCHE.getLargeur(), r.getCoordonnees().getHauteur()+Constante.HAUT.getHauteur()))
							deplacementPossible.add("q");
						//deplacementName = "q";
						if(!p.estObstacle(r.getCoordonnees().getLargeur()+Constante.DIAHAUTGAUCHE.getLargeur(), r.getCoordonnees().getHauteur()+Constante.DIAHAUTGAUCHE.getHauteur()))
							deplacementPossible.add("a");
						//deplacementName = "a";
						if(!p.estObstacle(r.getCoordonnees().getLargeur()+Constante.BAS.getLargeur(), r.getCoordonnees().getHauteur()+Constante.BAS.getHauteur()))
							deplacementPossible.add("s");
						//deplacementName = "s";

						int nbAlea = alea.nextInt(deplacementPossible.size());
						deplacementName = deplacementPossible.get(nbAlea);
					}
				}
			}
			else{
				if(r.getType().substring(0, 1).equals("c") || r.getType().substring(0, 1).equals("C")){
					cpt = 1;
					do{
						if(p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()+cpt) != null && p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()+cpt).getEquipe() != r.getEquipe() && !p.estObstacle(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()+cpt)){
							deplacementName = "s";
							test = true;
						}
						else if(p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()-cpt) != null &&  p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()-cpt).getEquipe() != r.getEquipe() && !p.estObstacle(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()-cpt)){
							deplacementName = "z";
							test = true;
						}
						else if(p.getContenu(r.getCoordonnees().getLargeur()-cpt, r.getCoordonnees().getHauteur()) != null && p.getContenu(r.getCoordonnees().getLargeur()-cpt, r.getCoordonnees().getHauteur()).getEquipe() != r.getEquipe() && !p.estObstacle(r.getCoordonnees().getLargeur()-cpt, r.getCoordonnees().getHauteur())){
							deplacementName = "q";
							test = true;
						}
						else if (p.getContenu(r.getCoordonnees().getLargeur()+cpt, r.getCoordonnees().getHauteur()) != null && p.getContenu(r.getCoordonnees().getLargeur()+cpt, r.getCoordonnees().getHauteur()).getEquipe() != r.getEquipe() && !p.estObstacle(r.getCoordonnees().getLargeur()+cpt, r.getCoordonnees().getHauteur())){
							deplacementName = "d";
							test = true;
						}
						else{
							deplacementName = " ";
						}
						cpt++;
					}while(cpt < 11 && test == false);
				}
				else{
					if(p.getContenu(r.getCoordonnees().getLargeur()+Constante.BAS.getLargeur(), r.getCoordonnees().getHauteur()+Constante.BAS.getHauteur()) != null && p.getContenu(r.getCoordonnees().getLargeur()+Constante.BAS.getLargeur(), r.getCoordonnees().getHauteur()+Constante.BAS.getHauteur()).getEquipe() != r.getEquipe() && !p.estObstacle(r.getCoordonnees().getLargeur()+Constante.BAS.getLargeur(), r.getCoordonnees().getHauteur()+Constante.BAS.getHauteur())){
						deplacementName = "s";
					}
					else if(p.getContenu(r.getCoordonnees().getLargeur()+Constante.HAUT.getLargeur(), r.getCoordonnees().getHauteur()+Constante.HAUT.getHauteur()) != null && p.getContenu(r.getCoordonnees().getLargeur()+Constante.HAUT.getLargeur(), r.getCoordonnees().getHauteur()+Constante.HAUT.getHauteur()).getEquipe() != r.getEquipe() && !p.estObstacle(r.getCoordonnees().getLargeur()+Constante.HAUT.getLargeur(), r.getCoordonnees().getHauteur()+Constante.HAUT.getHauteur())){
						deplacementName = "z";
					}
					else if(p.getContenu(r.getCoordonnees().getLargeur()+Constante.GAUCHE.getLargeur(), r.getCoordonnees().getHauteur()+Constante.GAUCHE.getHauteur()) != null && p.getContenu(r.getCoordonnees().getLargeur()+Constante.GAUCHE.getLargeur(), r.getCoordonnees().getHauteur()+Constante.GAUCHE.getHauteur()).getEquipe() != r.getEquipe() && !p.estObstacle(r.getCoordonnees().getLargeur()+Constante.GAUCHE.getLargeur(), r.getCoordonnees().getHauteur()+Constante.GAUCHE.getHauteur())){
						deplacementName = "q";
					}
					else if(p.getContenu(r.getCoordonnees().getLargeur()+Constante.DROITE.getLargeur(), r.getCoordonnees().getHauteur()+Constante.DROITE.getHauteur()) != null && p.getContenu(r.getCoordonnees().getLargeur()+Constante.DROITE.getLargeur(), r.getCoordonnees().getHauteur()+Constante.DROITE.getHauteur()).getEquipe() != r.getEquipe() && !p.estObstacle(r.getCoordonnees().getLargeur()+Constante.DROITE.getLargeur(), r.getCoordonnees().getHauteur()+Constante.DROITE.getHauteur())){
						deplacementName = "d";
					}
					else{
						deplacementName = " ";
					}
				}
			}
		}

		return deplacementName;		
	}
}
