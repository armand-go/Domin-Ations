package DominAtions;

public class Terrain {

	Type type;
	
	public Terrain(String type) {
		
		this.type = this.getType(type);
	}
	
	public Type getType(String type) {
		
		for(Type tipe : Type.values()) {
			if(tipe.name().equals(type)) {
				return tipe;
			}
		}
		return Type.VIDE;
	}
	
	public Type getType() {
		return this.type;
	}
	
}
