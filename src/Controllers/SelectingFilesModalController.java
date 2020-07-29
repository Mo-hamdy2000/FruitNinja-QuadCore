package Controllers;

import java.io.IOException;

import Models.Game;
import Models.MiscUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SelectingFilesModalController {
	
	
	@FXML
	ImageView file1;
	@FXML
	ImageView file2;
	@FXML
	ImageView file3;
	
	private boolean savingMode = true;
	
	
	
	@FXML
	private void fileSelected(MouseEvent event) {
		String fileName = ((ImageView)event.getTarget()).getId();
		Game game = Game.getInstance();
		game.getGameLogic().setTargetFile(fileName + ".xml");
	    if (savingMode) {
	    	game.getGameLogic().saveGame();
	    	game.getGameLogic().resetGame();
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
	    }
	    else {
	    	game.getGameLogic().loadGame();
	    	Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			Stage primaryStage = ((Stage) stage.getOwner());
			Parent root;
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/game.fxml"));
				root = loader.load();
				Scene gameScene= new Scene(root,1200,800);
				gameScene.setUserData(loader);
				primaryStage.setScene(gameScene);
				primaryStage.setResizable(false);
				primaryStage.show();
				game.start((AnchorPane)root, false, game.getDifficulty());
			} catch (IOException e) {
				e.printStackTrace();
				MiscUtils.fileNotFound();
			}
	    }
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.close();
	}
	
	public void setMode(boolean isSavingmode) {
		this.savingMode = isSavingmode;
	}
	
}
