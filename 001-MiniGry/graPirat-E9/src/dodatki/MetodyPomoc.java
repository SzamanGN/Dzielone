package dodatki;

import gra.Gra;

public class MetodyPomoc {
	
	public static boolean CzyMozeIsc(float x, float y, float szerkosc, float wysokosc, int[][] pozData) {
		
		if (!JestCaly( x, y, pozData)) {
			if (!JestCaly(x + szerkosc, y + wysokosc, pozData)) {
				if(!JestCaly(x + szerkosc, y, pozData)) {
					if(!JestCaly( x, y + wysokosc, pozData)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	private static boolean JestCaly(float x, float y, int[][] pozData) {
		
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
