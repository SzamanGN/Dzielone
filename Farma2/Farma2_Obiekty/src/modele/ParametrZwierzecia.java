package modele;

import java.awt.Color;

public class ParametrZwierzecia {
	
	private int maksimum;
	private int aktualny;
	private int minimum;
	private int wymagany;
	

	public ParametrZwierzecia() {
		ustaw(100, 100, 15, 85);
	}
	
	public ParametrZwierzecia(int maksimum, int aktulany, int minimum, int wymagany) {
		ustaw(maksimum, aktulany, minimum, wymagany);
	}

	private void ustaw(int maksimum, int aktulany, int minimum, int wymagany) {
		this.maksimum = maksimum;
		this.aktualny = aktulany;
		this.minimum = minimum;
		this.wymagany = wymagany;
	}
	
	public boolean isNajedzony() {
		return aktualny >= wymagany;
	}
	
	public boolean isGlodny() {
		return aktualny >= minimum && aktualny < wymagany;
	}
	
	public boolean isAgonia() {
		return aktualny < minimum;
	}
	
	public Color getStan() {
		if(isNajedzony()) {
			return Color.GREEN;
		} else if(isGlodny()) {
			return Color.ORANGE;
		}else {
			return Color.RED;
		}
	}
	
	public void updateAktualny(int delta) {
		int tmp =  aktualny + delta;
		if(tmp < maksimum) {
			aktualny = tmp;
		}
	}
	
	public void tikZegara() {
		aktualny -= 1;
	}
}

