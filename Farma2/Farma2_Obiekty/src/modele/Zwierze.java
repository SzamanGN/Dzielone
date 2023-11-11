package modele;

public class Zwierze {
	private int id; // rysunek i nazwa
	private Zycie zycie; // ilosc cykli okresla wiek
	private boolean samiec;// zalozenie tru samiec fallse samica
	private Ciaza ciaza; // obsluga ciazy 
	private ParametrZwierzecia najedzenie;
	private ParametrZwierzecia napojenie;
	
	public Zwierze() {
		ustaw(0, 0, 0, 0, true, 0);
	}
	
	public Zwierze(int id, int czasZycia, int wiek, int dojrzalosc, boolean samiec, int czasCiazy) {
		ustaw(id, czasZycia, wiek, dojrzalosc, samiec, czasCiazy);
	}

	private void ustaw(int id, int czasZycia, int wiek, int dojrzalosc, boolean samiec, int czasCiazy) { // przesylamy czas do ciazy 
		this.id = id;
		zycie = new Zycie(czasZycia, wiek, dojrzalosc); // wazne !!!!!!!!
		this.samiec = samiec;
		ciaza = new Ciaza(czasCiazy); // wazne pamietac !!!!!!!!
		najedzenie = new ParametrZwierzecia();
		napojenie = new ParametrZwierzecia();
	}

	public int getId() {
		return id;
	}


	public boolean isSamiec() {
		return samiec;
	}

	public Ciaza getCiaza() {
		return ciaza;
	}
	
	
	public void tikZegara() {
		zycie.tikZegara();
		ciaza.tikZegara();
		najedzenie.tikZegara();
		napojenie.tikZegara();
	}
	
	public boolean isZyje() {
		return zycie.isZyje();
	}
	
	public void sprawdzenieCiazy() {
		if (!ciaza.isCiaza()) { // bezpicznik czy w ciazy
			if(zycie.isDojrzaly()) {
				// lsowy bezpicznik zajcia w ciaze
				ciaza = new Ciaza(10);// wazne potzrebna zmiena globalna statyczna przechowujaca czas/od zwierzecia
			}
		}
	}

	public ParametrZwierzecia getNajedzenie() {
		return najedzenie;
	}

	public ParametrZwierzecia getNapojenie() {
		return napojenie;
	}
	
	
}
