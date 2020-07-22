package Models;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Models.Interfaces.GameObject;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.ImageView;

public class ScoreDecorator extends FruitDecorator implements GameObject  {

	public ScoreDecorator(GameObject specialFruit) {
		super(specialFruit);
		
	}

	@Override
	public GameObjects getObjectType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getXLocation() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getYLocation() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getInitialVelocity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getFallingVelocity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isSliced() {
		// TODO Auto-generated method stub
		return specialFruit.isSliced();
		
	}

	@Override
	public boolean hasMovedOffScreen() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void slice() {
		specialFruit.slice();
		GameLogic gameLogic =new GameLogic();
		gameLogic.getGameProperties().incrementScore(specialFruit.score);
		System.out.println(gameLogic.getGameProperties().getScore());
		
		
	}

	@Override
	public void move(double time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BufferedImage[] getBufferedImage() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
