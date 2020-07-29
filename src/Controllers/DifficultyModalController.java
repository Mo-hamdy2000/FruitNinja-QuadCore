package Controllers;

import java.io.IOException;

import Models.Game;
import Models.MiscUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.ImageCursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DifficultyModalController {

	@FXML
	ImageView easy;
	@FXML
	ImageView medium;
	@FXML
	ImageView hard;
	
	Game game=Game.getInstance();
	
	@FXML
	private void difficultySelected(MouseEvent event) {
		String difficulty = ((ImageView)event.getTarget()).getId();
		int diff = 1;
		if (difficulty.equals("medium")) {
			diff = 2;
		}
		else if (difficulty.equals("hard")) {
			diff = 3;
		}
    	Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Stage primaryStage = ((Stage) stage.getOwner());
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/game.fxml"));
        Parent root = null;
		try {
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
			MiscUtils.fileNotFound();
		}
        Image image = new Image("/resources/cursor.gif");
        Scene scene = new Scene(root, 1200, 800);
		scene.setUserData(loader);
        scene.setCursor(new ImageCursor(image));
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        game.start((AnchorPane)root, true, diff);
		stage.close();
	}
}
