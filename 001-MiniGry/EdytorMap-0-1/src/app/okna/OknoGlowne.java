package app.okna;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.modele.Kafelek;
import app.modeleLIst.ModelListyKafelki;
import app.narzedzia.Plik;
import app.okna.panele.PanelMapy;

import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Dimension;
import app.renderery.RenderKafelka;

import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OknoGlowne extends JFrame {

	private JPanel contentPane;
	private ModelListyKafelki kafelki;
	private PanelMapy panelMapy;
	private JTextField tfNazwaPliku;



	public OknoGlowne() {
		setTitle("EytorMap-0-1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 865, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane spKafelki = new JScrollPane();
		contentPane.add(spKafelki, BorderLayout.EAST);
		
		JLabel eKafelki = new JLabel("Kafelki");
		eKafelki.setHorizontalAlignment(SwingConstants.CENTER);
		eKafelki.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spKafelki.setColumnHeaderView(eKafelki);
		
		JList<Kafelek> listKafelkow = new JList<Kafelek>();
		listKafelkow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelMapy.setKafelekId(listKafelkow.getSelectedIndex());
			}
		});
		kafelki = new ModelListyKafelki(listKafelkow);
		listKafelkow.setCellRenderer(new RenderKafelka());
		listKafelkow.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		spKafelki.setViewportView(listKafelkow);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JLabel lbNazwa = new JLabel("Nazwa mapy");
		lbNazwa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lbNazwa);
		
		tfNazwaPliku = new JTextField();
		tfNazwaPliku.setText("Mapa001");
		tfNazwaPliku.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(tfNazwaPliku);
		tfNazwaPliku.setColumns(10);
		
		JLabel lblmc = new JLabel(".mc");
		lblmc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblmc);
		
		JButton btZapisz = new JButton("Zapisz");
		btZapisz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Plik.zapiszMape(
						tfNazwaPliku.getText() + ".mc",
						panelMapy.getMapa(),
						kafelki
						);
			}
		});
		btZapisz.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(btZapisz);
		
		JPanel panelGlowny = new JPanel();
		contentPane.add(panelGlowny, BorderLayout.CENTER);
		
		panelMapy = new PanelMapy(kafelki.getObrazki());
		panelMapy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelMapy.ustawKafelek(
						e.getY() / 32,
						e.getX() / 32
						);
				
			}
		});
		panelMapy.setPreferredSize(new Dimension(320, 320));
		panelGlowny.add(panelMapy);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
