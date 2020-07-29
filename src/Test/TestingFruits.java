package Test;

import java.io.IOException;

import Models.Game;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.ImageCursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TestingFruits  extends Application {
 
    Game game=Game.getInstance();
 
    public static void main(String[] args) {
        launch();
    }
 
    @Override
    public void start(Stage primaryStage) {
    	
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/game.fxml"));
        Parent root = null;
		try {
			root = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        Image image = new Image("/resources/cursor.gif");
        Scene scene = new Scene(root, 1200, 800);
        scene.setCursor(new ImageCursor(image));
        primaryStage.setScene(scene);
        primaryStage.setTitle("Fruit Ninja");
        primaryStage.show();
        primaryStage.setResizable(false);
        game.start((AnchorPane)root, true, 3);
        
        /*
        Button p=new Button();
        p.setText("Pause");
		root.getChildren().add(p);
		p.setOnAction(e->{
			game.setPause(true);
		});
		Button r=new Button();
		r.setLayoutX(800);
		r.setLayoutY(10);
        r.setText("Resume");
		root.getChildren().add(r);
		r.setOnAction(e->{
			game.setPause(false);
	        game.resume();
		});*/
 
    }
	
}
