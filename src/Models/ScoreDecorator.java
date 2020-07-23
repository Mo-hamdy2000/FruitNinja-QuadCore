package Models;

public class ScoreDecorator extends FruitDecorator {

	public ScoreDecorator(GameObject specialFruit) {
		super(specialFruit);
		
	}
	
	public void slice() {
		specialFruit.slice();
		GameLogic gameLogic =new GameLogic();
		gameLogic.getGameProperties().incrementScore(specialFruit.score);
		System.out.println(gameLogic.getGameProperties().getScore());
	}
}
