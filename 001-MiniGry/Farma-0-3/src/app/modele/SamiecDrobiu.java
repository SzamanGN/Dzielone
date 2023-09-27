package app.modele;

public class SamiecDrobiu extends DuszekDrobiu{
	
	public SamiecDrobiu() {
		super();
	}

	public boolean czyZapladnia() {
		if(isJestDorosly()) {
			return (getPoziomNajedzenia() > 70);
		}
		return false;
	}
}
