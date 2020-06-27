package Test;

import Models.GameLogic;

public class testSaving {

	public static void main(String[] args) {

		GameLogic game = GameLogic.getInstance();
		game.loadGame();
	}

}
