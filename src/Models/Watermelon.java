package Models;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.ImageView;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Watermelon extends Fruit {
	
	public Watermelon() {
        this.objectType = GameObjects.Watermelon;
        // Commented the part below just for testing --MO2--
        try {
            this.image = ImageIO.read(new File("src/resources/fruits/watermelon.png"));
            this.image_left = ImageIO.read(new File("src/resources/fruits/watermelon_left.png"));
            this.image_right = ImageIO.read(new File("src/resources/fruits/watermelon_right.png"));
            this.currentView = new ImageView(SwingFXUtils.toFXImage(this.image, null));
            this.currentView.setOnMouseEntered(MiscUtils.assignListener(this));
            System.out.println(this);


        } catch (IOException e) {
            MiscUtils.fileNotFound();
        }
    }

	@Override
	public void makeSpecial() {
		// TODO Auto-generated method stub
		
	}
}
