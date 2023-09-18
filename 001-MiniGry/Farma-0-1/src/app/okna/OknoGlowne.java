package app.okna;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OknoGlowne extends JFrame {

	private JPanel contentPane;


	public OknoGlowne() {
		setTitle("Farma-0-1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panelStart = new JPanel();
		contentPane.add(panelStart);
		panelStart.setLayout(new BorderLayout(0, 0));
		
		JLabel lblFarma = new JLabel("Farma-0-1 obrazek");
		lblFarma.setHorizontalAlignment(SwingConstants.CENTER);
		lblFarma.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelStart.add(lblFarma, BorderLayout.NORTH);
		
		JButton btnStart = new JButton("StartGry");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panelStart.add(btnStart, BorderLayout.WEST);
		
		JButton btnNewButton_1 = new JButton("Ustawienias");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panelStart.add(btnNewButton_1, BorderLayout.CENTER);
		
		JButton btnNewButton_2 = new JButton("Zakoncz");
		panelStart.add(btnNewButton_2, BorderLayout.EAST);
		
		JLabel lblNewLabel = new JLabel("Farma obrazek");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 34));
		panelStart.add(lblNewLabel, BorderLayout.SOUTH);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
