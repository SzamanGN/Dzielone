package gra.okna;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import gra.okna.panele.*;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JComponent;

@SuppressWarnings("serial")
public class OknoPulpitGracza extends JFrame {

	private JPanel contentPane;
	private int wybranaWyspa, nowaWyspa;
	private PanelMapy panelMapy;

	/**
	 * Create the frame.
	 */
	public OknoPulpitGracza() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(OknoPulpitGracza.class.getResource("/Obrazki/StatekR250.png")));
		setTitle("Statek -1-0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 970, 657);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(222, 184, 135));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbMapa = new JLabel("Mapa");
		lbMapa.setBounds(5, 5, 571, 20);
		lbMapa.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbMapa.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lbMapa);
		
		panelMapy = new PanelMapy(wlasnyMouseListener());
		panelMapy.setBounds(15, 36, 561, 459);
		contentPane.add(panelMapy);
		
		JLabel lbDaneGracza = new JLabel("Dane gracza");
		lbDaneGracza.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbDaneGracza.setHorizontalAlignment(SwingConstants.CENTER);
		lbDaneGracza.setBounds(594, 11, 350, 14);
		contentPane.add(lbDaneGracza);
		
		PanelDanychGracza panelGracza = new PanelDanychGracza();
		panelGracza.setBounds(604, 37, 340, 132);
		contentPane.add(panelGracza);
		
		PanelStatek panelStatek = new PanelStatek();
		panelStatek.setBounds(604, 201, 340, 132);
		contentPane.add(panelStatek);
		
		JLabel lblStatek = new JLabel("Statek");
		lblStatek.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatek.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStatek.setBounds(594, 175, 350, 14);
		contentPane.add(lblStatek);
		
		PanelWyspa panelWyspa = new PanelWyspa(wlasnyMouseListener());
		panelWyspa.setBounds(604, 362, 340, 132);
		contentPane.add(panelWyspa);
		
		JLabel lbWyspa = new JLabel("Wyspa");
		lbWyspa.setHorizontalAlignment(SwingConstants.CENTER);
		lbWyspa.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbWyspa.setBounds(594, 337, 350, 14);
		contentPane.add(lbWyspa);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 506, 561, 111);
		contentPane.add(scrollPane);
		
		JList<String> lKomnikaty = new JList<String>();
		lKomnikaty.setVisibleRowCount(10);
		lKomnikaty.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(lKomnikaty);
		
		JButton btnPlynDoWyspy = new JButton("Plyn do Wyspy\r\n");
		btnPlynDoWyspy.setBounds(604, 506, 153, 50);
		btnPlynDoWyspy.putClientProperty("akcja", "plynDo");
		btnPlynDoWyspy.addMouseListener(wlasnyMouseListener());
		contentPane.add(btnPlynDoWyspy);
		
		JButton btnNowaTura = new JButton("Nowa Tura");
		btnNowaTura.setBounds(791, 506, 153, 50);
		btnNowaTura.putClientProperty("akcja", "nowaTura");
		btnNowaTura.addMouseListener(wlasnyMouseListener());
		contentPane.add(btnNowaTura);
		
		JButton btnWczytaj = new JButton("Wczytaj gre");
		btnWczytaj.setBounds(604, 567, 153, 50);
		btnWczytaj.putClientProperty("akcja", "wczytaj");
		btnWczytaj.addMouseListener(wlasnyMouseListener());
		contentPane.add(btnWczytaj);
		
		JButton btnZapisz = new JButton("Zapisz gre");
		btnZapisz.setBounds(791, 567, 153, 50);
		btnZapisz.putClientProperty("akcja", "zapisz");
		btnZapisz.addMouseListener(wlasnyMouseListener());
		contentPane.add(btnZapisz);
		
		ustawDaneStartowe();
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void ustawDaneStartowe() {
		wybranaWyspa = 0;
		nowaWyspa = 0;
	}

	private void wyborWyspy(int indeks) {
		panelMapy.odznacz(wybranaWyspa);
		wybranaWyspa = indeks;
		panelMapy.zaznacz(wybranaWyspa);
	}
	
	private MouseAdapter wlasnyMouseListener() {
		return new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me) {
				JComponent obiekt = (JComponent) me.getSource();
				switch((String) obiekt.getClientProperty("akcja")) {
					case "kup":
						System.out.println("Wybrano akcje KUP.");
						break;
					case "sprzedaj":
						System.out.println("Wybrano akcje SPRZEDAJ.");
						break;
					case "plynDo":
						System.out.println("Wybrano akcje PLYN DO.");
						break;
					case "nowaTura":
						System.out.println("Wybrano akcje NOWA TURA.");
						break;
					case "wczytaj":
						System.out.println("Wybrano akcje WCZYTAJ.");
						break;
					case "zapisz":
						System.out.println("Wybrano akcje ZAPISZ.");
						break;
					case "wybranaWyspa":
						int indeks = (Integer) obiekt.getClientProperty("indeks");
						wyborWyspy(indeks);
						System.out.println("Wybrano akcje WYBRANA WYSPA o indeksie " + indeks);
						break;
				}
			}
		};
	}
}
