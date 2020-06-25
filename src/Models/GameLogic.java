package Models;

import Models.Interfaces.GameActions;
import Models.Interfaces.GameObject;

public class GameLogic implements GameActions {

	private static GameLogic instance;
	private static GameProperties gameProperties;

	private GameLogic() {
		if (instance != null)
			throw new RuntimeException("use getInstance method");
	}

	public static GameLogic getInstance() {
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
	 
		GameObjectfactory factory;
		GameObject obj;
		int index=(int) MiscUtils.rand(0,7);
		GameObjects object=GameObjects.values()[index];
		if(index<5) {
			factory=new FruitFactory();
			obj=factory.createObject(object);
		}
		else {
			factory=new BombFactory();
			obj=factory.createObject(object);
		}
	//System.out.println(index);
		return obj;
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

