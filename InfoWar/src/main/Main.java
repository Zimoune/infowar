package main;

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
	
	public static void main(String[] args) {
		int cpt = 1;
		Scanner sc = new Scanner(System.in);
		Robot r1 = null;
		Robot r2 = null;
		String choixUtilisateur;
		
		System.out.println("Bienvenue dans VirtualWar !!\n\n");

		do{
			do{
				System.out.println("Quel est le robot que vous voulez jouer pour l'equipe " + cpt + " ? (t/p/c)");			
				choixUtilisateur = sc.next();
			}while(!choixUtilisateur.equals("t") && !choixUtilisateur.equals("p") && !choixUtilisateur.equals("c"));
			
			if(cpt == 1){
				if(choixUtilisateur.equals("t")){
					r1 = new Tireur(v1,0,0,1);
				}
				else if(choixUtilisateur.equals("p")){
					r1 = new Piegeur(v1,0,0,1);
				} else {
					r1 = new Char(v1,0,0,1);
				}

			}
			else if(cpt == 2){
				if(choixUtilisateur.equals("t")){
					r2 = new Tireur(v2,p.getLargeur()-1,p.getHauteur()-1,2);
				}
				else if(choixUtilisateur.equals("p")){
					r2 = new Piegeur(v2,p.getLargeur()-1,p.getHauteur()-1,2);
				} else {
					r2 = new Char(v2,p.getLargeur()-1,p.getHauteur()-1,2);
				}
			}		
			cpt++;
		}while(cpt < 3);
		
		if(r1.getType().equals("T")){
			System.out.println("\nJoueur 1 : Tireur(T)");
		}
		else if(r1.getType().equals("P")){
			System.out.println("\nJoueur 1 : Piegeur(P)");
		} else {
			System.out.println("\nJoueur 1 : Char(C)");
		}
		if(r2.getType().equals("t")){
			System.out.println("Joueur 2 : Tireur(t)\n");
		}
		else if(r2.getType().equals("p")){
			System.out.println("\nJoueur 2 : Piegeur(p)");
		} else {
			System.out.println("\nJoueur 1 : Char(c)");
		}
		
		jouer(p,r1,r2);
	}
	
	public static void jouer(Plateau p, Robot r1, Robot r2) {
		Robot r;
		Action a;
		int tour = 0;
		do {
			if (tour%2 == 0){
				System.out.println("\nTour de jeu : Joueur 1\n");
				r = r1;
				p.afficherPlateau(r1);
				System.out.println();
			}
			else{
				System.out.println("\nTour de jeu : Joueur 2\n");
				r = r2;
				p.afficherPlateau(r2);
				System.out.println();
			}
			a = choixAction(r);
			a.agit();
			tour++;
		} while(r1.getEnergie() > 0 && r2.getEnergie() > 0);
		
		System.out.println("\nFin de la partie.");
	}
	
	public static Action choixAction(Robot r) {
		Scanner s = new Scanner(System.in);
		String actionName, deplacementName;
		Action action;
		Coordonnees c = null;
		do {
			System.out.print("Choisissez votre action: ");
			actionName = s.next();
		} while (!actionName.equals("a") && !actionName.equals("d"));
		
		do {
			System.out.print("Choisissez votre direction: ");
			deplacementName = s.next();
		} while(!deplacementName.equals("z") && !deplacementName.equals("q")
				&& !deplacementName.equals("s") && !deplacementName.equals("d")
				&& !deplacementName.equals("a") && !deplacementName.equals("e")
				&& !deplacementName.equals("w") && !deplacementName.equals("c"));
		
		//On regarde le caract�re de la chaine et on attribut la direction correspondante
		if(r.getType().equals("c") || r.getType().equals("C")){
			switch(deplacementName.charAt(0)) {
			case 'z': c = Constante.HautChar;break;
			case 's': c = Constante.BasChar;break;
			case 'd': c = Constante.DroiteChar;break;
			case 'q': c = Constante.GaucheChar;break;
			}
		} else {
			switch(deplacementName.charAt(0)) {
			case 'z': c = Constante.Haut;break;
			case 's': c = Constante.Bas;break;
			case 'd': c = Constante.Droite;break;
			case 'q': c = Constante.Gauche;break;
			case 'a': c = Constante.diaHautGauche;break;
			case 'e': c = Constante.diaHautDroite;break;
			case 'w': c = Constante.diaHautGauche;break;
			case 'c': c = Constante.diaBasDroite;break;
			}
		}
		
		if (actionName.equalsIgnoreCase("a")) {
			action = new Attaque(r,c);
		}
		else {
			action = new Deplacement(r,c);
		}
		
		return action;
	}

}
