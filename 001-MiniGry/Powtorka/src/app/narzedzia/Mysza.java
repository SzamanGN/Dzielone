package app.narzedzia;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import app.panele.PanelGry;

public class Mysza implements MouseListener, MouseMotionListener {
	
	private PanelGry panelGry;
	
	public Mysza(PanelGry panelGry) {
		this.panelGry = panelGry;
	}

	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		panelGry.ustawKwadratPozycje(e.getX(), e.getY());
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		panelGry.pojawienieRec(e.getX(), e.getY());
		
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
