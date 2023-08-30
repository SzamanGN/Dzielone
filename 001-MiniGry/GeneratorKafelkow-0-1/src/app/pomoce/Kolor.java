package app.pomoce;

import java.awt.Color;

public class Kolor {
	private static Color[] kolory = {
		Color.BLACK, Color.RED, Color.GREEN
	};

	public static int getIlosc() {
		return kolory.length;
	}
	
	public static Color get(int ktory) {
		return kolory[ktory];
	}
	
}
