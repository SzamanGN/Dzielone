package gra.okna.panele;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import gra.okna.OknoPulpitGracza;

import java.awt.Color;

@SuppressWarnings("serial")
public class PanelStatku extends JPanel {

	private JLabel lStausStatku, lLadunek, lCenaLadunku;
	
	/**
	 * Create the panel.
	 */
	public PanelStatku() {
		setBackground(Color.GRAY);
		setPreferredSize(new Dimension(539, 153));
		setLayout(null);
		
		JLabel lStatek = new JLabel("");
		lStatek.setIcon(new ImageIcon(OknoPulpitGracza.class.getResource("/obrazki/Statek.png")));
		lStatek.setHorizontalAlignment(SwingConstants.CENTER);
		lStatek.setBounds(10, 10, 100, 69);
		add(lStatek);
		
		lStausStatku = new JLabel("Status statku: w porcie A");
		lStausStatku.setHorizontalAlignment(SwingConstants.CENTER);
		lStausStatku.setFont(new Font("Tahoma", Font.BOLD, 14));
		lStausStatku.setBounds(120, 10, 409, 36);
		add(lStausStatku);
		
		lLadunek = new JLabel("Ladunek (10): pusta ladownia");
		lLadunek.setHorizontalAlignment(SwingConstants.CENTER);
		lLadunek.setFont(new Font("Tahoma", Font.BOLD, 14));
		lLadunek.setBounds(120, 41, 409, 36);
		add(lLadunek);
		
		lCenaLadunku = new JLabel("Cena ladunku: 15000C");
		lCenaLadunku.setHorizontalAlignment(SwingConstants.CENTER);
		lCenaLadunku.setFont(new Font("Tahoma", Font.BOLD, 14));
		lCenaLadunku.setBounds(120, 74, 409, 36);
		add(lCenaLadunku);
		
		JButton bZaladunek = new JButton("Zaladunek");
		bZaladunek.setFont(new Font("Tahoma", Font.BOLD, 16));
		bZaladunek.setBounds(130, 121, 119, 23);
		add(bZaladunek);
		
		JButton bRozladunek = new JButton("Rozladunek");
		bRozladunek.setFont(new Font("Tahoma", Font.BOLD, 16));
		bRozladunek.setBounds(259, 121, 143, 23);
		add(bRozladunek);
	}

	public void aktualizacjaStatusu(boolean plynie, String nazwaWyspy) {
		String opis = "Status statku: ";
		if (plynie) {
			opis += "płynie do wyspy";
		} else {
			opis += "znajduje się w porcie wyspy";
		}
		opis += " " + nazwaWyspy;
		lStausStatku.setText(opis);
	}
	
	public void aktualizacjaLadunku(int iloscTowaru, String rodzajTowaru) {
		String opis = "Ladunek (10): ";
		if (iloscTowaru == 0) {
			opis += "pusta ladownia";
		} else {
			opis += iloscTowaru + " x " + rodzajTowaru;
		}
		lLadunek.setText(opis);
	}
	
	public void aktualizacjaCenyLadunku(int cena) {
		String opis = "Cena ladunku: ";
		if (cena == 0) {
			opis += "-";
		} else {
			opis += cena + "C";
		}
		lCenaLadunku.setText(opis);
	}
}
