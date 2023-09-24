package app.narzedzia;

import java.util.Random;

public class Generator {
	
	private static Random generator = new Random();
	
	public static int getLosowa(int zakres) {
		return generator.nextInt(zakres);
	}

}
