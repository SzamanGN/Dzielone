package app;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Test extends JLabel{
	
	// sciaga do pobrania sciezki img
	public Test() {
		setIcon(new ImageIcon(Test.class.getResource("/app/img/player_sprites.png")));
	}

}
