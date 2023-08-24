package modele;

import menadzery.MenadzerObrazkuGracza;
import narzedzia.Ekran;

public class Gracz extends Duszek {
	private String nazwa;
	private MenadzerObrazkuGracza obrazki;
	private boolean wRuchu;
	private boolean wPrawo; // jezli nie w prawo to w lewo

	
	public Gracz(int x, int y, int szerkosc, int wysokosc, String nazwaGracza) {
		super(x, y, szerkosc, wysokosc);
		nazwa = nazwaGracza;
		obrazki = new MenadzerObrazkuGracza(nazwaGracza);
		setObrazek(obrazki.getPrzud());
	}
	
	public void nowaGra() {
		wRuchu = false;
		setObrazek(obrazki.getPrzud());
	}

	public void zmianaGracza(String nazwaGracza) {
		obrazki.zalodowanieObrazkowGracza(nazwaGracza);
		nazwa = nazwaGracza;
	}

	public void ustawPozycje(int nowyX, int nowyY) {
		obszar.x = nowyX;
		obszar.y = nowyY;
	}
	
	private void ruchWLewo() {
		int tmp = obszar.x - 1;
		if(tmp >= 0) {
			obszar.x = tmp;
		}else {
			obszar.x = 0;
		}
	}
	private void ruchWPrawo() {
		int tmp = obszar.x + 1;
		if(tmp <= (Ekran.getSzerkosc() - obszar.width)) {
			obszar.x = tmp;
		}else {
			obszar.x = Ekran.getSzerkosc() - obszar.width;
		}
	}
	
	public void ruch() {
		if(wRuchu) {
			if(wPrawo) {
				ruchWPrawo();
			}else {
				ruchWLewo();
			}
		}
	}
	
	public void ustawRuchWPrawo() {
		setObrazek(obrazki.getPrawo());
		wPrawo = true;
		wRuchu = true;
	}
	
	public void ustawRuchWLewo() {
		setObrazek(obrazki.getLewo());
		wPrawo = false;
		wRuchu = true;
	}
	
	public void wylaczRuch() {
		setObrazek(obrazki.getPrzud());
		wRuchu = false;
	}
	public String getNazwa() {
		return nazwa;
	}
}
