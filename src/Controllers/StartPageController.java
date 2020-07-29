package Controllers;

import java.io.IOException;

import Models.Game;
import Models.MiscUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StartPageController {
	
	@FXML
	HBox optionsBox;
	
	@FXML
	private void normalClicked(MouseEvent event) {
		optionsBox.setVisible(false);
		Stage stage = new Stage();
	    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/difficultyModal.fxml"));
	    Parent root;
		try {
			root = loader.load();
			stage.setScene(new Scene(root));
		    stage.initModality(Modality.APPLICATION_MODAL);
		    stage.initOwner(
		        ((Node)event.getSource()).getScene().getWindow());
		    stage.initStyle(StageStyle.TRANSPARENT);
		    stage.getScene().setFill(Color.TRANSPARENT);
		    stage.show();
		} catch (IOException e) {
			e.printStackTrace();
			MiscUtils.fileNotFound();
		}
	}
	
	@FXML
	private void arcadeClicked(MouseEvent event) {
		optionsBox.setVisible(false);
		Game.getInstance().setMode(false);
		Stage stage = new Stage();
	    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/difficultyModal.fxml"));
	    Parent root;
		try {
			root = loader.load();
			stage.setScene(new Scene(root));
		    stage.initModality(Modality.APPLICATION_MODAL);
		    stage.initOwner(
		        ((Node)event.getSource()).getScene().getWindow());
		    stage.initStyle(StageStyle.TRANSPARENT);
		    stage.getScene().setFill(Color.TRANSPARENT);
		    stage.show();
		} catch (IOException e) {
			e.printStackTrace();
			MiscUtils.fileNotFound();
		}
	}
	
	@FXML
	private void leaderBoardClicked(MouseEvent event) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/leaderBoard.fxml"));
        try {
        	Parent root = loader.load();
			((Stage) ((Node)event.getSource()).getScene().getWindow()).setScene(new Scene(root));
		} catch (IOException e) {
			e.printStackTrace();
			MiscUtils.fileNotFound();
		}
	}
	
	@FXML
	private void loadClicked(MouseEvent event) {
		optionsBox.setVisible(false);
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/selectingFilesModal.fxml"));
        try {
        	Parent root = loader.load();
            SelectingFilesModalController controller = loader.getController();
            controller.setMode(false);
			stage.setScene(new Scene(root));
		    stage.initModality(Modality.APPLICATION_MODAL);
		    stage.initOwner(
		        ((Stage) ((Node)event.getSource()).getScene().getWindow()));
		    stage.initStyle(StageStyle.TRANSPARENT);
		    stage.getScene().setFill(Color.TRANSPARENT);
		    stage.show();
		} catch (IOException e) {
			MiscUtils.fileNotFound();
		}
	}
	
}
