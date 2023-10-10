package dodatki;

import gra.Gra;

public class Stale {
	
	public static class UI{
		public static class Przyciski {
			public static final int P_SZEROKOSC_DOMYSLNA = 140;
			public static final int P_WYSOKOSC_DOMYSLNA = 56;
			public static final int P_SZEROKOSC = (int) (P_SZEROKOSC_DOMYSLNA * Gra.scalowanie);
			public static final int P_WYSOKOSC = (int) (P_WYSOKOSC_DOMYSLNA * Gra.scalowanie);
		}
		
		public static class PauzaPrzyciski{
			public static final int DZWIEK_WIELKOSC_DOMYSLNA = 42;
			public static final int DZWIEK_WIELKOSC = (int) (DZWIEK_WIELKOSC_DOMYSLNA * Gra.scalowanie);
		}
		
		public static class URMPRzyciski{
		public static final int URM_WIELKOSC_DOMYSLNA = 56;
		public static final int URM_WIELKOSC = (int) (URM_WIELKOSC_DOMYSLNA * Gra.scalowanie);
		}
		
		public static class GlosnoscPrzyciski{
			public static final int GLOSNOSC_DOMYSLNIE_SZEROKOSC = 28;
			public static final int GLOSNOSC_DOMYSLNIE_WYSOKOSC = 44;
			public static final int SUWAK_DOMYSLNIE_SZEROKOSC = 215;
			
			public static final int GLOSNOSC_SZEROKOSC = (int) (GLOSNOSC_DOMYSLNIE_SZEROKOSC * Gra.scalowanie);
			public static final int GLOSNOSC_WYSOKOSC = (int) (GLOSNOSC_DOMYSLNIE_WYSOKOSC * Gra.scalowanie);
			public static final int SUWAK_SZEROKOSC = (int) (SUWAK_DOMYSLNIE_SZEROKOSC * Gra.scalowanie);
			
		}
		
		
	}
	
	
	public static class Kierunek {

		public static final int LEWO = 0;
		public static final int GORA = 1;
		public static final int PRAWO = 2;
		public static final int DOL = 3;
		
	}
	
	public static  class StaleGracza {
	public static final int STOI = 0;
	public static final int BIEGNIE = 1;
	public static final int SKACZE = 2;
	public static final int UPADA = 3;
	public static final int ZIEMIA = 4;
	public static final int UDERZA = 5;
	public static final int ATAKUJE_1 = 6;
	public static final int ATAKUJE_SKOK_1 = 7;
	public static final int ATAKUJE_SKOK_2 = 8;
	
	public static int PobierzDuszkaWielkosc(int gracz_akcja) {
		switch(gracz_akcja) {
		case BIEGNIE:
			return 6;
		case STOI:
			return 5;
		case UDERZA:
			return 4;
		case SKACZE:
		case ATAKUJE_1:
		case ATAKUJE_SKOK_2:
			return 3;
		case ZIEMIA:
			return 2;
		case UPADA:
			default:
				return 1;
		}
		
	}
	
	}
}
