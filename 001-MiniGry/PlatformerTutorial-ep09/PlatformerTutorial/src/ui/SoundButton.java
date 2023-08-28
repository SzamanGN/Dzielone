package ui;

import java.awt.image.BufferedImage;

import utilz.LoadSave;

public class SoundButton extends PauseButton {
	
	private BufferedImage[][] soundImgs;

	public SoundButton(int x, int y, int width, int height) {
		super(x, y, width, height);
		loudSoundImgs();
	}

	private void loudSoundImgs() {
		BufferedImage tmp = LoadSave.GetSpriteAtlas(LoadSave.SOUND_BUTTONS);
		soundImgs = new BufferedImage[2][3];
		for(int j = 0 ; j < soundImgs.length; j++) 
			for(int i = 0; i < soundImgs[j].length; i++)
				soundImgs[j][i] = tmp.getSubimage(i, i, j, i);
				
			
		
	}

}
