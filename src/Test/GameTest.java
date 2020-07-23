package Test;
 
import Models.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
        Button p=new Button();
        p.setText("Pause");
		root.getChildren().add(p);
		p.setOnAction(e->{
			game.setPause(true);
		});
		/*Button r=new Button();
		r.setLayoutX(800);
		r.setLayoutY(10);
        r.setText("Resume");
		root.getChildren().add(r);
		r.setOnAction(e->{
			game.setPause(false);
	        game.start(root);
		});*/
        Scene scene = new Scene(root, 1200, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
 
    }
}