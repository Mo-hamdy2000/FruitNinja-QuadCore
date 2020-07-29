package Models;

public class SliceAllDecorator extends FruitDecorator {

	public SliceAllDecorator(GameObject specialFruit) {
		super(specialFruit);
	}

	public void slice() {
		specialFruit.slice();
		Game.getInstance().getGameLogic().sliceObjects();
	}
}
