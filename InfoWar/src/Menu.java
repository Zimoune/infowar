import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

	/**
	 * Affiche le menu, lance les fonctions de choix et de redirection.
	 */
	public void afficher() {
		System.out.println("------------------------------");
		System.out.println("|            MENU            |");
		System.out.println("------------------------------");
		System.out.println(" 1. Joueur contre Joueur");
		System.out.println(" 2. Quitter ");
		this.actionMenu(this.choixMenu());
		
	}

	/**
	 * Redirectionne l'utilisateur en fonction de sont choix.
	 * 
	 * @param choix
	 */
	public void actionMenu(int choix) {
		switch (choix) {
		case 1:
			new Partie();
			break;
		case 2:
			System.out.println("Bye");
			break;

		default:
			System.out.println("Entrer une valeur correcte");
			this.actionMenu(this.choixMenu());
			break;
		}
	}

	/**
	 * Demande à l'utilisateur de faire un choix. Renvoie le choix.
	 * 
	 * @return
	 */
	public int choixMenu() {
		do{
			try{
				return new Scanner(System.in).nextInt();	
			}
			catch(InputMismatchException e){
				System.out.println("Entrer une valeur correcte");
			}
		}while(true);
	}
}