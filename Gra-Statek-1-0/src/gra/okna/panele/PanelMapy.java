package gra.okna.panele;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class PanelMapy extends JPanel {

	private JLabel lbWysypa, lbWysypa_1, lbWysypa_2;
	/**
	 * Create the panel.
	 */
	public PanelMapy(MouseAdapter mouseAdapter) {
		setBackground(Color.cyan);
		setPreferredSize(new Dimension(561,459));
		
		setLayout(null);
		
		lbWysypa_2 = new JLabel("");
		lbWysypa_2.setIcon(new ImageIcon(PanelMapy.class.getResource("/Obrazki/Wyspa101a.png")));
		lbWysypa_2.setHorizontalAlignment(SwingConstants.CENTER);
		lbWysypa_2.setBounds(306, 277, 134, 101);
		lbWysypa_2.putClientProperty("akcja", "wybranaWyspa");
		lbWysypa_2.putClientProperty("indeks", 2);
		lbWysypa_2.addMouseListener(mouseAdapter);
		add(lbWysypa_2);
		
		lbWysypa_1 = new JLabel("");
		lbWysypa_1.setIcon(new ImageIcon(PanelMapy.class.getResource("/Obrazki/Wyspab101.png")));
		lbWysypa_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbWysypa_1.setBounds(382, 81, 134, 101);
		lbWysypa_1.putClientProperty("akcja", "wybranaWyspa");
		lbWysypa_1.putClientProperty("indeks", 1);
		lbWysypa_1.addMouseListener(mouseAdapter);
		add(lbWysypa_1);
		
		lbWysypa = new JLabel("");
		lbWysypa.setHorizontalAlignment(SwingConstants.CENTER);
		lbWysypa.setIcon(new ImageIcon(PanelMapy.class.getResource("/Obrazki/Wyspa101a.png")));
		lbWysypa.setBounds(10, 123, 134, 101);
		lbWysypa.putClientProperty("akcja", "wybranaWyspa");
		lbWysypa.putClientProperty("indeks", 0);
		lbWysypa.addMouseListener(mouseAdapter);
		add(lbWysypa);
		
		JLabel lbMapa = new JLabel("");
		lbMapa.setIcon(new ImageIcon(PanelMapy.class.getResource("/Obrazki/Morze451.png")));
		lbMapa.setHorizontalAlignment(SwingConstants.CENTER);
		lbMapa.setBounds(0, 0, 561, 459);
		add(lbMapa);

		zaznacz(0);
	}

	private void przelaczZaznaczenie(boolean zaznacz, JLabel etykieta) {
		if (zaznacz) {
			etykieta.setBorder(new LineBorder(Color.CYAN, 3));
		} else {
			etykieta.setBorder(null);
		}
	}
	
	public void odznacz(int indeks) {
		switch (indeks ) {
			case 0:
				przelaczZaznaczenie(false, lbWysypa);
				break;
			case 1:
				przelaczZaznaczenie(false, lbWysypa_1);
				break;
			case 2:
				przelaczZaznaczenie(false, lbWysypa_2);
				break;
		}
	}
	
	public void zaznacz(int indeks) {
		switch (indeks ) {
			case 0:
				przelaczZaznaczenie(true, lbWysypa);
				break;
			case 1:
				przelaczZaznaczenie(true, lbWysypa_1);
				break;
			case 2:
				przelaczZaznaczenie(true, lbWysypa_2);
				break;
		}
	}
}
