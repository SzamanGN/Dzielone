package app.monety;

public class Moneta {
	private String nazwa;
	private int rok;
	private String kraj;
	
	public Moneta() {
		ustaw("N/A",0,"N/A");
		
	}

	
	public void ustaw(String nazawa, int rok, String kraj) {
		this.nazwa = nazawa;
		this.kraj = kraj;
		this.rok = rok;
		
	}


	public String getNazwa() {
		return nazwa;
	}


	public int getRok() {
		return rok;
	}


	public String getKraj() {
		return kraj;
	}
	
	
	
	public void opis() {
		System.out.println("Mnoeta o nominale : " + nazwa + " z kraju : " + kraj + " oraz z roku : " + rok );
	}
	
}
