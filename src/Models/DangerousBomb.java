package Models;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.ImageView;

public class DangerousBomb extends Bomb{

	public DangerousBomb() {
		this.objectType = GameObjects.DangerousBomb;
        try {
            this.image = ImageIO.read(new File("src/resources/bombs/dangerous_bomb.png"));
            this.currentView = new ImageView(SwingFXUtils.toFXImage(this.image, null));
            this.currentView.setOnMousePressed(MiscUtils.assignListener(this));
        } catch (IOException e) {
            MiscUtils.fileNotFound();
        }
	}
	
	@Override
	public void slice() {
		this.isSliced = true;
		Game game = Game.getInstance();
		game.bombSliceSound();
		game.setLives(game.getLives()-1);
		game.changeLivesLabel(game.getLives()+"");
		if(game.getLives() < 1) {
			game.gameOver();
		}
	}

}
