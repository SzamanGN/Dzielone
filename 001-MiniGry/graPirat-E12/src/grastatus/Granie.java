package grastatus;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import gra.Gra;
import modele.Gracz;
import poziomy.PoziomManager;

public class Granie extends Status implements Statusmetod {

	private Gracz gracz;
	private PoziomManager poziomManager;

	public Granie(Gra gra) {
		super(gra);
		initKlasy();

	}

	private void initKlasy() {
		poziomManager = new PoziomManager(gra);
		gracz = new Gracz(200, 200, (int) (64 * Gra.scalowanie), (int) (40 * Gra.scalowanie));
		gracz.laduPozData(poziomManager.getWybranyPoziom().getPozData());
	}

	@Override
	public void aktulizajca() {
		poziomManager.aktulizacja();
		gracz.aktilazacja();
	}

	@Override
	public void rysuj(Graphics g) {
		poziomManager.rysuj(g);
		gracz.rysuj(g);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			gracz.ustawAtak(true);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
	
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_A:
			gracz.setLewo(true);
			break;
		case KeyEvent.VK_D:
			gracz.setPrawo(true);
			break;
		case KeyEvent.VK_SPACE:
			gracz.setSkok(true);
			break;
		case KeyEvent.VK_BACK_SPACE:
			Grastatus.status = Grastatus.MENU;
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_A:
			gracz.setLewo(false);
			break;
		case KeyEvent.VK_D:
			gracz.setPrawo(false);
			break;
		case KeyEvent.VK_SPACE:
			gracz.setSkok(false);
			break;
		}
	}

	public void windowFocusLost() {
		gracz.resetowanieKierukow();
	}

	public Gracz getGracz() {
		return gracz;
	}
}
