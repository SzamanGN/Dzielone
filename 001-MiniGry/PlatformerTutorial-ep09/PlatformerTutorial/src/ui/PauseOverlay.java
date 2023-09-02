package ui;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import gamesteats.Gamestate;
import gamesteats.Playing;

import static utilz.Constants.UI.PauseButtons.*;
import static utilz.Constants.UI.URMButtons.*;
import static utilz.Constants.UI.VolumeButtons.*;
import main.Game;
import utilz.Constants.UI.URMButtons;
import utilz.LoadSave;

public class PauseOverlay {

	private Playing playing;
	private BufferedImage backgroudImg;
	private int bgX, bgY, bgW, bgH;
	private SoundButton musicButtton, sfxButton;
	private UrmButton menuB, replayB, unpauseB;
	private VolumeButton volumeButtons;

	public PauseOverlay(Playing playing) {
		this.playing = playing;
		loadBcakground();
		creatSoundButtons();
		creaUrmButtons();
		createVolumeButtons();
	}

	private void createVolumeButtons() {
		int vX = (int) (309 * Game.SCALE);
		int vY = (int) (278 * Game.SCALE);
		volumeButtons = new VolumeButton(vX, vY, SLIDER_WIDTH, VOLUME_HEIGHT);
	}

	private void creaUrmButtons() {
		int menuX = (int) (313 * Game.SCALE);
		int replayX = (int) (387 * Game.SCALE);
		int unpausX = (int) (462 * Game.SCALE);
		int bY = (int) (325 * Game.SCALE);

		menuB = new UrmButton(menuX, bY, URM_SIZE, URM_SIZE, 2);
		replayB = new UrmButton(replayX, bY, URM_SIZE, URM_SIZE, 1);
		unpauseB = new UrmButton(unpausX, bY, URM_SIZE, URM_SIZE, 0);
		// yt 14 43

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

		menuB.update();
		replayB.update();
		unpauseB.update();
		
		volumeButtons.update();
	}

	public void draw(Graphics g) {
		// background
		g.drawImage(backgroudImg, bgX, bgY, bgW, bgH, null);

		// soundButtons
		musicButtton.draw(g);
		sfxButton.draw(g);

		// UrmButton buttons
		menuB.draw(g);
		replayB.draw(g);
		unpauseB.draw(g);
		// volume buttons
		volumeButtons.draw(g);
	}

	public void mouseDragged(MouseEvent e) {
		if (volumeButtons.isMousePressed()) {
			volumeButtons.changeX(e.getX());
		}
	}

	public void mousePressed(MouseEvent e) {
		if (isIn(e, musicButtton)) {
			musicButtton.setMousePressed(true);
			System.out.println("Wcisnieto misic Button");
		} else if (isIn(e, sfxButton)) {
			sfxButton.setMousePressed(true);
			System.out.println("Wcisnieto sfx Button");
		} else if (isIn(e, menuB)) {
			menuB.setMousePressed(true);
			System.out.println("Wcisnieto menuB Button");
		} else if (isIn(e, replayB)) {
			replayB.setMousePressed(true);
			System.out.println("Wcisnieto replayB Button");
		} else if (isIn(e, unpauseB)) {
			unpauseB.setMousePressed(true);
			System.out.println("Wcisnieto unpauseB Button");
		} else if (isIn(e, volumeButtons)) {
			volumeButtons.setMousePressed(true);
			System.out.println("Wcisnieto vloumeButton Button");
		}
	}

	public void mouseReleased(MouseEvent e) {
		if (isIn(e, musicButtton)) {
			if (musicButtton.isMousePressed()) {
				musicButtton.setMuted(!musicButtton.isMuted());
			}
		} else if (isIn(e, sfxButton)) {
			if (sfxButton.isMousePressed()) {
				sfxButton.setMuted(!sfxButton.isMuted());
			}
		} else if (isIn(e, menuB)) {
			if (menuB.isMousePressed()) {
				Gamestate.state = Gamestate.MENU;
				playing.unpauseGame();
			}
		} else if (isIn(e, replayB)) {
			if (replayB.isMousePressed()) {
				System.out.println("replay lvl!");
			}
		} else if (isIn(e, unpauseB)) {
			if (unpauseB.isMousePressed()) {
				playing.unpauseGame();
			}
		}
		musicButtton.resetBools();
		sfxButton.resetBools();
		menuB.resetBools();
		replayB.resetBools();
		unpauseB.resetBools();
		volumeButtons.resetBools();
	}

	public void mouseMoved(MouseEvent e) {
		musicButtton.setMouseOver(false);
		sfxButton.setMouseOver(false);
		menuB.setMouseOver(false);
		replayB.setMouseOver(false);
		unpauseB.setMouseOver(false);
		volumeButtons.setMouseOver(false);

		if (isIn(e, musicButtton))
			musicButtton.setMouseOver(true);
		else if (isIn(e, sfxButton))
			sfxButton.setMouseOver(true);
		else if (isIn(e, menuB))
			menuB.setMouseOver(true);
		else if (isIn(e, replayB))
			replayB.setMouseOver(true);
		else if (isIn(e, unpauseB))
			unpauseB.setMouseOver(true);
		else if (isIn(e, volumeButtons))
			volumeButtons.setMouseOver(true);

	}

	private boolean isIn(MouseEvent e, PauseButton b) {
		return b.getBounds().contains(e.getX(), e.getY());
	}
}
