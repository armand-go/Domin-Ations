package DominAtions;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

public class GameScreen extends JPanel {
	
	Tour turn;
	Graphics g;
	
	public GameScreen(Tour t) {
		super();
		this.turn = t;
	}
	
	public void paintComponent(Graphics g){
		this.setBackground(Color.decode("#ADCCDB"));
		
		if(this.turn.boolPioche) {
			this.piocher(g, this.turn.pioche);
		}
		if(this.turn.boolRois) {
			this.rois(g, this.turn.dominoChoisi);
		}
	}  
	
	public void rois(Graphics g, Joueur[] dominoChoisi) {
		for(int i = 0; i < dominoChoisi.length; i++) {
			if(dominoChoisi[i] != null) {
				g.setColor(dominoChoisi[i].getCouleur().getC());
				g.fillOval(80, 55 + 60 * i, 10, 10);
				g.fillRect(80, 55, 3, 10);
			}
		}
	}
	
	public void jouer(Graphics g) {
		
	}
	
	public void piocher(Graphics g, ArrayList<Domino> pioche) {
		
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
			pioche.get(i).paintHide(g, 30, 30 + 60 * i);
		}
		for(int i = 0; i < pioche.size(); i++) {
			pioche.get(i).paintShow(g, 30, 30 + 60 * i);
		}
	}
	
}