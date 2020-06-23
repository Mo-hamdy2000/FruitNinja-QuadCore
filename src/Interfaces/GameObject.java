package Interfaces;
import java.awt.image.BufferedImage;

public interface GameObject {
	
  public Enum<?> getObjectType();
  
  public int getXLocation();
  
  public int getYLocation();
  
  public int getMaxHeight();
  
  public int getInitialVelocity();
  
  public int getFallingVelocity();
  
  public boolean isSliced ();
  
  public boolean hasMovedOffScreen();
  
  public void slice();
  
  public void move(double time);
  
  public BufferedImage [] getBufferedImage();
  
 
  

}
