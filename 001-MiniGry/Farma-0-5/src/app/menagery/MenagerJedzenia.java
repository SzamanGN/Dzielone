package app.menagery;

import java.util.ArrayList;
import app.modele.Jedzenie;

public class MenagerJedzenia {

	private ArrayList<Jedzenie> wykaz;
	
	public MenagerJedzenia() {
		wykaz = new ArrayList<Jedzenie>();
	}
	
	public void add(int rodzaj, int ilosc) {
		wykaz.add(new Jedzenie(rodzaj, ilosc));
	}
	
	public int getILosc() {
		return wykaz.size();
	}
	
	public Jedzenie get(int ktore) {
		return wykaz.get(ktore);
	}
}
