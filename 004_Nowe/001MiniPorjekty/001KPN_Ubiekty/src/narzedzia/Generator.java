package narzedzia;

import java.util.Random;

public class Generator {
	
	private static Random generator = new Random();
	private static char[] wybory = {'K', 'P', 'N'};
	
	public static String wyboru() {
		String wybor = "";
		for(int w = 0; w < 5; w++) {
			wybor += wybory[generator.nextInt(3)];
		}
		return wybor;
	}

}
