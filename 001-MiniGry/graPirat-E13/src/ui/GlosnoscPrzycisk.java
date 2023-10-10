package ui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.peer.MouseInfoPeer;

import dodatki.LadowanieZapis;

import static dodatki.Stale.UI.GlosnoscPrzyciski.*;

public class GlosnoscPrzycisk extends PauzaPrzycisk {

	private BufferedImage[] obr;
	private BufferedImage suwak;
	private int index = 0;
	private boolean mouseOver, mousePressed;
	private int przyciskX, minX, maxX;

	public GlosnoscPrzycisk(int x, int y, int szerkosc, int wysokosc) {
		super(x + szerkosc / 2, y, GLOSNOSC_SZEROKOSC, wysokosc);
		bounds.x -= GLOSNOSC_SZEROKOSC / 2;
		przyciskX = x + szerkosc / 2;
		this.x = x;
		this.szerkosc = szerkosc;
		minX = x + GLOSNOSC_SZEROKOSC / 2;
		maxX = x + szerkosc - GLOSNOSC_SZEROKOSC / 2;
		ladowanieObrazow();
	}

	private void ladowanieObrazow() {
		BufferedImage temp = LadowanieZapis.GetDuszekAtlas(LadowanieZapis.GOLOSNOSC_PRZYCISKI);
		obr = new BufferedImage[3];
		for (int i = 0; i < obr.length; i++) {
			obr[i] = temp.getSubimage(i * GLOSNOSC_DOMYSLNIE_SZEROKOSC, 0, GLOSNOSC_DOMYSLNIE_SZEROKOSC,
					GLOSNOSC_DOMYSLNIE_WYSOKOSC);
			suwak = temp.getSubimage(3 * GLOSNOSC_DOMYSLNIE_SZEROKOSC, 0, SUWAK_DOMYSLNIE_SZEROKOSC,
					GLOSNOSC_DOMYSLNIE_WYSOKOSC);
		}
	}

	public void aktualizacja() {
		index = 0;
		if (mouseOver) {
			index = 0;
		}

		if (mousePressed) {
			index = 2;
		}
	}

	public void rysuj(Graphics g) {
		g.drawImage(suwak, x, y, szerkosc, wysokosc, null);
		g.drawImage(obr[index], przyciskX - GLOSNOSC_SZEROKOSC / 2, y, GLOSNOSC_SZEROKOSC, wysokosc, null);
	}

	public void zmianaX(int x) {
		if (x < minX) {
			przyciskX = minX;
		} else if (x > maxX) {
			przyciskX = maxX;
		} else {
			bounds.x = przyciskX - GLOSNOSC_SZEROKOSC / 2;
		}
	}

	public void resetMyszy() {
		mouseOver = false;
		mousePressed = false;
	}

	public boolean isMouseOver() {
		return mouseOver;
	}

	public void setMouseOver(boolean mouseOver) {
		this.mouseOver = mouseOver;
	}

	public boolean isMousePressed() {
		return mousePressed;
	}

	public void setMousePressed(boolean mousePressed) {
		this.mousePressed = mousePressed;
	}
	
	
}
