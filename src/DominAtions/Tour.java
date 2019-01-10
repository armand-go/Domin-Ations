package DominAtions;

import java.util.ArrayList;
import java.util.Collections;

public class Tour {

	int nbDomino;
	Joueur[] joueurs;
	ArrayList<Domino> listDominos;
	
	Joueur[] ordreJoueurs;
	ArrayList<Domino> pioche;
	ArrayList<Domino> pioche2;
	
	public Tour(int nbD, Joueur[] j, ArrayList<Domino> dominos) {
		
		this.nbDomino = nbD;
		this.joueurs = j;
		this.listDominos = dominos;
		this.ordreJoueurs = new Joueur[nbD];
		this.ordreJoueurs = this.firstOrder();
		this.pioche = this.piocher();
		this.pioche2 = this.piocher();
		
		this.firstTurn();
	}
	
	public Joueur[] firstOrder() {
		ArrayList<Joueur> ordre = new ArrayList<Joueur>();
		for(Joueur j : this.joueurs) {
			for(int i = 0; i < j.getNbRois(); i++) {
				ordre.add(j);
			}
		}
		
		Collections.shuffle(ordre);
		Joueur[] ordreArray = new Joueur[ordre.size()];
		ordreArray = ordre.toArray(ordreArray);
		return ordreArray;
	}
	
	public void firstTurn() {
		Joueur[] dominoChoisi = new Joueur[this.pioche.size()];
		for(int i = 0; i < dominoChoisi.length; i++) {
			dominoChoisi[i] = null;
		}
		
		for(int i = 0; i < this.ordreJoueurs.length; i++) {
			dominoChoisi[this.ordreJoueurs[i].choisirDomino(this.pioche, dominoChoisi)] = this.ordreJoueurs[i];
		}
		
		this.ordreJoueurs = dominoChoisi;
	}
	
	public void newTurn() {
		Joueur[] dominoChoisi = new Joueur[this.pioche2.size()];
		for(int i = 0; i < dominoChoisi.length; i++) {
			dominoChoisi[i] = null;
		}
		
		for(int i = 0; i < this.ordreJoueurs.length; i++) {
			dominoChoisi[this.ordreJoueurs[i].choisirDomino(this.pioche2, dominoChoisi)] = this.ordreJoueurs[i];
			this.ordreJoueurs[i].placerDomino();
		}
		
		this.ordreJoueurs = dominoChoisi;
	}
	
	
	public ArrayList<Domino> piocher(){
		ArrayList<Domino> pioche = new ArrayList<Domino>();
		for(int i = 0; i < this.nbDomino; i++) {
			int randomIndex = (int)((Math.random() * this.listDominos.size()));
			pioche.add(this.listDominos.get(randomIndex));
			this.listDominos.remove(randomIndex);
		}	
		Collections.sort(pioche);
		
		return pioche;
	}
}


