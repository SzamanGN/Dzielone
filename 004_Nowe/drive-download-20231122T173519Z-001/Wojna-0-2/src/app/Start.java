package app;

import app.modele.Gracz;

public class Start {

	public static void main(String[] args) {
		System.out.println("Test wojny-0-2");
		
		Gracz gracz1 = new Gracz("Gracz 1");
        Gracz gracz2 = new Gracz("Gracz 2");

        while (gracz1.czyZyje() && gracz2.czyZyje()) {
            gracz1.atakuj(gracz2);
            gracz2.atakuj(gracz1);
        }

        if (gracz1.czyZyje()) {
            System.out.println(gracz1.getNazwa() + " wygrał!");
        } else {
            System.out.println(gracz2.getNazwa() + " wygrał!");
        }
	}

}
