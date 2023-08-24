package app.inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.event.MouseInputListener;

import app.panele.GamePanel;

public class MouseInputs implements MouseInputListener,MouseMotionListener{

	private GamePanel gamePanel;
	
	public MouseInputs(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		//System.out.println("Mouse Clik");
		if(e.getButton() == MouseEvent.BUTTON1) {
			gamePanel.getGame().getPlayer().setAttacking(true);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		//System.out.println("Mouse Moved");
		//gamePanel.setRectPos(e.getX(), e.getY());
		//gamePanel.setRectPos(e.getX(), e.getY());
		
	}

}
