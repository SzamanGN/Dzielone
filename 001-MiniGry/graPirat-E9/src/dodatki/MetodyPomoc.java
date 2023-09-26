package dodatki;

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

}
