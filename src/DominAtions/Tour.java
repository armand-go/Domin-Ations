package DominAtions;

import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Arrays;
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
	Joueur[] dominoChoisi2;
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
	boolean boolRois2;
	
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
		this.fenetre.setResizable(false);
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
	
	public class ClicChoixDominoJoueur extends MouseInputAdapter {
		Tour t;
		Domino selectedDomino = null;
		int i = 0;
		
		public ClicChoixDominoJoueur(Tour t) {
			this.t = t;
			this.selectedDomino = this.t.playerTurn.dominos.get(0);
			this.t.dominoDrag = this.t.playerTurn.dominos.get(0);
			OrientationListen arrow = new OrientationListen(this.t, this.selectedDomino);
			this.t.fenetre.addKeyListener(arrow);
		}
		@Override
		public void mousePressed(MouseEvent e) {
			/*if(e.getX() > 150 && e.getX() < 250 && e.getY() > 350 && e.getY() < 400) {
				this.selectedDomino = this.t.playerTurn.dominos.get(0);
				this.t.dominoDrag = this.t.playerTurn.dominos.get(0);
				OrientationListen arrow = new OrientationListen(this.t, this.t.playerTurn.dominos.get(0));
				this.t.fenetre.addKeyListener(arrow);
				this.t.screen.repaint();
			}
			if(this.t.playerTurn.dominos.size() == 2) {
				if(e.getX() > 150 && e.getX() < 250 && e.getY() > 410 && e.getY() < 450) {
					this.selectedDomino = this.t.playerTurn.dominos.get(1);
					this.t.dominoDrag = this.t.playerTurn.dominos.get(1);
					OrientationListen arrow = new OrientationListen(this.t, this.selectedDomino);
					this.t.fenetre.addKeyListener(arrow);
					this.t.screen.repaint();
				}
			}*/
			
			
			if(this.selectedDomino != null) {
				int Xbegin = (this.t.playerTurn.numero *(450 + 10));
				
				if(e.getX() > 280 + Xbegin && e.getX() < 730 + Xbegin && e.getY() > 30 && e.getY() < 480) {
					int x = (e.getX()-280-Xbegin)/50;
					int y = (e.getY() - 30)/50;
					//System.out.println(x + "," + y);
					boolean placer = false;
					if(this.selectedDomino.sens == Orientation.RIGHT) {
						placer = this.t.playerTurn.royaume.placerDominoDroite(this.selectedDomino, x, y);
					} else if (this.selectedDomino.sens == Orientation.LEFT) {
						placer = this.t.playerTurn.royaume.placerDominoGauche(this.selectedDomino, x, y);
					} else if (this.selectedDomino.sens == Orientation.TOP) {
						placer = this.t.playerTurn.royaume.placerDominoTop(this.selectedDomino, x, y);
					} else if (this.selectedDomino.sens == Orientation.BOTTOM) {
						placer = this.t.playerTurn.royaume.placerDominoBottom(this.selectedDomino, x, y);
					} 
					
					if(placer) {
						this.t.playerTurn.dominos.remove(this.selectedDomino);
						this.selectedDomino = null;
						this.t.dominoDrag = null;
						this.t.screen.repaint();
						this.t.choisirDomino(this.t.playerTurn, this, this.i);
					}
					
				}
			}
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {}

		@Override
		public void mouseMoved(MouseEvent e) {
			if(selectedDomino != null) {
				this.t.screen.repaint();
			}
		}
	}
	
	public class OrientationListen implements KeyListener {

		Tour turn;
		Domino domino;
		
		public OrientationListen(Tour t, Domino d) {
			this.turn = t;
			this.domino = d;
		}
		
		@Override
		public void keyTyped(KeyEvent e) {
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
	        if (key == KeyEvent.VK_RIGHT) {
	        		this.domino.sens = Orientation.RIGHT;
	        		this.turn.screen.repaint();
	        } else if (key == KeyEvent.VK_UP) {
	        		this.domino.sens = Orientation.TOP;
	        		this.turn.screen.repaint();
	        } else if (key == KeyEvent.VK_DOWN) {
        			this.domino.sens = Orientation.BOTTOM;
        			this.turn.screen.repaint();
	        } else if (key == KeyEvent.VK_LEFT) {
        			this.domino.sens = Orientation.LEFT;
        			this.turn.screen.repaint();
	        }
		}
		@Override
		public void keyReleased(KeyEvent e) {}
		
	}
	
	public void choisirDomino(Joueur joueur, ClicChoixDominoJoueur clic, int index) {
		this.screen.removeMouseListener(clic);
		this.boolTextPioche = true;
		this.boolTextJeu = false;
		this.screen.repaint();
		ClicPioche1 clac = new ClicPioche1(this, joueur, index);
		this.screen.addMouseListener(clac);
	}
	
	public class ClicPioche1 implements MouseListener{
		Tour turn;
		Joueur joueur;
		int indexJoueur;
		
		public ClicPioche1(Tour t, Joueur joueur, int indexJoueur) {
			this.turn = t;
			this.joueur = joueur;
			this.indexJoueur = indexJoueur;

		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			if(150 < e.getX() && 150+100 > e.getX() && 30 < e.getY() && 80 > e.getY() && this.turn.dominoChoisi2[0] == null) {
				//System.out.println(j.name + ", vous avez selectionné le domino 1");
				this.turn.playerTurn.dominos.add(turn.playerTurn.dominos.size(), this.turn.pioche2.get(0));;
				this.turn.boolRois2 = true;
				this.turn.dominoChoisi[indexJoueur] = null;
				this.turn.dominoChoisi2[0] = this.turn.playerTurn;
				this.turn.screen.repaint();
				
				if(this.indexJoueur < this.turn.ordreJoueurs.length - 1) {
					this.indexJoueur++;
					this.turn.playerTurn = this.turn.ordreJoueurs[this.indexJoueur];
					this.turn.boolTextPioche = false;
					this.turn.boolTextJeu = true;
					this.turn.screen.repaint();
					ClicChoixDominoJoueur clic = new ClicChoixDominoJoueur(this.turn);
					this.turn.screen.addMouseListener(clic);
					this.turn.screen.addMouseMotionListener(clic);
				}  else {
					this.turn.pioche = this.turn.pioche2;
					this.turn.pioche2 = this.turn.piocher();
					this.turn.boolRois2 = false;
					this.turn.ordreJoueurs = this.turn.dominoChoisi2;
					this.turn.dominoChoisi = this.turn.ordreJoueurs;
					this.turn.playerTurn = this.turn.ordreJoueurs[0];
					
					this.turn.screen.repaint();
					
					this.turn.remove(this, this.turn.dominoChoisi2);
				}
				
			} else if (150 < e.getX() && 150+100 > e.getX() && 90 < e.getY() && 140 > e.getY() && this.turn.dominoChoisi2[1] == null){
				//System.out.println(j.name + ", vous avez selectionné le domino 2");
				this.turn.playerTurn.dominos.add(turn.playerTurn.dominos.size(), this.turn.pioche2.get(1));;
				this.turn.boolRois2 = true;
				this.turn.dominoChoisi[indexJoueur] = null;
				this.turn.dominoChoisi2[1] = this.turn.playerTurn;
				this.turn.screen.repaint();
				
				if(this.indexJoueur < this.turn.ordreJoueurs.length - 1) {
					this.indexJoueur++;
					this.turn.playerTurn = this.turn.ordreJoueurs[this.indexJoueur];
					this.turn.boolTextPioche = false;
					this.turn.boolTextJeu = true;
					ClicChoixDominoJoueur clic = new ClicChoixDominoJoueur(this.turn);
					this.turn.screen.addMouseListener(clic);
					this.turn.screen.addMouseMotionListener(clic);
				}  else {
					this.turn.pioche = this.turn.pioche2;
					this.turn.pioche2 = this.turn.piocher();
					this.turn.boolRois2 = false;
					this.turn.ordreJoueurs = this.turn.dominoChoisi2;
					this.turn.dominoChoisi = this.turn.ordreJoueurs;
					this.turn.playerTurn = this.turn.ordreJoueurs[0];
					
					
					this.turn.screen.repaint();
					
					this.turn.remove(this, this.turn.dominoChoisi2);
				}
				
			} else if (150 < e.getX() && 150+100 > e.getX() && 150 < e.getY() && 200 > e.getY() && this.turn.dominoChoisi2[2] == null){
				//System.out.println(j.name + ", vous avez selectionné le domino 3");
				this.turn.playerTurn.dominos.add(turn.playerTurn.dominos.size(), this.turn.pioche2.get(2));;
				this.turn.boolRois2 = true;
				this.turn.dominoChoisi[indexJoueur] = null;
				this.turn.dominoChoisi2[2] = this.turn.playerTurn;
				this.turn.screen.repaint();
				
				if(this.indexJoueur < this.turn.ordreJoueurs.length - 1) {
					this.indexJoueur++;
					this.turn.playerTurn = this.turn.ordreJoueurs[this.indexJoueur];
					this.turn.boolTextPioche = false;
					this.turn.boolTextJeu = true;
					ClicChoixDominoJoueur clic = new ClicChoixDominoJoueur(this.turn);
					this.turn.screen.addMouseListener(clic);
					this.turn.screen.addMouseMotionListener(clic);
				}  else {
					this.turn.pioche = this.turn.pioche2;
					this.turn.pioche2 = this.turn.piocher();
					this.turn.boolRois2 = false;
					this.turn.ordreJoueurs = this.turn.dominoChoisi2;
					this.turn.dominoChoisi = this.turn.ordreJoueurs;
					this.turn.playerTurn = this.turn.ordreJoueurs[0];
					
					
					this.turn.screen.repaint();
					
					this.turn.remove(this, this.turn.dominoChoisi2);
				}
				
			} if(this.turn.pioche.size() == 4) {
				if (150 < e.getX() && 150+100 > e.getX() && 210 < e.getY() && 280 > e.getY() && this.turn.dominoChoisi2[3] == null){
					//System.out.println(j.name + ", vous avez selectionné le domino 4");
					this.turn.playerTurn.dominos.add(turn.playerTurn.dominos.size(), this.turn.pioche2.get(3));;
					this.turn.boolRois2 = true;
					this.turn.dominoChoisi[indexJoueur] = null;
					this.turn.dominoChoisi2[3] = this.turn.playerTurn;
					this.turn.screen.repaint();
					
					if(this.indexJoueur < this.turn.ordreJoueurs.length - 1) {
						this.indexJoueur++;
						this.turn.playerTurn = this.turn.ordreJoueurs[this.indexJoueur];
						this.turn.boolTextPioche = false;
						this.turn.boolTextJeu = true;
						ClicChoixDominoJoueur clic = new ClicChoixDominoJoueur(this.turn);
						this.turn.screen.addMouseListener(clic);
						this.turn.screen.addMouseMotionListener(clic);
					}  else {
						this.turn.pioche = this.turn.pioche2;
						this.turn.pioche2 = this.turn.piocher();
						this.turn.boolRois2 = false;
						
						this.turn.screen.repaint();
						
						this.turn.remove(this, this.turn.dominoChoisi2);
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
	
	public void remove(ClicPioche1 clic, Joueur[] dominoChoisi2) {
		this.screen.removeMouseListener(clic);
		this.boolTextPioche = false;
		
		System.out.println(dominoChoisi2[0].name);
		
		for(int i = 0; i < dominoChoisi2.length; i++) {
			Joueur e = dominoChoisi2[i];
			Joueur temp = new Joueur(e.name, e.getNbRois(), e.numero, e.royaume, e.dominos);
			this.ordreJoueurs[i] = temp;
			this.dominoChoisi[i] = temp;
			dominoChoisi2[i] = null;
		}
		
		this.playerTurn = this.ordreJoueurs[0];
		
		this.newTurn();
	}
	
	public void newTurn() {
		this.play = true;
		this.boolTextJeu = true;
		this.boolListDom = true;
		this.screen.repaint();
		
		this.dominoChoisi2 = new Joueur[this.pioche.size()];
		for(int i = 0; i < this.dominoChoisi2.length; i++) {
			this.dominoChoisi2[i] = null;
		}
		
		ClicChoixDominoJoueur clic = new ClicChoixDominoJoueur(this);
		this.screen.addMouseListener(clic);
		this.screen.addMouseMotionListener(clic);
		
		
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


