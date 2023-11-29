package app.budowle;

public class Budynek {
	 private String nazwa;
	    private int efektZywnosci;
	    private int efektMieszkancow;

	    public Budynek(String nazwa, int efektZywnosci, int efektMieszkancow) {
	        this.nazwa = nazwa;
	        this.efektZywnosci = efektZywnosci;
	        this.efektMieszkancow = efektMieszkancow;
	    }

	    public String getNazwa() {
	        return nazwa;
	    }

	    public int getEfektZywnosci() {
	        return efektZywnosci;
	    }

	    public int getEfektMieszkancow() {
	        return efektMieszkancow;
	    }
}
