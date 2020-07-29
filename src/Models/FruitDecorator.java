package Models;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Models.Interfaces.GameObject;
import javafx.embed.swing.SwingFXUtils;

abstract public class FruitDecorator extends Fruit {
	
	protected Fruit specialFruit;
	
	public FruitDecorator(GameObject specialFruit)
	{ 
		this.specialFruit=(Fruit) specialFruit;
		this.setEq(this.specialFruit.eq);
		this.currentView = this.specialFruit.currentView;
		this.objectType = this.specialFruit.getObjectType();
		makeSpecial();
	}

	public void makeSpecial() {
		switch(specialFruit.getObjectType())
		{
		case Watermelon:
			try {
				image= ImageIO.read(new File("src/resources/fruits/specialWatermelon.png"));
			    image_left=ImageIO.read(new File("src/resources/fruits/specialWatermelon_left.png"));
			    image_right=ImageIO.read(new File("src/resources/fruits/specialWatermelon_right.png"));
			    currentView.setImage(SwingFXUtils.toFXImage(image, null));
			    this.currentView.setOnMousePressed(MiscUtils.assignListener(this));
		} catch (IOException e) {
            MiscUtils.fileNotFound();
        }
		  break;
		case Apple:
			try {
					image= ImageIO.read(new File("src/resources/fruits/apple_special.png"));
				    image_left=ImageIO.read(new File("src/resources/fruits/apple_special_left.png"));
				    image_right=ImageIO.read(new File("src/resources/fruits/apple_special_right.png"));
				    currentView.setImage(SwingFXUtils.toFXImage(image, null));
				    this.currentView.setOnMousePressed(MiscUtils.assignListener(this));       
			} catch (IOException e) {
	            MiscUtils.fileNotFound();
	        }
			break;
		case Banana:
			try {
					image= ImageIO.read(new File("src/resources/fruits/banana_special_sliceAll.png"));
				    image_left=ImageIO.read(new File("src/resources/fruits/banana_left.png"));
				    image_right=ImageIO.read(new File("src/resources/fruits/banana_right.png"));
				    currentView.setImage(SwingFXUtils.toFXImage(image, null));
				    this.currentView.setOnMousePressed(MiscUtils.assignListener(this));
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
					image= ImageIO.read(new File("src/resources/fruits/orange_special.png"));
				    image_left=ImageIO.read(new File("src/resources/fruits/orange_special_left.png"));
				    image_right=ImageIO.read(new File("src/resources/fruits/orange_special_right.png"));
				    currentView.setImage(SwingFXUtils.toFXImage(image, null));
				    currentView.setOnMousePressed(MiscUtils.assignListener(this));
		           
			} catch (IOException e) {
	            MiscUtils.fileNotFound();
	        }
			break;
		case Pineapple:
			try {
					image= ImageIO.read(new File("src/resources/fruits/pineapple_special.png"));
				    image_left=ImageIO.read(new File("src/resources/fruits/pineapple_left.png"));
				    image_right=ImageIO.read(new File("src/resources/fruits/pineapple_right.png"));
				    currentView.setImage(SwingFXUtils.toFXImage(image, null));
				    currentView.setOnMousePressed(MiscUtils.assignListener(this));
			} catch (IOException e) {
	            MiscUtils.fileNotFound();
	        }
			
			break;
		   default:
		}
	}
	
	public boolean isSliced() {
        return this.specialFruit.isSliced();
    }
}
