package kontrolery;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import grastatus.Grastatus;
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
		switch (Grastatus.status) {
		case MENU:
			panelGry.getGra().getMenu().keyPressed(e);
			break;
		case GRAJ:
			panelGry.getGra().getGranie().keyPressed(e);
			break;
			default:
				break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (Grastatus.status) {
		case MENU:
			panelGry.getGra().getMenu().keyReleased(e);
			break;
		case GRAJ:
			panelGry.getGra().getGranie().keyReleased(e);
			break;
			default:
				break;
		}
	}
}
