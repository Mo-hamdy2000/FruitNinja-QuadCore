package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Models.MiscUtils;
import Models.Player;
import Models.ScoreBoard;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LeaderboardController implements Initializable {

	@FXML
	private VBox playersBox;
	@FXML
	private Label msgLbl;
	@FXML
	private Label scoreLbl;

	
	
	@FXML
	private void backClicked(MouseEvent event) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/startPage.fxml"));
    	Parent root;
		try {
			root = loader.load();    
			((Stage) ((Node)event.getSource()).getScene().getWindow()).setScene(new Scene(root));
		} catch (IOException e) {
			e.printStackTrace();
			MiscUtils.fileNotFound();
		}
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		ScoreBoard sb = ScoreBoard.loadScoreBoard();
		while (!sb.getScoreBoard().isEmpty()) {
			Label lbl = new Label();
			Player plyr = sb.getScoreBoard().poll();
			lbl.setText(plyr.getName() + "\t\t" + plyr.getScore() + "\t\t" +plyr.getMode() + "\t\t" + plyr.getDiff());
			lbl.setFont(new Font("Viner Hand ITC", 22));
			lbl.setTextFill(Color.WHITE);
			playersBox.getChildren().add(lbl);
		}
	}
	
	public void setMsg(int state, Player player) {
		switch (state) {
		case 0:
			msgLbl.setText("Unfortunately you haven't entered the leaderboard");
			break;
		case 1:
			msgLbl.setText("Unfortunately you haven't acheived new record");
			break;
		case 2:
			msgLbl.setText("Congratulations!! you have entered the leaderboard");
			break;
		case 3:
			msgLbl.setText("Congratulations!! you have acheived new world record");
			break;
		}
		
		scoreLbl.setText("Your score: " + player.getScore());
	}
	
	
}
