package kurnik;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EtykietaJaja extends JLabel {
	public EtykietaJaja(int ktoryPanel, int indeksKury, int indeksJajka) {
		putClientProperty("ktoryPanel", ktoryPanel);
		putClientProperty("indeskKury", indeksKury);
		putClientProperty("indeksJajka", indeksJajka);
		
		addMouseListener();
		setHorizontalAlignment(SwingConstants.CENTER);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setIcon(new ImageIcon(EtykietaJaja.class.getResource("/obrazki/wiadro.png")));
	}
	
	public void setObrazek() {
		setIcon(new ImageIcon(EtykietaJaja.class.getResource("/obrazki/wiadro.png")));
	}
	
	public void removeObrazek() {
		setIcon(null);
	}
}
