package DominAtions;

public class Joueur {
	
	int score;
	String name;
	Royaume royaume;
	Couleur couleur;
	int[] rois;

	public Joueur(String name, int nbRoi, int col) {
		this.score = 0;
		this.name = name;
		this.royaume = new Royaume();
		this.rois = new int[nbRoi];
		this.couleur = Couleur.values()[col];
	}
}
