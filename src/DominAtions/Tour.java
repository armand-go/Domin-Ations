package DominAtions;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tour {

	int nbDomino;
	Joueur[] joueurs;
	ArrayList<Domino> listDominos;
	
	Joueur[] ordreJoueurs;
	Joueur[] dominoChoisi;
	ArrayList<Domino> pioche;
	ArrayList<Domino> pioche2;
	
	JFrame fenetre;
	GameScreen screen;
	
	
	//Booléens pour la partie graphique
	boolean boolPioche;
	boolean boolPioche2;
	boolean boolRois;
	
	public Tour(int nbD, Joueur[] j, ArrayList<Domino> dominos, JFrame fen) {
		
		this.nbDomino = nbD;
		this.joueurs = j;
		this.listDominos = dominos;
		this.ordreJoueurs = new Joueur[nbD];
		this.ordreJoueurs = this.firstOrder();
		this.pioche = this.piocher();
		this.pioche2 = this.piocher();
		this.fenetre = fen;
		
		this.initFrame();
		this.firstTurn();
	}
	
	public void initFrame() {
		this.fenetre.getContentPane().removeAll();
		this.fenetre.repaint();
		
		this.fenetre.setSize(800, 600); 
		//this.fenetre.setResizable(false);
		this.fenetre.setLayout(new GridBagLayout());
		
		this.screen = new GameScreen(this);
		
		this.fenetre.setContentPane(this.screen);
		this.fenetre.setVisible(true);
		
		
		this.boolPioche = true;
		this.screen.repaint();
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
		this.dominoChoisi = new Joueur[this.pioche.size()];
		for(int i = 0; i < dominoChoisi.length; i++) {
			this.dominoChoisi[i] = null;
		}
		
		for(int i = 0; i < this.ordreJoueurs.length; i++) {
			this.dominoChoisi[this.ordreJoueurs[i].choisirDomino(this.pioche, dominoChoisi, this.screen)] = this.ordreJoueurs[i];
			this.boolRois = true;
		}
		
		this.ordreJoueurs = this.dominoChoisi;
	}
	
	public void newTurn() {
		Joueur[] dominoChoisi = new Joueur[this.pioche2.size()];
		for(int i = 0; i < dominoChoisi.length; i++) {
			dominoChoisi[i] = null;
		}
		
		for(int i = 0; i < this.ordreJoueurs.length; i++) {
			dominoChoisi[this.ordreJoueurs[i].choisirDomino(this.pioche2, dominoChoisi, this.screen)] = this.ordreJoueurs[i];
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


