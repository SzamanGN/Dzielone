package app.wioski;

import java.util.ArrayList;
import java.util.List;

import app.budowle.Budynek;

public class Wioska {
	 private int iloscMieszkancow;
	    private int iloscZywnosci;
	    private List<Budynek> budynki;

	    public Wioska() {
	        this.iloscMieszkancow = 5;
	        this.iloscZywnosci = 10;
	        this.budynki = new ArrayList<>();
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
}
