package Models;

import Models.Interfaces.GameObject;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.ImageView;

import java.awt.image.BufferedImage;

public abstract class Fruit implements GameObject {

    protected ImageView currentView;
    protected BufferedImage image_right, image_left, image;
    private final double rotationAngle = Math.PI / 100; //change this to control rotation speed
    private int timesRotated = 0;
    private boolean okToRotate = (timesRotated * rotationAngle) <= (Math.PI / 3);
    private boolean isSliced = false;
    protected GameObjects objectType;
    protected int score;
    
    public abstract void makeSpecial();

    @Override
    public GameObjects getObjectType() {
        return objectType;
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
        isSliced = true;
        System.out.println("isSliced equals " + isSliced);
    }

    @Override
    public void move(double time) {

    }

    @Override
    public BufferedImage[] getBufferedImage() {
        BufferedImage[] bufferedImages = new BufferedImage[4];
        bufferedImages[0] = image;
        bufferedImages[1] = image_left;
        bufferedImages[2] = image_right;

        return bufferedImages;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void nextSlicedFrame() {
        okToRotate = (timesRotated * rotationAngle) <= (Math.PI / 10);
        if (this.isSliced() && this.okToRotate) {
            timesRotated++;
            image_left = MiscUtils.rotateLeft(image_left, rotationAngle);
            image_right = MiscUtils.rotateRight(image_right, rotationAngle);
            image = MiscUtils.concat(image_left, image_right, timesRotated);
            currentView.setImage(SwingFXUtils.toFXImage(image, null));
        }
    }

    public ImageView getImageView() {

        return currentView;
    }





}
