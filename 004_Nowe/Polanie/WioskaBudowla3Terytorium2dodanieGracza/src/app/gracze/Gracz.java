package app.gracze;

import java.util.Random;

public class Gracz {
	private String nazwa;
    private int zdrowie;
    private int sila;

    public Gracz(String nazwa, int zdrowie, int sila) {
        this.nazwa = nazwa;
        this.zdrowie = zdrowie;
        this.sila = sila;
    }

    public String getNazwa() {
        return nazwa;
    }

    public int getZdrowie() {
        return zdrowie;
    }

    public void otrzymajObrazenia(int obrazenia) {
        zdrowie -= obrazenia;
        if (zdrowie < 0) {
            zdrowie = 0;
        }
    }

    public int atakuj() {
        // Przykładowa implementacja - atak generuje losową liczbę obrażeń
        Random rand = new Random();
        int obrazenia = rand.nextInt(sila) + 1; // od 1 do sila
        System.out.println(nazwa + " zadaje " + obrazenia + " obrażeń.");
        return obrazenia;
    }
}
