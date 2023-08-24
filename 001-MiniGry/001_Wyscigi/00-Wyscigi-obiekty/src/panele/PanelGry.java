package panele;

import javax.swing.JPanel;

import enumy.StanGry;
import menadzery.MenadzerPrzeszkod;
import modele.Gracz;
import modele.Zycie;
import narzedzia.Ekran;
import narzedzia.Generator;
import narzedzia.NowyKamien;
import narzedzia.Obrazek;
import narzedzia.Zegar;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class PanelGry extends JPanel {
	
	private StanGry stanGry;
	private Gracz gracz;
	private boolean gotowyDoRysowania;
	private MenadzerPrzeszkod kamienie;
	private NowyKamien nowyKamien;
	private Zycie zycie;
	private boolean koniecGry;
	

	public PanelGry() {
		gracz = new Gracz(100, 100, 100, 120, "Bartek");
		setBackground(new Color(0, 0, 0));
		setLayout(null);
		koniecGry = false;
		kamienie = new MenadzerPrzeszkod(Obrazek.ladowanie("Kamien"));
		nowyKamien = new NowyKamien();
		zycie = new Zycie();
		stanGry = StanGry.Nowa;
		gotowyDoRysowania = true;
		new Thread(new Zegar(this)).start();

	}
	
	public void zmienGracza(String string) {
		if(stanGry == StanGry.Nowa) {
			gracz.zmianaGracza(string);
			incjowanieNowejGry();
		}
		
	}
	
	private void incjowanieNowejGry() {
		gracz.ustawPozycje(
				(Ekran.getSzerkosc() - 100) / 2,
				Ekran.getWysokosc() - 120
				);
		gracz.nowaGra();
		kamienie.czysc();
		//kamienie.doadawaniePrzeszkody(100);// dodanie testowego kamienia
		zycie.ustaw(3);
		stanGry = StanGry.Aktywna;
		koniecGry = false;
	}
	public void pokazKoniecGry(Graphics g) {
		g.setFont(new Font("Tahoma", Font.BOLD, 28));
		g.setColor(Color.YELLOW);
		g.drawString(
				gracz.getNazwa() + "! Koniec Gry!", 200, 80);
		
	}
	
	private void pokazWyborGracza(Graphics g) {
		if(koniecGry) {
			pokazKoniecGry(g);
		}
		g.setFont(new Font("Tahoma", Font.BOLD, 22));
		g.setColor(Color.ORANGE);
		g.drawString(
				"Wybierz gracza: ", 200, 100);
		g.drawString("B - Gracz Bartek", 200, 130);
		g.drawString("O - Gracz Oliwia", 200, 150);
	}
	
	private void rysowanieSytuacji(Graphics g) {
		// dodanie nowego przeciwnika
		if(nowyKamien.isNowyKamien()) {
			kamienie.doadawaniePrzeszkody(
					Generator.losowaZ(Ekran.getSzerkosc()- 80));
		}
		// wykonanie ruchu
		gracz.ruch();
		kamienie.ruch();
		// detekcja kolizji
		if(kamienie.isKolizja(gracz.getObszar())) {
			System.out.println("Kolizja");
			zycie.traci();
			if(zycie.isZyje()) {	
				// zmiejszona ilosc zyc
			}else {
				stanGry = StanGry.Koniec;
			}
		}
		// rysowanie gracza 
		gracz.draw(g);
		// rysowanie przecinikow
		kamienie.draw(g);
		// rysowanie zycia
		zycie.draw(g);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		gotowyDoRysowania = false;
		
		switch(stanGry) {
			case Nowa:
				// nowa gra.
				//System.out.println("Wybor gracza");
				pokazWyborGracza(g);
				break;
			case Koniec:
				// koniec gry
				koniecGry = true;
				stanGry = StanGry.Nowa;
				break;
			default:
				// rysowanie sytuacji
				rysowanieSytuacji(g);
				break;
		}
		
		gotowyDoRysowania = true;
	}

	public void odswiez() {
		if(gotowyDoRysowania) {
			repaint();
		}
	}

	// obsluga ruchu gracza
	
	public void ustawRuchGraczaWPrawo() {
		if(stanGry == StanGry.Aktywna) {
			gracz.ustawRuchWPrawo();
		}
	}

	public void ustawRuchGraczaWLewo() {
		if(stanGry == StanGry.Aktywna) {
			gracz.ustawRuchWLewo();
		}	
	}

	public void zakonczRuchGracz() {
		if(stanGry == StanGry.Aktywna) {
			gracz.wylaczRuch();
		}
	}
}
