package Models;
 
import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
 
public class Game {
 
	double mouseX;
	double speed;
	double falling;
	AnimationTimer timer;
 
	private static Game instance;
 
	private Game() {
		if (instance != null)
			throw new RuntimeException("use getInstance method");
	}
 
	public static Game getInstance() {
		if (instance == null) {
			synchronized (GameLogic.class) {
				if (instance == null) {
					instance = new Game();
				}
			}
		}
		return instance;
	}
 
	GameLogic gameLogic = new GameLogic();
	private int score = 0;
	private int lives = 3;
	private ArrayList<GameObject> list = new ArrayList<GameObject>();
 
	public void start(Pane root) {
 
		EasyEquationGenerator eg = new EasyEquationGenerator(1200, 800);
		DangerousBomb b = new DangerousBomb();
		b.setEq(eg.generateEquation());
		list.add(b);
		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(2000), event -> {
			GameObject object = gameLogic.createGameObject();
			// if (object instanceof Fruit)
			((GameObject) object).setEq(eg.generateEquation());
			// else if (object instanceof Bomb)
			// ((Bomb)object).setEq(eq);
			list.add(object);
	 
			// if (object instanceof Fruit)
			root.getChildren().add(((GameObject) list.get(list.size() - 1)).getImageView()); 
			System.out.println("Hello Here");
        }));
 
        timeline.setCycleCount(1000);
        timeline.play();
		
		// else if (object instanceof Bomb)
		// root.getChildren().add(((Bomb) list.get(list.size() - 1)).getImageView());
 
		/*
		 * Timeline timeline = new Timeline(new KeyFrame(Duration.millis(falling), event
		 * -> {
		 * 
		 * speed += falling / 2000; GameObject object = gameLogic.createGameObject();
		 * ((Fruit) object).setEq(eq);
		 * 
		 * list.add(object); root.getChildren().add(((Fruit) list.get(list.size() -
		 * 1)).getImageView());
		 * 
		 * }));
		 * 
		 * timeline.setCycleCount(1000); timeline.play();
		 */
 
		timer = new AnimationTimer() {
 
			@Override
			public void handle(long arg0) {
				
				gameUpdate(list);
 
			}
 
		};
 
		timer.start();
 
	}
 
	public void gameUpdate(ArrayList<GameObject> list) {
		for (GameObject object : list) {
			object.move(System.currentTimeMillis());
		}
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
	
	public void gameOver() {
		
	}
	
	public ArrayList<GameObject> getList() {
		return list;
	}
 
}