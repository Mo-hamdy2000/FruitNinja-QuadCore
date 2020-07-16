package Models;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Models.Interfaces.GameObject;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.ImageView;

public class FruitDecorator extends Fruit {
	
	protected Fruit specialFruit;
	
	public FruitDecorator(GameObject specialFruit)
	{ 
		this.specialFruit=(Fruit) specialFruit;
		makeSpecial();
		
		
	}

	public void makeSpecial() {
		switch(specialFruit.getObjectType())
		{
		case Watermelon:
		
		try {
			this.specialFruit.image= ImageIO.read(new File("src/resources/fruits/specialWatermelon.png"));
			     specialFruit.image_left=ImageIO.read(new File("src/resources/fruits/specialWatermelon_left.png"));
			     specialFruit.image_right=ImageIO.read(new File("src/resources/fruits/specialWatermelon_right.png"));
			     specialFruit.currentView = new ImageView(SwingFXUtils.toFXImage(specialFruit.image, null));
	             specialFruit.currentView.setOnMouseEntered(MiscUtils.assignListener(this));
	           
		} catch (IOException e) {
            MiscUtils.fileNotFound();
        }
		  break;
		case Apple:
			try {
				this.specialFruit.image= ImageIO.read(new File("src/resources/fruits/apple_special.png"));
				     specialFruit.image_left=ImageIO.read(new File("src/resources/fruits/apple_special_left.png"));
				     specialFruit.image_right=ImageIO.read(new File("src/resources/fruits/apple_special_right.png"));
				     specialFruit.currentView = new ImageView(SwingFXUtils.toFXImage(specialFruit.image, null));
		             specialFruit.currentView.setOnMouseEntered(MiscUtils.assignListener(this));
		           
			} catch (IOException e) {
	            MiscUtils.fileNotFound();
	        }
			break;
		case Banana:
			try {
				this.specialFruit.image= ImageIO.read(new File("src/resources/fruits/banana_special_sliceAll.png"));
				     specialFruit.image_left=ImageIO.read(new File("src/resources/fruits/banana_left.png"));
				     specialFruit.image_right=ImageIO.read(new File("src/resources/fruits/banana_right.png"));
				     specialFruit.currentView = new ImageView(SwingFXUtils.toFXImage(specialFruit.image, null));
		             specialFruit.currentView.setOnMouseEntered(MiscUtils.assignListener(this));
		           
			} catch (IOException e) {
	            MiscUtils.fileNotFound();
	        }
			break;
		case DangerousBomb:
			break;
		case FatalBomb:
			break;
		case Orange:
			try {
				this.specialFruit.image= ImageIO.read(new File("src/resources/fruits/orange_special.png"));
				     specialFruit.image_left=ImageIO.read(new File("src/resources/fruits/orange_special_left.png"));
				     specialFruit.image_right=ImageIO.read(new File("src/resources/fruits/orange_special_right.png"));
				     specialFruit.currentView = new ImageView(SwingFXUtils.toFXImage(specialFruit.image, null));
		             specialFruit.currentView.setOnMouseEntered(MiscUtils.assignListener(this));
		           
			} catch (IOException e) {
	            MiscUtils.fileNotFound();
	        }
			break;
		case Pineapple:
			try {
				this.specialFruit.image= ImageIO.read(new File("src/resources/fruits/pineapple_special.png"));
				     specialFruit.image_left=ImageIO.read(new File("src/resources/fruits/pineapple_left.png"));
				     specialFruit.image_right=ImageIO.read(new File("src/resources/fruits/pineapple_right.png"));
				     specialFruit.currentView = new ImageView(SwingFXUtils.toFXImage(specialFruit.image, null));
		             specialFruit.currentView.setOnMouseEntered(MiscUtils.assignListener(this));
		           
			} catch (IOException e) {
	            MiscUtils.fileNotFound();
	        }
			
			break;
		   default:
			
		
	}
	}


}
