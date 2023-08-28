package inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import gamesteats.Gamestate;
import main.GamePanel;
import ui.MenuButton;
import ui.MenuButton.*;

public class MouseInputs implements MouseListener, MouseMotionListener {

	private GamePanel gamePanel;

	public MouseInputs(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		switch(Gamestate.state) {
		case MENU:
			gamePanel.getGame().getMenu().mouseMoved(e);
			break;
		case PLAYING:
			gamePanel.getGame().getPlaying().mouseMoved(e);
			break;
		default:
			break;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		switch(Gamestate.state) {
//		case MENU:
//			gamePanel.getGame().getMenu().mouseCliked(e);
//			break;
		case PLAYING:
			gamePanel.getGame().getPlaying().mouseCliked(e);
			break;
		default:
			break;
		
		}
	
	}

	@Override
	public void mousePressed(MouseEvent e) {
		switch(Gamestate.state) {
		case MENU:
			gamePanel.getGame().getMenu().mousePressed(e);
			break;
		case PLAYING:
			gamePanel.getGame().getPlaying().mousePressed(e);
			break;
		default:
			break;
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		switch(Gamestate.state) {
		case MENU:
			gamePanel.getGame().getMenu().mouseReleased(e);
			break;
		case PLAYING:
			gamePanel.getGame().getPlaying().mouseReleased(e);
			break;
		default:
			break;
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

}
