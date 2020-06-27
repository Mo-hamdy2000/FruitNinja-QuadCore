package Models;

public class GameProperties {
	private int lives=3;
	private int score;
  
	
	
	public void pause()
	{
		
	}
	
	public void resume()
	{
		
	}
	
	public void setLives(int lives) {
		this.lives = lives;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getLives() {
		return lives;
	}

	public int getScore() {
		return score;
	}
}
