package app.okna;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OknoUstawien extends JFrame {

	private JPanel contentPane;

	public OknoUstawien() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 841, 683);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelAkcji = new JPanel();
		contentPane.add(panelAkcji, BorderLayout.SOUTH);
		
		JButton pZatwierdz = new JButton("Zatwierdz");
		pZatwierdz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zatwierdzenie();
			}
		});
		panelAkcji.add(pZatwierdz);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void zatwierdzenie() {
		new OknoMenu();
		dispose();
	}

}
