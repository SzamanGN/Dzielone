package menadzery;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;

import modele.Przeszkoda;
import narzedzia.Ekran;

public class MenadzerPrzeszkod {
	
	private ArrayList<Przeszkoda> wykaz;
	private Image obrazekPrzeszkody;

	public MenadzerPrzeszkod(Image obrazekPrzeszkody) {
		wykaz = new ArrayList<Przeszkoda>();
		this.obrazekPrzeszkody = obrazekPrzeszkody;
		
	}
	
	public void doadawaniePrzeszkody(int x) {
		wykaz.add(new Przeszkoda(x));
	}
	
	public void ruch() {
		if(!wykaz.isEmpty()) {
			//wykaz.forEach((p) -> p.ruch());
			Iterator<Przeszkoda> iter = wykaz.iterator();
			Przeszkoda p;
			while(iter.hasNext()) {
				p = iter.next();
				p.ruch();
				// czy nasz obiekt jest w ekranie lub sie styka
				if(!Ekran.getObszar().intersects(p.getObszar())) {
					iter.remove();
				}
			}
		}
	}
	
	public void czysc() {
		wykaz.clear();
	}
	
	public void draw(Graphics g) {
		if(!wykaz.isEmpty()) {
			wykaz.forEach((p) -> p.draw(g, obrazekPrzeszkody));
		}
		
	}
	
	public boolean isKolizja(Rectangle gracza) {
		boolean wynik = false;
		if(!wykaz.isEmpty()) {
			Przeszkoda p;
			Iterator<Przeszkoda> iter = wykaz.iterator();
			while(iter.hasNext()) {
				p = iter.next();
				if(p.getObszar().intersects(gracza)) {
					wynik = true;
					iter.remove();
				}
			}
			
		}
		return wynik;	
	}
}
