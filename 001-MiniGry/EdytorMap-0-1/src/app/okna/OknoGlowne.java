package app.okna;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.modele.Kafelek;
import app.modeleLIst.ModelListyKafelki;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import app.renderery.RenderKafelka;

import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class OknoGlowne extends JFrame {

	private JPanel contentPane;
	private ModelListyKafelki kafelki;



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
		kafelki = new ModelListyKafelki(listKafelkow);
		listKafelkow.setCellRenderer(new RenderKafelka());
		listKafelkow.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		spKafelki.setViewportView(listKafelkow);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JLabel lbNazwa = new JLabel("New label");
		lbNazwa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lbNazwa);
		
		JPanel panelGlowny = new JPanel();
		contentPane.add(panelGlowny, BorderLayout.CENTER);
		
		JPanel panelMapy = new JPanel();
		panelMapy.setPreferredSize(new Dimension(320, 320));
		panelGlowny.add(panelMapy);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
