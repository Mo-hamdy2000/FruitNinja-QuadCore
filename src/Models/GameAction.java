package Models;

import Models.Interfaces.GameActions;
import Models.Interfaces.GameObject;

public class GameAction implements GameActions {

	private GameAction instance;

	private GameAction() {
		if (instance != null)
			throw new RuntimeException("use getInstance method");
	}

	public GameAction getInstance() {
		if (instance == null) {
			synchronized (GameAction.class) {
				if (instance == null)
					instance = new GameAction();

			}
		} 
		return instance;
	}

	@Override
	public GameObject createGameObject() {

		return null;
	}

	@Override
	public void updateObjectsLocation() {

	}

	@Override
	public void sliceObjects() {

	}

	@Override
	public void saveGame() {

	}

	@Override
	public void loadGame() {

	}

	@Override
	public void resetGame() {

	}

}
