package kontrolery;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import grastatus.Grastatus;
import panele.PanelGry;

public class Myszka implements MouseListener, MouseMotionListener {

	private PanelGry panelGry;

	public Myszka(PanelGry panelGry) {
		this.panelGry = panelGry;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		switch (Grastatus.status) {
		case GRAJ:
			panelGry.getGra().getGranie().mouseDragged(e);
			break;
		default:
			break;
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		switch (Grastatus.status) {
		case MENU:
			panelGry.getGra().getMenu().mouseMoved(e);
			break;
		case GRAJ:
			panelGry.getGra().getGranie().mouseMoved(e);
			break;
		default:
			break;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		switch (Grastatus.status) {
		case GRAJ:
			panelGry.getGra().getMenu().mouseClicked(e);
			break;
		default:
			break;
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		switch (Grastatus.status) {
		case MENU:
			panelGry.getGra().getMenu().mousePressed(e);
			break;
		case GRAJ:
			panelGry.getGra().getGranie().mousePressed(e);
			break;
		default:
			break;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		switch (Grastatus.status) {
		case MENU:
			panelGry.getGra().getMenu().mouseReleased(e);
			break;
		case GRAJ:
			panelGry.getGra().getGranie().mouseReleased(e);
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
		// TODO Auto-generated method stub

	}

}
