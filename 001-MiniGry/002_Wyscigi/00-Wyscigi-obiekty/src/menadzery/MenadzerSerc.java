package menadzery;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;

import modele.Serce;
import narzedzia.Ekran;

public class MenadzerSerc {
	
	private ArrayList<Serce> wykaz;
	private Image obrazekSerca;
	
	public MenadzerSerc(Image obrazekSerca) {
		wykaz = new ArrayList<Serce>();
		this.obrazekSerca = obrazekSerca;
	}

	public void dodawanieSerc(int x) {
		wykaz.add(new Serce(x));
	}
	
	public void ruch() {
		if(!wykaz.isEmpty()) {
			Iterator<Serce> iter = wykaz.iterator();
			Serce s;
			while(iter.hasNext()) {
				s = iter.next();
				s.ruch();
				if(!Ekran.getObszar().intersects(s.getObszar())) {
					iter.remove();
				}
			}
		}
	}

	
	
	public void draw(Graphics g) {
		if(!wykaz.isEmpty()) {
			wykaz.forEach( (s) -> s.draw(g, obrazekSerca));
		}
	}
	
	public boolean isKolizja(Rectangle gracza) {
		boolean wynik = false;
		if(!wykaz.isEmpty()) {
			Serce s;
			Iterator<Serce> iter = wykaz.iterator();
			while(iter.hasNext()) {
				s = iter.next();
				if(s.getObszar().intersects(gracza)) {
					wynik = true;
					iter.remove();
				}
			}
		}
		return wynik;
	}	
	
	public void czysc() {
		wykaz.clear();
	}
}

