package Models;

public class ScoreDecorator extends FruitDecorator {

	public ScoreDecorator(GameObject specialFruit) {
		super(specialFruit);
		
	}
	
	public void slice() {
		specialFruit.slice();
		Game.getInstance().incrementScore(specialFruit.score * 5);
		Game.getInstance().changeScoreLabel(Game.getInstance().getScore()+"");
	}
}
