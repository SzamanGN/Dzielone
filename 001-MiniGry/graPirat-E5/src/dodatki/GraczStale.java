package dodatki;

public class GraczStale {
	
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
		case ATAKUJE_SKOK_1:
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
