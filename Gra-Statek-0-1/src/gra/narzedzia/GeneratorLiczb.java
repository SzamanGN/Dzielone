package gra.narzedzia;

import java.util.Random;

public class GeneratorLiczb {

	private static Random generator = new Random();
	
	public static int losowa(int zakres) {
		return generator.nextInt(zakres);
	}
	
	public static int deltaCeny() {
		/*
		 * Wartosci delty (0 - 99):
		 * -1 = (0 - 14)
		 * 0  = (15 - 84)
		 * +1 = (85 - 99)
		 */
		int delta = 0;
		int losowa = generator.nextInt(100);
		if (losowa < 15) {
			delta = -1;
		} else if (losowa > 84) {
			delta = 1;
		}
		return delta;
	}
}
