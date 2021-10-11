package gra;

import gra.narzedzia.GeneratorLiczb;
import gra.okna.OknoPulpitGracza;

public class Testy {
	
	public Testy() {
		System.out.println("Start Testu : ");
		
		new OknoPulpitGracza();
		/*
		for (int l =0; l < 100; l++) {
			System.out.println("Losowanie nr: " + l + " delta = " + GeneratorLiczb.deltaCeny());
		}
		*/
		System.out.println("Koniec Testu! ");
		
	}

}
