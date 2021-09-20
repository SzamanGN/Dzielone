package app.inwestycje;

import java.util.ArrayList;
import java.util.Iterator;

public class Inwestycje {

	private ArrayList<Inwestycja> wykaz;
	
	public Inwestycje() {
		wykaz = new ArrayList<Inwestycja>();
	}
	
	public void add(String nazwa, int kosztInwestycji, int kosztMiesieczny) {  // w formie paremetrow
		wykaz.add(new Inwestycja(nazwa, kosztInwestycji, kosztMiesieczny));
	}
	
	public void add(Inwestycja inwestycja) { /// gotwy obiekt
		wykaz.add(inwestycja);
	}
	
	public Iterator<Inwestycja> getIterator() {
		return wykaz.iterator();
	}
	
	public ArrayList<Inwestycja> getList() {
		return wykaz;
	}
	
	public Inwestycja get(int indeks) {
		return wykaz.get(indeks);
	}
	
	public void update(int indeks, Inwestycja inwestycja) {
		wykaz.set(indeks, inwestycja);
	}
	
	public void delete(int indeks) {
		wykaz.remove(indeks);
	}
	
	public void delete(Inwestycja inwestycja) {
		wykaz.remove(inwestycja);
	}
	
	public int getIlosc() {
		return wykaz.size();
	}
	
	public boolean areInwestycje() {
		return !wykaz.isEmpty();
	}
}
