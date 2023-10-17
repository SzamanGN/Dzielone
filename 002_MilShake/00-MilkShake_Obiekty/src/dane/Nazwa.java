package dane;

public class Nazwa {
	
	private static String[] nazwyShakow = { // Nazwa.nazwyShakow[]
			"Shake-0", "Shake-1", "Shake-2"
	};
	
	private static String[] nazwyProduktow = { // Nazwa.nazwPr.. statyczna i deklaracja od razu
			"Pordukt-0", "Pordukt-1", "Pordukt-2"
	};

	
	public static String sheka(int ktory) { // Nazwa.sheka(0); metoda
		return nazwyShakow[ktory];
	}
	
	public static String produktu(int ktory) { // pobranie produtku
		return nazwyProduktow[ktory];
	}
	
}
