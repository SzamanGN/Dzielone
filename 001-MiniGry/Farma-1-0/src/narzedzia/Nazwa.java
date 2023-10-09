package narzedzia;

public class Nazwa {
	
	private static String[] nazwyObrazkowProduktow = {
			"wiadroM", "ziarno1", "jajko"
	};

	private static String[] nazwyProduktow = {
			"Woda", "Ziarno", "Jajko"
	};
	
	public static String produktu(int ktory) {
		return nazwyProduktow[ktory];
	}
	
	public static String obrazkaProduktu(int ktory) {
		return nazwyObrazkowProduktow[ktory];
	}
}
