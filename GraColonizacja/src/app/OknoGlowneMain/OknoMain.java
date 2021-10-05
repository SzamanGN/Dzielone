package app.OknoGlowneMain;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OknoMain extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public OknoMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Witaj w grze Colonizacja by A.Cygan");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(163, 11, 392, 39);
		layeredPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");	
		Image img = new ImageIcon(this.getClass().getResource("IMG/caravelTen.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(148, 91, 400, 279);
		layeredPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Nowa Gra");
		btnNewButton.setBounds(51, 489, 89, 23);
		layeredPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Wczytaj Gre");
		btnNewButton_1.setBounds(163, 489, 116, 23);
		layeredPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Koniec Gry");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(546, 489, 89, 23);
		layeredPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Zapisz gre");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(308, 489, 89, 23);
		layeredPane.add(btnNewButton_3);
		
		setVisible(true);
	}
}
