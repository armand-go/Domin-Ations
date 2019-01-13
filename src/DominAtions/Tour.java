package DominAtions;

import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFrame;
import javax.swing.event.MouseInputAdapter;

public class Tour {

	int nbDomino;
	Joueur[] joueurs;
	ArrayList<Domino> listDominos;
	
	Joueur playerTurn;
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
	boolean boolTextPioche;
	boolean boolRois;
	boolean play;
	boolean boolTextJeu;
	boolean boolListDom;
	
	Domino dominoDrag;
	
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
		
		this.fenetre.setSize(280, 400); 
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
		
		for(int i = 0; i < ordre.size();i++) {
			System.out.println(ordre.get(i).name);
		}
		
		Joueur[] ordreArray = new Joueur[ordre.size()];
		ordreArray = ordre.toArray(ordreArray);
		this.playerTurn = ordreArray[0];
		return ordreArray;
	}
	
	public class ClicPioche implements MouseListener{
		Tour turn;
		
		int i;
		int x;
		
		public ClicPioche(Tour t, int indexJoueur, int x) {
			this.turn = t;
			this.i = indexJoueur;
			this.x = x;
			
			this.turn.playerTurn = this.turn.ordreJoueurs[this.i];
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			
			if(x < e.getX() && x+100 > e.getX() && 30 < e.getY() && 80 > e.getY() && this.turn.dominoChoisi[0] == null) {
				//System.out.println(j.name + ", vous avez selectionné le domino 1");
				this.turn.playerTurn.dominos.add(this.turn.pioche.get(0));
				this.turn.boolRois = true;
				this.turn.dominoChoisi[0] = this.turn.playerTurn;
				this.turn.screen.repaint();
				
				if(this.i < this.turn.ordreJoueurs.length - 1) {
					this.i++;
					this.turn.playerTurn = this.turn.ordreJoueurs[this.i];
				}  else {
					this.turn.secondPiocheFirstTurn(this);
				}
				
			} else if (x < e.getX() && x+100 > e.getX() && 90 < e.getY() && 140 > e.getY() && this.turn.dominoChoisi[1] == null){
				//System.out.println(j.name + ", vous avez selectionné le domino 2");
				this.turn.playerTurn.dominos.add(this.turn.pioche.get(1));
				this.turn.boolRois = true;
				this.turn.dominoChoisi[1] = this.turn.playerTurn;
				this.turn.screen.repaint();
				
				if(this.i < this.turn.ordreJoueurs.length - 1) {
					this.i++;
					this.turn.playerTurn = this.turn.ordreJoueurs[this.i];
				}  else {
					this.turn.secondPiocheFirstTurn(this);
				}
				
			} else if (x < e.getX() && x+100 > e.getX() && 150 < e.getY() && 200 > e.getY() && this.turn.dominoChoisi[2] == null){
				//System.out.println(j.name + ", vous avez selectionné le domino 3");
				this.turn.playerTurn.dominos.add(this.turn.pioche.get(2));
				this.turn.boolRois = true;
				this.turn.dominoChoisi[2] = this.turn.playerTurn;
				this.turn.screen.repaint();
				
				if(this.i < this.turn.ordreJoueurs.length - 1) {
					this.i++;
					this.turn.playerTurn = this.turn.ordreJoueurs[this.i];
				}  else {
					this.turn.secondPiocheFirstTurn(this);
				}
				
			} if(this.turn.pioche.size() == 4) {
				if (x < e.getX() && x+100 > e.getX() && 210 < e.getY() && 280 > e.getY() && this.turn.dominoChoisi[3] == null){
					//System.out.println(j.name + ", vous avez selectionné le domino 4");
					this.turn.playerTurn.dominos.add(this.turn.pioche.get(3));
					this.turn.boolRois = true;
					this.turn.dominoChoisi[3] = this.turn.playerTurn;
					this.turn.screen.repaint();
					
					if(this.i < this.turn.ordreJoueurs.length - 1) {
						this.i++;
						this.turn.playerTurn = this.turn.ordreJoueurs[this.i];
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
		
		ClicPioche clic = new ClicPioche(this, 0, 30);
		this.screen.addMouseListener(clic);
	}
	
	public void secondPiocheFirstTurn(ClicPioche clic){
		this.screen.removeMouseListener(clic);
		this.boolTextPioche = false;
		this.boolTextJeu = true;
		this.fenetre.setSize(280 + this.joueurs.length * 480, 550);
	    this.fenetre.setLocationRelativeTo(null);
		this.ordreJoueurs = this.dominoChoisi;
		
		this.playerTurn = this.ordreJoueurs[0];
		this.boolPioche2 = true;
		this.newTurn();
	}
	
	
	public class ClicChoixDomino extends MouseInputAdapter {
		Tour t;
		Domino selectedDomino = null;
		
		public ClicChoixDomino(Tour t) {
			this.t = t;
		}
		@Override
		public void mousePressed(MouseEvent e) {
			if(e.getX() > 150 && e.getX() < 250 && e.getY() > 350 && e.getY() < 400) {
				System.out.println("Vous avez selectionner votre premier domino");
				this.selectedDomino = this.t.playerTurn.dominos.get(0);
				this.t.dominoDrag = this.t.playerTurn.dominos.get(0);
				this.t.screen.repaint();
			}
			if(this.t.playerTurn.dominos.size() == 2) {
				if(e.getX() > 150 && e.getX() < 250 && e.getY() > 410 && e.getY() < 450) {
					System.out.println("Vous avez selectionner votre deuxieme domino");
					this.selectedDomino = this.t.playerTurn.dominos.get(1);
					this.t.dominoDrag = this.t.playerTurn.dominos.get(1);
					this.t.screen.repaint();
				}
			}
			
			if(this.selectedDomino != null) {
				int Xbegin = (this.t.playerTurn.numero *(450 + 10));
				if(e.getX() > 280 + Xbegin && e.getX() < 730 + Xbegin && e.getY() > 30 && e.getY() < 480) {
					int x = (e.getX()-280-Xbegin)/50;
					int y = (e.getY() - 30)/50;
					
					boolean placer = this.t.playerTurn.royaume.placerDomino(this.selectedDomino, x, y);
					if(placer) {
						this.t.playerTurn.dominos.remove(this.selectedDomino);
						this.selectedDomino = null;
						this.t.dominoDrag = null;
						this.t.screen.repaint();
					}
					
				}
			}
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			if(selectedDomino != null) {
				this.t.screen.repaint();
			}
		}
	}
	
	public void newTurn() {
		this.play = true;
		this.boolListDom = true;
		this.screen.repaint();
		
		ClicChoixDomino clic = new ClicChoixDomino(this);
		this.screen.addMouseListener(clic);
		this.screen.addMouseMotionListener(clic);
		
		/*Joueur[] dominoChoisi = new Joueur[this.pioche2.size()];
		for(int i = 0; i < dominoChoisi.length; i++) {
			dominoChoisi[i] = null;
		}*/
		
		//ClicPioche2 clic = new ClicPioche2(this, 0, 150);
		//this.screen.addMouseListener(clic);
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


