package app.dodatki;

public class Stale {

	public static class Kierunek {
		public static final int LEWO = 0;
		public static final int GORA = 1;
		public static final int PRAWA = 2;
		public static final int DOL = 3;
	}

	public static class GraczStale{
		public static final int STOI = 0;
		public static final int BIEG = 1;
		public static final int SKOK = 2;
		public static final int SPADEK = 3;
		public static final int PODLOGA = 4;
		public static final int UDEZ = 5;
		public static final int ATAK_1 = 6;
		public static final int ATAK_SKOK_1 = 7;
		public static final int ATAK_SKOK_2 = 8;
		
		public static int PobDuszkaWiel(int gracz_akcja) {
			switch (gracz_akcja) {
			case BIEG:
				return 6;
			case STOI:
				return 5;
			case UDEZ:
				return 4;
			case SKOK:
			case ATAK_1:
			case ATAK_SKOK_1:
			case ATAK_SKOK_2:
				return 3;
			case PODLOGA:
				return 2;
			case SPADEK:
				default:
					return 1;
			}
		}
		
	}
	
}
