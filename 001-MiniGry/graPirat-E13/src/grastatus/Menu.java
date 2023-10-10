package grastatus;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import dodatki.LadowanieZapis;
import gra.Gra;
import ui.MenuPrzyciski;

public class Menu extends Status implements Statusmetod {

	private MenuPrzyciski[] przyciski = new MenuPrzyciski[3];
	private BufferedImage obrazMenu;
	private int menuX, menuY, menuSzerekosc, menuWysokosc;

	public Menu(Gra gra) {
		super(gra);
		ladowaniePrzyciskow();
		ladowanieTlaMenu();
	}

	private void ladowanieTlaMenu() {
		obrazMenu =  LadowanieZapis.GetDuszekAtlas(LadowanieZapis.MENU_TLO);
		menuSzerekosc = (int) (obrazMenu.getWidth() * Gra.scalowanie);
		menuWysokosc = (int) (obrazMenu.getHeight() * Gra.scalowanie);
		menuX =  Gra.gra_szerkosc / 2 - menuSzerekosc / 2;
		menuY = (int) (45 * Gra.scalowanie);
	}

	private void ladowaniePrzyciskow() {
		przyciski[0] = new MenuPrzyciski(Gra.gra_szerkosc / 2, (int) (150 * Gra.scalowanie), 0, Grastatus.GRAJ);
		przyciski[1] = new MenuPrzyciski(Gra.gra_szerkosc / 2, (int) (220 * Gra.scalowanie), 1, Grastatus.OPCJE);
		przyciski[2] = new MenuPrzyciski(Gra.gra_szerkosc / 2, (int) (290 * Gra.scalowanie), 2, Grastatus.WYJDZ);
	}

	@Override
	public void aktulizajca() {
		for (MenuPrzyciski mp : przyciski) {
			mp.aktuliazjca();
		}
	}

	@Override
	public void rysuj(Graphics g) {
		
		g.drawImage(obrazMenu, menuX, menuY, menuWysokosc, menuSzerekosc, null);

		for (MenuPrzyciski mp : przyciski) {
			mp.rysuj(g);
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		for (MenuPrzyciski mp : przyciski) {
			if (jestW(e, mp)) {
				mp.setMousePressed(true);
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		for (MenuPrzyciski mp : przyciski) {
			if (jestW(e, mp)) {
				if (mp.isMousePressed()) {
					mp.zatwiedzGraStatus();
				}
				break;
			}
		}
		resetPrzyciskow();
	}
	
	public void resetPrzyciskow() {
		for (MenuPrzyciski mp : przyciski) {
			mp.resetujMysz();
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		for (MenuPrzyciski mp : przyciski) {
			mp.setMouseOver(false);
		}
		for (MenuPrzyciski mp : przyciski) {
			if (jestW(e, mp)) {
				mp.setMouseOver(true);
				break;
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			Grastatus.status = Grastatus.GRAJ;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
