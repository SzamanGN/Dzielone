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

public class OknoMenu extends JFrame {

	private JPanel contentPane;


	public OknoMenu() {
		setUndecorated(true);
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
		
		JLabel lblNewLabel = new JLabel("Farma obrazek");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 34));
		panelStart.add(lblNewLabel, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		panelStart.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(3, 1, 5, 5));
		
		JButton pStarGry = new JButton("Start gry");
		pStarGry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				uruchomienieGry();
			}

		});
		panel.add(pStarGry);
		
		JButton pUstawienia = new JButton("Ustawienia");
		pUstawienia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doUstawien();
			}
		});
		panel.add(pUstawienia);
		
		JButton pWyjdz = new JButton("Zakoncz gre");
		pWyjdz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		panel.add(pWyjdz);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void uruchomienieGry() {
		new OknoFarmy();
		dispose();
	}
	
	private void doUstawien() {
		new OknoUstawien();
		dispose();
	}

}
