package okna;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import okna.panele.PanelOknaGlownego;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JList;

public class OknoGlowne extends JFrame {

	private JPanel contentPane;

	public OknoGlowne() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1108, 850);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		PanelOknaGlownego panelOknaFarmy = new PanelOknaGlownego();
		contentPane.add(panelOknaFarmy, BorderLayout.CENTER);
		
		JPanel panelinformacyjny = new JPanel();
		contentPane.add(panelinformacyjny, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("Kalendarz\r\n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelinformacyjny.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new EmptyBorder(0, 10, 0, 10));
		contentPane.add(scrollPane, BorderLayout.SOUTH);
		
		JLabel lblNewLabel = new JLabel("Komunikaty");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setColumnHeaderView(lblNewLabel);
		
		JList list = new JList();
		list.setVisibleRowCount(10);
		scrollPane.setViewportView(list);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
