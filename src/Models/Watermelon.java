package Models;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.ImageView;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Watermelon extends Fruit {
	
	public Watermelon() {
        this.objectType = GameObjects.Watermelon;
        try {
            this.image = ImageIO.read(new File("src/resources/fruits/Watermelon.png"));
            this.image_left = ImageIO.read(new File("src/resources/fruits/Watermelon_left.png"));
            this.image_right = ImageIO.read(new File("src/resources/fruits/Watermelon_right.png"));
            this.currentView = new ImageView(SwingFXUtils.toFXImage(this.image, null));
            this.currentView.setOnMousePressed(MiscUtils.assignListener(this));
        } catch (IOException e) {
            MiscUtils.fileNotFound();
        }
    }
	
}
