package DominAtions;

import java.awt.Color;
import java.awt.Graphics;

public class Terrain {

	Type type;
	int nbCouronne = 0;
	
	public Terrain(String type) {
		
		this.type = this.getType(type);
	}
	
	public Terrain(String type, int nC) {
		
		this.type = this.getType(type);
		this.nbCouronne = nC;
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
	
	public void draw(Graphics g, int x, int y) {
		if(this.type == Type.Champs) {
			g.setColor(Color.decode("#EDFE01"));
		} else if (this.type == Type.Foret) {
			g.setColor(Color.decode("#005E13"));
		} else if (this.type == Type.Chateau) {
			g.setColor(Color.decode("#010101"));
		}else if (this.type == Type.Mer) {
			g.setColor(Color.decode("#010C9D"));
		} else if (this.type == Type.Mine) {
			g.setColor(Color.decode("#494842"));
		} else if (this.type == Type.Montagne) {
			g.setColor(Color.decode("#796902"));
		} else if (this.type == Type.Prairie) {
			g.setColor(Color.decode("#01FE55"));
		} else { // Type.VIDE
			g.setColor(Color.decode("#D2D2D2"));
		}
		
		g.fillRect(x, y, 50, 50);
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
