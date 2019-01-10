package DominAtions;

public class Royaume {
	
	int X = 9;
	int Y = 9;
	Terrain[][] terrain;
	
	public Royaume() {
		this.terrain = new Terrain[X][Y];
		this.initRoyaume();
	}
	
	public void initRoyaume() {
		for(int x = 0; x < this.terrain.length; x++) {
			for(int y = 0; y < this.terrain[x].length; y++) {
				this.terrain[x][y] = new Terrain();
			}
		}
		this.terrain[4][4].setType("Chateau");
	}
	
	public void printRoyaume() {
		for(int x = 0; x < this.terrain.length; x++) {
			System.out.print("|");
			for(int y = 0; y < this.terrain[x].length; y++) {
				this.terrain[x][y].print();
				System.out.print("|");
			}
			System.out.println("");
		}
	}
}
