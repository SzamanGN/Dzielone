package ui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import dodatki.LadowanieZapis;
import grastatus.Grastatus;
import static dodatki.Stale.UI.Przyciski.*;

public class MenuPrzyciski {
	
	private int xPoz, yPoz, rowIndex, index;
	private int xOffSierodek = P_SZEROKOSC /2;
	private Grastatus status;
	private BufferedImage[] obraz;
	private boolean mouseOver, mousePressed;
	private Rectangle bounds;
	
	public MenuPrzyciski(int xPoz, int yPoz, int rowIndex, Grastatus status) {
		this.xPoz = xPoz;
		this.yPoz = yPoz;
		this.rowIndex =  rowIndex;
		this.status = status;
		
		ladowanieObrazkow();
		initBounds();
	}

	private void initBounds() {
		bounds =  new Rectangle(xPoz - xOffSierodek, yPoz, P_SZEROKOSC, P_WYSOKOSC);
	}

	private void ladowanieObrazkow() {
		obraz = new BufferedImage[3];
		BufferedImage tmp = LadowanieZapis.GetDuszekAtlas(LadowanieZapis.MENU_PRZYCISKI);
		for (int i = 0; i < obraz.length; i++) {
			obraz[i] = tmp.getSubimage(i * P_SZEROKOSC_DOMYSLNA , rowIndex * P_WYSOKOSC_DOMYSLNA, P_SZEROKOSC_DOMYSLNA, P_WYSOKOSC_DOMYSLNA);
		}
	}

	public void rysuj(Graphics g) {
		g.drawImage(obraz[index], xPoz -xOffSierodek, yPoz, P_SZEROKOSC, P_WYSOKOSC, null);
	}
	
	public void aktuliazjca() {
		index = 0;
		if (mouseOver) {
			index = 1;
		}
		if (mousePressed) {
			index = 1;
		}
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
	
	public Rectangle getBounds() {
		return bounds;
	}
	
	public void zatwiedzGraStatus() {
		Grastatus.status = status;
	}
	
	public void resetujMysz() {
		mouseOver =  false;
		mousePressed =  false;
	}
	
}
