package app.modele;

public class Samiec extends Duszek{
	
	public Samiec() {
		super();
	}

	public boolean czyZapladnia() {
		if(isJestDorosly()) {
			return (getPoziomNajedzenia() > 70);
		}
		return false;
	}
}
