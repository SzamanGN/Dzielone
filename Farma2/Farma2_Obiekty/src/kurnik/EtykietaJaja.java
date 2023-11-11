package kurnik;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EtykietaJaja extends JLabel {
	
	private boolean jestJajko;

	public EtykietaJaja(int ktoryPanel, int indeksKury, int indeksJajka) {
		ustaw(ktoryPanel, indeksKury, indeksJajka, null);
	}

	public EtykietaJaja(int ktoryPanel, int indeksKury, int indeksJajka, MouseAdapter mouseAdapter) {
		ustaw(ktoryPanel, indeksKury, indeksJajka, mouseAdapter);
	}

	private void ustaw(int ktoryPanel, int indeksKury, int indeksJajka, MouseAdapter mouseAdapter) {
		putClientProperty("ktoryPanel", ktoryPanel);
		putClientProperty("indeskKury", indeksKury);
		putClientProperty("indeksJajka", indeksJajka);

		addMouseListener(mouseAdapter);
		setHorizontalAlignment(SwingConstants.CENTER);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setObrazek();
	}

	public void setObrazek() {
		setIcon(new ImageIcon(EtykietaJaja.class.getResource("/obrazki/jajko.png")));
		jestJajko = true;
	}

	public void removeObrazek() {
		setIcon(null);
		jestJajko = false;
	}

	public boolean isJajko() {
		return jestJajko;
	}
}
