package Models;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.ImageView;


public class FruitDecorator extends Fruit {
	
	protected Fruit specialFruit;
	
	public FruitDecorator(Fruit specialFruit)
	{
		this.specialFruit=specialFruit;
		System.out.println(specialFruit);
		this.makeSpecial();
	}
  
    /* make a fruit special by making its color blue and doubling its score*/
	@Override
	public void makeSpecial() {
		switch(specialFruit.getObjectType())
		{
		case Watermelon:
		
		
		try {
			this.specialFruit.image= ImageIO.read(new File("src/resources/fruits/specialWatermelon.png"));
			     specialFruit.image_left=ImageIO.read(new File("src/resources/fruits/specialWatermelon_left.png"));
			     specialFruit.image_right=ImageIO.read(new File("src/resources/fruits/specialWatermelon_right.png"));
			     specialFruit.currentView = new ImageView(SwingFXUtils.toFXImage(specialFruit.image, null));
	             specialFruit.currentView.setOnMouseEntered(MiscUtils.assignListener(this.specialFruit));
	             specialFruit.score*=2;
		} catch (IOException e) {
            MiscUtils.fileNotFound();
        }
		case Apple:
			break;
		case Banana:
			break;
		case DangerousBomb:
			break;
		case FatalBomb:
			break;
		case Orange:
			break;
		case Pineapple:
			break;
		default:
			break;
		
	}
	}

	




	

	
}
