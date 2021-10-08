package gra.okna.panele;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import gra.dane.Wyspa;
import gra.narzedzia.Nazwy;
import gra.okna.OknoPulpitGracza;

import java.awt.Color;

@SuppressWarnings("serial")
public class PanelWyspa extends JPanel {

	private JLabel lNazwaWyspy, lSurowiecP0, lSurowiecP1, lSurowiecP2, lSurowiecW0, lSurowiecW1, lSurowiecW2;
	
	/**
	 * Create the panel.
	 */
	public PanelWyspa() {
		setBackground(Color.GRAY);
		setPreferredSize(new Dimension(539, 147));
		setLayout(null);
		
		JLabel lWyspa = new JLabel("");
		lWyspa.setIcon(new ImageIcon(OknoPulpitGracza.class.getResource("/obrazki/wyspaSama.png")));
		lWyspa.setHorizontalAlignment(SwingConstants.CENTER);
		lWyspa.setBounds(10, 10, 100, 100);
		add(lWyspa);
		
		lNazwaWyspy = new JLabel("Wyspa: Nazwa");
		lNazwaWyspy.setHorizontalAlignment(SwingConstants.CENTER);
		lNazwaWyspy.setFont(new Font("Tahoma", Font.BOLD, 14));
		lNazwaWyspy.setBounds(120, 10, 409, 36);
		add(lNazwaWyspy);
		
		JPanel panelSurowcow = new JPanel();
		panelSurowcow.setBackground(Color.GRAY);
		panelSurowcow.setBounds(120, 47, 409, 89);
		add(panelSurowcow);
		panelSurowcow.setLayout(new GridLayout(2, 3, 5, 5));
		
		lSurowiecP0 = new JLabel("<html><center><b>Drzewo</b><br>Kup: 15C</center></html>");
		lSurowiecP0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		lSurowiecP0.setOpaque(true);
		lSurowiecP0.setBackground(Color.YELLOW);
		lSurowiecP0.setForeground(Color.BLACK);
		lSurowiecP0.setBorder(new LineBorder(Color.RED, 2));
		lSurowiecP0.setHorizontalAlignment(SwingConstants.CENTER);
		lSurowiecP0.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelSurowcow.add(lSurowiecP0);
		
		lSurowiecP1 = new JLabel("<html><center><b>Żelazo</b><br>Kup: 15C</center></html>");
		lSurowiecP1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		lSurowiecP1.setOpaque(true);
		lSurowiecP1.setBackground(Color.YELLOW);
		lSurowiecP1.setForeground(Color.BLACK);
		lSurowiecP1.setBorder(new LineBorder(Color.RED, 2));
		lSurowiecP1.setHorizontalAlignment(SwingConstants.CENTER);
		lSurowiecP1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelSurowcow.add(lSurowiecP1);
		
		lSurowiecP2 = new JLabel("<html><center><b>Skóry</b><br>Kup: 15C</center></html>");
		lSurowiecP2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		lSurowiecP2.setOpaque(true);
		lSurowiecP2.setBackground(Color.YELLOW);
		lSurowiecP2.setForeground(Color.BLACK);
		lSurowiecP2.setBorder(new LineBorder(Color.RED, 2));
		lSurowiecP2.setHorizontalAlignment(SwingConstants.CENTER);
		lSurowiecP2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelSurowcow.add(lSurowiecP2);
		
		lSurowiecW0 = new JLabel("<html><center><b>Drzewo</b><br>Sprzedaj: 15C</center></html>");
		lSurowiecW0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		lSurowiecW0.setOpaque(true);
		lSurowiecW0.setBackground(Color.GREEN);
		lSurowiecW0.setForeground(Color.BLACK);
		lSurowiecW0.setBorder(new LineBorder(Color.RED, 2));
		lSurowiecW0.setHorizontalAlignment(SwingConstants.CENTER);
		lSurowiecW0.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelSurowcow.add(lSurowiecW0);
		
		lSurowiecW1 = new JLabel("<html><center><b>Żelazo</b><br>Sprzedaj: 15C</center></html>");
		lSurowiecW1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		lSurowiecW1.setOpaque(true);
		lSurowiecW1.setBackground(Color.GREEN);
		lSurowiecW1.setForeground(Color.BLACK);
		lSurowiecW1.setBorder(new LineBorder(Color.RED, 2));
		lSurowiecW1.setHorizontalAlignment(SwingConstants.CENTER);
		lSurowiecW1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelSurowcow.add(lSurowiecW1);
		
		lSurowiecW2 = new JLabel("<html><center><b>Skóry</b><br>Sprzedaj: 15C</center></html>");
		lSurowiecW2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		lSurowiecW2.setOpaque(true);
		lSurowiecW2.setBackground(Color.GREEN);
		lSurowiecW2.setForeground(Color.BLACK);
		lSurowiecW2.setBorder(new LineBorder(Color.RED, 2));
		lSurowiecW2.setHorizontalAlignment(SwingConstants.CENTER);
		lSurowiecW2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelSurowcow.add(lSurowiecW2);
	}

	public void pokazDane(Wyspa wyspa) {
		lNazwaWyspy.setText("Wyspa: " + Nazwy.wyspa(wyspa.getNazwa()));
		for (int s = 0; s < 3; s++) {
			switch(s) {
				case 0:
					//Kupno
					lSurowiecP0.setText("<html><center><b>" + Nazwy.surowiec(wyspa.getNazwaSurowcaDoKupna(s)) + "</b><br>Kup: " + wyspa.getCenaSurowcaDOKupna(s) + "</center></html>");
					//Sprzedaz
					lSurowiecW0.setText("<html><center><b>" + Nazwy.surowiec(wyspa.getNazwaSurowcaDoSprzedazy(s)) + "</b><br>Sprzedaj: " + wyspa.getCenaSurowcaDoSprzedazy(s) + "</center></html>");
					break;
				case 1:
					//Kupno
					lSurowiecP1.setText("<html><center><b>" + Nazwy.surowiec(wyspa.getNazwaSurowcaDoKupna(s)) + "</b><br>Kup: " + wyspa.getCenaSurowcaDOKupna(s) + "</center></html>");
					//Sprzedaz
					lSurowiecW1.setText("<html><center><b>" + Nazwy.surowiec(wyspa.getNazwaSurowcaDoSprzedazy(s)) + "</b><br>Sprzedaj: " + wyspa.getCenaSurowcaDoSprzedazy(s) + "</center></html>");
					break;
				case 2:
					//Kupno
					lSurowiecP2.setText("<html><center><b>" + Nazwy.surowiec(wyspa.getNazwaSurowcaDoKupna(s)) + "</b><br>Kup: " + wyspa.getCenaSurowcaDOKupna(s) + "</center></html>");
					//Sprzedaz
					lSurowiecW2.setText("<html><center><b>" + Nazwy.surowiec(wyspa.getNazwaSurowcaDoSprzedazy(s)) + "</b><br>Sprzedaj: " + wyspa.getCenaSurowcaDoSprzedazy(s) + "</center></html>");
					break;
			}
		}
	}
	/*
	public void aktualizacjaNazwy(int indeks) {
		
	}
	
	public void aktualizacjaOpisuKupnaSurowca(int indeksOpisu, int indeksSurowca, int cena) {
		String opis = "<html><center><b>" + Nazwy.surowiec(indeksSurowca) + "</b><br>Kup: " + cena + "</center></html>";
		switch (indeksOpisu) {
			case 0:
				lSurowiecP0.setText(opis);
				break;
			case 1:
				lSurowiecP1.setText(opis);
				break;
			case 2:
				lSurowiecP2.setText(opis);
				break;
		}
	}
	
	public void aktualizacjaOpisuSprzedazySurowca(int indeksOpisu, int indeksSurowca, int cena) {
		String opis = "<html><center><b>" + Nazwy.surowiec(indeksSurowca) + "</b><br>Sprzedaj: " + cena + "</center></html>";
		switch(indeksOpisu) {
			case 0:
				lSurowiecW0.setText(opis);
				break;
			case 1:
				lSurowiecW1.setText(opis);
				break;
			case 2:
				lSurowiecW2.setText(opis);
				break;
		}
	}
	*/
}
