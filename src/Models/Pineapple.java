package Models;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.ImageView;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Pineapple extends Fruit {
    public Pineapple() {
        this.objectType = GameObjects.Pineapple;
        // Commented the part below just for testing --MO2--
        try {
            this.image = ImageIO.read(new File("src/resources/fruits/pineapple.png"));
            this.image_left = ImageIO.read(new File("src/resources/fruits/pineapple_left.png"));
            this.image_right = ImageIO.read(new File("src/resources/fruits/pineapple_right.png"));
            this.currentView = new ImageView(SwingFXUtils.toFXImage(this.image, null));
            this.currentView.setOnMouseClicked(MiscUtils.assignListener(this));
            System.out.println(this);


        } catch (IOException e) {
            MiscUtils.fileNotFound();
        }
    }
   
	
}
