package Models;

import Models.Interfaces.GameObject;
import javafx.scene.image.ImageView;

import java.awt.image.BufferedImage;

public class Fruit implements GameObject {
	
	protected ImageView currentView;
	protected BufferedImage image_right, image_left, image;
	private final double rotationAngle = Math.PI / 20; //change this to control rotation speed
	private int timesRotated = 0;
	private final boolean okToRotate = timesRotated * rotationAngle <= Math.PI / 2;
	private boolean isSliced=false;

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
		return isSliced;
	}

	@Override
	public boolean hasMovedOffScreen() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void slice() {
		
		isSliced=true;
		System.out.println("isSliced equals " + isSliced);
	}

	@Override
	public void move(double time) {
		if (this.isSliced() && this.okToRotate) this.nextSlicedFrame();
		

	}

	@Override
	public BufferedImage[] getBufferedImage() {
	    BufferedImage[] bufferedImages=new BufferedImage[4];
	    bufferedImages[0]=image;
	    bufferedImages[1]=image_left;
	    bufferedImages[2]=image_right;
	    
		return bufferedImages;
	}

	private void nextSlicedFrame() {
		timesRotated++;
		image_left = MiscUtils.rotateLeft(image_left, rotationAngle);
		image_right = MiscUtils.rotateRight(image_right, rotationAngle);
		image = MiscUtils.concat(image_left, image_right);
	}
	
	public  ImageView getImageView ()
	{
		 
		return currentView;
	}

	
}
