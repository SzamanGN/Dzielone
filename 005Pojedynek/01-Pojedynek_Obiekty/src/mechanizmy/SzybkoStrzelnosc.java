package mechanizmy;

public class SzybkoStrzelnosc {

	private int szybkoStrzelnosc;
	private int licznik;
	
	public SzybkoStrzelnosc(int szybkoStrzelnosc) {
		this.szybkoStrzelnosc = szybkoStrzelnosc;
		licznik = szybkoStrzelnosc;
	}
	
	public boolean isStrzal() {
		return licznik == 0;
	}
	
	public void tikZegara() {
		if(licznik > 0) {
			licznik -= 1;
		} else {
			licznik = szybkoStrzelnosc;
		}
	} 
}
