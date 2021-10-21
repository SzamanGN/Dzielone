package gra.okna.panele;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;

public class PanelDanychGracza extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelDanychGracza() {
		setBackground(Color.LIGHT_GRAY);
		setPreferredSize(new Dimension(340,132));
		setLayout(null);
		
		JLabel lbObrazekGracza = new JLabel("");
		lbObrazekGracza.setIcon(new ImageIcon(PanelDanychGracza.class.getResource("/Obrazki/Gracz02.png")));
		lbObrazekGracza.setBounds(236, 11, 94, 110);
		add(lbObrazekGracza);
		
		JLabel lbZsiedloneWyspy = new JLabel("Zasiedlone wyspy : 0");
		lbZsiedloneWyspy.setForeground(Color.YELLOW);
		lbZsiedloneWyspy.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbZsiedloneWyspy.setHorizontalAlignment(SwingConstants.CENTER);
		lbZsiedloneWyspy.setBounds(10, 11, 216, 37);
		add(lbZsiedloneWyspy);
		
		JLabel lbStanKonta = new JLabel("Stan konta : 1000000C");
		lbStanKonta.setForeground(Color.YELLOW);
		lbStanKonta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbStanKonta.setHorizontalAlignment(SwingConstants.CENTER);
		lbStanKonta.setBounds(10, 59, 216, 37);
		add(lbStanKonta);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(PanelDanychGracza.class.getResource("/Obrazki/TloDoGracza354.png")));
		lblNewLabel.setBounds(-14, 0, 354, 132);
		add(lblNewLabel);

	}

}
