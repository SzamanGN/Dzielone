package narzedzia;

import java.util.Random;

public class Generator {
	
	private static Random generator = new Random();

	public static int liczba(int zakres) { 
		return generator.nextInt(zakres); // losowa liczba z zakresu od 0 do  zakres -1!!!!!!!!!!!!!! 
	}
}
