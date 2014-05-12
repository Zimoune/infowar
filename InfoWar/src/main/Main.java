//********************************************************************* 
// Programmeur : Hanquez Rémy
// Date : 08/05/2014
// Fichier : Main.java
// 
// Gére le dérooulement de la partie 
//*********************************************************************

package main;

import java.util.ArrayList;
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
	
	public static void main(String[] args) {
		int cpt = 1;
		int choixMode;
		
		String choixUtilisateur;
		
		System.out.println("Bienvenue dans VirtualWar !!\n\n");
		
		do{
			System.out.println("Quel mode de jeu voulez vous? Joueur vs Joueur(1) ou IA vs IA(2)");
			choixMode = sc.nextInt();
		}while(choixMode < 1 || choixMode > 2);
		
		do{
			System.out.println("Combien de robot par equipe voulez vous ?");
			nbRobot = sc.nextInt();
		}while(nbRobot < 0 || nbRobot > 5);
		
		int t = 1;
		int t1 = 1;
		int pi = 1;
		int pi1 = 1;
		int c = 1;
		int c1 = 1;
		
		for( int i = 0; i < nbRobot; i++){
			
			cpt = 1;
			
		do{
			do{
				System.out.println("Quel est le robot que vous voulez jouer pour l'equipe " + cpt + " ? (t/p/c)");			
				choixUtilisateur = sc.next();
			}while(!choixUtilisateur.equals("t") && !choixUtilisateur.equals("p") && !choixUtilisateur.equals("c"));
			
			if(cpt == 1){
				if(choixUtilisateur.equals("t")){
					
					//r1 = new Tireur(v1,0,0,1);
					listeRobotEquipe1.add(new Tireur(v1,0,0,1,"Tireur" + t));
					t ++;
				}
				else if(choixUtilisateur.equals("p")){
					
					//r1 = new Piegeur(v1,0,0,1);
					listeRobotEquipe1.add(new Piegeur(v1,0,0,1, "Piegeur" + pi));
					pi++;
				} else {
					//r1 = new Char(v1,0,0,1);
					listeRobotEquipe1.add(new Char(v1,0,0,1,"Char" + c));
					c++;
				}

			}
			else if(cpt == 2){
				if(choixUtilisateur.equals("t")){
					//r2 = new Tireur(v2,p.getLargeur()-1,p.getHauteur()-1,2);
					listeRobotEquipe2.add(new Tireur(v2,p.getLargeur()-1,p.getHauteur()-1,2,"Tireur" + t1));
					t1++;
				}
				else if(choixUtilisateur.equals("p")){
					//r2 = new Piegeur(v2,p.getLargeur()-1,p.getHauteur()-1,2);
					listeRobotEquipe2.add(new Piegeur(v2,p.getLargeur()-1,p.getHauteur()-1,2,"Piegeur" + pi1));
					pi1++;
				} else {
					//r2 = new Char(v2,p.getLargeur()-1,p.getHauteur()-1,2);
					listeRobotEquipe2.add(new Char(v2,p.getLargeur()-1,p.getHauteur()-1,2,"Char" + c1));
					c1++;
				}
			}		
			cpt++;
		}while(cpt < 3);
		}	
		if(choixMode == 1){
			jouer(p,listeRobotEquipe1,listeRobotEquipe2);
		}
		else{
			jouerIaSimple(p,listeRobotEquipe1,listeRobotEquipe2);
		}
		
		sc.close();
	}
	
	public static void jouerIaSimple(Plateau p, ArrayList<Robot> liste1, ArrayList<Robot> liste2){
		boolean partieContinu = true;
		int tour = 0;
		Robot r = null;
		Action a;
		Robot choixRobot;
		Random alea = new Random();
		do{
			if(tour%2 == 0){
				System.out.println("\n----------------------------------------------------------------------------------");
				System.out.println("\nTour de jeu : Joueur 1\n");
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
				System.out.println("\nTour de jeu : Joueur 2\n");
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
			tour++;

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
		int tour = 0;
		String choixRobot;
		boolean partieContinu = true;
		boolean robotDansListe = false;
		do {
			robotDansListe = false;
			if (tour%2 == 0){
				System.out.println("\n----------------------------------------------------------------------------------");
				System.out.println("\nTour de jeu : Joueur 1\n");
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
				System.out.println("\nTour de jeu : Joueur 2\n");
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
			tour++;

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
		Random alea = new Random();
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
			int g = alea.nextInt(2);
			if(g == 0){
				actionName = "a";
			}
			else{
				actionName = "d";
			}

			g = alea.nextInt(7);

			if(g == 0){
				deplacementName = "z";
			}
			else if(g == 1){
				deplacementName = "q";
			}
			else if(g == 2){
				deplacementName = "s";
			}
			else if(g == 3){
				deplacementName = "d";
			}
			else if(g == 4){
				deplacementName = "a";
			}
			else if(g == 5){
				deplacementName = "e";
			}
			else if(g == 6){
				deplacementName = "w";
			}
			else{
				deplacementName = "c";
			}			
		}		
		
		//On regarde le caractï¿½re de la chaine et on attribut la direction correspondante
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
				if(deplacementName.equals("z") || deplacementName.equals("s") || deplacementName.equals("q") || deplacementName.equals("d")){
					action = new Deplacement(r,new Coordonnees(c.getLargeur()*2,c.getHauteur()*2));
				}			
				else{
					action = new Deplacement(r, new Coordonnees(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()));
				}
			} else {
			action = new Deplacement(r,c);
			}
			
		}
		return action;
	}
}
