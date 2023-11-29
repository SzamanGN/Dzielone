package app.menuWyboru;

import java.util.Scanner;

import app.budowle.Budynek;
import app.gracze.Gracz;
import app.wioski.Wioska;

public class GraWioska {

	public GraWioska() {
		Scanner scanner = new Scanner(System.in);
		Wioska wioska = new Wioska(10);

		boolean graDziala = true;

		while (graDziala) {
			System.out.println("\nWybierz akcję:");
			System.out.println("1. Wyświetl stan wioski");
			System.out.println("2. Produkuj żywność");
			System.out.println("3. Rekrutuj mieszkańca");
			System.out.println("4. Zbuduj budynek");
			System.out.println("5. Jedz");
			System.out.println("0. Zakończ grę");

			int wybor = scanner.nextInt();

			switch (wybor) {
			case 1:
				wioska.wyswietlStan();
				System.out.println("Czas od startu gry: " + wioska.czasOdStartu() + " sekundy");
				break;
			case 2:
				wioska.produkujZywnosc();
				break;
			case 3:
				wioska.rekrutujMieszkanca();
				break;
			case 4:
				System.out.println("Dostępne budynki:");
				System.out.println("1. Dom (Efekt: +1 Mieszkaniec)");
				System.out.println("2. Pole uprawne (Efekt: +2 Żywność)");
				int wyborBudynku = scanner.nextInt();
				switch (wyborBudynku) {
				case 1:
					 if (wioska.zajmijObszar(0, 0)) {
                         wioska.zbudujBudynek(new Budynek("Dom", 0, 1));
                     } else {
                         System.out.println("Nie można zbudować na zajętym obszarze!");
                     }
					break;
				case 2:
					  if (wioska.zajmijObszar(1, 1)) {
                          wioska.zbudujBudynek(new Budynek("Pole uprawne", 2, 0));
                      } else {
                          System.out.println("Nie można zbudować na zajętym obszarze!");
                      }
					break;
				default:
					System.out.println("Nieprawidłowy wybór budynku.");
					break;
				}
				break;
			case 5:
				wioska.jedz();
				break;
			case 0:
				graDziala = false;
				System.out.println("Koniec gry.");
				break;
			 case 6:
                 // Walka między graczami
                 if (wioska.getLiczbaGraczy() >= 2) {
                     Gracz atakujacy = wioska.wylosujGracza();
                     Gracz obronca = wioska.wylosujGracza(atakujacy);
                     System.out.println("Walka między graczami: " + atakujacy.getNazwa() + " vs " + obronca.getNazwa());
                     wioska.atakujGracza(atakujacy, obronca);
                 } else {
                     System.out.println("Potrzebujesz co najmniej dwóch graczy do walki.");
                 }
                 break;
			default:
				System.out.println("Nieprawidłowy wybór.");
				break;
			}
		}
	}
}
