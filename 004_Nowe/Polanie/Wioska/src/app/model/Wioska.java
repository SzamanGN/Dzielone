package app.model;

public class Wioska {

	  private int iloscMieszkancow;
	    private int iloscZywnosci;

	    public Wioska() {
	        this.iloscMieszkancow = 5;
	        this.iloscZywnosci = 10;
	    }

	    public void wyswietlStan() {
	        System.out.println("Stan wioski:");
	        System.out.println("Mieszkańcy: " + iloscMieszkancow);
	        System.out.println("Żywność: " + iloscZywnosci);
	    }

	    public void produkujZywnosc() {
	        iloscZywnosci += iloscMieszkancow * 2;
	        System.out.println("Produkcja żywności zakończona.");
	    }

	    public void rekrutujMieszkanca() {
	        iloscMieszkancow++;
	        System.out.println("Nowy mieszkaniec dołączył do wioski.");
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
