package panele;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class PanelTest extends JPanel {


	public PanelTest() {
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setIcon(new ImageIcon(PanelTest.class.getResource("/obrazki/BartekPrzud.png")));
		add(lblNewLabel);

	}

}
