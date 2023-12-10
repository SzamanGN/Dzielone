package panele;

import javax.swing.JPanel;

import etykiety.EtykietaPunktacji;

import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.FlowLayout;

public class PanelPunktacja extends JPanel {

	private static final long serialVersionUID = 1L;
	private EtykietaPunktacji punkty;
	private EtykietaPunktacji wygrane;
	private EtykietaPunktacji remisy;
	private EtykietaPunktacji przegrane;
	
	
	public PanelPunktacja() {
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setHgap(25);
		setBackground(new Color(64, 0, 64));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		punkty = new EtykietaPunktacji("Punkty: 0");
		wygrane = new EtykietaPunktacji("Wygrane: 0");
		remisy = new EtykietaPunktacji("Remisy: 0");
		przegrane = new EtykietaPunktacji("Przegrane: 0");
		 
		add(punkty);
		add(wygrane);
		add(remisy);
		add(przegrane);
		
	}
	
	public void aktulizacjaPuntow(long ilosc) {
		punkty.pokazTekst("Punkty: " + ilosc);
	}
	
	public void aktulizacjaWygrane(long ilosc) {
		wygrane.pokazTekst("Wygrane: " + ilosc);
	}
	
	public void aktulizacjaRemisy(long ilosc) {
		remisy.pokazTekst("Remisy: " + ilosc);
	}
	
	public void aktulizacjaPrzegrane(long ilosc) {
		przegrane.pokazTekst("Przegrane: " + ilosc);
	}

}
