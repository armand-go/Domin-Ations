package DominAtions;

import java.util.Scanner; 

public class Menu {

	int nbrJoueur;
	
	public Menu() {
		this.nbrJoueur = this.choixNbJoueur();
	}
	
	public void show() {
		// TODO : Interface Graphique
	}
	
	public int choixNbJoueur() {
		System.out.println("DOMINATION");
		System.out.println("Vous pouvez jouer à 2, 3 ou 4 joueurs\n\n");
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez choisir le nombre de Joueur :");
		int nbr = sc.nextInt();
		
		while(nbr != 2 && nbr !=3 && nbr != 4) {
			System.out.println("Vous ne pouvez jouer qu'à 2, 3 ou 4 Joueurs !\n");
			
			System.out.println("Veuillez choisir le nombre de Joueur :");
			nbr = sc.nextInt();
		}
		
		System.out.println("C'est parti pour un mode " + nbr + " Joueurs");
		
		return nbr;
	}
}
