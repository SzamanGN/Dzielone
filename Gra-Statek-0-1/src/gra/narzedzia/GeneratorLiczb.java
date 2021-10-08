package gra.narzedzia;

import java.util.Random;

public class GeneratorLiczb {

	private static Random generator = new Random();
	
	public static int losowa(int zakres) {
		return generator.nextInt(zakres);
	}
}
