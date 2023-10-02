package app.start;

import app.gracze.Gracz;
import app.gracze.Potwor;
import app.narzedzia.Generator;

public class Test {
	

	public Test() {
		System.out.println("Start testu:");
		
		testGraczaA();
		testWalki();
		
		System.out.println("Koniec testu:");
	}

	private void testWalki() {
		System.out.println("Test walki");
		Gracz gracz =  new Gracz("Cygus", 20, 20, 20);
		Potwor potwor =  new Potwor("Drakula", 20, 20, 20);
		System.out.println("10 pojedynkow");
		String opis;
		int atak;
		int obrona;
		int obrazenia;
		for(int i = 1; i <= 10; i++) {
			System.out.println("Pojedynek nr: " + i);
			// atak gracza
			atak = gracz.getWyliczonyAtak();
			obrona = potwor.getWyliczonaObrona();
			opis = "Gracz atak = " + atak + ", potwor obrona = " + obrona;
			if (atak > obrona) {
				opis += " wygrywa gracz!"; 
				// odjecie puntow zycia potworowi
				obrazenia = 2 + Generator.getLosowa(3);
				if (potwor.otrzymaneObrazenia(obrazenia)) {
					opis += " potwor nie zyje!";
					System.out.println(opis);
					break;
				} else {
					opis += " potwor otrzymal obrazenia = " + obrazenia; 
				}
			} else if (obrona > atak) {
				opis += " potwor obrnil sie!";
				//odjecie puktow zycia graczowi
				obrazenia = 2 + Generator.getLosowa(3);
				if (gracz.otrzymaneObrazenia(obrazenia)) {
					opis += " gracz nie zyje!!";
					System.out.println(opis);
					break;
				} else {
					opis += "gracz otrzymal obrazenia = " + obrazenia;
				}
			} else {
				opis += " gracz nie trafil potwora";
			}
			System.out.println(opis);
			// atak potwora
			atak =  potwor.getWyliczonyAtak();
			obrona =  gracz.getWyliczonaObrona();
			opis = "Potwor atak = " +  atak + ", gracz obrona = " + obrona;
			if (atak > obrona) {
				opis += " wygrya potwor";
				obrazenia = 2 + Generator.getLosowa(3);
				if (gracz.otrzymaneObrazenia(obrazenia)) {
					opis += " gracz nie zyje!!";
					System.out.println(opis);
					break;
				} else {
					opis += " gracz otrzymal obrazenia = " + obrazenia;
				}
			} else if (obrona > atak) {
				opis += " gracz obronil sie";
				obrazenia = 2 + Generator.getLosowa(3);
				if(potwor.otrzymaneObrazenia(obrazenia)) {
					opis += " potwor padl!!";
					System.out.println(opis);
					break;
				} else {
					opis += " potwor otrzymal obrazenia = " + obrazenia;
				}
			} else {
				opis += " potwor nie trafil gracza";
			}
			System.out.println(opis);
		}
	}

	private void testGraczaA() {
		System.out.println("TestGracza A");
		Gracz graczA = new Gracz("GraczA", 100, 20, 20);
		System.out.println("Gracz parametry: " +  graczA.toString());
		System.out.println("10 prob ataku/obrona:");
		for(int i = 0; i < 10; i++) {
			System.out.println("Wartosc ataku: " + graczA.getWyliczonyAtak() + ", obrona: " +  graczA.getWyliczonaObrona());
		}
	}
}
