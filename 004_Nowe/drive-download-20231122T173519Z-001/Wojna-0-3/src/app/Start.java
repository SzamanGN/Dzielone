package app;

import app.modele.Gracz;
import app.modele.Terytorium;

public class Start {

	public static void main(String[] args) {
		System.out.println("Test wojny-0-3");

		Gracz gracz1 = new Gracz("Gracz 1");
		Gracz gracz2 = new Gracz("Gracz 2");

		Terytorium terytorium1 = new Terytorium("Terytorium 1");
		Terytorium terytorium2 = new Terytorium("Terytorium 2");

		// Przypisanie terytoriów do graczy
		terytorium1.setWlasciciel(gracz1);
		terytorium2.setWlasciciel(gracz2);

		while (gracz1.czyZyje() && gracz2.czyZyje()) {
			// Symulacja ataku na terytorium
			if (terytorium1.getWlasciciel() == gracz1) {
				gracz1.atakuj(gracz2, "Piechota", 10);
			} else {
				gracz2.atakuj(gracz1, "Czołgi", 5);
			}
		}

		if (gracz1.czyZyje()) {
			System.out.println(gracz1.getNazwa() + " wygrał!");
		} else {
			System.out.println(gracz2.getNazwa() + " wygrał!");
		}
	}

}
