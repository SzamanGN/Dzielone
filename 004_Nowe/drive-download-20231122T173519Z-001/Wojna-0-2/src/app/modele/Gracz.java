package app.modele;

public class Gracz {
	private String nazwa;
    private Armia armia;

    public Gracz(String nazwa) {
        this.setNazwa(nazwa);
        this.armia = new Armia();
    }

    public void atakuj(Gracz przeciwnik) {
        int moceAtaku = this.armia.obliczMocAtaku();
        przeciwnik.obrona(moceAtaku);
    }

    public void obrona(int mocAtakuPrzeciwnika) {
        // Tutaj możesz dodać logikę obrony, np. zmniejszenie liczby jednostek w armii
        // w zależności od mocy ataku przeciwnika.
    	int jednostkiStracone = mocAtakuPrzeciwnika;
        this.armia.zmniejszLiczbeJednostek(jednostkiStracone);
        System.out.println(this.nazwa + " stracił " + jednostkiStracone + " jednostek w obronie.");
    
    }

    public boolean czyZyje() {
        return armia.czyMaJednostki();
    }

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
}
