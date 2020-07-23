package Models;

public abstract class Fruit extends GameObject {
   
	protected int score = 1;
	
    @Override
    public void slice() {
        this.isSliced = true;
		GameLogic gameLogic =new GameLogic();
        gameLogic.getGameProperties().incrementScore(score);
    }
}
