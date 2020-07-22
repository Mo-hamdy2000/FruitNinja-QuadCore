package Models;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.ImageView;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Banana extends Fruit {
    public Banana() {
        this.objectType = GameObjects.Banana;
        try {
            this.image = ImageIO.read(new File("src/resources/fruits/banana.png"));
            this.image_left = ImageIO.read(new File("src/resources/fruits/banana_left.png"));
            this.image_right = ImageIO.read(new File("src/resources/fruits/banana_right.png"));
            this.currentView = new ImageView(SwingFXUtils.toFXImage(this.image, null));
            this.currentView.setOnMouseEntered(MiscUtils.assignListener(this));
            System.out.println(this);


        } catch (IOException e) {
            MiscUtils.fileNotFound();
        }
    }
   


}
