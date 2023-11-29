package app.wioski;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import app.budowle.Budynek;

public class Wioska {
	 private int iloscMieszkancow;
	    private int iloscZywnosci;
	    private List<Budynek> budynki;
	    private Instant startCzasu;

	    public Wioska() {
	        this.iloscMieszkancow = 5;
	        this.iloscZywnosci = 10;
	        this.budynki = new ArrayList<>();
	        this.startCzasu = Instant.now();
	        // Tworzymy zegar, który co sekundę zwiększa produkcję żywności
	        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
	        executorService.scheduleAtFixedRate(this::tikZegara, 0, 1, TimeUnit.SECONDS);
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
	        // Przykładowa implementacja - załóżmy, że budynek jest zbudowany w ciągu 10 sekund
	        return czasOdStartu() >= 10;
	    }    
}
