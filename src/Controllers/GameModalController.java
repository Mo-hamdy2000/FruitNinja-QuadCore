package Controllers;

import java.io.IOException;

import Models.Game;
import Models.GameObject;
import Models.MiscUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class GameModalController {
	@FXML
	private AnchorPane root;
	
	@FXML
	private void resumeGame(MouseEvent event) {
	    Game.getInstance().resume();
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.close();
	}
	
	@FXML
	private void restartGame(MouseEvent event) {
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		AnchorPane mainRoot = (AnchorPane)stage.getOwner().getScene().getRoot();
		for (GameObject object : Game.getInstance().getList()) {
			mainRoot.getChildren().remove(object.getImageView());
	    }
		((Label)(stage.getOwner().getScene().lookup("#scoreLbl"))).setText(0 + "");
		((Label)(stage.getOwner().getScene().lookup("#livesLbl"))).setText(3 + "");
		Game.getInstance().getGameLogic().resetGame();
		Game.getInstance().resume();	
		stage.close();
	}
	
	@FXML
	private void saveGame(MouseEvent event) {
		Stage stage = new Stage();
	    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/selectingFilesModal.fxml"));
	    Parent root;
		try {
			root = loader.load();
			stage.setScene(new Scene(root));
		    stage.initModality(Modality.APPLICATION_MODAL);
		    stage.initOwner(
		        ((Stage) ((Node)event.getSource()).getScene().getWindow()).getOwner());
		    stage.initStyle(StageStyle.TRANSPARENT);
		    stage.getScene().setFill(Color.TRANSPARENT);
		    stage.show();
		} catch (IOException e) {
			MiscUtils.fileNotFound();
		}
		((Stage)((Node)event.getSource()).getScene().getWindow()).close();
	}
	
	@FXML
	private void exit(MouseEvent event) {
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Stage primaryStage = ((Stage) stage.getOwner());
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/Views/startPage.fxml"));
			Scene startScene= new Scene(root,1200,800);
			primaryStage.setScene(startScene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
			MiscUtils.fileNotFound();
		}
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.close();
		Game.getInstance().getGameLogic().resetGame();
	}
}
