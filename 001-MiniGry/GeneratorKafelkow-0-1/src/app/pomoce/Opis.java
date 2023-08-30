package app.pomoce;

public class Opis {

	private static String[] kolory = {
		"Czarny", "Czerwony", "Zielony"	
	};
	
	public static String getKolor(int ktory) {
		return kolory[ktory];
	}
}
