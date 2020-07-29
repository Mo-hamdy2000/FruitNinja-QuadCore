package Models;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.ImageView;

public class FatalBomb extends Bomb{

	public FatalBomb() {
		this.objectType = GameObjects.FatalBomb;
        try {
            this.image = ImageIO.read(new File("src/resources/bombs/Fatal_Bomb.png"));
            this.currentView = new ImageView(SwingFXUtils.toFXImage(this.image, null));
            this.currentView.setOnMousePressed(MiscUtils.assignListener(this));
        } catch (IOException e) {
            MiscUtils.fileNotFound();
        }
	}
	
	@Override
	public void slice() {
		this.isSliced = true;
		Game.getInstance().bombSliceSound();
		Game.getInstance().gameOver();
	}

}
