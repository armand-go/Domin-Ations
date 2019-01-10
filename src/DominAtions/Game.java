package DominAtions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Game {
	
	private int nbrJoueur;
	private Joueur joueurs[];
	private ArrayList<Domino> listDominos;

	public Game(int nbrJoueur) {
		this.nbrJoueur = nbrJoueur;
		this.joueurs = new Joueur[this.nbrJoueur];
		
		this.listDominos = this.readCsvDomino();
		
		this.initJoueurs();
	}
	
	public void begin() {
		int nbDom;
		if(this.nbrJoueur == 3) {
			nbDom = 3;
		} else {
			nbDom = 4;
		}

		Tour turn = new Tour(nbDom, this.joueurs, this.listDominos);
		while( (this.listDominos.size() != 0) ? true : false) {
			turn.newTurn();
		}

	}
	
	
	public void initJoueurs() {
		int nbRois;
		if(this.nbrJoueur == 2) {
			nbRois = 2;
		} else {
			nbRois = 1;
		}
		
		for(int i = 0; i < this.nbrJoueur; i++) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Joueur " + (i+1) + ", quel est votre nom ?");
			String name = sc.nextLine();
			
			this.joueurs[i] = new Joueur(name, nbRois, i);
		}
	}
	
	public void printDominosList() {
		for(int i = 0; i < this.listDominos.size(); i++) {
			this.listDominos.get(i).print();
		}
	}
	
	public ArrayList<Domino> choixDomino(ArrayList<Domino> allDominos) {
		int nbrRetire = 0;
		
		switch(this.nbrJoueur) {
			case 3:
				nbrRetire = 12;
				break;
			case 4:
				break;
			default:
				nbrRetire = 24;
				break;
		}
		
		for(int i = 0; i < nbrRetire; i++) {
			int randomIndex = (int)((Math.random() * allDominos.size()));
			allDominos.remove(randomIndex);
		}
		
		Collections.shuffle(allDominos);
		return allDominos;
	}
	
	public ArrayList<Domino> readCsvDomino(){
		
		ArrayList<Domino> allDominos = new ArrayList<Domino>();
		
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("dominos.csv"));
			
			String line = br.readLine(); // Pour sauter les headers
			
	        while((line = br.readLine()) != null && !line.isEmpty()){
	        		String[] info = line.split(",");
	        		Terrain[] terrains = new Terrain[2];
	        		terrains[0] = new Terrain(info[1]);
	        		terrains[1] = new Terrain(info[3]);
	        		int[] couronnes = new int[2];
	        		couronnes[0] = Integer.parseInt(info[0]);
	        		couronnes[1] = Integer.parseInt(info[2]);
	        		int numero = Integer.parseInt(info[4]);
	        		
	        		Domino dom = new Domino(terrains, couronnes, numero);
	        		allDominos.add(dom);
	        }
	        br.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	
		return choixDomino(allDominos);
	}
}
