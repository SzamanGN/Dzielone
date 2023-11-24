package app.modele;

import java.util.HashMap;
import java.util.Map;

public class Armia {
	private Map<String, Integer> jednostki;

	public Armia() {
		jednostki = new HashMap<>();
		// Inicjalizacja różnych typów jednostek
		jednostki.put("Piechota", 50);
		jednostki.put("Czołgi", 20);
		// Dodaj więcej typów jednostek według potrzeb gry
	}

	public int obliczMocAtaku() {
		int mocAtaku = 0;
		for (int ilosc : jednostki.values()) {
			mocAtaku += ilosc;
		}
		return mocAtaku;
	}

	public void zmniejszLiczbeJednostek(String typJednostki, int ilosc) {
		if (jednostki.containsKey(typJednostki)) {
			jednostki.put(typJednostki, jednostki.get(typJednostki) - ilosc);
			if (jednostki.get(typJednostki) < 0) {
				jednostki.put(typJednostki, 0);
			}
		}
	}

	public boolean czyMaJednostki() {
		return jednostki.values().stream().anyMatch(ilosc -> ilosc > 0);
	}
}
