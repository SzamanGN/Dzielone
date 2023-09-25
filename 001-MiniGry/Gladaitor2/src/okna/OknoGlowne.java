package okna;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Dimension;

public class OknoGlowne extends JFrame {

	private JPanel contentPane;


	public OknoGlowne() {
		setTitle("Arena-0-1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1021, 689);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelInformacyjny = new JPanel();
		contentPane.add(panelInformacyjny, BorderLayout.NORTH);
		
		JPanel panelAkcji = new JPanel();
		contentPane.add(panelAkcji, BorderLayout.SOUTH);
		
		JButton btnRozpocznijWalke = new JButton("Walcz");
		btnRozpocznijWalke.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelAkcji.add(btnRozpocznijWalke);
		
		JButton btnZakoncz = new JButton("Zakoncz");
		btnZakoncz.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelAkcji.add(btnZakoncz);
		
		JPanel panelGladiatoraB = new JPanel();
		panelGladiatoraB.setPreferredSize(new Dimension(150, 200));
		contentPane.add(panelGladiatoraB, BorderLayout.EAST);
		
		JLabel lblGladiatorB = new JLabel("Gladiator B");
		lblGladiatorB.setFont(new Font("Tahoma", Font.BOLD, 20));
		panelGladiatoraB.add(lblGladiatorB);
		
		JLabel lbGladiatorB = new JLabel("");
		lbGladiatorB.setIcon(new ImageIcon(OknoGlowne.class.getResource("/obrazki/GladiatorB.png")));
		panelGladiatoraB.add(lbGladiatorB);
		
		JLabel eGladiorB = new JLabel("<html>\r\nAtak: XX <br>\r\nObrona: XX <br>\r\nZucie: XX \r\n</html>");
		eGladiorB.setFont(new Font("Tahoma", Font.BOLD, 22));
		panelGladiatoraB.add(eGladiorB);
		
		JPanel panelGladiatoraA = new JPanel();
		panelGladiatoraA.setPreferredSize(new Dimension(150, 200));
		contentPane.add(panelGladiatoraA, BorderLayout.WEST);
		
		JLabel lblGladiatorAA = new JLabel("Gladiator A");
		lblGladiatorAA.setFont(new Font("Tahoma", Font.BOLD, 20));
		panelGladiatoraA.add(lblGladiatorAA);
		
		JLabel lbGladiatorA = new JLabel("");
		lbGladiatorA.setHorizontalAlignment(SwingConstants.CENTER);
		lbGladiatorA.setIcon(new ImageIcon(OknoGlowne.class.getResource("/obrazki/GladiatorB.png")));
		panelGladiatoraA.add(lbGladiatorA);
		
		JLabel eGladiorA = new JLabel("<html>\r\nAtak: XX <br>\r\nObrona: XX <br>\r\nZucie: XX \r\n</html>");
		eGladiorA.setFont(new Font("Tahoma", Font.BOLD, 22));
		panelGladiatoraA.add(eGladiorA);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPaneWynikBitwy = new JScrollPane();
		panel_4.add(scrollPaneWynikBitwy, BorderLayout.SOUTH);
		
		JLabel lbwynikBitwy = new JLabel("Wynik bitwy");
		lbwynikBitwy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbwynikBitwy.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPaneWynikBitwy.setColumnHeaderView(lbwynikBitwy);
		
		JList listWyink = new JList();
		listWyink.setVisibleRowCount(10);
		scrollPaneWynikBitwy.setViewportView(listWyink);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(OknoGlowne.class.getResource("/obrazki/Arena.png")));
		panel_4.add(lblNewLabel_2, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
