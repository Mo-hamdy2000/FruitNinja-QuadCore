package Test;

import Models.MiscUtils;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Game2 extends Application {

    public static void main(String[] args) {
        launch();

    }

    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();
        BufferedImage right = ImageIO.read(new File("src/resources/fruits/pineapple_right.png"));
        BufferedImage left = ImageIO.read(new File("src/resources/fruits/pineapple_left.png"));
        for (int i = 0; i < 3; i++) {
            right = MiscUtils.rotateRight(right, Math.PI / 20);
            left = MiscUtils.rotateLeft(left, Math.PI / 20);
        }
        root.setStyle("-fx-background-color: black;");
        Image image = SwingFXUtils.toFXImage(right, null);
        ImageView imageView = new ImageView(image);
        root.getChildren().addAll(imageView);
        Scene scene = new Scene(root, 1000, 500);
        stage.setScene(scene);
        stage.show();
    }
}
