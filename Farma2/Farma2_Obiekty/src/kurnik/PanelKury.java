package kurnik;

import paneleZwirzat.PanelZwierzecia;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;

import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class PanelKury extends PanelZwierzecia {

	private Kura kura;
	private JPanel panelJaj;

	public PanelKury() {
		super();
		ustaw(-1, 0, 0, 0, 0, null);
	}

	public PanelKury(int czasZycia, int wiek, int czasCiazy, int ktoryPanel, int indeksKury,
			MouseAdapter mouseAdapter) {
		super();
		ustaw(czasZycia, wiek, czasCiazy, ktoryPanel, indeksKury, mouseAdapter);
	}

	private void ustaw(int czasZycia, int wiek, int czasCiazy,int ktoryPanel, int indeksKury, MouseAdapter mouseAdapter) {
		panelJaj = new JPanel();
		panelJaj.setBorder(new EmptyBorder(5, 5, 5, 5));
		add(panelJaj, BorderLayout.SOUTH);
		panelJaj.setLayout(new GridLayout(0, 5, 5, 5));
		
		if(czasZycia > 0) {
			kura = new Kura(czasZycia, wiek, czasCiazy);
		} else {
			kura = new Kura(-1);
		}
		
		for(int i = 0; i < 5; i++) {
			panelJaj.add(new EtykietaJaja(ktoryPanel, indeksKury, i, mouseAdapter));
		}
		incjowanieWizulalizacji();
	}

	private void incjowanieWizulalizacji() {
		if (kura.getId() >= 0) {
			// rysujemy kure
			eObrazek.setBackground(Color.ORANGE);
			eObrazek.setText("");
			// eObrazek.setIcon(new
			// ImageIcon(PanelKogut.class.getResource("/obrazki/wiadro.png")));
			aktualizacjaParametrow();
		} else {
			// brak kury
			eObrazek.setBackground(Color.GREEN);
			eObrazek.setText("<html><center>Brak kury!</center></html>");
			eObrazek.setIcon(null);
		}
	}

	public void tikZegara() {
		if (kura.getId() >= 0) {
			kura.tikZegara();
			aktualizacjaParametrow();
		}
	}

	private void aktualizacjaParametrow() {
		eNajedzie.setBackground(kura.getNajedzenie().getStan());
		eNapojenie.setBackground(kura.getNapojenie().getStan());
	}

	public boolean isJajko(int indeksJajka) {
		return ((EtykietaJaja) panelJaj.getComponent(indeksJajka)).isJajko();
	}

	public void usunJajko(int indeksJajka) {
		((EtykietaJaja) panelJaj.getComponent(indeksJajka)).removeObrazek();	
	}

}
