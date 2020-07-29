package Models;

public abstract class Fruit extends GameObject {
   
	protected int score = 1;
	
    @Override
    public void slice() {
        this.isSliced = true;
        Game game = Game.getInstance();
        game.fruitSliceSound();
		game.incrementScore(score);
		game.changeScoreLabel(game.getScore() + "");
    }
}
