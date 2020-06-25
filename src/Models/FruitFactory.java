package Models;

import Models.Interfaces.GameObject;

public class FruitFactory extends GameObjectfactory{

	@Override
	public GameObject createObject(GameObjects fruit) {
		switch (fruit) {
		case Apple:
			return new Apple();
		case Banana:
			return new Banana();
		case Watermelon:
			return new Watermelon();
		case Orange:
			return new Orange();
		case Pineapple:
			return new Pineapple();
		default:
			return null;
		}
	}
}
