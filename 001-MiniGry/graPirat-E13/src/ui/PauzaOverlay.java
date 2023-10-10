package ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import dodatki.LadowanieZapis;
import gra.Gra;
import grastatus.Granie;
import grastatus.Status.*;
import grastatus.Grastatus;
import static dodatki.Stale.UI.PauzaPrzyciski.*;
import static dodatki.Stale.UI.URMPRzyciski.*;
import static dodatki.Stale.UI.GlosnoscPrzyciski.*;

public class PauzaOverlay {
	
	private Granie granie;
	private BufferedImage obrazTlo;
	private int obX, obY, obS, obW;
	private DzwiekPrzycisk muzykaPrzycisk, sfxPrzycisk;
	private UrmPrzycisk menuP, powtorkaP, unPauzaP;
	private GlosnoscPrzycisk glosnoscPrzycisk;
	
	public PauzaOverlay (Granie granie) {
		this.granie = granie;
		ladowanieTla();
		tworzenieDzwiekPrzyciskow();
		tworzenieUrmPrzyciskow();
		tworzenieGlosnoscPrzycisku();
	}

	private void tworzenieGlosnoscPrzycisku() {
		int vX = (int) (309 * Gra.scalowanie);
		int vY = (int) (278 * Gra.scalowanie);
		
		glosnoscPrzycisk = new GlosnoscPrzycisk(vX, vY, SUWAK_SZEROKOSC, GLOSNOSC_WYSOKOSC);
	}

	private void tworzenieUrmPrzyciskow() {
		int menuX = (int) (313 * Gra.scalowanie);
		int replayX = (int) (387 * Gra.scalowanie);
		int unpauseX = (int) (462 * Gra.scalowanie);
		int pY = (int) (325 * Gra.scalowanie);
		
		menuP = new UrmPrzycisk(menuX, pY, URM_WIELKOSC, URM_WIELKOSC, 2);
		powtorkaP = new UrmPrzycisk( replayX, pY, URM_WIELKOSC, URM_WIELKOSC, 1);
		unPauzaP = new UrmPrzycisk( unpauseX, pY, URM_WIELKOSC, URM_WIELKOSC, 0);
	}

	private void tworzenieDzwiekPrzyciskow() {
		int soundX = (int) (450 * Gra.scalowanie);
		int musicY = (int) (140 * Gra.scalowanie);
		int sfxY = (int) (186 * Gra.scalowanie);
		
		muzykaPrzycisk = new DzwiekPrzycisk(soundX, musicY, DZWIEK_WIELKOSC, DZWIEK_WIELKOSC);
		sfxPrzycisk = new DzwiekPrzycisk(soundX, sfxY, DZWIEK_WIELKOSC, DZWIEK_WIELKOSC);
	}

	private void ladowanieTla() {
		obrazTlo = LadowanieZapis.GetDuszekAtlas(LadowanieZapis.PAUZA_TLO);
		obS = (int) (obrazTlo.getWidth() * Gra.scalowanie);
		obW = (int) (obrazTlo.getHeight() * Gra.scalowanie);
		obX = Gra.gra_szerkosc / 2 - obS / 2;
		obY = (int) (25 * Gra.scalowanie);
	}

	public void aktualizacja() {
		
		muzykaPrzycisk.aktualizacja();
		sfxPrzycisk.aktualizacja();
		
		menuP.aktuliazjca();
		powtorkaP.aktuliazjca();
		unPauzaP.aktuliazjca();
		
		glosnoscPrzycisk.aktualizacja();
	}
	
	public void rysuj(Graphics g) {
		// tlo
		g.drawImage(obrazTlo, obX, obY,obS ,obW, null);
		
		// dzwiek przyimport grastatus.ciski
		muzykaPrzycisk.rysuj(g);
		sfxPrzycisk.rysuj(g);
		
		// urm przyciski
		menuP.rysuj(g);
		powtorkaP.rysuj(g);
		unPauzaP.rysuj(g);
		
		// glosnosc
		glosnoscPrzycisk.rysuj(g);
	}
	
	public void mouseDragged(MouseEvent e) {
		if (glosnoscPrzycisk.isMousePressed()) {
			glosnoscPrzycisk.zmianaX(e.getX());
		}
	}
	
	public void mousePressed(MouseEvent e) {
		if (jestW(e, muzykaPrzycisk)) {
			muzykaPrzycisk.setMousePressed(true);
		} else if (jestW(e, sfxPrzycisk)) {
			sfxPrzycisk.setMousePressed(true);
		} else if (jestW(e, menuP)) {
			menuP.setMousePressed(true);
		} else if (jestW(e, powtorkaP)) {
			powtorkaP.setMousePressed(true);
		} else if (jestW(e, unPauzaP)) {
			unPauzaP.setMousePressed(true);
		} else if (jestW(e, glosnoscPrzycisk)) {
			glosnoscPrzycisk.setMousePressed(true);
		}
	}
	
	public void mouseReleased(MouseEvent e) {
		if (jestW(e, muzykaPrzycisk)) {
			if (muzykaPrzycisk.isMousePressed()) {
				muzykaPrzycisk.setWycisz(!muzykaPrzycisk.isWycisz());
			}
		} else if (jestW(e, sfxPrzycisk)) {
			if (sfxPrzycisk.isMousePressed()) {
				sfxPrzycisk.setWycisz(!sfxPrzycisk.isWycisz());
			}
		} else if (jestW(e, menuP)) {
			if (menuP.isMousePressed()) {
				Grastatus.status = Grastatus.MENU;
				granie.pauzaGry();
			}
		} else if (jestW(e, powtorkaP)) {
			if (powtorkaP.isMousePressed()) {
				System.out.println("Powtorz poziom!");
			}
		} else if (jestW(e, unPauzaP)) {
			if (unPauzaP.isMousePressed()) {
				granie.pauzaGry();
			}
		}
		
		muzykaPrzycisk.resetMyszy();
		sfxPrzycisk.resetMyszy();
		menuP.resetMyszki();
		powtorkaP.resetMyszki();
		unPauzaP.resetMyszki();
		glosnoscPrzycisk.resetMyszy();
	}
	
	public void mouseMoved(MouseEvent e) {
		muzykaPrzycisk.setMouseOver(false);
		sfxPrzycisk.setMouseOver(false);
		menuP.setMouseOver(false);
		powtorkaP.setMouseOver(false);
		unPauzaP.setMouseOver(false);
		glosnoscPrzycisk.setMouseOver(false);
		
		if (jestW(e, muzykaPrzycisk)) {
			muzykaPrzycisk.setMouseOver(true);
		} else if (jestW(e, sfxPrzycisk)) {
			sfxPrzycisk.setMouseOver(true);
		} else if (jestW(e, menuP)) {
			menuP.setMouseOver(true);
		} else if (jestW(e, powtorkaP)) {
			powtorkaP.setMouseOver(true);
		} else if (jestW(e, unPauzaP)) {
			unPauzaP.setMouseOver(true);
		} else if (jestW(e, glosnoscPrzycisk)) {
			glosnoscPrzycisk.setMouseOver(true);
		}
	}
	
	private boolean jestW(MouseEvent e,PauzaPrzycisk p ) {
		return p.getBounds().contains(e.getX(), e.getY());
	}
}
