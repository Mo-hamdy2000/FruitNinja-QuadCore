package Models;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.ImageView;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Apple extends Fruit {

    public Apple() {
        this.objectType = GameObjects.Apple;
        try {
            this.image = ImageIO.read(new File("src/resources/fruits/apple.png"));
            this.image_left = ImageIO.read(new File("src/resources/fruits/apple_left.png"));
            this.image_right = ImageIO.read(new File("src/resources/fruits/apple_right.png"));
            this.currentView = new ImageView(SwingFXUtils.toFXImage(this.image, null));
            this.currentView.setOnMouseClicked(MiscUtils.assignListener(this));

        } catch (IOException e) {
            MiscUtils.fileNotFound();
        }
    }

    

}
