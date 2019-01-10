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
		this.terrain[5][5].setType("Chateau");
	}
}
