package ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import dodatki.LadowanieZapis;
import static dodatki.Stale.UI.URMPRzyciski.*;

public class UrmPrzycisk extends PauzaPrzycisk{
	
	private BufferedImage[] obr;
	private int rowIndex, index;
	private boolean mouseOver, mousePressed;
	

	public UrmPrzycisk(int x, int y, int szerkosc, int wysokosc, int rowIndex) {
		super(x, y, szerkosc, wysokosc);
		this.rowIndex = rowIndex;
		ladujObrazy();
	}


	private void ladujObrazy() {
		BufferedImage temp = LadowanieZapis.GetDuszekAtlas(LadowanieZapis.URM_PRZYCISKI);
		obr = new BufferedImage[3];
		for (int i = 0; i < obr.length; i ++) {
			obr[i] = temp.getSubimage(i * URM_WIELKOSC_DOMYSLNA, rowIndex * URM_WIELKOSC_DOMYSLNA, URM_WIELKOSC_DOMYSLNA, URM_WIELKOSC_DOMYSLNA);
		}
	}
	
	public void aktuliazjca() {
		index = 0;
		if (mouseOver) {
			index = 1;
		}
		if (mousePressed) {
			index = 2;
		}
	}

	public void rysuj(Graphics g) {
		g.drawImage(obr[index], x, y, URM_WIELKOSC, URM_WIELKOSC, null);
	}
	
	public void resetMyszki() {
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
