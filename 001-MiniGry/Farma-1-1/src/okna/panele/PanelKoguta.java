package okna.panele;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;

public class PanelKoguta extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelKoguta() {
		setOpaque(false);
		setPreferredSize(new Dimension(184, 260));
		setLayout(null);
		
		JLabel eNazwa = new JLabel("(Nazwa koguta)");
		eNazwa.setHorizontalAlignment(SwingConstants.CENTER);
		eNazwa.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		eNazwa.setBounds(10, 10, 164, 57);
		add(eNazwa);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(PanelKoguta.class.getResource("/obrazki/kurnik/kogutD.png")));
		lblNewLabel.setBounds(20, 62, 145, 159);
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBounds(10, 211, 164, 36);
		add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Czy zapladania");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel_1);
		
	}
}
