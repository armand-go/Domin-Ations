package DominAtions;

public class DominAtions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Menu menu = new Menu();
		menu.show();
		Game partie = new Game(menu.nbrJoueur);
		partie.begin();
		//partie.endGame();
	}

}
