package app.okna;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import app.okna.popupy.DodawanieInwestycji;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class OknoGlowne2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the frame.
	 */
	public OknoGlowne2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 705, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, BorderLayout.CENTER);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 173, 65);
		layeredPane.add(tabbedPane);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(172, 0, 173, 65);
		layeredPane.add(tabbedPane_1);
		
		textField = new JTextField();
		textField.setBounds(164, 141, 86, 20);
		layeredPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Roczny Zysk");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(44, 140, 111, 19);
		layeredPane.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(164, 171, 86, 20);
		layeredPane.add(textField_1);
		
		JLabel lblRoczbneWydatki = new JLabel("Roczne Wydatki");
		lblRoczbneWydatki.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRoczbneWydatki.setBounds(44, 170, 111, 19);
		layeredPane.add(lblRoczbneWydatki);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(164, 203, 86, 20);
		layeredPane.add(textField_2);
		
		JLabel lblRoczbnyDochod = new JLabel("Roczny Dochod");
		lblRoczbnyDochod.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRoczbnyDochod.setBounds(44, 202, 111, 19);
		layeredPane.add(lblRoczbnyDochod);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(164, 235, 86, 20);
		layeredPane.add(textField_3);
		
		JLabel lblRentownosc = new JLabel("Rentownosc");
		lblRentownosc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRentownosc.setBounds(44, 234, 111, 19);
		layeredPane.add(lblRentownosc);
		
		JButton btnNewButton = new JButton("Zapis");
		btnNewButton.setBounds(562, 370, 89, 23);
		layeredPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Usun");
		btnNewButton_1.setBounds(29, 370, 89, 23);
		layeredPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		Image img = new ImageIcon(this.getClass().getResource("/Money-icon.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(355, 87, 256, 256);
		layeredPane.add(lblNewLabel_1);
		
		JButton btnNewButton_2 = new JButton("Dodaj Inwestycje");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pokazPopupDodaniaInwestycji();
			}
		});
		btnNewButton_2.setBounds(355, 11, 142, 23);
		layeredPane.add(btnNewButton_2);
		
		setVisible(true);
	}

	private void pokazPopupDodaniaInwestycji() {
		setVisible(false);
		new DodawanieInwestycji(this);
	}
	
	public void pokazOkno() {
		setVisible(true);
	}
}
