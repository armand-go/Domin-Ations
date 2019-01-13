package DominAtions;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Menu {

	int nbrJoueur;
	JFrame fenetre;
	
	public Menu() {
		//this.nbrJoueur = this.choixNbJoueur();
	}
	
	public void setNbrJoueur(int n) {
		this.nbrJoueur = n;
	}
	
	public void show() {
	    this.fenetre = new JFrame();
	    this.fenetre.setTitle("Domi'Nations");
	    this.fenetre.setSize(400, 100);
	    this.fenetre.setLocationRelativeTo(null);
	    this.fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	    
	    this.fenetre.setLayout(new GridBagLayout());
	    GridBagConstraints c = new GridBagConstraints();
	    
	    c.gridx = 1;
	    c.gridy = 0;
	    this.fenetre.add(new JLabel("Domi'Nations"), c);
	    
		JButton button2, button3, button4;
		button2 = new JButton("2 Joueurs");
		button3 = new JButton("3 Joueurs");
		button4 = new JButton("4 Joueurs");
	    c.ipadx = -2;
	    c.ipady = -2;
	    c.gridx = 0;
	    c.gridy = 1;
	    this.fenetre.add(button2, c);
	    c.gridx = 1;
	    c.gridy = 1;
	    this.fenetre.add(button3, c);
	    c.gridx = 2;
	    c.gridy = 1;
	    this.fenetre.add(button4, c);	 
	    
	    button2.addActionListener(new buttonChoix(this, 2));
	    button3.addActionListener(new buttonChoix(this, 3));
	    button4.addActionListener(new buttonChoix(this, 4));
	    
	    this.fenetre.setVisible(true);    
	}
	
	class buttonChoix implements ActionListener {
	
		Menu menu;
		int nbr;
		
		public buttonChoix(Menu menu, int nbr) {
			super();
			this.menu = menu;
			this.nbr = nbr;
		}
		
		public void actionPerformed(ActionEvent e) {
			this.menu.setNbrJoueur(this.nbr);
			//System.out.println(this.menu.nbrJoueur);
			
			Game partie = new Game(this.menu.nbrJoueur, this.menu.fenetre);
			partie.initFrame();
		}
	}

	/*public int choixNbJoueur() {
		System.out.println("DOMINATION");
		System.out.println("Vous pouvez jouer à 2, 3 ou 4 joueurs\n\n");
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez choisir le nombre de Joueur :");
		int nbr = sc.nextInt();
		
		while(nbr != 2 && nbr !=3 && nbr != 4) {
			System.out.println("Vous ne pouvez jouer qu'à 2, 3 ou 4 Joueurs !\n");
			
			System.out.println("Veuillez choisir le nombre de Joueur :");
			nbr = sc.nextInt();
		}
		
		System.out.println("C'est parti pour un mode " + nbr + " Joueurs");
		
		return nbr;
	}*/
}
