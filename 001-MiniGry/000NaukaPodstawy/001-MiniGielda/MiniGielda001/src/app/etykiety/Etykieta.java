package app.etykiety;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Etykieta extends JLabel {

	public Etykieta() {
		super();
		ustaw(0, null);
	}

	public Etykieta(int ile, MouseAdapter etykietaMouseAdapter) {
		super();
		ustaw(ile, etykietaMouseAdapter);
	}

	private void ustaw(int ile, MouseAdapter etykietaMouseAdapter) {
		addMouseListener(etykietaMouseAdapter);
		setBorder(new EmptyBorder(15, 15, 15, 15));
		setText(String.valueOf(ile));
		setHorizontalAlignment(SwingConstants.CENTER);
		setForeground(new Color(255, 255, 0));
		setFont(new Font("Tahoma", Font.PLAIN, 29));
		setBackground(new Color(0, 0, 255));
		setOpaque(true);
	}
}
