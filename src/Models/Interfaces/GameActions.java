package Models.Interfaces;

public interface GameActions {

	public GameObject createGameObject();
	
	public void updateObjectsLocation();
	
	public void sliceObjects();
	
	public void saveGame();
	
	public void loadGame();
	
	public void resetGame();
	
}
