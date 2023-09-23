package narzedzia;

import panele.PanelGry;

public class Zegar implements Runnable{
	
	private long czasZakonczenia;
	private long aktulanyCzas;
	private int opoznienie;
	private PanelGry panelGry;

	public Zegar(PanelGry panelGry) {
		this.panelGry = panelGry;
		opoznienie = 50;
		czasZakonczenia = System.currentTimeMillis() + opoznienie;
	}
	private void czekaj() {
		do {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			aktulanyCzas = System.currentTimeMillis();
		} while (aktulanyCzas >= czasZakonczenia);
		czasZakonczenia = aktulanyCzas + opoznienie;
	}
	
	@Override
	public void run() {
		while(true) {
			czekaj();
			// odswiezenie pane;u gry
			panelGry.odswiez();
		}
	}
	

}
