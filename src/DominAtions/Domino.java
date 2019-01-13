package DominAtions;

import java.awt.Color;
import java.awt.Graphics;

public class Domino implements Comparable<Domino> {
	
	int nbCouronnes1;
	int nbCouronnes2;
	Terrain terrain1;
	Terrain terrain2;
	int numero;
	
	Orientation sens;
	
	public Domino(Terrain[] terrains, int[] couronnes, int numero) {
		
		this.nbCouronnes1 = couronnes[0];
		this.nbCouronnes2 = couronnes[1];
		this.terrain1 = terrains[0];
		this.terrain2 = terrains[1];
		this.numero = numero;
		
		this.sens = Orientation.RIGHT;
		
	}
	
	public void print() {
		System.out.println(this.numero + ":" + this.nbCouronnes1 + "|" + this.terrain1.type + "|" + this.nbCouronnes2 + "|" + this.terrain2.type);
	}
	
	public void paintHide(Graphics g, int x, int y){
		g.setColor(Color.decode("#8A5904")); 
		g.fillRoundRect(x, y, 100, 50, 10, 10);
		g.setColor(Color.BLACK); 
		g.drawString(Integer.toString(this.getNum()), x+45, y+30);
	}
	
	public void paintShow(Graphics g, int x, int y) {
		this.terrain1.draw(g, x, y);
		this.terrain2.draw(g, x+50, y);
		g.setColor(Color.YELLOW);
		for(int i = 0; i < this.nbCouronnes1; i++) {g.fillOval(x+15*(i+1), y+5, 8, 8);}
		for(int j = 0; j < this.nbCouronnes2; j++) {g.fillOval(x + 100 - 15*(j+1), y+5, 8, 8);}
		g.setColor(Color.BLACK);
		g.drawString(Integer.toString(this.nbCouronnes1), x+20, y+25);
		g.drawString(Integer.toString(this.nbCouronnes2), x+100-25, y+25);
	}
	
	public void paintDrag(Graphics g, int x, int y) {
		if(this.sens == Orientation.RIGHT) {
			this.terrain1.draw(g, x, y);
			this.terrain2.draw(g, x+50, y);
			g.setColor(Color.YELLOW);
			for(int i = 0; i < this.nbCouronnes1; i++) {g.fillOval(x+15*(i+1), y+5, 8, 8);}
			for(int j = 0; j < this.nbCouronnes2; j++) {g.fillOval(x + 100 - 15*(j+1), y+5, 8, 8);}
			g.setColor(Color.BLACK);
			g.drawString(Integer.toString(this.nbCouronnes1), x+20, y+25);
			g.drawString(Integer.toString(this.nbCouronnes2), x+100-25, y+25);
		} else if (this.sens == Orientation.BOTTOM) {
			this.terrain1.draw(g, x, y);
			this.terrain2.draw(g, x, y+50);
			g.setColor(Color.YELLOW);
			for(int i = 0; i < this.nbCouronnes1; i++) {g.fillOval(x+15*(i+1), y+5, 8, 8);}
			for(int j = 0; j < this.nbCouronnes2; j++) {g.fillOval(x+15*(j+1), y+85, 8, 8);}
			g.setColor(Color.BLACK);
			g.drawString(Integer.toString(this.nbCouronnes1), x+20, y+25);
			g.drawString(Integer.toString(this.nbCouronnes2), x+20, y+100-25);
		} else if (this.sens == Orientation.LEFT) {
			this.terrain1.draw(g, x, y);
			this.terrain2.draw(g, x-50, y);
			g.setColor(Color.YELLOW);
			for(int i = 0; i < this.nbCouronnes1; i++) {g.fillOval(x+15*(i+1), y+5, 8, 8);}
			for(int j = 0; j < this.nbCouronnes2; j++) {g.fillOval(x - 50 + 15*(j+1), y+5, 8, 8);}
			g.setColor(Color.BLACK);
			g.drawString(Integer.toString(this.nbCouronnes1), x+20, y+25);
			g.drawString(Integer.toString(this.nbCouronnes2), x-50+25, y+25);
		} else if (this.sens == Orientation.TOP) {
			this.terrain1.draw(g, x, y);
			this.terrain2.draw(g, x, y-50);
			g.setColor(Color.YELLOW);
			for(int i = 0; i < this.nbCouronnes1; i++) {g.fillOval(x+15*(i+1), y+5, 8, 8);}
			for(int j = 0; j < this.nbCouronnes2; j++) {g.fillOval(x+15*(j+1), y-45, 8, 8);}
			g.setColor(Color.BLACK);
			g.drawString(Integer.toString(this.nbCouronnes1), x+20, y+25);
			g.drawString(Integer.toString(this.nbCouronnes2), x+20, y-25);
		}
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
