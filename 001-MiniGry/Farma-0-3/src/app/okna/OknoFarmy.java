package app.okna;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.modele.Drub;
import app.modeleList.ModelListyDrobiu;
import app.modeleList.ModelListyKogutow;
import app.modeleList.ModelListyKomunikaty;
import app.narzedzia.Dane;
import app.narzedzia.Kalendarz;
import app.narzedzia.Zegar;
import app.narzedzia.ZegarKalendarza;

import java.awt.Frame;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import app.okna.renderery.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OknoFarmy extends JFrame {

	private JPanel contentPane;
	private ModelListyKomunikaty komunikaty;
	private Kalendarz kalendarz;
	private ModelListyDrobiu kurnik;
	private ModelListyKogutow koguty;

	public OknoFarmy() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1062, 745);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelInforamyjny = new JPanel();
		contentPane.add(panelInforamyjny, BorderLayout.NORTH);
		
		JLabel eKalendarz = new JLabel("Kalendarz: XXXX-XX-XX XX:XX");
		kalendarz = new Kalendarz(eKalendarz, "Kalendarz: ", "");
		eKalendarz.setText(kalendarz.getStan());
		eKalendarz.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelInforamyjny.add(eKalendarz);
		
		JPanel panelAkccji = new JPanel();
		contentPane.add(panelAkccji, BorderLayout.SOUTH);
		panelAkccji.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panelAkccji.add(panel, BorderLayout.SOUTH);
		
		JButton pWurcDoMenu = new JButton("Wruc do menu");
		panel.add(pWurcDoMenu);
		pWurcDoMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				powrotDoMenu();
			}
		});
		pWurcDoMenu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JScrollPane spKomunikaty = new JScrollPane();
		panelAkccji.add(spKomunikaty, BorderLayout.CENTER);
		
		JLabel eKomunikatow = new JLabel("Komunikaty:");
		eKomunikatow.setHorizontalAlignment(SwingConstants.CENTER);
		spKomunikaty.setColumnHeaderView(eKomunikatow);
		
		JList<String> lKomunikaty = new JList<String>();
		komunikaty = new ModelListyKomunikaty(lKomunikaty);
		lKomunikaty.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		spKomunikaty.setViewportView(lKomunikaty);
		
		JPanel panelCentralny = new JPanel();
		contentPane.add(panelCentralny, BorderLayout.CENTER);
		panelCentralny.setLayout(new GridLayout(0, 3, 5, 5));
		
		JScrollPane spMagazyn = new JScrollPane();
		panelCentralny.add(spMagazyn);
		
		JLabel lbMagzyn = new JLabel("Magazyn");
		lbMagzyn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbMagzyn.setHorizontalAlignment(SwingConstants.CENTER);
		spMagazyn.setColumnHeaderView(lbMagzyn);
		
		JList lMagazyn = new JList();
		lMagazyn.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		spMagazyn.setViewportView(lMagazyn);
		
		JScrollPane spZagroda = new JScrollPane();
		panelCentralny.add(spZagroda);
		
		JLabel lbZagroda = new JLabel("Zagroda");
		lbZagroda.setHorizontalAlignment(SwingConstants.CENTER);
		lbZagroda.setFont(new Font("Tahoma", Font.PLAIN, 16));
		spZagroda.setColumnHeaderView(lbZagroda);
		
		JList lZagroda = new JList();
		lZagroda.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		spZagroda.setViewportView(lZagroda);
		
		JScrollPane spKurnik = new JScrollPane();
		panelCentralny.add(spKurnik);
		
		JLabel lbKurnik = new JLabel("Kurik\r\n");
		lbKurnik.setHorizontalAlignment(SwingConstants.CENTER);
		lbKurnik.setFont(new Font("Tahoma", Font.PLAIN, 16));
		spKurnik.setColumnHeaderView(lbKurnik);
		
		JList<Drub> lKurnik = new JList<Drub>();
		lKurnik.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int indeks = lKurnik.getSelectedIndex();
				if(indeks >= 0) {
					pokazDrub(indeks);
				}
			}
		});
		kurnik = new ModelListyDrobiu(lKurnik);
		lKurnik.setCellRenderer(new RendererKurnik());
		lKurnik.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		spKurnik.setViewportView(lKurnik);
		
		Dane.aktywnaGra = true;
		// uruchomienie zegara kalendarza
		new ZegarKalendarza(kalendarz).start();
		komunikaty.dodajKomunikat("Start gry");
		
		ladowanieDanychStartowych();
		
		ladnowanieDanychTestowych();
		setVisible(true);
	}
	
	private void ladowanieDanychStartowych() {
		koguty =  new ModelListyKogutow();
		koguty.add();
		kurnik.add(0, 1);
	}

	private void powrotDoMenu() {
		Dane.aktywnaGra = false;
		new OknoMenu();
		dispose();
	}

	public void ladnowanieDanychTestowych() {
		kurnik.add(1, 15);
	}
	
	private void pokazDrub(int indeks) {
		switch(kurnik.get(indeks).getRodzaj()) {
		// uzupenic !!!!!
		}
		
	}
}
