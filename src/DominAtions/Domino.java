package DominAtions;

public class Domino implements Comparable<Domino> {
	
	int nbCouronnes1;
	int nbCouronnes2;
	Terrain terrain1;
	Terrain terrain2;
	int numero;
	
	
	public Domino(Terrain[] terrains, int[] couronnes, int numero) {
		
		this.nbCouronnes1 = couronnes[0];
		this.nbCouronnes2 = couronnes[1];
		this.terrain1 = terrains[0];
		this.terrain2 = terrains[1];
		this.numero = numero;
		
	}
	
	public void print() {
		System.out.println(this.numero + ":" + this.nbCouronnes1 + "|" + this.terrain1.type + "|" + this.nbCouronnes2 + "|" + this.terrain2.type);
	}
	
	public int getNum() {
		return this.numero;
	}

	@Override
	public int compareTo(Domino dom) {
		int compareNum = ((Domino) dom).getNum(); 
		return this.numero - compareNum;
	}

}
