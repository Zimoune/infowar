import java.util.Scanner;

public class Menu {

	/**
	 * Affiche le menu, lance les fonctions de choix et de redirection.
	 */
	public void afficher() {
		System.out.println("------------------------------");
		System.out.println("|            MENU            |");
		System.out.println("------------------------------");
		System.out.println(" 1. Joueur contre ordinateur ");
		System.out.println(" 2. Joueur contre joueur  ");
		System.out.println(" 3. Quitter ");
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
			System.out.println("lancement de la partie jcj");
			break;
		case 3:
			System.out.println("Bye");
			break;

		default:
			System.out.println("Veuillez rentrer un choix valide");
			break;
		}
	}

	/**
	 * Demande à l'utilisateur de faire un choix. Renvoie le choix.
	 * 
	 * @return
	 */
	public int choixMenu() {
		return new Scanner(System.in).nextInt();
	}

}