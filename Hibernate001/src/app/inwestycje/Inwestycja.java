package app.inwestycje;

public class Inwestycja {
	
	private String nazwa;
	private int kosztInwestycji; 
	private int kosztMiesieczny;
	
	public Inwestycja() {
	}
	
	public Inwestycja(String nazwa, int kosztInwestycji, int kosztMiesieczny) {
		this.nazwa = nazwa;
		this.kosztInwestycji = kosztInwestycji;
		this.kosztMiesieczny = kosztMiesieczny;
	}
	
	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	
	public int getKosztInwestycji() {
		return kosztInwestycji;
	}

	public void setKosztInwestycji(int kosztInwestycji) {
		this.kosztInwestycji = kosztInwestycji;
	}

	public int getKosztMiesieczny() {
		return kosztMiesieczny;
	}

	public void setKosztMiesieczny(int kosztMiesieczny) {
		this.kosztMiesieczny = kosztMiesieczny;
	}
	
	public String getOpis() {
		return "Iwestycja: nazwa = " + nazwa + ", kosztInwestycji = " + kosztInwestycji + ", kosztMiesieczny = " + kosztMiesieczny;
	}

}
