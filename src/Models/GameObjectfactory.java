package Models;

import Models.Interfaces.GameObject;

public abstract class GameObjectfactory {
	
	public abstract GameObject createObject(GameObjects object);

	public GameObjectfactory create(String object) {
		if (object.equalsIgnoreCase("Fruit"))
			return new FruitFactory();
		else if (object.equalsIgnoreCase("Bomb"))
			return new BombFactory();
		return null;
	}
}
