package gra.okna.panele;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;

public class PanelWyspa extends JPanel {

	private JLabel lKup;
	/**
	 * Create the panel.
	 */
	public PanelWyspa(MouseAdapter mouseAdapter) {
		setBackground(Color.BLUE);
		setPreferredSize(new Dimension(340,132));
		setLayout(null);
		
		JLabel lblNazwaWyspy = new JLabel("Wyspa : nazwa");
		lblNazwaWyspy.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNazwaWyspy.setForeground(Color.YELLOW);
		lblNazwaWyspy.setHorizontalAlignment(SwingConstants.LEFT);
		lblNazwaWyspy.setBounds(10, 11, 110, 30);
		add(lblNazwaWyspy);
		
		JLabel lblWyspa = new JLabel("");
		lblWyspa.setIcon(new ImageIcon(PanelWyspa.class.getResource("/Obrazki/PanelWyspyTlo110.png")));
		lblWyspa.setBounds(117, 11, 213, 110);
		add(lblWyspa);
		
		lKup = new JLabel("Kup");
		lKup.setOpaque(true);
		lKup.setForeground(Color.BLACK);
		lKup.setBackground(Color.GREEN);
		lKup.setHorizontalAlignment(SwingConstants.CENTER);
		lKup.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lKup.putClientProperty("akcja", "kup");
		lKup.addMouseListener(mouseAdapter);
		lKup.setBounds(10, 52, 97, 21);
		add(lKup);
		
		JLabel lSprzedaj = new JLabel("Sprzedaj");
		lSprzedaj.setOpaque(true);
		lSprzedaj.setHorizontalAlignment(SwingConstants.CENTER);
		lSprzedaj.setForeground(Color.BLACK);
		lSprzedaj.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lSprzedaj.setBackground(Color.YELLOW);
		lSprzedaj.setBounds(10, 86, 97, 21);
		lSprzedaj.putClientProperty("akcja", "sprzedaj");
		lSprzedaj.addMouseListener(mouseAdapter);
		add(lSprzedaj);

	}

}
