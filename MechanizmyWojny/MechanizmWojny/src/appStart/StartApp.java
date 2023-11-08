package appStart;

import gracze.Gracz;
import modele.Armia;

public class StartApp {

	public static void main(String[] args) {
		System.out.println("Mechaniz wojny chatGP");
		Gracz cezar = new Gracz("Cezar");
		Gracz faraon = new Gracz("Faraon");
		
		while (cezar.czyZyje() && faraon.czyZyje()) {
			cezar.atakuj(faraon);
			faraon.atakuj(cezar);
		}
		
		if (cezar.czyZyje()) {
			System.out.println("Wygral Cezar" + cezar.toString());
		} else {
			System.out.println("Wygral Faron" + faraon.toString());
		}

	}

}
