package views;

import javafx.application.Application;
import javafx.stage.Stage;
 
 
 
	import javafx.fxml.FXMLLoader;
	import javafx.scene.Parent;
	import javafx.scene.Scene;
 
	public class StartPage extends Application {
 
		  public static void main(String[] args) {
		        launch();
 
		    } 
 
		@Override
		public void start(Stage primaryStage) throws Exception {
 
			Parent root=FXMLLoader.load(getClass().getResource("/fxmls/startPage.fxml"));
			Scene startScene= new Scene(root,600,400);
			primaryStage.setScene(startScene);
			primaryStage.setResizable(false);
			primaryStage.show();
 
 
 
		}
	}