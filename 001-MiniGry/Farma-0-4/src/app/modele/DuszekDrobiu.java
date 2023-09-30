package app.modele;

import app.menagery.MenagerJedzenia;

public class DuszekDrobiu {
	
	private int rodzaj;
	private int zycie;
	private boolean jestDorosly;
	private MenagerJedzenia pozywienie;
	private int poziomNajedzenia;
	
	public DuszekDrobiu() {
		ustaw(0);
	}

	public DuszekDrobiu(int rodzaj) {
		ustaw(rodzaj);
	}
	
	private void ustaw(int rodzaj) {
		this.rodzaj = rodzaj;
		zycie = 100;
		jestDorosly = false;
		pozywienie =  new MenagerJedzenia();
		poziomNajedzenia = 50;
	}

	public int getRodzaj() {
		return rodzaj;
	}

	public int getZycie() {
		return zycie;
	}

	public boolean isJestDorosly() {
		return jestDorosly;
	}

	public MenagerJedzenia getPozywienie() {
		return pozywienie;
	}

	public int getPoziomNajedzenia() {
		return poziomNajedzenia;
	}
	
	public void addJedzenie(int rodzaj, int ilosc) {
		pozywienie.add(rodzaj, ilosc);
	}
}
