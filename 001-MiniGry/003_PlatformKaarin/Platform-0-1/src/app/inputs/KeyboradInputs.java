package app.inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static app.utliz.Constans.Directions.*;
import app.panele.GamePanel;

public class KeyboradInputs implements KeyListener {

	private GamePanel gamePanel;

	public KeyboradInputs(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			// System.out.println("Press W");
			gamePanel.getGame().getPlayer().setUp(true);
			break;
		case KeyEvent.VK_A:
			// System.out.println("Press A");
			gamePanel.getGame().getPlayer().setLeft(true);
			break;
		case KeyEvent.VK_S:
			// System.out.println("Press S");
			gamePanel.getGame().getPlayer().setDown(true);
			break;
		case KeyEvent.VK_D:
			// System.out.println("Press D");
			gamePanel.getGame().getPlayer().setRight(true);
			break;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// System.out.println("key A is pres");
		// dodanie przyciskow i casow

//		switch (e.getKeyCode()) {
//		case KeyEvent.VK_W:
//			// System.out.println("Press W");
//			//gamePanel.setDirection(UP);
//			//break;
//		case KeyEvent.VK_A:
//			// System.out.println("Press A");
//			//gamePanel.setDirection(LEFT);
//			//break;
//		case KeyEvent.VK_S:
//			// System.out.println("Press S");
//			//gamePanel.setDirection(DOWN);
//			//break;
//		case KeyEvent.VK_D:
//			// System.out.println("Press D");
//			//gamePanel.setDirection(RIGHT);
//			gamePanel.getGame().getPlayer().setMoving(false);
//			break;
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			// System.out.println("Press W");
			gamePanel.getGame().getPlayer().setUp(false);
			break;
		case KeyEvent.VK_A:
			// System.out.println("Press A");
			gamePanel.getGame().getPlayer().setLeft(false);
			break;
		case KeyEvent.VK_S:
			// System.out.println("Press S");
			gamePanel.getGame().getPlayer().setDown(false);
			break;
		case KeyEvent.VK_D:
			// System.out.println("Press D");
			gamePanel.getGame().getPlayer().setRight(false);
			break;

		}

	}
}

