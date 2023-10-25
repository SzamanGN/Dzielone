package dane;

public class Receptury {
	
	private static String[] receptury = {
			"010", "020", "012"    // 0 - mleko 1 - truskawka 2 - babanany  indeksy nazw nazwyProdukty
	};

	public static int isReceptura(String receptura) {
		int wynik = -1;
		int ilosc = receptury.length;
		for(int i = 0; i < ilosc; i++) {
			if(receptury[i].equals(receptura)){
				wynik = i;
				break;
			}
		}
		return wynik;
	}
}
