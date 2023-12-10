package okna;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import panele.PanelPunktacja;
import silnik.Wyniki;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OknoTestowe extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private PanelPunktacja panelPuktacji;
	private Wyniki wyniki;

	public OknoTestowe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		wyniki =  new Wyniki();

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panelPuktacji =  new PanelPunktacja();
		contentPane.add(panelPuktacji, BorderLayout.NORTH);
		panelPuktacji.aktulizacjaPuntow(wyniki.getPunkty());
		panelPuktacji.aktulizacjaWygrane(wyniki.getWygrane());
		panelPuktacji.aktulizacjaRemisy(wyniki.getRemisy());
		panelPuktacji.aktulizacjaPrzegrane(wyniki.getPrzegrane());
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton bPunty = new JButton("Punkty += 10");
		bPunty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wyniki.aktulizacjaPuktow(10);
				panelPuktacji.aktulizacjaPuntow(wyniki.getPunkty());
			}
		});
		bPunty.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(bPunty);
		
		JButton nWygrane = new JButton("Wygrana");
		nWygrane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wyniki.zwiekszWygrane();
				panelPuktacji.aktulizacjaWygrane(wyniki.getWygrane());
			}
		});
		nWygrane.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(nWygrane);
		
		JButton bRemisy = new JButton("Remis");
		bRemisy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wyniki.zwiekszRemisy();
				panelPuktacji.aktulizacjaRemisy(wyniki.getRemisy());
			}
		});
		bRemisy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(bRemisy);
		
		JButton bPrzegrane = new JButton("Przegrana");
		bPrzegrane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wyniki.zwiekszPrzegrane();
				panelPuktacji.aktulizacjaPrzegrane(wyniki.getPrzegrane());
			}
		});
		bPrzegrane.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(bPrzegrane);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
