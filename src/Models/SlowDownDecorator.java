package Models;

import java.awt.image.BufferedImage;

import Models.Interfaces.GameObject;

public class SlowDownDecorator extends FruitDecorator implements GameObject {

	public SlowDownDecorator(GameObject specialFruit) {
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
		new java.util.Timer().schedule( 
		        new java.util.TimerTask() {
		        	int i=0;
		            @Override
		            public void run() {
		            	i++;
		                GameLogic.speedFactor=(float) 0.2;
		                System.out.println(GameLogic.speedFactor);
		                System.out.println("Slow mode Running");
		                if(i>4) {
		                cancel();
		                GameLogic.speedFactor=(float) 1.0;
		                System.out.println(GameLogic.speedFactor);
		                }
		            } 
		        }, 
		        0,1000
		        
		        
		);
		
	}

	@Override
	public void move(double time) {
	
		
	}

	@Override
	public BufferedImage[] getBufferedImage() {
		// TODO Auto-generated method stub
		return null;
	}

}
