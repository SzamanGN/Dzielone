package app.OknoMapa;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OnoMapa extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public OnoMapa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 808, 591);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBackground(Color.CYAN);
		contentPane.add(layeredPane, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Wyspa");
		lblNewLabel.setBounds(101, 97, 74, 32);
		layeredPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Wyspa");
		lblNewLabel_1.setBounds(576, 67, 74, 32);
		layeredPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Wyspa");
		lblNewLabel_2.setBounds(221, 182, 74, 32);
		layeredPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Wyspa");
		lblNewLabel_3.setBounds(648, 472, 74, 32);
		layeredPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Statek");
		lblNewLabel_4.setBounds(335, 363, 101, 45);
		layeredPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Powrot do main");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(624, 11, 135, 23);
		layeredPane.add(btnNewButton);
	}
}
