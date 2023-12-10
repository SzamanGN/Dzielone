package silnik;

public class Wyniki {
	
	private long punkty;
	private long wygrane;
	private long remisy;
	private long przegrane;
	
	public Wyniki() {
		punkty = 0;
		wygrane = 0;
		remisy = 0;
		przegrane = 0;
	}

	public long getPunkty() {
		return punkty;
	}

	public long getWygrane() {
		return wygrane;
	}

	public long getRemisy() {
		return remisy;
	}

	public long getPrzegrane() {
		return przegrane;
	}
	
	public void aktulizacjaPuktow(int ilosc) {
		punkty += ilosc;
	}
	
	public void zwiekszWygrane() {
		wygrane += 1;
	}
	
	public void zwiekszRemisy() {
		remisy += 1;
	}
	
	public void zwiekszPrzegrane() {
		przegrane += 1;
	}
}
