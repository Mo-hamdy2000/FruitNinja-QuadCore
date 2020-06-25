package Models;

import Models.Interfaces.GameObject;

import java.awt.image.BufferedImage;

public class Fruit implements GameObject {

	protected BufferedImage image_right, image_left, image;
	private final double rotationAngle = Math.PI / 20; //change this to control rotation speed
	private int timesRotated = 0;
	private final boolean okToRotate = timesRotated * rotationAngle <= Math.PI / 2;

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
		if (this.isSliced() && this.okToRotate) this.nextSlicedFrame();
		// TODO Auto-generated method stub

	}

	@Override
	public BufferedImage[] getBufferedImage() {
		// TODO Auto-generated method stub
		return null;
	}

	private void nextSlicedFrame() {
		timesRotated++;
		image_left = MiscUtils.rotateLeft(image_left, rotationAngle);
		image_right = MiscUtils.rotateRight(image_right, rotationAngle);
		image = MiscUtils.concat(image_left, image_right);
	}
}
