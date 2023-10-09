package okna;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import menagery.MenagerList;
import modeleLIst.ModelListyKomunikaty;
import okna.panele.PanelOknaGlownego;
import poupy.PopupMagazyn;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OknoGlowne extends JFrame {

	private JPanel contentPane;
	private ModelListyKomunikaty komunikaty;
	private MenagerList listy;

	public OknoGlowne() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1108, 850);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		PanelOknaGlownego panelOknaFarmy = new PanelOknaGlownego();
		contentPane.add(panelOknaFarmy, BorderLayout.CENTER);
		panelOknaFarmy.setLayout(null);
		
		JLabel eMagazyn = new JLabel("");
		eMagazyn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pokazMagazyn();
			}
		});
		eMagazyn.setBounds(333, 374, 200, 162);
		panelOknaFarmy.add(eMagazyn);
		
		JLabel eKurnik = new JLabel("");
		eKurnik.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pokazKurnik();
			}
		});
		eKurnik.setBounds(89, 393, 54, 70);
		panelOknaFarmy.add(eKurnik);
		
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
		
		JList<String> list = new JList<String>();
		komunikaty =  new ModelListyKomunikaty(list);
		
		list.setVisibleRowCount(10);
		scrollPane.setViewportView(list);
		setLocationRelativeTo(null);
		ladowanieDanychStartowych();
		komunikaty.add("Start gry-1-0");
		setVisible(true);
	}

	private void ladowanieDanychStartowych() {
		// ladowanie list
		listy = new MenagerList();
		listy.produty.add(0, 100);
		listy.produty.add(1, 100);
		listy.produty.add(2, 20);
		
	}
	
	private void pokazMagazyn() {
		new PopupMagazyn(listy.produty);
	}
	
	private void pokazKurnik() {
		System.out.println("pokazanie kurnika");
	}
}
