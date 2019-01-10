package DominAtions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Joueur {
	
	public int score;
	public String name;
	public Royaume royaume;
	public Couleur couleur;
	public boolean[] rois;
	public ArrayList<Domino> dominos;

	public Joueur(String name, int nbRoi, int col) {
		this.score = 0;
		this.name = name;
		this.royaume = new Royaume();
		this.rois = new boolean[nbRoi];
		this.couleur = Couleur.values()[col];
		this.dominos = new ArrayList<Domino>();
	}
	
	public void placerDomino() {
		Domino currentDomino = this.dominos.get(0);
		
		System.out.println(this.name + ", voici votre royaume :");
		this.royaume.printRoyaume();
		System.out.println("\nOù voulez-vous placer votre domino ? (Coordonnées de 0 à max) \n");
		currentDomino.print();
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		
		
	}
	
	public int choisirDomino(ArrayList<Domino> pioche, Joueur[] domC) {
		for(int i = 0; i < pioche.size(); i++) {
			pioche.get(i).print();
			if(domC[i] != null) {
				System.out.println("^^^Deja Pris^^^");
			}
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.println(this.name + ", quel domino voulez-vous ? (Entrez index domino (0-max) ):");
		int index = sc.nextInt();
		
		while(domC[index] != null) {
			System.out.println("Ce domino a déjà été pris");
			index = sc.nextInt();
		}

		this.dominos.add(pioche.get(index));
		Collections.sort(this.dominos); // S'il y a 2 rois par joueur
		return index;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void setScore(int s) {
		this.score = s;
	}
	
	public Couleur getCouleur() {
		return this.couleur;
	}
	
	public int getNbRois() {
		return this.rois.length;
	}
}
