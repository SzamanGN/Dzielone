package silnik;

public class WynikPojedynku {
	
	private int punkty;
	private StanPojedynku stan;
	
	public WynikPojedynku(int punkty, StanPojedynku stan) {
		this.punkty = punkty;
		this.stan = stan;
	}

	public int getPunkty() {
		return punkty;
	}

	public StanPojedynku getStan() {
		return stan;
	}
	
	
}
