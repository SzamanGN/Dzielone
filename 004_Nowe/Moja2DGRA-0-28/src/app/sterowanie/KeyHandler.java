package app.sterowanie;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import app.panele.GamePanel;

public class KeyHandler implements KeyListener {

	public boolean upPressed, downPressed, leftPressed, rightPressed, entertPressed, shotKeyPressed;
	// debug
	public boolean checkDrawTime = false;

	public GamePanel gp;

	public KeyHandler(GamePanel gp) {
		this.gp = gp;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		// titel state
		if (gp.gameState == gp.titleState) {
			tileState(code);
		}
		// this is a play state
		else if (gp.gameState == gp.playState) {
			playState(code);
		}
		// PAUSE STATE
		else if (gp.gameState == gp.pauseState) {
			pauseState(code);
		}
		// DIALOG STATE
		else if (gp.gameState == gp.dialogueState) {
			dialogeState(code);
		}
		// CHARACTER STATE
		else if (gp.gameState == gp.characterState) {
			characterState(code);
		}
	}

	public void tileState(int code) {

		if (gp.ui.titleScreenState == 0) {
			if (code == KeyEvent.VK_W) {
				gp.ui.commandNum--;
				if (gp.ui.commandNum < 0) {
					gp.ui.commandNum = 2;
				}
			}
			if (code == KeyEvent.VK_S) {
				gp.ui.commandNum++;
				if (gp.ui.commandNum > 2) {
					gp.ui.commandNum = 0;
				}
			}
			// dodanie wcisniecia entera aby aktywowac
			if (code == KeyEvent.VK_ENTER) {
				// start gry
				if (gp.ui.commandNum == 0) {
					gp.ui.titleScreenState = 1;
				} // ladowanie
				if (gp.ui.commandNum == 1) {
					// add later
				}
				if (gp.ui.commandNum == 2) {
					System.exit(0);
				}
			}
		}
		// titel screnn 1
		else if (gp.ui.titleScreenState == 1) {
			if (code == KeyEvent.VK_W) {
				gp.ui.commandNum--;
				if (gp.ui.commandNum < 0) {
					gp.ui.commandNum = 3;
				}
			}
			if (code == KeyEvent.VK_S) {
				gp.ui.commandNum++;
				if (gp.ui.commandNum > 3) {
					gp.ui.commandNum = 0;
				}
			}
			// dodanie wcisniecia entera aby aktywowac
			if (code == KeyEvent.VK_ENTER) {

				if (gp.ui.commandNum == 0) {
					System.out.println("Do sam fighter specific stuff!");
					gp.gameState = gp.playState;
					// gp.playMusic(0);
				}
				if (gp.ui.commandNum == 1) {
					System.out.println("Do sam thief specific stuff!");
					gp.gameState = gp.playState;
					// gp.playMusic(0);
				}
				if (gp.ui.commandNum == 2) {
					System.out.println("Do sam sorcer specific stuff!");
					gp.gameState = gp.playState;
					// gp.playMusic(0);
				}
				if (gp.ui.commandNum == 3) {
					gp.ui.titleScreenState = 0;
				}
			}
		}
	}

	public void playState(int code) {
		if (code == KeyEvent.VK_W) {
			upPressed = true;
		}
		if (code == KeyEvent.VK_S) {
			downPressed = true;
		}
		if (code == KeyEvent.VK_A) {
			leftPressed = true;
		}
		if (code == KeyEvent.VK_D) {
			rightPressed = true;
		}

		if (code == KeyEvent.VK_P) {
			gp.gameState = gp.pauseState;
		}

		if (code == KeyEvent.VK_C) {
			gp.gameState = gp.characterState;
		}

		if (code == KeyEvent.VK_ENTER) {
			entertPressed = true;
		}
		
		if (code == KeyEvent.VK_F) {
			shotKeyPressed = true;
		}

		// debug
		if (code == KeyEvent.VK_T) {
			if (checkDrawTime == false) {
				checkDrawTime = true;
			} else if (checkDrawTime == true) {
				checkDrawTime = false;
			}
		}
	}

	public void pauseState(int code) {
		if (code == KeyEvent.VK_P) {
			gp.gameState = gp.pauseState;
		}
	}

	public void dialogeState(int code) {
		if (code == KeyEvent.VK_ENTER) {
			gp.gameState = gp.playState;
		}
	}

	public void characterState(int code) {
		if (code == KeyEvent.VK_C) {
			gp.gameState = gp.playState;
		}
		// dodanie poruszania sie po ewkipunku
		if (code == KeyEvent.VK_W) {
			if (gp.ui.slotRow != 0) {
				gp.ui.slotRow--;
				gp.playSE(9);
			}
		}

		if (code == KeyEvent.VK_A) {
			if (gp.ui.slotCol != 0) {
				gp.ui.slotCol--;
				gp.playSE(9);
			}
		}

		if (code == KeyEvent.VK_S) {
			if (gp.ui.slotRow != 3) { 
				gp.ui.slotRow++;
				gp.playSE(9);
			}
		}

		if (code == KeyEvent.VK_D) {
			if (gp.ui.slotCol != 4) {
				gp.ui.slotCol++;
				gp.playSE(9);
			}
		}
		// dodanie wybrania ewkipunku
		if(code == KeyEvent.VK_ENTER) {
			gp.player.selectItem();
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();

		if (code == KeyEvent.VK_W) {
			upPressed = false;
		}
		if (code == KeyEvent.VK_S) {
			downPressed = false;
		}
		if (code == KeyEvent.VK_A) {
			leftPressed = false;
		}
		if (code == KeyEvent.VK_D) {
			rightPressed = false;
		}
		if (code == KeyEvent.VK_F) {
			shotKeyPressed = false;
		}
	}

}
