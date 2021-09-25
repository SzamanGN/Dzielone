package Statki;

import java.util.ArrayList;

public class MenagerStatkow {
	
	private ArrayList<Statek> wykaz;
	
	public MenagerStatkow() {
		wykaz =  new ArrayList<Statek>();
	}
	
	
	public void add(String nazwa,String rodzaj) {
		wykaz.add(new Statek(nazwa,rodzaj));
	}
	
	public void add (Statek statek) {
		wykaz.add(statek);
	}

}
