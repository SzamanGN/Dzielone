package cygus.menadzerInt;

import java.util.ArrayList;

public class MenagerMenagerowInt {

	private ArrayList<MenagerInt> menager;
	private int ilosc;

	public MenagerMenagerowInt() {
		ustaw(1);
	}

	public MenagerMenagerowInt(int ilosc) {
		ustaw(ilosc);
	}
	
	private void ustaw(int ilosc) {
		this.ilosc = ilosc;
		menager = new ArrayList<MenagerInt>();
		if(ilosc >= 1) {
			
		} else {
			this.ilosc = 1;
		}
		incjowanieMenagerowInt();
	}

	private void incjowanieMenagerowInt() {
		for(int i = 0; i < ilosc; i++) {
			menager.add(new MenagerInt());
		}	
	}
	
	public int getIloscMenagerowInt() {
		return menager.size();
	}
	
	public void dodajMenagerInt() {
		menager.add(0, new MenagerInt());
		if(menager.size() > ilosc) {
			menager.remove(ilosc);
		}
	}
	
	public void dodajDoMengeraInt(int ktory, int wartosc) {
		menager.get(ktory).dodajNaPoczatku(wartosc);
	}
	
	public int pobierzZmenageraInt(int ktory, int index) {
		return menager.get(ktory).get(index);
	}
	
	public int getIloscWmenagerInt(int ktory) {
		return menager.get(ktory).getIlosc();
	}
}
