package ui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import dodatki.LadowanieZapis;
import static dodatki.Stale.UI.PauzaPrzyciski.*;

public class DzwiekPrzycisk extends PauzaPrzycisk{
	
	private BufferedImage[][] dzwiekObr;
	private boolean mouseOver, mousePressed;
	private boolean wycisz;
	private int rowIndex, colIndex;

	public DzwiekPrzycisk(int x, int y, int szerkosc, int wysokosc) {
		super(x, y, szerkosc, wysokosc);
		
		ladujDzwiekObr();
	}

	private void ladujDzwiekObr() {
		BufferedImage temp = LadowanieZapis.GetDuszekAtlas(LadowanieZapis.DZWIEK_PRZYCISKI);
		dzwiekObr = new BufferedImage[2][3];
		for(int j = 0; j < dzwiekObr.length; j++) {
			for (int i = 0; i < dzwiekObr[j].length; i++) {
				dzwiekObr[j][i] = temp.getSubimage(i * DZWIEK_WIELKOSC_DOMYSLNA , j * DZWIEK_WIELKOSC_DOMYSLNA, DZWIEK_WIELKOSC_DOMYSLNA, DZWIEK_WIELKOSC_DOMYSLNA);
			}
		}
	}
	
	public void aktualizacja() {
		if (wycisz) {
			rowIndex = 1;
		} else {
			rowIndex = 0;
		}
		
		colIndex = 0;
		if(mouseOver) {
			colIndex = 1;
		}
		if(mousePressed) {
			colIndex = 2;
		}
		
	}
	
	
	public void resetMyszy() {
		mouseOver = false;
		mousePressed = false;
	}
	
	public void rysuj(Graphics g) {
		g.drawImage(dzwiekObr[rowIndex][colIndex], x, y, szerkosc, wysokosc, null);
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

	public boolean isWycisz() {
		return wycisz;
	}

	public void setWycisz(boolean wycisz) {
		this.wycisz = wycisz;
	}

}
