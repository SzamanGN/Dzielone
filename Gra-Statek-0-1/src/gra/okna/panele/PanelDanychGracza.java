package gra.okna.panele;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import gra.okna.OknoPulpitGracza;

import java.awt.Color;

@SuppressWarnings("serial")
public class PanelDanychGracza extends JPanel {

	private JLabel lStanKonta, lZasiedloneWyspy;
	
	/**
	 * Create the panel.
	 */
	public PanelDanychGracza() {
		setBackground(Color.GRAY);
		setPreferredSize(new Dimension(539, 125));
		setLayout(null);
		
		JLabel lObrazekGracza = new JLabel("");
		lObrazekGracza.setIcon(new ImageIcon(OknoPulpitGracza.class.getResource("/obrazki/gracz01.png")));
		lObrazekGracza.setHorizontalAlignment(SwingConstants.CENTER);
		lObrazekGracza.setBounds(10, 10, 100, 94);
		add(lObrazekGracza);
		
		lStanKonta = new JLabel("Stan konta : 1000000000C");
		lStanKonta.setFont(new Font("Tahoma", Font.BOLD, 14));
		lStanKonta.setHorizontalAlignment(SwingConstants.CENTER);
		lStanKonta.setBounds(120, 10, 409, 36);
		add(lStanKonta);
		
		lZasiedloneWyspy = new JLabel("Zasiedlone wyspy: 0");
		lZasiedloneWyspy.setHorizontalAlignment(SwingConstants.CENTER);
		lZasiedloneWyspy.setFont(new Font("Tahoma", Font.BOLD, 14));
		lZasiedloneWyspy.setBounds(120, 57, 409, 36);
		add(lZasiedloneWyspy);
	}

	public void aktualizacjaOpisuStanuKonta(long stanKonta) {
		lStanKonta.setText("Stan konta: " + stanKonta + "C");
	}
	
	public void aktualizacjaOpisuZasiedlenia(int iloscZasiedlonychWysp) {
		lZasiedloneWyspy.setText("Zasiedlone wyspy: " + iloscZasiedlonychWysp);
	}
}
