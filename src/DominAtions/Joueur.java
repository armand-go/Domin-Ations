package DominAtions;

public class Joueur {
	
	int score;
	String name;
	Royaume royaume;
	String couleur;
	int[] rois;

	public Joueur(String name, int nbRoi) {
		this.score = 0;
		this.name = name;
		this.royaume = new Royaume();
		this.rois = new int[nbRoi];
	}
}
