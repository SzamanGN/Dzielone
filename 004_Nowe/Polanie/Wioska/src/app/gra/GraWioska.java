package app.gra;

import java.util.Scanner;

import app.model.Wioska;

public class GraWioska {
	Scanner scanner = new Scanner(System.in);
	Wioska wioska = new Wioska();

	public GraWioska() {
		boolean graDziala = true;

		while (graDziala) {
			System.out.println("\nWybierz akcję:");
			System.out.println("1. Wyświetl stan wioski");
			System.out.println("2. Produkuj żywność");
			System.out.println("3. Rekrutuj mieszkańca");
			System.out.println("4. Jedz");
			System.out.println("0. Zakończ grę");

			int wybor = scanner.nextInt();

			switch (wybor) {
			case 1:
				wioska.wyswietlStan();
				break;
			case 2:
				wioska.produkujZywnosc();
				break;
			case 3:
				wioska.rekrutujMieszkanca();
				break;
			case 4:
				wioska.jedz();
				break;
			case 0:
				graDziala = false;
				System.out.println("Koniec gry.");
				break;
			default:
				System.out.println("Nieprawidłowy wybór.");
				break;
			}
		}
	}
}
