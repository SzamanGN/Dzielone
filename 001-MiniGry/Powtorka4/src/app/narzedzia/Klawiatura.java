package app.narzedzia;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import app.panele.PanelGry;

public class Klawiatura implements KeyListener {

	private PanelGry panelGry;
	
	
	public Klawiatura(PanelGry panelGry) {
		this.panelGry = panelGry;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			panelGry.zmienYDelta(-5);
			break;
		case KeyEvent.VK_A:
			panelGry.zmienXDelta(-5);
			break;
		case KeyEvent.VK_S:
			panelGry.zmienYDelta(5);
			break;
		case KeyEvent.VK_D:
			panelGry.zmienXDelta(5);
			break;
		}

	}		

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}