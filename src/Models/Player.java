package Models;

public class Player {
	
	private String name;
	private int score;
	private String mode;
	private String diff;
	
	public Player() {}
	
	public Player(String name,int score, String mode, String diff)
	{
		this.name=name;
		this.score=score;
		this.mode = mode;
		this.diff = diff;
	}

	public int getScore() {
		return score;
	}
	
	public void setScore(int score)
	{
		this.score=score;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}

	public String getDiff() {
		return diff;
	}
	
	public String getMode() {
		return mode;
	}
	
	public void setDiff(String diff)
	{
		this.diff=diff;
	}
	
	public void setMode(String mode)
	{
		this.mode=mode;
	}
}
