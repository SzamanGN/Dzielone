package gra;

import javax.swing.JFrame;
import java.awt.Toolkit;

public class Test extends JFrame{
	public Test() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Test.class.getResource("/obrazki/level_one_data.png")));
	}

}
