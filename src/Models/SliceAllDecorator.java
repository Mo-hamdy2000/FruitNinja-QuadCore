package Models;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class SliceAllDecorator extends FruitDecorator {

	public SliceAllDecorator(GameObject specialFruit) {
		super(specialFruit);
		// TODO Auto-generated constructor stub
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
		//System.out.println("custom slice");
		ArrayList<GameObject> fruits = Game.getInstance().getList();
		System.out.println(fruits);
		for(GameObject gameObject: fruits)
		{   
		    if(!(gameObject.getClass().equals(Bomb.class)|| gameObject.isSliced()))
			gameObject.slice();
		}
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
