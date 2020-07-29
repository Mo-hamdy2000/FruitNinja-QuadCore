package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Models.Game;
import Models.MiscUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class GameController implements Initializable {
	
	@FXML
	private AnchorPane root;
	@FXML
	private ImageView quitImageView;
	@FXML
	private Label scoreLbl;
	@FXML
	private Label livesLbl;
	@FXML
	private Label timeLbl;
	@FXML
	private Label scoreTextLbl;
	@FXML
	private Label livesTextLbl;
	@FXML
	private Label timeTextLbl; 
	
	
	@FXML
	private void quitMenu(MouseEvent event) {
	    Game.getInstance().stop();
		Stage stage = new Stage();
	    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/gameModal.fxml"));
	    Parent root;
		try {
			root = loader.load();
			stage.setScene(new Scene(root));
		    stage.initModality(Modality.APPLICATION_MODAL);
		    stage.initOwner(
		        ((Node)event.getSource()).getScene().getWindow() );
		    stage.initStyle(StageStyle.TRANSPARENT);
		    stage.getScene().setFill(Color.TRANSPARENT);
		    stage.show();
		} catch (IOException e) {
			MiscUtils.fileNotFound();
		}
	}
	
	public void gameOver() {
		Stage stage = new Stage();
	    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/nameModal.fxml"));
	    Parent root;
		try {
			root = loader.load();
			stage.setScene(new Scene(root));
		    stage.initModality(Modality.APPLICATION_MODAL);
		    stage.initOwner(scoreLbl.getScene().getWindow());
		    stage.initStyle(StageStyle.TRANSPARENT);
		    stage.getScene().setFill(Color.TRANSPARENT);
		    stage.show();
		} catch (IOException e) {
			e.printStackTrace();
			MiscUtils.fileNotFound();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		if (!Game.getInstance().getMode()) {
			livesLbl.setVisible(false);
			livesTextLbl.setVisible(false);
			timeLbl.setVisible(true);
			timeTextLbl.setVisible(true);
		}
		
	}
}
