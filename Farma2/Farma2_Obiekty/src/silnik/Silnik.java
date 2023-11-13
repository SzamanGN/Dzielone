package silnik;

import magazyn.ModelListyProduktow;

public class Silnik {

	private ModelListyProduktow magazyn;
	
	public Silnik() {
		magazyn = new ModelListyProduktow();
		
		ladowanieDanychTestowych();
	}

	private void ladowanieDanychTestowych() {
		magazyn.add(0, 2);
		magazyn.add(1, 5);
		magazyn.add(2, 2);
		magazyn.add(3, 8);
	}
	
	public void ladowanieDanychStartowych() {
		
	}

	public ModelListyProduktow getMagazyn() {
		return magazyn;
	}

	public void dodajProduktDoMagazynu(int id, int ilosc) {
		magazyn.add(id, ilosc);
	}

}
