package DominAtions;

import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFrame;

public class Tour {

	int nbDomino;
	Joueur[] joueurs;
	ArrayList<Domino> listDominos;
	
	Joueur[] ordreJoueurs;
	Joueur[] dominoChoisi;
	ArrayList<Domino> pioche;
	ArrayList<Domino> pioche2;
	
	JFrame fenetre;
	GameScreen screen;
	Game game;
	
	
	//Booléens pour la partie graphique
	boolean boolPioche;
	boolean boolPioche2;
	boolean boolRois;
	
	public Tour(int nbD, Joueur[] j, ArrayList<Domino> dominos, JFrame fen, Game g) {
		
		this.nbDomino = nbD;
		this.joueurs = j;
		this.listDominos = dominos;
		this.ordreJoueurs = new Joueur[nbD];
		this.ordreJoueurs = this.firstOrder();
		this.pioche = this.piocher();
		this.pioche2 = this.piocher();
		this.fenetre = fen;
		this.game = g;
		
		this.initFrame();
	}
	
	public void initFrame() {
		this.fenetre.getContentPane().removeAll();
		this.fenetre.repaint();
		
		this.fenetre.setSize(800, 600); 
		//this.fenetre.setResizable(false);
		this.fenetre.setLayout(new GridBagLayout());
		
		this.screen = new GameScreen(this);
		
		this.fenetre.setContentPane(this.screen);
		this.fenetre.setVisible(true);
		
		this.screen.paintPioche();
	}
	
	public Joueur[] firstOrder() {
		ArrayList<Joueur> ordre = new ArrayList<Joueur>();
		for(Joueur j : this.joueurs) {
			for(int i = 0; i < j.getNbRois(); i++) {
				ordre.add(j);
			}
		}
		
		Collections.shuffle(ordre);

		Joueur[] ordreArray = new Joueur[ordre.size()];
		ordreArray = ordre.toArray(ordreArray);
		return ordreArray;
	}
	
	public class ClicPioche implements MouseListener{
		Tour turn;
		
		int i;
		
		public ClicPioche(Tour t, int indexJoueur) {
			this.turn = t;
			this.i = indexJoueur;
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			Joueur j = this.turn.ordreJoueurs[this.i];
			
			if(30 < e.getX() && 130 > e.getX() && 30 < e.getY() && 80 > e.getY() && this.turn.dominoChoisi[0] == null) {
				System.out.println(j.name + ", vous avez selectionné le domino 1");
				j.dominos.add(this.turn.pioche.get(0));
				this.turn.boolRois = true;
				this.turn.dominoChoisi[0] = j;
				this.turn.screen.repaint();
				
				if(this.i < this.turn.ordreJoueurs.length - 1) {
					j = this.turn.ordreJoueurs[this.i++];
				}  else {
					this.turn.secondPiocheFirstTurn(this);
				}
				
			} else if (30 < e.getX() && 130 > e.getX() && 90 < e.getY() && 130 > e.getY() && this.turn.dominoChoisi[1] == null){
				System.out.println(j.name + ", vous avez selectionné le domino 2");
				j.dominos.add(this.turn.pioche.get(1));
				this.turn.boolRois = true;
				this.turn.dominoChoisi[1] = j;
				this.turn.screen.repaint();
				
				if(this.i < this.turn.ordreJoueurs.length - 1) {
					j = this.turn.ordreJoueurs[this.i++];
				}  else {
					this.turn.secondPiocheFirstTurn(this);
				}
				
			} else if (30 < e.getX() && 130 > e.getX() && 150 < e.getY() && 180 > e.getY() && this.turn.dominoChoisi[2] == null){
				System.out.println(j.name + ", vous avez selectionné le domino 3");
				j.dominos.add(this.turn.pioche.get(2));
				this.turn.boolRois = true;
				this.turn.dominoChoisi[2] = j;
				this.turn.screen.repaint();
				
				if(this.i < this.turn.ordreJoueurs.length - 1) {
					j = this.turn.ordreJoueurs[this.i++];
				}  else {
					this.turn.secondPiocheFirstTurn(this);
				}
				
			} if(this.turn.pioche.size() == 4) {
				if (30 < e.getX() && 130 > e.getX() && 210 < e.getY() && 230 > e.getY() && this.turn.dominoChoisi[3] == null){
					System.out.println(j.name + ", vous avez selectionné le domino 4");
					j.dominos.add(this.turn.pioche.get(3));
					this.turn.boolRois = true;
					this.turn.dominoChoisi[3] = j;
					this.turn.screen.repaint();
					
					if(this.i < this.turn.ordreJoueurs.length - 1) {
						j = this.turn.ordreJoueurs[this.i++];
					} else {
						this.turn.secondPiocheFirstTurn(this);
					}
				}
			}
		}
		@Override
		public void mousePressed(MouseEvent e) {}
		@Override
		public void mouseReleased(MouseEvent e) {}
		@Override
		public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseExited(MouseEvent e) {}
	}
	
	public void firstTurn() {
		this.dominoChoisi = new Joueur[this.pioche.size()];
		for(int i = 0; i < dominoChoisi.length; i++) {
			this.dominoChoisi[i] = null;
		}
		
		ClicPioche clic = new ClicPioche(this, 0);
		this.screen.addMouseListener(clic);
	}
	
	public void secondPiocheFirstTurn(ClicPioche clic){
		this.screen.removeMouseListener(clic);
		
	}
	
	public void newTurn() {
		Joueur[] dominoChoisi = new Joueur[this.pioche2.size()];
		for(int i = 0; i < dominoChoisi.length; i++) {
			dominoChoisi[i] = null;
		}
		
		for(int i = 0; i < this.ordreJoueurs.length; i++) {
			//dominoChoisi[this.ordreJoueurs[i].choisirFirstDomino(this.pioche2, dominoChoisi, this)] = this.ordreJoueurs[i];
			this.ordreJoueurs[i].placerDomino();
		}
		
		this.ordreJoueurs = dominoChoisi;
	}
	
	public ArrayList<Domino> piocher(){
		ArrayList<Domino> pioche = new ArrayList<Domino>();
		for(int i = 0; i < this.nbDomino; i++) {
			int randomIndex = (int)((Math.random() * this.listDominos.size()));
			pioche.add(this.listDominos.get(randomIndex));
			this.listDominos.remove(randomIndex);
		}	
		Collections.sort(pioche);
		
		return pioche;
	}
}


