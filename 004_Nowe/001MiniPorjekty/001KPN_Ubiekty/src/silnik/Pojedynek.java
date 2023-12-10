package silnik;

public class Pojedynek {
	
	private char[] wyboryGracza;
	private char[] wyboryPrzciwnika;
	
	public Pojedynek(String podaneWyboryGracza, String podaneWyboryPrzciwnika) {
		wyboryGracza = podaneWyboryGracza.toCharArray();
		wyboryPrzciwnika = podaneWyboryPrzciwnika.toCharArray();
	}
	
	public void ustawWyboryGracza(String wybory) {
		wyboryGracza = wybory.toCharArray();
	}
	
	public void ustawWyboryPrzeciwnika(String wybory) {
		wyboryPrzciwnika = wybory.toCharArray();
	}
	
	public WynikPojedynku walcz() {
		int zdobytePunktyGracza = 0;
		int zdobytePunktyPrzeciwnika = 0;
		String wybory = "";
		for(int r = 0; r < 5; r++) {
			wybory = "" + wyboryGracza[r] + wyboryPrzciwnika[r];
			System.out.println("Runda: " + wybory);
			switch(wybory) {
				case "KP":
					zdobytePunktyPrzeciwnika += 3;
					break;
				case "KN":
					zdobytePunktyGracza += 3;
					break;
				case "PK":
					zdobytePunktyGracza += 3;
					break;
				case "PN":
					zdobytePunktyPrzeciwnika += 3;
					break;
				case "NK":
					zdobytePunktyPrzeciwnika += 3;
					break;
				case "NP":
					zdobytePunktyGracza += 3;
					break;
				default:
					zdobytePunktyGracza += 1;
					zdobytePunktyPrzeciwnika += 1;
					break;			
			}
		}
		System.out.println("Zdobyte punkty = " + zdobytePunktyGracza);
		
		if(zdobytePunktyGracza > zdobytePunktyPrzeciwnika) {
			return new WynikPojedynku(zdobytePunktyGracza, StanPojedynku.Wygrana);
		} else if(zdobytePunktyGracza < zdobytePunktyPrzeciwnika) {
			return new WynikPojedynku(zdobytePunktyGracza, StanPojedynku.Przegrana);
		} else {
			return new WynikPojedynku(zdobytePunktyGracza, StanPojedynku.Remis);
		}
	}
}
