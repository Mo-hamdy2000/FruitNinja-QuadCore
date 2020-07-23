package Models;

import java.awt.Point;
import java.awt.image.BufferedImage;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.ImageView;

abstract public class GameObject implements Models.Interfaces.GameObject {
	protected ImageView currentView;
    protected BufferedImage image_right, image_left, image;
    private int timesRotated = 0;
    protected boolean isSliced = false;
    protected GameObjects objectType;
    protected Equation eq;
    private final double startingTime;
   

    public GameObject() {
        startingTime = System.currentTimeMillis();
    }

   

    @Override
    public GameObjects getObjectType() {
        return objectType;
    }

    @Override
    public int getXLocation() {
        return (int) currentView.getLayoutX();
    }

    @Override
    public int getYLocation() {
        return (int) currentView.getLayoutY();

    }

    @Override
    public int getMaxHeight() {
        return eq.getMaxHeight();
    }

    @Override
    public int getInitialVelocity() {
        return Math.abs((int) eq.getInitialSpeed());
    }

    @Override
    public int getFallingVelocity() {
        return Math.abs((int) eq.getInitialSpeed());

    }

    @Override
    public boolean isSliced() {
        return isSliced;
    }

    @Override
    public boolean hasMovedOffScreen() {
        int[] arr = eq.getScreenSize();
        return getImageView().getLayoutX() > arr[1] || getImageView().getLayoutY() > arr[0];
    }

    @Override
    abstract public void slice();

    /**
     * @param time current time NOT delta time
     *             the starting time is then deducted from this time to get delta time
     *             that is passed to updateCoordinates
     */
    @Override
    public void move(double time) {
        Point p = eq.updateCoordinates((int) (getImageView().getLayoutX()), (int) (getImageView().getLayoutY()),
                time - startingTime, this.isSliced());
        nextSlicedFrame();
        getImageView().setRotate(getImageView().getRotate() + 1);
        getImageView().setLayoutX(p.x);
        getImageView().setLayoutY(p.y);
    }

    @Override
    public BufferedImage[] getBufferedImage() {
        BufferedImage[] bufferedImages = new BufferedImage[4];
        bufferedImages[0] = image;
        bufferedImages[1] = image_left;
        bufferedImages[2] = image_right;
        return bufferedImages;
    }

    public void nextSlicedFrame() {
        //change this to control rotation speed
        double rotationAngle = Math.PI / 200;
        boolean okToRotate = (timesRotated * rotationAngle) <= (Math.PI / 10);
        if (this.isSliced() && okToRotate) {
            timesRotated++;
            image_left = MiscUtils.rotateLeft(image_left, rotationAngle);
            image_right = MiscUtils.rotateRight(image_right, rotationAngle);
            image = MiscUtils.concat(image_left, image_right, timesRotated);
            currentView.setImage(SwingFXUtils.toFXImage(image, null));
        }
        if (isSliced) {
            double x = getImageView().getScaleX() - 0.005;
            double y = getImageView().getScaleY() - 0.005;
            getImageView().setScaleX(x > 0.5 ? x : getImageView().getScaleX());
            getImageView().setScaleY(y > 0.5 ? y : getImageView().getScaleY());
        }
    }

    public ImageView getImageView() {
        return currentView;
    }

    public void setEq(Equation eq) {
        this.eq = eq;
    }
}
