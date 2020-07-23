package Models;

import Models.Interfaces.GameObject;

public class SlowDownDecorator extends FruitDecorator {

	public SlowDownDecorator(GameObject specialFruit) {
		super(specialFruit);
		
	}

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
}
