package dodatki;

import java.awt.geom.Rectangle2D;

import gra.Gra;

public class MetodyPomoc {
	
	public static boolean czyMozeIsc(float x, float y, float szerkosc, float wysokosc, int[][] pozData) {
		
		if (!jestCaly( x, y, pozData)) {
			if (!jestCaly(x + szerkosc, y + wysokosc, pozData)) {
				if(!jestCaly(x + szerkosc, y, pozData)) {
					if(!jestCaly( x, y + wysokosc, pozData)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	private static boolean jestCaly(float x, float y, int[][] pozData) {
		
		if (x < 0 || x >= Gra.gra_szerkosc) {
			return true;
		}
		
		if(y < 0 || y >= Gra.gra_wysokosc) {
			return true;
		}
		
		float xIndex = x / Gra.plytka_wielkosc;
		float yIndex = y / Gra.plytka_wielkosc;
		int wartosc  =  pozData[(int) yIndex][(int) xIndex];
		
		if (wartosc >= 48 || wartosc < 0 || wartosc != 11) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public static float getDuszekXpozycjaDoSciany(Rectangle2D.Float detekcajKolizji, float xPredkosc) {
		int wybranaPlytka = (int) (detekcajKolizji.x / Gra.plytka_wielkosc);
		if (xPredkosc > 0) {
			// prawa strona
			int plytkaXpoz = wybranaPlytka * Gra.plytka_wielkosc;
			int xZarkes = (int) (Gra.plytka_wielkosc - detekcajKolizji.width);
			return plytkaXpoz + xZarkes - 1;
		} else {
			// lewa strona
			return wybranaPlytka * Gra.plytka_wielkosc;
		}
	}
	
	public static float getDuszekYpozycjaPowyzjDachuAlboPonizejPodlogi(Rectangle2D.Float detekcajKolizji, float powietrzPredkosc) {
		int wybranaPlytka = (int) (detekcajKolizji.y / Gra.plytka_wielkosc);
		if (powietrzPredkosc > 0) {
			// upadamy na podloge
			int plytkaYpoz = wybranaPlytka * Gra.plytka_wielkosc;
			int yZakres = (int) (Gra.plytka_wielkosc - detekcajKolizji.height);
			return plytkaYpoz + yZakres - 1;
		} else {
			// skok
			return wybranaPlytka * Gra.plytka_wielkosc;
		}
	}
	
	public static boolean isDuszekJestNaPodlodze(Rectangle2D.Float detekcjaKolizji, int[][] pozData) {
		// sprawdzenied czy piksele ponizej lewej i prawej sa na podlodze
		if (!jestCaly(detekcjaKolizji.x, detekcjaKolizji.y + detekcjaKolizji.height + 1, pozData)) {
			if (!jestCaly(detekcjaKolizji.x + detekcjaKolizji.width, detekcjaKolizji.y + detekcjaKolizji.height + 1, pozData)) {
				return false;
			}
		}
		return true;
	}

}
