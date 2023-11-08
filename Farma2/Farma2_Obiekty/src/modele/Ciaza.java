package modele;

public class Ciaza {
	private int czas; //  czas okreslony w cyklach
	private boolean miot;
	
	public Ciaza(int czas) {
		this.czas = czas;
		miot = false;
	}
	
	public boolean isCiaza() {
		return czas > 0;
	}
	
	public void tikZegara() {
		if (isCiaza()) {
			czas -= 1;
			if(czas == 0) {
				miot = true;
			}
		}
	}
	
	public boolean isMiot() { // nowy produkt/ narodziny
		if (miot) {
			miot = false;
			return true;
		}
		return false;
	}
}
