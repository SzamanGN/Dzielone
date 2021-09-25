package app.mapa;

public class Mapa {
	private String nazwaMapy;
	private int dlugosc;
	private int szerokosc;
	
	
	public Mapa(String nazwaMapy,int dlugosc,int szerokosc) {
		this.nazwaMapy = nazwaMapy;
		this.dlugosc = dlugosc;
		this.szerokosc = szerokosc;
	}


	public String getNazwaMapy() {
		return nazwaMapy;
	}


	public void setNazwaMapy(String nazwaMapy) {
		this.nazwaMapy = nazwaMapy;
	}


	public int getDlugosc() {
		return dlugosc;
	}


	public void setDlugosc(int dlugosc) {
		this.dlugosc = dlugosc;
	}


	public int getSzerokosc() {
		return szerokosc;
	}


	public void setSzerokosc(int szerokosc) {
		this.szerokosc = szerokosc;
	}


	@Override
	public String toString() {
		return "Mapa [nazwaMapy=" + nazwaMapy + ", dlugosc=" + dlugosc + ", szerokosc=" + szerokosc + "]";
	}
	

	

}
