package Models;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Pineapple extends Fruit {
    public Pineapple() {
        try {
            this.image = ImageIO.read(new File("src/resources/fruits/pineapple.png"));
            this.image_left = ImageIO.read(new File("src/resources/fruits/pineapple_left.png"));
            this.image_right = ImageIO.read(new File("src/resources/fruits/pineapple_right.png"));
        } catch (IOException e) {
            MiscUtils.fileNotFound();
        }
    }
}
