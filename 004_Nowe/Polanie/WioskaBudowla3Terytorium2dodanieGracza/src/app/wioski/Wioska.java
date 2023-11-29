package app.wioski;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import app.budowle.Budynek;
import app.gracze.Gracz;
import app.terytoria.ObszarTerytorium;

public class Wioska {
	private int iloscMieszkancow;
	private int iloscZywnosci;
	private List<Budynek> budynki;
	private List<Gracz> gracze;
	private Instant startCzasu;
	private ObszarTerytorium obszarTerytorium;

	public Wioska(int rozmiarTerytorium) {
		this.iloscMieszkancow = 5;
		this.iloscZywnosci = 10;
		this.budynki = new ArrayList<>();
		this.gracze = new ArrayList<>();
		this.startCzasu = Instant.now();
		this.obszarTerytorium = new ObszarTerytorium(rozmiarTerytorium);
		
		 // Dodajemy przykładowych graczy
        gracze.add(new Gracz("Gracz1", 100, 10));
        gracze.add(new Gracz("Gracz2", 100, 8));
		
		// Tworzymy zegar, który co sekundę zwiększa produkcję żywności
		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
		executorService.scheduleAtFixedRate(this::tikZegara, 0, 1, TimeUnit.SECONDS);
	}

	public boolean zajmijObszar(int x, int y) {
		return obszarTerytorium.zajmijObszar(x, y);
	}

	private void tikZegara() {
		// Zwiększ produkcję żywności za każdym tiknięciem zegara
		for (Budynek budynek : budynki) {
			iloscZywnosci += budynek.getEfektZywnosci();
		}
		System.out.println("Produkcja żywności zwiększona. Nowa ilość: " + iloscZywnosci);

		// Sprawdź, czy budynki są już zbudowane
		for (Budynek budynek : budynki) {
			// Przykładowa implementacja - załóżmy, że czas budowy to 10 sekund
			if (czasOdStartu() >= 10 && !budynekZbudowany(budynek)) {
				budynekZbudowany(budynek);
				System.out.println("Budynek " + budynek.getNazwa() + " został zbudowany!");
			}
		}
	}

	public void wyswietlStan() {
		System.out.println("Stan wioski:");
		System.out.println("Mieszkańcy: " + iloscMieszkancow);
		System.out.println("Żywność: " + iloscZywnosci);

		System.out.println("\nBudynki:");
		for (Budynek budynek : budynki) {
			System.out.println(budynek.getNazwa());
		}
	}

	public void produkujZywnosc() {
		for (Budynek budynek : budynki) {
			iloscZywnosci += budynek.getEfektZywnosci();
		}
		System.out.println("Produkcja żywności zakończona.");
	}

	public void rekrutujMieszkanca() {
		iloscMieszkancow++;
		System.out.println("Nowy mieszkaniec dołączył do wioski.");
	}

	public void zbudujBudynek(Budynek budynek) {
		budynki.add(budynek);
		System.out.println("Zbudowano budynek: " + budynek.getNazwa());
	}

	public void jedz() {
		if (iloscZywnosci >= iloscMieszkancow) {
			iloscZywnosci -= iloscMieszkancow;
			System.out.println("Mieszkańcy zjedli posiłek.");
		} else {
			System.out.println("Brak wystarczającej ilości jedzenia.");
		}
	}

	public long czasOdStartu() {
		Instant teraz = Instant.now();
		Duration roznica = Duration.between(startCzasu, teraz);
		return roznica.getSeconds();
	}

	private boolean budynekZbudowany(Budynek budynek) {
		// Przykładowa implementacja - załóżmy, że budynek jest zbudowany w ciągu 10
		// sekund
		return czasOdStartu() >= 10;
	}
	
	 public void atakujGracza(Gracz atakujacy, Gracz obronca) {
	        int obrazenia = atakujacy.atakuj();
	        obronca.otrzymajObrazenia(obrazenia);
	        System.out.println(obronca.getNazwa() + " otrzymuje " + obrazenia + " obrażeń. Zdrowie: " + obronca.getZdrowie());
	    }

	public int getLiczbaGraczy() {
		return gracze.size(); // dodanie przez Cygusa
	}

	public Gracz wylosujGracza() {
		 Random rand = new Random();
		 Gracz losowyGracz = (int)gracze.get(rand);
		 return loswyGracz;
	}
}
