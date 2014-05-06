package main;

import java.util.ArrayList;
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
	
	public static void main(String[] args) {
		int cpt = 1;
		
		String choixUtilisateur;
		
		System.out.println("Bienvenue dans VirtualWar !!\n\n");
		
		System.out.println("Combien de robot par equipe voulez vous ?");
		int nbRobot = sc.nextInt();
		
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
					listeRobotEquipe1.add(new Piegeur(v1,0,0,1, "Piegeur" + p));
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

		for(Robot r : listeRobotEquipe1){
			if(r.getType().equals("T")){
				System.out.println("\nJoueur 1 : " + r.getNom());
			}
			else if(r.getType().equals("P")){
				System.out.println("\nJoueur 1 : " + r.getNom());
			} else {
				System.out.println("\nJoueur 1 : " + r.getNom());
			}
		}

		for(Robot r : listeRobotEquipe2){
			if(r.getType().equals("t")){
				System.out.println("Joueur 2 : " + r.getNom());
			}
			else if(r.getType().equals("p")){
				System.out.println("Joueur 2 : " + r.getNom());
			} else {
				System.out.println("Joueur 2 : " + r.getNom());
			}
		}		
		
		jouer(p,listeRobotEquipe1,listeRobotEquipe2);
		sc.close();
	}
	
	public static void jouer(Plateau p, ArrayList<Robot> liste1, ArrayList<Robot> liste2) {
		Robot r = null;
		Action a;
		int tour = 0;
		String choixRobot;
		boolean test = true;
		boolean test2 = false;
		do {
			if (tour%2 == 0){
				System.out.println("\n----------------------------------------------------------------------------------");
				System.out.println("\nTour de jeu : Joueur 1\n");
				p.afficherPlateau(r);
				System.out.println();
				do{
				System.out.println("Quel robot voulez vous bouger ?");
				choixRobot = sc.next();
				
				for(Robot rob : listeRobotEquipe1){
					if(rob.getNom().equals(choixRobot))
						test2 = true;
				}
				
				}while(test2 == false);
				for(Robot rob : listeRobotEquipe1){
					if(rob.getNom().equals(choixRobot)){
						r = rob;
					}
				}
			}
			else{
				System.out.println("\n----------------------------------------------------------------------------------");
				System.out.println("\nTour de jeu : Joueur 2\n");
				p.afficherPlateau(r);
				System.out.println("Quel robot voulez vous bouger ?");
				choixRobot = sc.next();
				for(Robot rob : listeRobotEquipe2){
					if(rob.getNom().equals(choixRobot)){
						r = rob;
					}
				}
				System.out.println();
			}
			a = choixAction(r);
			a.agit();
			tour++;

			for(Robot rob : listeRobotEquipe1){
				if(rob.getEnergie() <= 0){
					test = false;
				}
			}
			for(Robot rob : listeRobotEquipe2){
				if(rob.getEnergie() <= 0){
					test = false;
				}
			}

		} while(test == true);

		System.out.println("\nFin de la partie.");
	}

	public static Action choixAction(Robot r) {
		String actionName, deplacementName;
		Action action;
		Coordonnees c = null;
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
			if(r.getType().equals("c") || r.getType().equals("C")){
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
			if(r.getType().equals("c") || r.getType().equals("C")){
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
