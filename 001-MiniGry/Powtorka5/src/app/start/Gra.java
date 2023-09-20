package app.start;

import app.okna.OknoGry;
import app.panele.PanelGry;

public class Gra implements Runnable{
	
	private OknoGry oknoGry;
	private PanelGry panelGry;
	private Thread gameThread;
	private final int FPS_SET = 120;

	public Gra() {
		panelGry = new PanelGry();
		oknoGry =  new OknoGry(panelGry);
		panelGry.requestFocus();
		startPentliGra();
	}
	
	private void startPentliGra() {
		gameThread =  new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
		
		double timePerFrame = 1000000000.0 / FPS_SET;
		long lastFrame = System.nanoTime();
		long now = System.nanoTime();

		int frames = 0;
		long lastCheck = System.currentTimeMillis();

		while (true) {

			now = System.nanoTime();
			if (now - lastFrame >= timePerFrame) {
				panelGry.repaint();
				lastFrame = now;
				frames++;
			}

			if (System.currentTimeMillis() - lastCheck >= 1000) {
				lastCheck = System.currentTimeMillis();
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
	}

}
