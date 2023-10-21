package dane;

public class Nazwa {
	
	private static String[] nazwyShakow = { // Nazwa.nazwyShakow[]
			"Truskawkowy", "Banananowy", "Mix"
	};
	
	private static String[] nazwyProduktow = { // Nazwa.nazwPr.. statyczna i deklaracja od razu
			"Mleko", "Truskawa", "Bannan"
	};

	
	public static String sheka(int ktory) { // Nazwa.sheka(0); metoda
		return nazwyShakow[ktory];
	}
	
	public static String produktu(int ktory) { // pobranie produtku
		return nazwyProduktow[ktory];
	}
	
}
