package main;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Test extends JPanel {

	/**
	 * Create the panel.
	 */
	public Test() {
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Test.class.getResource("/res/level_one_data.png")));
		add(lblNewLabel);

	}

}
