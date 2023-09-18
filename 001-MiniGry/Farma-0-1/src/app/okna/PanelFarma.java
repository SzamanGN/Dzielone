package app.okna;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.JList;

public class PanelFarma extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelFarma() {
		setOpaque(false);
		setForeground(new Color(128, 255, 128));
		setLayout(new BorderLayout(0, 0));
		
		JLabel lbStanKonta = new JLabel("StanKonta:");
		lbStanKonta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbStanKonta.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbStanKonta, BorderLayout.NORTH);
		
		JLabel lbStajnia = new JLabel("Stajnia");
		add(lbStajnia, BorderLayout.WEST);
		
		JLabel lbZagroda = new JLabel("Zagroda");
		lbZagroda.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbZagroda, BorderLayout.CENTER);
		
		JLabel lbKurnik = new JLabel("Kurnik");
		add(lbKurnik, BorderLayout.EAST);
		
		JLabel lbStudnia = new JLabel("Studnia");
		add(lbStudnia, BorderLayout.SOUTH);

	}

}
