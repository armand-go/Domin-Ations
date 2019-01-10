package DominAtions;

import java.awt.Color;

public enum Couleur {
	VERT ("#06B929"),
	BLEU ("#10AAF7"),
	ROSE ("#FB52DA"),
	JAUNE ("#F9FE66");
	
	private Color c;

	Couleur(String c){
		this.setC(Color.decode(c));
	}

	public Color getC() {
		return c;
	}

	public void setC(Color c) {
		this.c = c;
	}
}
