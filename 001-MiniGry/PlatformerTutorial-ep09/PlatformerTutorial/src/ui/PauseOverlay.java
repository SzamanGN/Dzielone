package ui;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import main.Game;
import utilz.LoadSave;

public class PauseOverlay {
	
	private BufferedImage backgroudImg;
	private int bgX, bgY, bgW, bgH;
	

	public PauseOverlay() {
		loadBcakground();
	}

	private void loadBcakground() {
		backgroudImg = LoadSave.GetSpriteAtlas(LoadSave.PAUSE_BACKGROUD);
		bgW = (int)(backgroudImg.getWidth() * Game.SCALE);
		bgH = (int)(backgroudImg.getHeight() * Game.SCALE);
		bgX = Game.GAME_WIDTH / 2 - bgW / 2;
		bgY = (int)(25 * Game.SCALE) ;
	}

	public void upDate() {
	}

	public void draw(Graphics g) {
		g.drawImage(backgroudImg, bgX, bgY, bgW, bgH, null);
	}

	public void mouseDrag(MouseEvent e) {

	}

	public void mouseMoved(MouseEvent e) {

	}

	public void keyPressed(KeyEvent e) {

	}

	public void keyReleased(KeyEvent e) {
	}
}
