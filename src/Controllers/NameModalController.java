package Controllers;

import java.io.IOException;

import Models.Game;
import Models.MiscUtils;
import Models.Player;
import Models.ScoreBoard;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class NameModalController {

	@FXML
	private TextField nameTxt;
	
	@FXML
	private void doneClicked(MouseEvent event) {
		Game game = Game.getInstance();
		
		String name = nameTxt.getText();
		String mode;
		if(game.getMode()) {
			mode = "Normal";
		}
		else {
			mode = "Arcade";
		}
		
		String diff;
		switch (game.getDifficulty()) {
		case 1:
			diff = "Easy";
			break;
		case 2:
			diff = "Medium";
			break;
		case 3:
			diff = "Hard";
			break;
		default:
			diff = "Easy";
			break;
		}
		Player player = new Player(name, game.getScore(), mode, diff);
		game.getGameLogic().resetGame();
		ScoreBoard sb = ScoreBoard.loadScoreBoard();
		int state = sb.addPlayer(player);
		sb.saveScoreBoard();
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/leaderBoard.fxml"));
        try {
        	Parent root = loader.load();
            LeaderboardController controller = loader.getController();
            controller.setMsg(state, player);
            ((Stage) ((Node)event.getSource()).getScene().getWindow()).close();
			((Stage)((Stage) ((Node)event.getSource()).getScene().getWindow()).getOwner()).setScene(new Scene(root));
		} catch (IOException e) {
			e.printStackTrace();
			MiscUtils.fileNotFound();
		}
	}
	
}
