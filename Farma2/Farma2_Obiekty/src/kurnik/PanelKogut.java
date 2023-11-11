package kurnik;

import paneleZwirzat.PanelZwierzecia;
import java.awt.Color;
import javax.swing.ImageIcon;

public class PanelKogut extends PanelZwierzecia {

	private Kogut kogut;

	public PanelKogut() {
		super();
		ustaw(-1, 0);
	}

	public PanelKogut(int czasZycia, int wiek) {
		super();
		ustaw(czasZycia, wiek);
	}

	private void ustaw(int czasZycia, int wiek) {
		setBackground(Color.DARK_GRAY);
		if (czasZycia > 0) {
			kogut = new Kogut(czasZycia, wiek);
		} else {
			kogut = new Kogut(-1);
		}
		incjowanieWizulalizacji();
	}

	private void incjowanieWizulalizacji() {
		if (kogut.getId() >= 0) {
			// rysujemy koguta
			eObrazek.setBackground(Color.ORANGE);
			eObrazek.setText("");
			// eObrazek.setIcon(new
			// ImageIcon(PanelKogut.class.getResource("/obrazki/wiadro.png")));
			aktulizacjaParametrow();
		} else {
			// brak koguta
			eObrazek.setBackground(Color.GREEN);
			eObrazek.setText("<html><center>Brak koguta!<br>Bez koguta nie ma jaj!</center></html>");
			eObrazek.setIcon(null);
		}
	}

	public void tikZegara() {
		kogut.tikZegara();
		aktulizacjaParametrow();
	}

	private void aktulizacjaParametrow() {
		eNajedzie.setBackground(kogut.getNajedzenie().getStan());
		eNapojenie.setBackground(kogut.getNapojenie().getStan());
	}
}
