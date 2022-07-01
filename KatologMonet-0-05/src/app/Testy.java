package app;

import app.monety.Moneta;

public class Testy {
	public Testy() {
		System.out.println("Star testu : ");
		
		Moneta moneta = new Moneta();
		moneta.ustaw("2 zl", 1990, "Polska");
		moneta.opis();
		
		System.out.println("Koniec testu : ");
	}

}
