package DominAtions;

import java.util.ArrayList;
import java.util.Scanner;

public class Joueur {
	
	public int score;
	public String name;
	public Royaume royaume;
	public Couleur couleur;
	public boolean[] rois;
	public ArrayList<Domino> dominos;
	public int numero;
	public ArrayList<Terrain> listZone;
	public ArrayList<Terrain> listTer;
	
	public Joueur(String name, int nbRoi, int i) {
		this.score = 0;
		this.name = name;
		this.royaume = new Royaume();
		this.rois = new boolean[nbRoi];
		this.couleur = Couleur.values()[i];
		this.dominos = new ArrayList<Domino>();
		this.numero = i;
	}
	
	public Joueur(String name, int nbRoi, int i, Royaume royaume, ArrayList<Domino> dom) {
		this.score = 0;
		this.name = name;
		this.royaume = royaume;
		this.rois = new boolean[nbRoi];
		this.couleur = Couleur.values()[i];
		this.dominos = dom;
		this.numero = i;
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
