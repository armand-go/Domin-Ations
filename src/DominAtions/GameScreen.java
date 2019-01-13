package DominAtions;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JPanel;

public class GameScreen extends JPanel {
	
	Tour turn;
	
	public GameScreen(Tour t) {
		super();
		this.turn = t;
	}
	
	public void paintComponent(Graphics g){
		this.setBackground(Color.decode("#ADCCDB"));
		
		//Texts
		if(this.turn.boolTextPioche) {
			this.textPioche(g);
		} if(this.turn.boolTextJeu) {
			this.textJeu(g);
		}
		
		
		if(this.turn.boolPioche) {
			g.setColor(Color.BLACK);
			this.piocher(g, 30, 30, this.turn.pioche);
		} if(this.turn.boolPioche2) {
			this.piocher(g, 150, 30, this.turn.pioche2);
		} if(this.turn.boolRois) {
			this.rois(g, 75, this.turn.dominoChoisi);
		} if(this.turn.boolRois2) {
			this.rois(g, 150, this.turn.dominoChoisi2);
		} if(this.turn.play) {
			this.royaume(g);
		} if(this.turn.dominoDrag != null) {
			this.dominosDrag(g);
		} if(this.turn.boolListDom) {
			this.dominos(g);
		}
	}  
	
	public void dominosDrag(Graphics g) {
		Point p = MouseInfo.getPointerInfo().getLocation();
		int x = p.x;
		int y = p.y;
		
		this.turn.dominoDrag.paintDrag(g, x - 90, y - 180);
	}
	
	public void dominos(Graphics g) {
		ArrayList<Domino> dom = this.turn.playerTurn.dominos;
		for(int i = 0; i < dom.size(); i++) {
			dom.get(i).paintShow(g, 150, 350 + 60 * i);
		}
	}
	
	public void textPioche(Graphics g) {
		g.drawString(this.turn.playerTurn.name + ", c'est à vous de piocher", 30, 20);
	}
	
	public void textJeu(Graphics g) {
		g.drawString(this.turn.playerTurn.name + ", c'est votre tour", 150, 20);
	}
	
	public void royaume(Graphics g) {
		int X = 280;
		for(int i = 0; i < this.turn.joueurs.length; i++) {
			int Y = 30;
			
			Royaume royaume = this.turn.joueurs[i].royaume;
			
			for(int x = 0; x < royaume.terrain.length; x++) {
				for(int y = 0; y < royaume.terrain[x].length;y++) {
					royaume.terrain[x][y].draw(g, X + 50*x, Y + 50*y);
				}
			}
			g.setColor(Color.BLACK);
			g.drawString("Royaume de " + this.turn.joueurs[i].name, X + 10, Y + 450 + 15);
			
			X+=460;
		}
	}
	
	public void rois(Graphics g, int x, Joueur[] dom) {
		for(int i = 0; i < dom.length; i++) {
			if(dom[i] != null) {
				g.setColor(dom[i].getCouleur().getC());
				g.fillOval(x, 55 + 60 * i, 10, 10);
				g.fillRect(x+2, 60 + 60 * i, 7, 10);
			}
		}
	}
	
	
	public void paintPioche() {
		this.turn.boolPioche = true;
		this.turn.boolTextPioche = true;
		this.repaint();
	}
	
	public void piocher(Graphics g, int x, int y, ArrayList<Domino> pioche) {
		/*Timer timer = new Timer();
		timer.schedule( new TimerTask() {
			
			int i = 0;
			
			@Override
		    public void run() {
				if(this.i < pioche.size()) {
		    			pioche.get(this.i).print();
		    			pioche.get(this.i).paintHide(g, 30, 30 + 60 * this.i);
		    			this.i++;
				} else {
					this.cancel();
				}
		    }
		}, 1000, 1000);
		
		timer.schedule( new TimerTask() {
			int i = 0;
			
			@Override
		    public void run() {
				if(this.i < pioche.size()) {
		    			pioche.get(this.i).print();
		    			pioche.get(i).paintShow(g, 30, 30 + 60 * this.i);
		    			this.i++;
				} else {
					this.cancel();
				}
		    }
		}, 2000, 3000);*/
		
		for(int i = 0; i < pioche.size(); i++) {
			pioche.get(i).paintHide(g, x, y + 60 * i);
		}
		for(int i = 0; i < pioche.size(); i++) {
			pioche.get(i).paintShow(g, x, y + 60 * i);
		}
	}
}