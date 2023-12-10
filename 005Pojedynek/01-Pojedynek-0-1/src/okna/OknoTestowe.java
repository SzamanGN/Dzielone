package okna;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import panele.PanelPolaBitwy;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OknoTestowe extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private PanelPolaBitwy panelPolaBitwy;
	private JButton btnZycieGracza;
	private JButton btnZyciePrzeciwnika;
	

	public OknoTestowe() {
		setTitle("Pojedynek-0-1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1105, 708);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelPolaBitwy = new PanelPolaBitwy();
		panelPolaBitwy.setBounds(10, 10, 800, 600);
		contentPane.add(panelPolaBitwy);
		
		JButton bTikZegara = new JButton("Tik zegara");
		bTikZegara.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelPolaBitwy.tikZegara();
			}
		});
		bTikZegara.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bTikZegara.setBounds(847, 574, 164, 36);
		contentPane.add(bTikZegara);
		
		btnZycieGracza = new JButton("Zycie Gracza -10");
		btnZycieGracza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelPolaBitwy.aktualizacjaZyciaGracza(-10);
			}
		});
		btnZycieGracza.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnZycieGracza.setBounds(847, 491, 164, 36);
		contentPane.add(btnZycieGracza);
		
		btnZyciePrzeciwnika = new JButton("Zycie Przeciwnika -10");
		btnZyciePrzeciwnika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelPolaBitwy.aktualizacjaZyciaPrzeciwnika(-10);
			}
		});
		btnZyciePrzeciwnika.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnZyciePrzeciwnika.setBounds(830, 445, 192, 36);
		contentPane.add(btnZyciePrzeciwnika);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
