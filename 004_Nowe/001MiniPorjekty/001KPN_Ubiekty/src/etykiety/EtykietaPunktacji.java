package etykiety;

import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class EtykietaPunktacji extends JLabel {
	public EtykietaPunktacji() {
		ustaw("Etykieta domyslna");
	}
	
	public EtykietaPunktacji(String tekst) {
		ustaw(tekst);
	}
	
	public void pokazTekst(String tekst) {
		setText(tekst);
	}
	
	private void ustaw(String tekst) {
		setHorizontalAlignment(SwingConstants.CENTER);
		setText(tekst);
		setForeground(new Color(255, 255, 128));
		setFont(new Font("Tahoma", Font.BOLD, 16));
		setOpaque(true);
		setBackground(new Color(0, 128, 255));
		setBorder(new EmptyBorder(5, 5, 5, 5));
	}

}
