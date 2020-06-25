package Models;

import java.awt.image.BufferedImage;

import Models.Interfaces.GameObject;

public class Fruit implements GameObject{

	@Override
	public Enum<?> getObjectType() {
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
		return false;
	}

	@Override
	public boolean hasMovedOffScreen() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void slice() {
		// TODO Auto-generated method stub
		
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
