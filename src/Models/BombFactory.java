package Models;

import Models.Interfaces.GameObject;

public class BombFactory extends GameObjectfactory<Bombs>{
	@Override
	public GameObject createObject(Bombs bomb) {
		
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
