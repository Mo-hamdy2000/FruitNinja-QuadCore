package Models;

public class FactoryProvider {

	public static GameObjectfactory create(String object) {
		if (object.equalsIgnoreCase("Fruit"))
			return new FruitFactory();
		else if (object.equalsIgnoreCase("Bomb"))
			return new BombFactory();
		return null;
	}
}
