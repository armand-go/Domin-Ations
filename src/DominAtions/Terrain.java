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
	
	public void print() {
		Type type = this.getType();
		if(type == Type.Mine) {
			System.out.print("Mi");
		} else if (type == Type.Montagne) {
			System.out.print("Mo");
		} else if (type == Type.Chateau){
			System.out.print("^^");
		} else {
			System.out.print(type.toString().substring(0, 1));
		} 
	}
}
