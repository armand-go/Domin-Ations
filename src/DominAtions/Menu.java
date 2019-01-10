package DominAtions;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Menu {

	int nbrJoueur;
	
	public Menu() {
		//this.nbrJoueur = this.choixNbJoueur();
	}
	
	public void show() {
	    JFrame fenetre = new JFrame();
	    fenetre.setTitle("Domi'Nations");
	    fenetre.setSize(400, 100);
	    fenetre.setLocationRelativeTo(null);
	    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	    
	    fenetre.setLayout(new GridBagLayout());
	    GridBagConstraints c = new GridBagConstraints();
	    c.ipadx = -2;
	    c.ipady = -2;
	    
	    c.gridx = 1;
	    c.gridy = 0;
	    fenetre.add(new JLabel("Domi'Nations"), c);
	    
		JButton button2, button3, button4;
		button2 = new JButton("2 Joueurs");
		button3 = new JButton("3 Joueurs");
		button4 = new JButton("4 Joueurs");
		
	    c.gridx = 0;
	    c.gridy = 1;
	    fenetre.add(button2, c);
	    c.gridx = 1;
	    c.gridy = 1;
	    fenetre.add(button3, c);
	    c.gridx = 2;
	    c.gridy = 1;
	    fenetre.add(button4, c);
	    
	    fenetre.setVisible(true);
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
