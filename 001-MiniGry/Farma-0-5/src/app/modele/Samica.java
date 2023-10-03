package app.modele;

public class Samica extends Duszek{

	private int licznikZnoszeniaJajka;
	private boolean jestZaplodniona;
	private int iloscJajek;
	private int limitJajek;
	
	public Samica() {
		super(1);
		licznikZnoszeniaJajka = 10;
		jestZaplodniona = false;
		iloscJajek = 0;
		limitJajek = 3;
	}
	
	public boolean czyZniesionoJajko() {
		if(jestZaplodniona) {
			licznikZnoszeniaJajka -= 1;
			if(licznikZnoszeniaJajka <= 0) {
				iloscJajek += 1;
				if(iloscJajek > limitJajek) {
					iloscJajek = limitJajek;
				}
				licznikZnoszeniaJajka = 10;
				jestZaplodniona = false;
				return true;
			}
		}		
		return false;
	}
	
	public void setJestZaplodniona() {
		if(isJestDorosly()) {
			jestZaplodniona = true;
		}
	}
	
	public void zwiekszLimitJajek() {
		limitJajek += 1;
	}
	
	public boolean isZaplodniona() {
		return jestZaplodniona;
	}
	
	public int getIloscJajek() {
		return iloscJajek;
	}
}
