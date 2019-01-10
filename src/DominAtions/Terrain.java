package DominAtions;

public class Terrain {

	Type type;
	
	public Terrain(String type) {
		
		this.type = this.getType(type);
	}
	
	public Terrain() {
		this.type = Type.VIDE;
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
	
	public void setType(String str) {
		for(Type tipe : Type.values()) {
			if(tipe.name().equals(str)) {
				this.type = tipe;
			}
		}
	}
}
