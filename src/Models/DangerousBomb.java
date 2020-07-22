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
            this.image = ImageIO.read(new File("src/resources/bombs/Dangerous_Bomb.png"));
            this.image_left = ImageIO.read(new File("src/resources/bombs/bomb_cut_left.png"));
            this.image_right = ImageIO.read(new File("src/resources/bombs/bomb_cut_left.png"));
            this.currentView = new ImageView(SwingFXUtils.toFXImage(this.image, null));
            this.currentView.setOnMouseEntered(MiscUtils.assignListener(this));
            

        } catch (IOException e) {
            MiscUtils.fileNotFound();
        }
	}
	
	@Override
	public void slice() {
		System.out.println("#############################################################");
		this.isSliced = true;
		Game game = Game.getInstance();
		game.setLives(game.getLives()-1);
		if(game.getLives() < 1) {
			game.gameOver();
		}
	}

}
