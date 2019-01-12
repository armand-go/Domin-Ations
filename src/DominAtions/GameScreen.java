package DominAtions;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
		
		if(this.turn.boolPioche) {
			this.piocher(g);
		}
		if(this.turn.boolRois) {
			this.rois(g);
		}
	}  
	
	public void choisirDomino() {
		
	}
	
	public void rois(Graphics g) {
		for(int i = 0; i < turn.dominoChoisi.length; i++) {
			if(turn.dominoChoisi[i] != null) {
				g.setColor(turn.dominoChoisi[i].getCouleur().getC());
				g.fillOval(75, 55 + 60 * i, 10, 10);
				g.fillRect(77, 60 + 60 * i, 7, 10);
			}
		}
	}
	
	public void jouer(Graphics g) {
		
	}
	
	public void paintPioche() {
		this.turn.boolPioche = true;
		this.repaint();
	}
	
	public synchronized void piocher(Graphics g) {
		ArrayList<Domino> pioche = this.turn.pioche;
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