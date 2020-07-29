package Models;

import Models.Interfaces.GameObject;

public class SlowDownDecorator extends FruitDecorator {

	public SlowDownDecorator(GameObject specialFruit) {
		super(specialFruit);
		
	}

	public void slice() {
		specialFruit.slice();
		Game.getInstance().flashScreen();
		new java.util.Timer().schedule( 
		        new java.util.TimerTask() {
		        	int i=0;
		            @Override
		            public void run() {
		            	i++;
		                GameLogic.speedFactor=(float) 0.2;
		                if(i>4) {
		                cancel();
		                Game.getInstance().getGameLogic().setSlowMotionDelayTime();
		                GameLogic.speedFactor=(float) 1.0;
		                Game.getInstance().flashScreen();
		                }
		            } 
		        }, 
		        0,1000
		        
		        
		);
		
	}
}
