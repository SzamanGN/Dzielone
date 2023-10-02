package gra;

import java.awt.Graphics;

import grastatus.Granie;
import grastatus.Grastatus;
import grastatus.Menu;
import modele.Gracz;
import okna.OknoGry;
import panele.PanelGry;
import poziomy.PoziomManager;

public class Gra implements Runnable {

	private OknoGry oknoGry;
	private PanelGry panelGry;
	private Thread graThread;
	private final int FPS_SET = 120;
	private final int UPS_SET = 200;

	private Granie granie;
	private Menu menu;

	public final static int plytka_domyslna_wielkosc = 32;
	public final static float scalowanie = 2f;
	public final static int plytka_in_szerokosc = 26;
	public final static int plytka_in_wysokosc = 14;
	public final static int plytka_wielkosc = (int) (plytka_domyslna_wielkosc * scalowanie);
	public final static int gra_szerkosc = plytka_wielkosc * plytka_in_szerokosc;
	public final static int gra_wysokosc = plytka_wielkosc * plytka_in_wysokosc;

	public Gra() {
		initKlasy();
		panelGry = new PanelGry(this);
		oknoGry = new OknoGry(panelGry);
		panelGry.requestFocus();

		startGraPentla();
	}

	private void initKlasy() {
		menu = new Menu(this);
		granie = new Granie(this);

	}

	private void startGraPentla() {
		graThread = new Thread(this);
		graThread.start();
	}

	public void aktulkizacja() {
		switch (Grastatus.status) {
		case MENU:
			menu.aktulizajca();
			break;
		case GRAJ:
			granie.aktulizajca();
			break;
		default:
			break;
		}

	}

	public void rysuj(Graphics g) {
		switch (Grastatus.status) {
		case MENU:
			menu.rysuj(g);
			break;
		case GRAJ:
			granie.rysuj(g);
			break;
		default:
			break;
		}
	}

	@Override
	public void run() {
		double timePerFrame = 1000000000.0 / FPS_SET;
		double timePerUpdate = 1000000000.0 / UPS_SET;

		long previousTime = System.nanoTime();

		int frames = 0;
		int updates = 0;
		long lastCheck = System.currentTimeMillis();

		double deltaU = 0;
		double deltaF = 0;

		while (true) {
			long currentTime = System.nanoTime();

			deltaU += (currentTime - previousTime) / timePerUpdate;
			deltaF += (currentTime - previousTime) / timePerFrame;
			previousTime = currentTime;

			if (deltaU >= 1) {
				aktulkizacja();
				updates++;
				deltaU--;
			}

			if (deltaF >= 1) {
				panelGry.repaint();
				frames++;
				deltaF--;
			}

			if (System.currentTimeMillis() - lastCheck >= 1000) {
				lastCheck = System.currentTimeMillis();
				System.out.println("FPS: " + frames + " | UPS: " + updates);
				frames = 0;
				updates = 0;

			}
		}

	}

	public void windowFocusLost() {
		if (Grastatus.status == Grastatus.GRAJ) {
			granie.getGracz().resetowanieKierukow();
		}
	}
	
	public Menu getMenu() {
		return menu;
	}
	
	public Granie getGranie() {
		return granie;
	}

}
