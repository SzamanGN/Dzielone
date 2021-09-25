package app.mapa;

public class Wyspa {
private String nazwaWyspy;
private int dlugosc;
private int szerokosc;

public Wyspa(String nazwaWyspy, int dlugosc , int szerokosc) {
	this.nazwaWyspy = nazwaWyspy;
	this.dlugosc = dlugosc;
	this.szerokosc =  szerokosc;
	
}

public String getNazwaWyspy() {
	return nazwaWyspy;
}

public void setNazwaWyspy(String nazwaWyspy) {
	this.nazwaWyspy = nazwaWyspy;
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
	return "Wyspa [nazwaWyspy=" + nazwaWyspy + ", dlugosc=" + dlugosc + ", szerokosc=" + szerokosc + "]";
}




}
