package gra.okna.panele;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class PanelStatek extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelStatek() {
		setBackground(Color.orange);
		setPreferredSize(new Dimension(340,132));
		setLayout(null);
		
		JLabel lblLadunek = new JLabel("Ladunek (10) = pusta ladownia");
		lblLadunek.setForeground(Color.YELLOW);
		lblLadunek.setBounds(10, 38, 251, 45);
		add(lblLadunek);
		
		JLabel lblStatusStatku = new JLabel("Status statku : W porcie A.");
		lblStatusStatku.setForeground(Color.YELLOW);
		lblStatusStatku.setBounds(10, 0, 172, 45);
		add(lblStatusStatku);
		
		JLabel lblLadowniaStatku = new JLabel("");
		lblLadowniaStatku.setIcon(new ImageIcon(PanelStatek.class.getResource("/Obrazki/WnetrzeKapitana132.png")));
		lblLadowniaStatku.setHorizontalAlignment(SwingConstants.CENTER);
		lblLadowniaStatku.setBounds(0, 0, 182, 132);
		add(lblLadowniaStatku);
		
		JLabel lbStatek = new JLabel("");
		lbStatek.setIcon(new ImageIcon(PanelStatek.class.getResource("/Obrazki/StatekPanel.png")));
		lbStatek.setHorizontalAlignment(SwingConstants.CENTER);
		lbStatek.setBounds(180, 0, 160, 132);
		add(lbStatek);

	}

}
