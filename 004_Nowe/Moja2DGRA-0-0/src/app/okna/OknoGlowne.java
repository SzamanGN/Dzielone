package app.okna;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.panele.GamePanel;

public class OknoGlowne extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private GamePanel gamePanel;


	public OknoGlowne() {
		setTitle("2D Gra");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		//contentPane = new JPanel();
		//.setBorder(new EmptyBorder(5, 5, 5, 5));
		gamePanel = new GamePanel();
		contentPane.add(gamePanel);
		
		
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

}
