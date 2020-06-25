package Models;

import Models.Interfaces.GameActions;
import Models.Interfaces.GameObject;

public class GameLogic implements GameActions {

	private GameLogic instance;
	private GameProperties gameProperties;

	private GameLogic() {
		if (instance != null)
			throw new RuntimeException("use getInstance method");
	}

	public GameLogic getInstance() {
		if (instance == null) {
			synchronized (GameLogic.class) {
				if (instance == null) {
					instance = new GameLogic();
					gameProperties = new GameProperties();

				}

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