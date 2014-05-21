//********************************************************************* 
// Programmeur : Hanquez Remy
// Date : 08/05/2014
// Fichier : Main.java
// 
// Gere le deroulement de la partie 
//*********************************************************************

package main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import action.Action;
import action.Attaque;
import action.Deplacement;
import plateau.Constante;
import plateau.Coordonnees;
import plateau.Plateau;
import plateau.Vue;
import robot.*;

public class Main {
	static Plateau p = new Plateau(5,10);
	static Vue v1 = new Vue(1,p);
	static Vue v2 = new Vue(2,p);
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Robot> listeRobotEquipe1 = new ArrayList<Robot>();
	static ArrayList<Robot> listeRobotEquipe2 = new ArrayList<Robot>();
	static int nbRobot;
	static String nomPaysEquipe1, nomPaysEquipe2;
	
	public static void main(String[] args) {
		int cptIndiceEquipe = 1;
		int choixMode = 0;
		int testChoixUtilisateurInt = 0;
		String choixUtilisateur;
		/*p.genererchemin();*/
		System.out.println("Bienvenue dans VirtualWar !!\n\n");

		do{
			try{
				System.out.println("Quel mode de jeu voulez vous? \n1. Joueur vs Joueur\n2. IA vs IA\n3. Quitter");
				choixMode = sc.nextInt();
				if(choixMode == 3){
					return;
				}
			}catch(InputMismatchException e){
				System.out.println("Vous n'avez pas entree une valeur valide");
				testChoixUtilisateurInt = 1;
				sc.next();
			}
		}while((choixMode < 1 || choixMode > 2) || testChoixUtilisateurInt == 1);
		
		testChoixUtilisateurInt = 0;

		do{
			try{
				System.out.println("Combien de robot par equipe voulez vous ?");
				nbRobot = sc.nextInt();
			}catch(InputMismatchException e){
				System.out.println("Vous n'avez pas entree une valeur valide");
				testChoixUtilisateurInt = 1;
				sc.next();
			}
		}while((nbRobot <= 0 || nbRobot > 5) || testChoixUtilisateurInt == 1);

		testChoixUtilisateurInt = 0;

		do{
			try{
				System.out.println("Equipe 1, qu'elle sera le nom de  votre Pays?");
				nomPaysEquipe1 = sc.next();

			}
			catch(InputMismatchException e){
				System.out.println("Vous n'avez pas entree une valeur valide");
				testChoixUtilisateurInt = 1;
				sc.next();
			}
		}while(testChoixUtilisateurInt == 1);

		testChoixUtilisateurInt = 0;

		do{
			try{
				System.out.println("Equipe 2, qu'elle sera le nom de votre Pays?");
				nomPaysEquipe2 = sc.next();

			}
			catch(InputMismatchException e){
				System.out.println("Vous n'avez pas entree une valeur valide");
				testChoixUtilisateurInt = 1;
				sc.next();
			}
		}while(testChoixUtilisateurInt == 1);


		int nbTireurEquipe1 = 1;
		int nbTireurEquipe2 = 1;
		int nbPiegeurEquipe1 = 1;
		int nbPiegeurEquipe2 = 1;
		int nbCharEquipe1 = 1;
		int nbCharEquipe2 = 1;
		
		for( int i = 0; i < nbRobot; i++){
			
			cptIndiceEquipe = 1;
			
		do{
			do{
				if(cptIndiceEquipe == 1){
					System.out.println("Quel est le robot que vous voulez jouer pour le pays " + nomPaysEquipe1 + " ? (t/p/c)");
				}
				else{
					System.out.println("Quel est le robot que vous voulez jouer pour le pays " + nomPaysEquipe2 + " ? (t/p/c)");
				}
							
				choixUtilisateur = sc.next();
			}while(!choixUtilisateur.equals("t") && !choixUtilisateur.equals("p") && !choixUtilisateur.equals("c"));
			
			if(cptIndiceEquipe == 1){
				if(choixUtilisateur.equals("t")){					
					//r1 = new Tireur(v1,0,0,1);
					listeRobotEquipe1.add(new Tireur(v1,0,0,1,"Tireur" + nbTireurEquipe1));
					nbTireurEquipe1++;
				}
				else if(choixUtilisateur.equals("p")){					
					//r1 = new Piegeur(v1,0,0,1);
					listeRobotEquipe1.add(new Piegeur(v1,0,0,1, "Piegeur" + nbPiegeurEquipe1));
					nbPiegeurEquipe1++;
				} else {
					//r1 = new Char(v1,0,0,1);
					listeRobotEquipe1.add(new Char(v1,0,0,1,"Char" + nbCharEquipe1));
					nbCharEquipe1++;
				}

			}
			else if(cptIndiceEquipe == 2){
				if(choixUtilisateur.equals("t")){
					//r2 = new Tireur(v2,p.getLargeur()-1,p.getHauteur()-1,2);
					listeRobotEquipe2.add(new Tireur(v2,p.getLargeur()-1,p.getHauteur()-1,2,"Tireur" + nbTireurEquipe2));
					nbTireurEquipe2++;
				}
				else if(choixUtilisateur.equals("p")){
					//r2 = new Piegeur(v2,p.getLargeur()-1,p.getHauteur()-1,2);
					listeRobotEquipe2.add(new Piegeur(v2,p.getLargeur()-1,p.getHauteur()-1,2,"Piegeur" + nbPiegeurEquipe2));
					nbPiegeurEquipe2++;
				} else {
					//r2 = new Char(v2,p.getLargeur()-1,p.getHauteur()-1,2);
					listeRobotEquipe2.add(new Char(v2,p.getLargeur()-1,p.getHauteur()-1,2,"Char" + nbCharEquipe2));
					nbCharEquipe2++;
				}
			}		
			cptIndiceEquipe++;
		}while(cptIndiceEquipe < 3);
		}	
		if(choixMode == 1){
			jouer(p,listeRobotEquipe1,listeRobotEquipe2);
		}
		else{
			for(Robot r:listeRobotEquipe1)
				r.setIa();
			for(Robot r:listeRobotEquipe2)
				r.setIa();
			jouerIaSimple(p,listeRobotEquipe1,listeRobotEquipe2);
		}
		
		sc.close();
	}
	
	public static void jouerIaSimple(Plateau p, ArrayList<Robot> liste1, ArrayList<Robot> liste2){
		boolean partieContinu = true;
		int tourDeJeu = 0;
		Robot r = null;
		Action a;
		Random alea = new Random();
		do{
			if(tourDeJeu%2 == 0){
				System.out.println("\n----------------------------------------------------------------------------------");
				System.out.println("\nTour de jeu : " + nomPaysEquipe1 + "\n");
				p.afficherPlateau(r);
				System.out.println();
				for(Robot r2 : listeRobotEquipe1){
					if(r2.getType().equals("T")){
						System.out.println(r2.getNom() + ", " + "Energie : " + r2.getEnergie());
					}
					else if(r2.getType().equals("P")){
						System.out.println(r2.getNom() + ", " + "Energie : " + r2.getEnergie());
					} else {
						System.out.println(r2.getNom() + ", " + "Energie : " + r2.getEnergie());
					}
				}
				int g = alea.nextInt(nbRobot);
				r=listeRobotEquipe1.get(g);
				System.out.println();
			}
			else{
				System.out.println("\n----------------------------------------------------------------------------------");
				System.out.println("\nTour de jeu : " + nomPaysEquipe2 + "\n");
				p.afficherPlateau(r);
				System.out.println();
				for(Robot r2 : listeRobotEquipe1){
					if(r2.getType().equals("T")){
						System.out.println(r2.getNom() + ", " + "Energie : " + r2.getEnergie());
					}
					else if(r2.getType().equals("P")){
						System.out.println(r2.getNom() + ", " + "Energie : " + r2.getEnergie());
					} else {
						System.out.println(r2.getNom() + ", " + "Energie : " + r2.getEnergie());
					}
				}
				int g = alea.nextInt(nbRobot);
				r=listeRobotEquipe2.get(g);
				System.out.println();
			}
			a = choixAction(r, 1);
			a.agit();
			tourDeJeu++;

			for(Robot rob : listeRobotEquipe1){
				if(rob.getEnergie() <= 0){
					partieContinu = false;
				}
			}
			for(Robot rob : listeRobotEquipe2){
				if(rob.getEnergie() <= 0){
					partieContinu = false;
				}
			}			
			try{
				Thread.sleep(3000);
			}catch(InterruptedException ex){
				Thread.currentThread().interrupt();
			}
		}while(partieContinu == true);
	}
	
	public static void jouer(Plateau p, ArrayList<Robot> liste1, ArrayList<Robot> liste2) {
		Robot r = null;
		Action a;
		int tourDeJeu = 0;
		String choixRobot;
		boolean partieContinu = true;
		boolean robotDansListe = false;
		do {
			robotDansListe = false;
			if (tourDeJeu%2 == 0){
				System.out.println("\n----------------------------------------------------------------------------------");
				System.out.println("\nTour de jeu : " + nomPaysEquipe1 + "\n");
				p.afficherPlateau(r);
				System.out.println();
				
				do{
					for(Robot r2 : listeRobotEquipe1){
						if(r2.getType().equals("T")){
							System.out.println(r2.getNom() + ", " + "Energie : " + r2.getEnergie());
						}
						else if(r2.getType().equals("P")){
							System.out.println(r2.getNom() + ", " + "Energie : " + r2.getEnergie());
						} else {
							System.out.println(r2.getNom() + ", " + "Energie : " + r2.getEnergie());
						}
					}
					if(listeRobotEquipe1.size() != 1){
						System.out.println("Quel robot voulez vous jouer ?");
						choixRobot = sc.next();

						for(Robot rob : listeRobotEquipe1){
							if(rob.getNom().equals(choixRobot))
								robotDansListe = true;

						}
					}
					else{
						choixRobot = listeRobotEquipe1.get(0).getNom();
						robotDansListe = true;
					}

				}while(robotDansListe == false);

				for(Robot rob : listeRobotEquipe1){
					if(rob.getNom().equals(choixRobot)){
						r = rob;
					}
				}
				System.out.println();
			}
			else{
				System.out.println("\n----------------------------------------------------------------------------------");
				System.out.println("\nTour de jeu : " + nomPaysEquipe2 + "\n");
				p.afficherPlateau(r);
				System.out.println();
				do{
					for(Robot r2 : listeRobotEquipe2){
						if(r2.getType().equals("t")){
							System.out.println(r2.getNom() + ", " + "Energie : " + r2.getEnergie());
						}
						else if(r2.getType().equals("p")){
							System.out.println(r2.getNom() + ", " + "Energie : " + r2.getEnergie());
						} else {
							System.out.println(r2.getNom() + ", " + "Energie : " + r2.getEnergie());
						}
					}
					if(listeRobotEquipe2.size() != 1){
						System.out.println("Quel robot voulez vous jouer ?");
						choixRobot = sc.next();

						for(Robot rob : listeRobotEquipe2){
							if(rob.getNom().equals(choixRobot))
								robotDansListe = true;
						}
					}
					else{
						choixRobot = listeRobotEquipe2.get(0).getNom();
						robotDansListe = true;
					}

				}while(robotDansListe == false);


				for(Robot rob : listeRobotEquipe2){
					if(rob.getNom().equals(choixRobot)){
						r = rob;
					}
				}
				System.out.println();
			}
			a = choixAction(r, 0);
			a.agit();
			tourDeJeu++;

			for(Robot rob : listeRobotEquipe1){
				if(rob.getEnergie() <= 0){
					partieContinu = false;
				}
			}
			for(Robot rob : listeRobotEquipe2){
				if(rob.getEnergie() <= 0){
					partieContinu = false;
				}
			}

		} while(partieContinu == true);

		System.out.println("\nFin de la partie.");
	}

	public static Action choixAction(Robot r, int choixMode) {
		String actionName, deplacementName;
		Action action;
		Coordonnees c = null;
		if(choixMode == 0){
			do {
				System.out.print("Choisissez votre action: ");
				actionName = sc.next();
			} while (!actionName.equals("a") && !actionName.equals("d"));

			do {
				System.out.print("Choisissez votre direction: ");
				deplacementName = sc.next();
			} while(!deplacementName.equals("z") && !deplacementName.equals("q")
					&& !deplacementName.equals("s") && !deplacementName.equals("d")
					&& !deplacementName.equals("a") && !deplacementName.equals("e")
					&& !deplacementName.equals("w") && !deplacementName.equals("c"));
		}
		else{
			if(listeRobotEquipe1.contains(r)){
				IA ia = new IA(choixMode, listeRobotEquipe2);
				actionName = ia.choixAction(r, p);
				deplacementName = ia.choixDeplacement(r, p, actionName);
			}
			else{
				IA ia = new IA(choixMode, listeRobotEquipe1);
				actionName = ia.choixAction(r, p);
				deplacementName = ia.choixDeplacement(r, p, actionName);
			}						
		}		
		
		//On regarde le caract�re de la chaine et on attribut la direction correspondante
		if(r.getType().equals("c") || r.getType().equals("C")){
			switch(deplacementName.charAt(0)) {
			case 'z': c = Constante.HAUT;break;
			case 's': c = Constante.BAS;break;
			case 'd': c = Constante.DROITE;break;
			case 'q': c = Constante.GAUCHE;break;
			default : c = null;
			}
		} else {
			switch(deplacementName.charAt(0)) {
			case 'z': c = Constante.HAUT;break;
			case 's': c = Constante.BAS;break;
			case 'd': c = Constante.DROITE;break;
			case 'q': c = Constante.GAUCHE;break;
			case 'a': c = Constante.DIAHAUTGAUCHE;break;
			case 'e': c = Constante.DIAHAUTDROITE;break;
			case 'w': c = Constante.DIABASGAUCHE;break;
			case 'c': c = Constante.DIABASDROITE;break;
			}
		}

		if (actionName.equalsIgnoreCase("a")) {
			int cpt = 1;
			boolean test = true;
			if(r.getType().substring(0, 1).equals("c") || r.getType().substring(0, 1).equals("C")){
				do{
					action = new Attaque(r, new Coordonnees(c.getLargeur()*cpt, c.getHauteur()*cpt));
					if(p.getContenu(r.getCoordonnees().getLargeur() + c.getLargeur()*cpt, r.getCoordonnees().getHauteur() + c.getHauteur()*cpt) != null){
						test = false;
					}
					cpt++;
				}while(cpt < 10 && test == true);
			}
			else				
				action = new Attaque(r,c);
		}

		else {
			if(r.getType().substring(0, 1).equals("c") || r.getType().substring(0, 1).equals("C")){
				if(deplacementName.equals("z")){
					if(p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()-1) == null)
						action = new Deplacement(r,new Coordonnees(c.getLargeur()*2,c.getHauteur()*2));
					else{
						action = new Deplacement(r, new Coordonnees(c.getLargeur(), c.getHauteur()+1));
					}
				}	
				else if(deplacementName.equals("s")){
					if(p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()+1) == null)
						action = new Deplacement(r,new Coordonnees(c.getLargeur()*2,c.getHauteur()*2));
					else{
						action = new Deplacement(r, new Coordonnees(c.getLargeur(), c.getHauteur()-1));
					}
				}
				else if(deplacementName.equals("q")){
					if(p.getContenu(r.getCoordonnees().getLargeur()-1, r.getCoordonnees().getHauteur()) == null)
						action = new Deplacement(r,new Coordonnees(c.getLargeur()*2,c.getHauteur()*2));
					else{
						action = new Deplacement(r, new Coordonnees(c.getLargeur()+1, c.getHauteur()));
					}
				}
				else if(deplacementName.equals("d")){
					if(p.getContenu(r.getCoordonnees().getLargeur()+1, r.getCoordonnees().getHauteur()) == null)
						action = new Deplacement(r,new Coordonnees(c.getLargeur()*2,c.getHauteur()*2));
					else{
						action = new Deplacement(r, new Coordonnees(c.getLargeur()-1, c.getHauteur()));
					}
				}
				else{
					action = new Deplacement(r, new Coordonnees(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()));
				}
			}
			else{
				action = new Deplacement(r,c);
			}
		}
		return action;
	}
}
