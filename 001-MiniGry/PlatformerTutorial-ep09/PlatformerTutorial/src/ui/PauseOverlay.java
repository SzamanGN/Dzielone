package ui;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import static utilz.Constants.UI.PauseButtons.*;
import static utilz.Constants.UI.URMButtons.*;
import main.Game;
import utilz.Constants.UI.URMButtons;
import utilz.LoadSave;

public class PauseOverlay {

	private BufferedImage backgroudImg;
	private int bgX, bgY, bgW, bgH;
	private SoundButton musicButtton, sfxButton;
	private URMButtons menuB, replayB, unpauseB; 

	public PauseOverlay() {
		loadBcakground();
		creatSoundButtons();
		creaUrmButtons();
	}

	private void creaUrmButtons() {
		int menuX = (int) (313 * Game.SCALE);
		int replayX = (int) (387 * Game.SCALE);
		int unpausX = (int) (462 * Game.SCALE);
		int bY = (int) (325 * Game.SCALE);
		
		menuB = new URMButtons(menuX, bY, URM_SIZE, URM_SIZE, 2);
		// yt 10 37
		
	
	}

	private void creatSoundButtons() {
		int soundX = (int) (450 * Game.SCALE);
		int musicY = (int) (140 * Game.SCALE);
		int sfxY = (int) (186 * Game.SCALE);
		musicButtton = new SoundButton(soundX, musicY, SOUND_SIZE, SOUND_SIZE);
		sfxButton = new SoundButton(soundX, sfxY, SOUND_SIZE, SOUND_SIZE);
	}

	private void loadBcakground() {
		backgroudImg = LoadSave.GetSpriteAtlas(LoadSave.PAUSE_BACKGROUD);
		bgW = (int) (backgroudImg.getWidth() * Game.SCALE);
		bgH = (int) (backgroudImg.getHeight() * Game.SCALE);
		bgX = Game.GAME_WIDTH / 2 - bgW / 2;
		bgY = (int) (25 * Game.SCALE);
	}

	public void upDate() {
		musicButtton.upDate();
		sfxButton.upDate();
	}

	public void draw(Graphics g) {
		// background
		g.drawImage(backgroudImg, bgX, bgY, bgW, bgH, null);

		// soundButtons
		musicButtton.draw(g);
		sfxButton.draw(g);
	}

	public void mouseDrag(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {
		if (isIn(e, musicButtton))
			musicButtton.setMousePressed(true);
		else if (isIn(e, sfxButton))
			sfxButton.setMousePressed(true);
	}

	public void mouseReleased(MouseEvent e) {
		if (isIn(e, musicButtton)) {
			if (musicButtton.isMousePressed()) 
				musicButtton.setMuted(!musicButtton.isMuted());
			
			} else if (isIn(e, sfxButton))
				if(sfxButton.isMousePressed()) {
					sfxButton.setMuted(!sfxButton.isMuted());
				}
		musicButtton.resetBools();
		sfxButton.resetBools();
	}
	
	public void mouseMoved(MouseEvent e) {
		musicButtton.setMouseOver(false);
		sfxButton.setMouseOver(false);
		
		if (isIn(e, musicButtton))
			musicButtton.setMouseOver(true);
		else if (isIn(e, sfxButton))
			sfxButton.setMouseOver(true);
	}

	private boolean isIn(MouseEvent e, PauseButton b) {
		return b.getBounds().contains(e.getX(), e.getY());
	}
}
