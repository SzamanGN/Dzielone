package kontrolery;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import panele.PanelGry;
import static dodatki.GraczStale.Kierunek.*;

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
				panelGry.getGra().getGracz().setGora(true);
				break;
			case KeyEvent.VK_A:
				panelGry.getGra().getGracz().setLewo(true);
				break;
			case KeyEvent.VK_S:
				panelGry.getGra().getGracz().setDol(true);
				break;
			case KeyEvent.VK_D:
				panelGry.getGra().getGracz().setPrawo(true);
				break;
			case KeyEvent.VK_SPACE:
				panelGry.getGra().getGracz().setSkok(true);
				break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_W:
				panelGry.getGra().getGracz().setGora(false);
				break;
			case KeyEvent.VK_A:
				panelGry.getGra().getGracz().setLewo(false);
				break;
			case KeyEvent.VK_S:
				panelGry.getGra().getGracz().setDol(false);
				break;
			case KeyEvent.VK_D:
				panelGry.getGra().getGracz().setPrawo(false);
				break;
			case KeyEvent.VK_SPACE:
				panelGry.getGra().getGracz().setSkok(false);
				break;
		}
	}

}
