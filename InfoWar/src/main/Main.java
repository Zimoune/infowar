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
		int cpt = 0;
		Scanner sc = new Scanner(System.in);
		Robot r1 = null;
		Robot r2 = null;
		String choixUtilisateur;

		do{
			System.out.println("Quel est le robot que vous voulez jouer ? (t/p)");			
			choixUtilisateur = sc.next();
			if(cpt == 0){
				if(choixUtilisateur.equals("t")){
					r1 = new Tireur(v1,0,0,1);
				}
				else{
					r1 = new Piegeur(v1,0,0,1);
				}

			}
			else if(cpt == 1){
				if(choixUtilisateur.equals("t")){
					r2 = new Tireur(v2,p.getLargeur()-1,p.getHauteur()-1,2);
				}
				else{
					r2 = new Piegeur(v2,p.getLargeur()-1,p.getHauteur()-1,2);
				}			
			}		
			cpt++;
		}while(cpt < 2);
		jouer(p,r1,r2);
	}
	
	public static void jouer(Plateau p, Robot r1, Robot r2) {
		Robot r;
		Action a;
		int tour = 0;
		do {
			if (tour%2 == 0){
				r = r1;
				p.afficherPlateau(r1);
			}
			else{
				r = r2;
				p.afficherPlateau(r2);
			}
			a = choixAction(r);
			a.agit();
			tour++;
		} while(r1.getEnergie() > 0 && r2.getEnergie() > 0);
	}
	
	public static Action choixAction(Robot r) {
		Scanner s = new Scanner(System.in);
		String actionName, deplacementName;
		Action action;
		Coordonnees c = null;
		do {
			System.out.print("Choisissez votre action: ");
			actionName = s.next();
		} while (actionName.equalsIgnoreCase("a") && actionName.equalsIgnoreCase("d"));
		
		do {
			System.out.print("Choisissez votre direction: ");
			deplacementName = s.next();
		} while(deplacementName.equalsIgnoreCase("z") && deplacementName.equalsIgnoreCase("q")
				&& deplacementName.equalsIgnoreCase("s") && deplacementName.equalsIgnoreCase("d")
				&& deplacementName.equalsIgnoreCase("a") && deplacementName.equalsIgnoreCase("e")
				&& deplacementName.equalsIgnoreCase("w") && deplacementName.equalsIgnoreCase("c"));
		
		//On regarde le caractère de la chaine et on attribut la direction correspondante
		switch(deplacementName.charAt(0)) {
		case 'z': c = Constante.Haut;break;
		case 's': c = Constante.Bas;break;
		case 'd': c = Constante.Droite;break;
		case 'q': c = Constante.Gauche;break;
		case 'a': c = Constante.diaHautGauche;break;
		case 'e': c = Constante.diaHautDroite;break;
		case 'w': c = Constante.diaBasGauche;break;
		case 'c': c = Constante.diaBasDroite;break;
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
