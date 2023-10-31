package panelInformacyjny;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class PanelInformacyjny extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanelInformacyjny() {
		setBackground(new Color(192, 192, 192));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lStanKonta = new JLabel("Stan konta: XX");
		lStanKonta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lStanKonta);

	}

}
