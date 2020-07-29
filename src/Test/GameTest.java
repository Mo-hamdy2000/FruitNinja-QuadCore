package Test;
 
import Models.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GameTest extends Application {
 
    Game game=Game.getInstance();
 
    public static void main(String[] args) {
        launch();
    }
 
    @Override
    public void start(Stage primaryStage) {
 
        AnchorPane root = new AnchorPane();
        //game.start(root, true);

        game.getGameLogic().loadGame();
		game.start(root, false, 1);
        Button p=new Button();
        p.setText("Pause");
		root.getChildren().add(p);
		p.setOnAction(e->{
			game.getGameLogic().saveGame();
			game.stop();
		});
		Button r=new Button();
		r.setLayoutX(800);
		r.setLayoutY(10);
        r.setText("Resume");
		root.getChildren().add(r);
		r.setOnAction(e->{
	        game.resume();
		});
        Scene scene = new Scene(root, 1200, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
 
    }
}