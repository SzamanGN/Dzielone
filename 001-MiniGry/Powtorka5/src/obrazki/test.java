package obrazki;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class test extends JPanel {

	/**
	 * Create the panel.
	 */
	public test() {
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(test.class.getResource("/obrazki/player_sprites.png")));
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		add(panel);

	}

}
