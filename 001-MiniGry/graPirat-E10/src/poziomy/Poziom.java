package poziomy;

public class Poziom {
	
	private int[][] pozData;
	
	public Poziom(int[][] pozData) {
		this.pozData = pozData;
	}
	
	public int getDuszekIndex(int x, int y) {
		return pozData[y][x];
	}
	
	public int[][] getPozData(){
		return pozData;
	}

}
