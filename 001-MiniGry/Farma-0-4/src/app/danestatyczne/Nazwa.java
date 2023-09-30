package app.danestatyczne;

public class Nazwa {

	private static String[] nazwyDrobiu = {
		"Kogut", "Kura" 	
	};
	
	private static String[] nazwyObrazkowDrobiu = {
		"kogut", "kura"
	};
	
	
	public static String drobiu(int ktory) {
		return nazwyDrobiu[ktory];
	}
	
	public static String obrazkaDrobiu(int ktory) {
		return nazwyObrazkowDrobiu[ktory];
	}
}
