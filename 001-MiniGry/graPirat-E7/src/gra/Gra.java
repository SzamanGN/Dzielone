package gra;

import java.awt.Graphics;

import modele.Gracz;
import okna.OknoGry;
import panele.PanelGry;

public class Gra implements Runnable{

	private OknoGry oknoGry;
	private PanelGry panelGry;
	private Thread graThread;
	private final int FPS_SET =  120;
	private final int UPS_SET = 200;
	
	private Gracz gracz;
	
	public Gra() {
		initKlasy();
		panelGry = new PanelGry(this);
		oknoGry = new OknoGry(panelGry);
		panelGry.requestFocus();
		startGraPentla();
		
	}
	
	private void initKlasy() {
		gracz = new Gracz(200, 200);
	}

	private void startGraPentla() {
		graThread = new Thread(this);
		graThread.start();
	}
	
	public void aktulkizacja() {
		gracz.aktilazacja();
	}
	public void render(Graphics g) {
		gracz.render(g);
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
		gracz.resetowanieKierukow();
	}
	
	public Gracz getGracz() {
		return gracz;
	}
}
