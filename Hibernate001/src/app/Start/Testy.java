package app.Start;

import app.inwestycje.Inwestycja;
import app.inwestycje.Inwestycje;

public class Testy {

	public Testy() {
		pokaz("---Start testów---");
		//testInwestycji();
		testMenageraInwestycji();
		pokaz("---Koniec testów---");
	}

	private void testMenageraInwestycji() {
		pokaz("---Menager inwestycji---");
		Inwestycje i = new Inwestycje();
		pokaz("Ilość inwestycji: " + i.getIlosc());
		pokaz("Czy są inwestycje: " + i.areInwestycje());
		pokaz("Dodanie inwestycji.");
		i.add("BTC", 123, 12);
		pokaz("Ilość inwestycji: " + i.getIlosc());
		pokaz("Czy są inwestycje: " + i.areInwestycje());
		pokaz("Opis inwestycji 0: " + i.get(0).getOpis());
		pokaz("Dodanie inwestycji.");
		i.add(new Inwestycja("LTC", 234, 56));
		pokaz("Ilość inwestycji: " + i.getIlosc());
		pokaz("Czy są inwestycje: " + i.areInwestycje());
		pokaz("Opis inwestycji 0: " + i.get(0).getOpis());
		pokaz("Opis inwestycji 1: " + i.get(1).getOpis());
		pokaz("Usunięcie inwestycji o indeksie 0.");
		i.delete(0);
		pokaz("Ilość inwestycji: " + i.getIlosc());
		pokaz("Czy są inwestycje: " + i.areInwestycje());
		pokaz("Opis inwestycji 0: " + i.get(0).getOpis());
		pokaz("Usunięcie inwestycji o indeksie 0.");
		Inwestycja usowanaInwestycja = i.get(0);
		i.delete(usowanaInwestycja);
		pokaz("Ilość inwestycji: " + i.getIlosc());
		pokaz("Czy są inwestycje: " + i.areInwestycje());
	}

	private void testInwestycji() {
		pokaz("---Klasa Inwestycja---");
		Inwestycja i = new Inwestycja("BTC", 123, 12);
		pokaz("Opis inwestycji: " + i.getOpis());
		pokaz("- nazwa: " + i.getNazwa());
		pokaz("- koszt: " + i.getKosztInwestycji());
		pokaz("- koszt miesięczny: " + i.getKosztMiesieczny());
	}
	
	private void pokaz(String wpis) {
		System.out.println("<Test> " + wpis);
	}
}
