package Models;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Watermelon extends Fruit {
    public Watermelon() {
        try {
            this.image = ImageIO.read(new File("src/resources/fruits/watermelon.png"));
            this.image_left = ImageIO.read(new File("src/resources/fruits/watermelon_left.png"));
            this.image_right = ImageIO.read(new File("src/resources/fruits/watermelon_right.png"));
        } catch (IOException e) {
            MiscUtils.fileNotFound();
        }
    }
}
