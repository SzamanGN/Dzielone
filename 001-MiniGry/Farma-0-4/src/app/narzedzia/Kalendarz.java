package app.narzedzia;

import javax.swing.JLabel;

public class Kalendarz {
	
	private JLabel etykieta;
	private String prefiks;
	private String sufiks;
	private int rok, miesiac, dzien, godzina, minuta;
	
	public Kalendarz(JLabel etykieta ,String prefiks, String sufiks) {
		this.etykieta = etykieta;
		this.prefiks = prefiks;
		this.sufiks = sufiks;
		rok = 1;
		miesiac = 1;
		dzien = 1;
		godzina = 0;
		minuta = 1;
	}

	public String getStan() {
		return String.format(
				"%s%04d-%02d-%02d %02d:%02d%s",// wazne 0 wiodace dla cyfr!!!!!!
				prefiks, rok, miesiac, dzien, godzina, minuta, sufiks
				);
	}
	
	public void tikZegara() {
		minuta += 1;
		if (minuta > 59) {
			minuta = 0;
			godzina += 1;
			if (godzina > 23) {
				godzina = 0;
				dzien += 1;
				if (dzien > 30) {
					dzien = 1;
					miesiac += 1;
					if (miesiac > 12) {
						miesiac = 1;
						rok += 1;
						if (rok > 9999) {
							rok = 0;
						}
					}
				}
			}
		}
		etykieta.setText(getStan());
		etykieta.updateUI();
	}
}
