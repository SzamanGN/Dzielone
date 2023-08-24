package menadzery;

import java.awt.Image;
import java.util.ArrayList;

import narzedzia.Obrazek;

public class MenadzerObrazkuGracza {
	
	private ArrayList<Image> wykaz;
	
	public MenadzerObrazkuGracza(String nazwaGracza) {
		wykaz = new ArrayList<Image>();
		zalodowanieObrazkowGracza(nazwaGracza);
	}

	public void zalodowanieObrazkowGracza(String nazwaGracza) {
		wykaz.clear();
		wykaz.add(Obrazek.ladowanie(nazwaGracza + "Przud"));
		wykaz.add(Obrazek.ladowanie(nazwaGracza + "Prawa"));
		wykaz.add(Obrazek.ladowanie(nazwaGracza + "Lewa"));
	}
	
	public Image getPrzud() {
		return wykaz.get(0);
	}
	
	public Image getPrawo() {
		return wykaz.get(1);
	}
	
	public Image getLewo() {
		return wykaz.get(2);
	}

}
