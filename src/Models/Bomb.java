package Models;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;

abstract public class Bomb extends GameObject {
	
	private BufferedImage slicedBomb;
	
	Bomb() {
		try {
			slicedBomb = ImageIO.read(new File("src/resources/bombs/bomb_slice.png"));
		} catch (IOException e) {
			MiscUtils.fileNotFound();
		}
	}
	
	public void nextSlicedFrame() {
		if (this.isSliced) {
			this.currentView.setImage(SwingFXUtils.toFXImage(slicedBomb, null));
		}
	}
}
