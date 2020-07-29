package Controllers;

import java.io.File;
import java.io.IOException;

import Models.MiscUtils;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class Main extends Application {
		
	@FXML
	MediaPlayer mediaPlayer;
	
	 @Override
	 public void start(Stage primaryStage) throws Exception {
	 	FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/start.fxml"));
        Parent root = loader.load();
        FadeTransition ft = new FadeTransition(Duration.millis(3000), root);
        ft.setFromValue(1.0);
        ft.setToValue(0.0);
        ft.play();
        Scene scene = new Scene(root, 1200, 800);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Fruit Ninja");
        primaryStage.getIcons().add(new Image("/resources/icon.png"));
        primaryStage.show();
        primaryStage.setResizable(false);
        ft.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/startPage.fxml"));
            	Parent root;
				try {
					root = loader.load();
					Scene scene = new Scene(root);
					String sep = System.getProperty("file.separator");
					String path = System.getProperty("user.dir") + sep + "src" + sep + "resources" + sep + "test.mp3";  
				    Media media = new Media(new File(path).toURI().toString());  
				    mediaPlayer = new MediaPlayer(media);
				    mediaPlayer.setAutoPlay(true);  
					primaryStage.setScene(scene);
	    	        primaryStage.show();
				} catch (IOException e) {
					e.printStackTrace();
					MiscUtils.fileNotFound();
				}
            }
        });
    }
	 
	public static void main(String[] args) {
		launch(args);
	}
}
