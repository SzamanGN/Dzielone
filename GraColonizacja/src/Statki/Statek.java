package Statki;

public class Statek {
	
	private String nazwa;
	private String rodzaj;
	
	public Statek(String nazwa, String rodzaj) {
		this.nazwa = nazwa;
		this.rodzaj = rodzaj;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getRodzaj() {
		return rodzaj;
	}

	public void setRodzaj(String rodzaj) {
		this.rodzaj = rodzaj;
	}

	@Override
	public String toString() {
		return "Statek [nazwa=" + nazwa + ", rodzaj=" + rodzaj + "]";
	}
	


}
