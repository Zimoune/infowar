
package main;

import graphics.Map;
import graphics.MenuPanel;
import graphics.MenuPrincipal;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JFrame;

import plateau.Constante;
import plateau.Coordonnees;
import plateau.Plateau;
import plateau.Vue;
import robot.Char;
import robot.IaFinal;
import robot.Piegeur;
import robot.Robot;
import robot.Tireur;
import action.Action;
import action.Attaque;
import action.Deplacement;

public class Main {
	private static Plateau p = new Plateau(5,10);
	private static Vue v1 = new Vue(1,p);
	private static Vue v2 = new Vue(2,p);
	private static Scanner sc = new Scanner(System.in);
	private static ArrayList<Robot> listeRobotEquipe1 = new ArrayList<Robot>();
	private static ArrayList<Robot> listeRobotEquipe2 = new ArrayList<Robot>();
	private static int nbRobot;
	private static String nomPaysEquipe1, nomPaysEquipe2;
	private static int choixDifficulte = 0;

	public static void main(String[] args) {
		int cptIndiceEquipe = 1;
		int choixMode = 1;
		String choixUtilisateur;
		p.genererchemin();
		System.out.println("Bienvenue dans VirtualWar !!\n\n");

		do{
			try{
				System.out.println("Quel mode de jeu voulez vous? \n1. Joueur vs Joueur\n2. IA vs IA\n3. Joueur vs IA\n4. Quitter\n5. Map Graphique\n6. Graphique simple");
				choixMode = sc.nextInt();
				if(choixMode == 4){
					return;
				}
				else if(choixMode == 5){
					MenuPrincipal menu = new MenuPrincipal();
				}
				else if(choixMode == 6){
					MenuPrincipal menu = new MenuPrincipal();
					menu.setContentPane(new MenuPanel(menu));
					menu.revalidate();
				}
			}catch(InputMismatchException e){
				System.out.println("Vous n'avez pas entree une valeur valide");
				sc.next();
			}
		}while((choixMode < 1 || choixMode > 5));
		if(choixMode == 2){
			do{
				try{
					System.out.println("Difficulte IA : Aleatoire(1), NonAleatoire(2)");
					choixDifficulte = sc.nextInt();
				}catch(InputMismatchException e){
					System.out.println("Vous n'avez pas entree une valeur valide");
					sc.next();
				}
			}while(choixDifficulte < 1 || choixDifficulte > 2);
		}

		do{
			try{
				System.out.println("Combien de robot par equipe voulez vous ?");
				nbRobot = sc.nextInt();
			}catch(InputMismatchException e){
				System.out.println("Vous n'avez pas entree une valeur valide");
				sc.next();
			}
		}while((nbRobot < 1 || nbRobot > 5));
		try{
			System.out.println("Equipe 1, qu'elle sera le nom de  votre Pays?");
			nomPaysEquipe1 = sc.next();

		}
		catch(InputMismatchException e){
			System.out.println("Vous n'avez pas entree une valeur valide");
			sc.next();
		}
		try{
			System.out.println("Equipe 2, qu'elle sera le nom de votre Pays?");
			nomPaysEquipe2 = sc.next();

		}
		catch(InputMismatchException e){
			System.out.println("Vous n'avez pas entree une valeur valide");
			sc.next();
		}


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
		else if(choixMode == 2){
			for(Robot r:listeRobotEquipe1)
				r.setIa();
			for(Robot r:listeRobotEquipe2)
				r.setIa();
			jouerIa(p,listeRobotEquipe1,listeRobotEquipe2, choixDifficulte);
		}
		else{
			for(Robot r:listeRobotEquipe2)
				r.setIa();
			jouerIAvsJoueur(p,listeRobotEquipe1,listeRobotEquipe2, choixDifficulte);
		}

		sc.close();
	}

	public static void jouerIAvsJoueur(Plateau p, ArrayList<Robot> liste1, ArrayList<Robot> liste2, int choixDifficulte){
		JFrame menu = new MenuPrincipal(p);
		Robot r = null;
		Action a;
		int tourDeJeu = 0;
		String choixRobot;
		boolean partieContinu = true;
		boolean robotDansListe = false;
		Random alea = new Random();

		do{
			menu.setContentPane(new Map(p,r.getEquipe()));
			menu.revalidate();
			
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
				a = choixAction(r, 0);
				a.agit();
				tourDeJeu++;
			}
			else{
				System.out.println("\n----------------------------------------------------------------------------------");
				System.out.println("\nTour de jeu : " + nomPaysEquipe2 + "\n");
				p.afficherPlateau(r);
				System.out.println();
				for(Robot r2 : listeRobotEquipe2){
					if(r2.getType().equals("T")){
						System.out.println(r2.getNom() + ", " + "Energie : " + r2.getEnergie());
					}
					else if(r2.getType().equals("P")){
						System.out.println(r2.getNom() + ", " + "Energie : " + r2.getEnergie());
					} else {
						System.out.println(r2.getNom() + ", " + "Energie : " + r2.getEnergie());
					}
				}
				int g = alea.nextInt(listeRobotEquipe2.size());
				r=listeRobotEquipe2.get(g);
				System.out.println();
				a = choixAction(choixRobot(r.getEquipe()), 1);
				a.agit();
				tourDeJeu++;
				try{
					Thread.sleep(1000);
				}catch(InterruptedException ex){
					Thread.currentThread().interrupt();
				}
			}
			
			r = null;

			Iterator<Robot> itEquipe1 = listeRobotEquipe1.iterator();

			while(itEquipe1.hasNext()){
				Robot rob = itEquipe1.next();
				if(rob.estMort()){
					r = rob;
					p.videCase(rob.getCoordonnees().getLargeur(), rob.getCoordonnees().getHauteur());
					System.out.println(nomPaysEquipe1 + " : " + rob.getNom() + " est mort au combat !");
					itEquipe1.remove();

				}
			}

			listeRobotEquipe1.remove(r);

			Iterator<Robot> itEquipe2= listeRobotEquipe2.iterator();

			while(itEquipe2.hasNext()){
				Robot rob = itEquipe2.next();
				if(rob.estMort()){
					r = rob;
					p.videCase(rob.getCoordonnees().getLargeur(), rob.getCoordonnees().getHauteur());
					System.out.println(nomPaysEquipe2 + " : " + rob.getNom() + " est mort au combat !");
					itEquipe2.remove();
				}
			}

			listeRobotEquipe2.remove(r);

			if(listeRobotEquipe1.isEmpty() || listeRobotEquipe2.isEmpty())
				partieContinu = false;		

			for(Robot rob : listeRobotEquipe1){
				if(rob.getEnergie() != rob.getEnergieDeBase() && rob.estSurBase()){
					if(rob.getEnergieDeBase() - rob.getEnergie() >= 1){
						rob.setEnergie(rob.getEnergie() + 2);
						System.out.println();
						System.out.println(rob.getNom() + " a recupere 2 point d'energie");
					}
					else{
						rob.setEnergie(rob.getEnergie() + 1);
						System.out.println();
						System.out.println(rob.getNom() + " a recupere 1 point d'energie");
					}
				}
			}

		}while(partieContinu == true);
		
		System.out.println("\nFin de la partie.");
	}

	public static void jouerIa(Plateau p, ArrayList<Robot> liste1, ArrayList<Robot> liste2, int choixDifficulte){
		JFrame menu = new MenuPrincipal(p);
		boolean partieContinu = true;
		int tourDeJeu = 0;
		Robot r = null;
		Action a;
		Random alea = new Random();
		do{
			menu.setContentPane(new Map(p,r.getEquipe()));
			menu.revalidate();
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
				int g = alea.nextInt(listeRobotEquipe2.size());
				r=listeRobotEquipe1.get(g);
				System.out.println();
			}
			else{
				System.out.println("\n----------------------------------------------------------------------------------");
				System.out.println("\nTour de jeu : " + nomPaysEquipe2 + "\n");
				p.afficherPlateau(r);
				System.out.println();
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
				int g = alea.nextInt(listeRobotEquipe2.size());
				r=listeRobotEquipe2.get(g);
				System.out.println();
			}
			a = choixAction(choixRobot(r.getEquipe()), 1);
			a.agit();
			tourDeJeu++;

			r = null;

			Iterator<Robot> itEquipe1 = listeRobotEquipe1.iterator();

			while(itEquipe1.hasNext()){
				Robot rob = itEquipe1.next();
				if(rob.estMort()){
					r = rob;
					p.videCase(rob.getCoordonnees().getLargeur(), rob.getCoordonnees().getHauteur());
					System.out.println(nomPaysEquipe1 + " : " + rob.getNom() + " est mort au combat !");
					itEquipe1.remove();

				}
			}

			listeRobotEquipe1.remove(r);

			Iterator<Robot> itEquipe2= listeRobotEquipe2.iterator();

			while(itEquipe2.hasNext()){
				Robot rob = itEquipe2.next();
				if(rob.estMort()){
					r = rob;
					p.videCase(rob.getCoordonnees().getLargeur(), rob.getCoordonnees().getHauteur());
					System.out.println(nomPaysEquipe2 + " : " + rob.getNom() + " est mort au combat !");
					itEquipe2.remove();
				}
			}

			listeRobotEquipe2.remove(r);

			if(listeRobotEquipe1.isEmpty() || listeRobotEquipe2.isEmpty())
				partieContinu = false;		

			for(Robot rob : listeRobotEquipe1){
				if(rob.getEnergie() != rob.getEnergieDeBase() && rob.estSurBase()){
					if(rob.getEnergieDeBase() - rob.getEnergie() >= 1){
						rob.setEnergie(rob.getEnergie() + 2);
						System.out.println();
						System.out.println(rob.getNom() + " a recupere 2 point d'energie");
					}
					else{
						rob.setEnergie(rob.getEnergie() + 1);
						System.out.println();
						System.out.println(rob.getNom() + " a recupere 1 point d'energie");
					}
				}
			}

			try{
				Thread.sleep(1000);
			}catch(InterruptedException ex){
				Thread.currentThread().interrupt();
			}

		}while(partieContinu == true);
		
		System.out.println("\nFin de la partie.");
	}

	public static void jouer(Plateau p, ArrayList<Robot> liste1, ArrayList<Robot> liste2) {
		JFrame menu = new MenuPrincipal(p);
		Robot r = null;
		Action a;
		int tourDeJeu = 0;
		String choixRobot;
		boolean partieContinu = true;
		boolean robotDansListe = false;
		do {
			menu.setContentPane(new Map(p,1));
			menu.revalidate();
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

			r = null;

			Iterator<Robot> itEquipe1 = listeRobotEquipe1.iterator();

			while(itEquipe1.hasNext()){
				Robot rob = itEquipe1.next();
				if(rob.estMort()){
					r = rob;
					p.videCase(rob.getCoordonnees().getLargeur(), rob.getCoordonnees().getHauteur());
					System.out.println(nomPaysEquipe1 + " : " + rob.getNom() + " est mort au combat !");
					itEquipe1.remove();

				}
			}

			listeRobotEquipe1.remove(r);

			Iterator<Robot> itEquipe2= listeRobotEquipe2.iterator();

			while(itEquipe2.hasNext()){
				Robot rob = itEquipe2.next();
				if(rob.estMort()){
					r = rob;
					p.videCase(rob.getCoordonnees().getLargeur(), rob.getCoordonnees().getHauteur());
					System.out.println(nomPaysEquipe2 + " : " + rob.getNom() + " est mort au combat !");
					itEquipe2.remove();
				}
			}

			listeRobotEquipe2.remove(r);

			if(listeRobotEquipe1.isEmpty() || listeRobotEquipe2.isEmpty())
				partieContinu = false;		

			for(Robot rob : listeRobotEquipe1){
				if(rob.getEnergie() != rob.getEnergieDeBase() && rob.estSurBase()){
					if(rob.getEnergieDeBase() - rob.getEnergie() >= 1){
						rob.setEnergie(rob.getEnergie() + 2);
						System.out.println();
						System.out.println(rob.getNom() + " a recupere 2 point d'energie");
					}
					else{
						rob.setEnergie(rob.getEnergie() + 1);
						System.out.println();
						System.out.println(rob.getNom() + " a recupere 1 point d'energie");
					}
				}
			}

		} while(partieContinu == true);

		System.out.println("\nFin de la partie.");
	}

	public static Robot choixRobot(int equipe){
		Robot r;
		int nbRobotBase = 0;
		ArrayList<Robot> list;

		if(equipe == 1){
			list = listeRobotEquipe1;			
		}
		else{
			list = listeRobotEquipe2;
		}

		for(Robot rob : list){
			if(rob.estSurBase()){
				nbRobotBase++;
			}
		}

		if(nbRobotBase == list.size()){
			return list.get(0);
		}
		else{
			for(Robot rob : list){
				if(!rob.estSurBase()){
					return rob;
				}
			}			
		}

		return null;
	}

	public static Action choixAction(Robot r, int choixMode) {
		String actionName, deplacementName;
		Action action;
		Coordonnees c = null;
		int nbRobotSurBase = 0;

		if(choixMode == 0){
			if(r.getEquipe() == 0){
				for(Robot rob : listeRobotEquipe1){
					if(rob.estSurBase()){
						nbRobotSurBase++;
					}
				}
				if(nbRobotSurBase == listeRobotEquipe1.size()){
					do {
						System.out.print("Choisissez votre action: ");
						actionName = sc.next();
						if(!actionName.equals("d"))
							System.out.println("Vous devez avoir au moins 1 robot hors de la base");
					} while (!actionName.equals("d"));
				}
				else{
					do {
						System.out.print("Choisissez votre action: ");
						actionName = sc.next();
					} while (!actionName.equals("a") && !actionName.equals("d"));
				}
			}

			else{
				for(Robot rob : listeRobotEquipe2){
					if(rob.estSurBase()){
						nbRobotSurBase++;
					}
				}
				if(nbRobotSurBase == listeRobotEquipe2.size()){
					do {
						System.out.print("Choisissez votre action: ");
						actionName = sc.next();
						if(!actionName.equals("d"))
							System.out.println("Vous devez avoir au moins 1 robot hors de la base");
					} while (!actionName.equals("d"));
				}
				else{
					do {
						System.out.print("Choisissez votre action: ");
						actionName = sc.next();
					} while (!actionName.equals("a") && !actionName.equals("d"));
				}
			}

			if(r.getType().substring(0, 1).equals("c") || r.getType().substring(0, 1).equals("C")){
				do {
					System.out.print("Choisissez votre direction: ");
					deplacementName = sc.next();
				} while(!deplacementName.equals("z") && !deplacementName.equals("q")
						&& !deplacementName.equals("s") && !deplacementName.equals("d"));
			}
			else{
				do {
					System.out.print("Choisissez votre direction: ");
					deplacementName = sc.next();
				} while(!deplacementName.equals("z") && !deplacementName.equals("q")
						&& !deplacementName.equals("s") && !deplacementName.equals("d")
						&& !deplacementName.equals("a") && !deplacementName.equals("e")
						&& !deplacementName.equals("w") && !deplacementName.equals("c"));
			}
		}
		else{			
			if(r.getEquipe() == 1){
				IaFinal ia = new IaFinal(choixDifficulte, listeRobotEquipe1);
				actionName = ia.choixAction(r, p, listeRobotEquipe2);
				deplacementName = ia.choixDeplacement(r, p, actionName);
			}
			else{
				IaFinal ia = new IaFinal(choixDifficulte, listeRobotEquipe2);
				actionName = ia.choixAction(r, p, listeRobotEquipe1);
				deplacementName = ia.choixDeplacement(r, p, actionName);
			}
		}

		//On regarde le caractere de la chaine et on attribut la direction correspondante
		if(r.getType().substring(0, 1).equals("c") || r.getType().substring(0, 1).equals("C")){
			switch(deplacementName.charAt(0)) {
			case 'z': c = Constante.HAUT;break;
			case 's': c = Constante.BAS;break;
			case 'd': c = Constante.DROITE;break;
			case 'q': c = Constante.GAUCHE;break;
			//default : c = null; break;
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
			//default : c = null; break;
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
				}while(cpt <= 10 && test == true);
			}
			else				
				action = new Attaque(r,c);
		} else {
			action = new Deplacement(r,c);
		}
		return action;
	}
	
}
