package narzedzia;

public class NowyKamien {
	private int licznik;
	private int granica;

	public NowyKamien() {
		licznik = 0;
		granica = 10;
	}
	
	public boolean isNowyKamien() {
		licznik += 1;
		if(licznik >= granica) {
			licznik = 0;
			granica = 20 + Generator.losowaZ(100);
			return  true;
		}
		return false;
	}
}
