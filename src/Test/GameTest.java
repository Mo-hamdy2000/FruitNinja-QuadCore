package Test;
 
import Models.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GameTest extends Application {
 
    Game game=Game.getInstance();
 
    public static void main(String[] args) {
        launch();
    }
 
    @Override
    public void start(Stage primaryStage) {
 
        Pane root = new Pane();
        game.start(root);
        Scene scene = new Scene(root, 1200, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
 
    }
}