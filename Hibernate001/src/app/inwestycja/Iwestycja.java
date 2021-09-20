package app.inwestycja;

public class Iwestycja {
	private int kosztInwestycji; 
	private int kosztMiesieczny;
	
	public Iwestycja(int kosztInwestycji, int kosztMiesieczny) {
		super();
		this.kosztInwestycji = kosztInwestycji;
		this.kosztMiesieczny = kosztMiesieczny;
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
	

}
