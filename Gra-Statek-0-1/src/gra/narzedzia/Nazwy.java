package gra.narzedzia;

public class Nazwy {

	private static String[] wyspy = {"Alfa", "Brawo", "Czarli"};
	private static String[] surowce = {"Zloto", "Kamien", "Drewno", "Skora", "Tyton", "Bawelna", "Papirus", "Srebro"};
	
	public static int iloscWysp() {
		return wyspy.length;
	}
	
	public static String wyspa(int indeks) {
		return wyspy[indeks];
	}
	
	public static int iloscSurowcow() {
		return surowce.length;
	}
	
	public static String surowiec(int indeks) {
		return surowce[indeks];
	}
}
