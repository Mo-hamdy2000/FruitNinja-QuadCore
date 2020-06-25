package Models;

import Models.Interfaces.GameObject;

public class BombFactory extends GameObjectfactory {
	@Override
	public GameObject createObject(GameObjects bomb) {
		
		switch (bomb) {
		case DangerousBomb:
			return new DangerousBomb();
		case FatalBomb:
			return new FatalBomb();
		default:
			return null;
		}	
	}
}
