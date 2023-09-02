package cygus.menadzerInt;

import java.util.ArrayList;

public class MenagerInt {

	private ArrayList<Integer> wykaz;
	private int zakres;
	
	public MenagerInt() {
		ustaw(0);
	}
	
	public MenagerInt(int zakres) {
		ustaw(zakres);
	}
	
	private void ustaw(int zakres) {
		this.zakres = zakres;
		wykaz =  new ArrayList<Integer>();
	}
	
	private boolean isZakres() {
		return zakres > 0;
	}
	
	public void dodajNaPoczatku(int wartosc) {
		wykaz.add(0, wartosc);
		if(isZakres()) {
			if(wykaz.size() > zakres) {
				wykaz.remove(zakres);
			}
		}
	}
	
	public void dodajNaKoncu(int wartosc) {
		wykaz.add(wartosc);
		if(isZakres()) {
			if(wykaz.size() > zakres) {
				wykaz.remove(0);
			}
		}
	}
	
	public void usun(int ktory) {
		wykaz.remove(ktory);
	}
	
	public int  getIlosc() {
		return wykaz.size();
	}
	
	public int get(int ktory) {
		return wykaz.get(ktory);
	}
}
