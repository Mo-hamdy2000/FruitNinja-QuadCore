package Models;

import java.io.File;
import java.util.ArrayList;

import Controllers.GameController;
import Models.Interfaces.EquationGenerator;
import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.util.Duration;

public class Game {
	
	private static Game instance;
	public static int screenHeight = 800;
	public static int screenWidth = 1200;
	
	
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

	AnimationTimer timer;
	Timeline timelineMain, timelineSpecialFruits, timelineArcade;
	String sep = System.getProperty("file.separator");
	AudioClip fruitClip = new AudioClip(new File(System.getProperty("user.dir") + sep + "src" + sep + "resources" + sep + "slice.mp3").toURI().toString());;
	AudioClip bombClip = new AudioClip(new File(System.getProperty("user.dir") + sep + "src" + sep + "resources" + sep + "bomb.mp3").toURI().toString());;
	private AnchorPane root;
	private Label scoreLbl, livesLbl, timeLbl;
	private double pauseTime = 0;
	private GameLogic gameLogic = new GameLogic();
	private int score = 0;
	private int lives = 3;
	private ArrayList<GameObject> list = new ArrayList<GameObject>();
	private boolean pause=false;
	private boolean normalMode = true;
	private int difficulty;
	private int remainingTime = 60;
	

	public void start(AnchorPane root, boolean listIsEmpty, int diff) {
		
		this.root = root;
		this.scoreLbl = (Label)root.getScene().lookup("#scoreLbl");
		this.livesLbl = (Label)root.getScene().lookup("#livesLbl");
		this.timeLbl = (Label)root.getScene().lookup("#timeLbl");
		
		
		this.scoreLbl.setText(this.score + "");
		this.livesLbl.setText(this.lives + "");
		
		EquationGenerator eg;
		int specialFruitDuration = 0;
		this.difficulty = diff;
		
		switch (diff) {
		case 1:
			eg = new EasyEquationGenerator(Game.screenWidth, Game.screenHeight);
			specialFruitDuration = 10;
			break;
		case 2:
			eg = new ModerateEquationGenerator(Game.screenWidth, Game.screenHeight);
			specialFruitDuration = 13;
			break;
		case 3:
			eg = new HardEquationGenerator(Game.screenWidth, Game.screenHeight);
			specialFruitDuration = 16;
			break;
		default:
			eg = new EasyEquationGenerator(Game.screenWidth, Game.screenHeight);
			specialFruitDuration = 10;
			break;
		}
		
		if (!listIsEmpty) {
			for (GameObject object: list) {
				root.getChildren().add(object.getImageView());
			}
		}
		
		if (!normalMode) {
			changeTimeLabel(this.remainingTime + "");
			timelineArcade = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
				remainingTime = Integer.parseInt(timeLbl.getText()) - 1;
				changeTimeLabel((Integer.parseInt(timeLbl.getText())- 1) + "");
			})); 
			timelineArcade.setCycleCount(60);
			timelineArcade.setOnFinished(event -> {
				this.gameOver();
			});
			timelineArcade.play();
		}
		
		timelineMain = new Timeline(new KeyFrame(Duration.millis(1500), event -> {
			GameObject object = gameLogic.createGameObject();
			if (!(object.getClass().equals(DangerousBomb.class) && !normalMode)) {
				object.setEq(eg.generateEquation());
				list.add(object);
				root.getChildren().add(list.get(list.size() - 1).getImageView());
			}
		}));
		
		timelineMain.setCycleCount(1000);
		timelineMain.play();

		timelineSpecialFruits = new Timeline(new KeyFrame(Duration.seconds(specialFruitDuration), event -> {

			GameObject object = gameLogic.createGameObject();
			((GameObject) object).setEq(eg.generateEquation());

			if (object instanceof Fruit) {
				
				Fruit specialFruit = null;
				int index = (int) MiscUtils.rand(0, 2);
				switch (index) {
				case 0:
					specialFruit = new ScoreDecorator(object);
					break;
				case 1:
					specialFruit = new SliceAllDecorator(object);
					break;
				case 2:
					specialFruit = new SlowDownDecorator(object);
					break;
				default:
					specialFruit = new SlowDownDecorator(object);
					break;
				}
				list.add(specialFruit);
				root.getChildren().add(specialFruit.getImageView());

			}

		}));
		timelineSpecialFruits.setCycleCount(1000);
		timelineSpecialFruits.play();

		timer = new AnimationTimer() {

			@Override
			public void handle(long arg0) {

				gameUpdate(list);
				if(pause) {
					timer.stop();
					timelineMain.pause();
					timelineSpecialFruits.pause();
					if (timelineArcade != null) {
						timelineArcade.pause();
					}
				}	
			}
		};
		
		timer.start();
		
	}
	
	public void flashScreen() {
		FadeTransition ftout = new FadeTransition(Duration.millis(100), root);
		ftout.setFromValue(1.0);
		ftout.setToValue(0.0);
		ftout.play();
		ftout.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	FadeTransition ftin = new FadeTransition(Duration.millis(100), root);
            	ftin.setFromValue(0.0);
            	ftin.setToValue(1.0);
            	ftin.play();
            }
        });
	}
	
	public void fruitSliceSound() {
		fruitClip.play();
	}
	
	public void bombSliceSound() {
		bombClip.play();
	}
	
	public void gameUpdate(ArrayList<GameObject> list) {
		gameLogic.updateObjectsLocation();
	}
	
	public void resume() {
		gameLogic.addDelayTime(System.currentTimeMillis() - this.pauseTime);
		pause = false;
		timelineMain.play();
		timelineSpecialFruits.play();
		timer.start();
		if (timelineArcade != null) {
			timelineArcade.play();
		}
	}
	
	private void changeLabelText(Label lbl, String text) { 
		lbl.setText(text);
		lbl.setScaleX(1);
		lbl.setScaleY(1);
	    ScaleTransition scaleTransitionIn = new ScaleTransition(Duration.millis(100), lbl);
	    scaleTransitionIn.setByX(-1);
	    scaleTransitionIn.setByY(-1);
	    
	    ScaleTransition scaleTransitionOut = new ScaleTransition(Duration.millis(100), lbl);
	    scaleTransitionOut.setByX(1);
	    scaleTransitionOut.setByY(1);
	    
	    scaleTransitionIn.setOnFinished(event -> {
	    	scaleTransitionOut.play();
	    });
	    
	    scaleTransitionIn.play();
	    
	}
	
	public void changeScoreLabel(String text) { 
		changeLabelText(scoreLbl, text);
	}
	
	public void changeLivesLabel(String text) { 
		changeLabelText(livesLbl, text);
	}
	
	public void changeTimeLabel(String text) { 
		changeLabelText(timeLbl, text);
	}
	public void stop() {
		pause = true;
		this.pauseTime = System.currentTimeMillis();
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
	
	public void incrementScore(int score) {
		this.score += score;
	}

	public void gameOver() {
		stop();
		FXMLLoader loader = (FXMLLoader)root.getScene().getUserData();
		GameController controller = loader.getController();
		controller.gameOver();
	}

	public ArrayList<GameObject> getList() {
		return list;
	}
	
	public void setPause(boolean pause) {
		this.pause = pause;
	}

	public boolean getPause() {
		return pause;
	}

	public GameLogic getGameLogic() {
		return gameLogic;
	}
	
	public void setMode(boolean isNormalMode) {
		this.normalMode = isNormalMode;
	}
	
	public boolean getMode() {
		return this.normalMode;
	}
	
	public int getDifficulty() {
		return this.difficulty;
	}
	
	public void setDifficulty(int diff) {
		this.difficulty = diff;
	}
	
	public int getRemainingTime() {
		return this.remainingTime;
	}
	
	public void setRemainingTime(int remainingTime) {
		this.remainingTime = remainingTime;
	}
}
