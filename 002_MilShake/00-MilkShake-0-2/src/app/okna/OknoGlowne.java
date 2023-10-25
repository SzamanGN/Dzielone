package app.okna;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.print.attribute.standard.SheetCollate;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dane.Nazwa;
import enumy.RodzajPoupu;
import jListy.ListaProdukty;
import jListy.ListaZamowien;
import modele.Minutnik;
import modele.Produkt;
import modeleList.ListaZamowienia;
import moduly.ModulShakera;
import narzedzia.Generator;
import popupy.PoupInformacja;

import java.awt.BorderLayout;
import java.awt.Color;

public class OknoGlowne extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private ListaZamowien zamowienia;
	private boolean aktywnyTikZegara;
	private Minutnik generatorZamowien;
	private ListaProdukty produkty;
	private ModulShakera shaker;

	public OknoGlowne() {
		setTitle("Shake-0-2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 697);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		// nasza lista zamowien
		zamowienia = new ListaZamowien();
		contentPane.add(zamowienia, BorderLayout.WEST);
		
		// dadanie listy produtkow
		
		produkty =  new ListaProdukty(produktyMouseAdapter());
		contentPane.add(produkty, BorderLayout.EAST);
		
		
		ladownaieDanychStartowych();
		zegar();
		
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void ladownaieDanychStartowych() {
		//dodanie testowe zamowienia
//		zamowienia.dodaj(0, 0, 3);
//		zamowienia.dodaj(1, 1, 5);
//		zamowienia.dodaj(2, 2, 30);
		zamowienia.dodaj(Generator.liczba(3), 0, 30);
		generatorZamowien = new Minutnik(0, 5 + Generator.liczba(5));
		
		// dodanie domyslne produty
		
		produkty.addProdukt(0, 50, Color.WHITE, Color.BLACK);
		produkty.addProdukt(1, 50, Color.RED, Color.WHITE);
		produkty.addProdukt(2, 50, Color.YELLOW, Color.BLACK);
		
		aktywnyTikZegara = false;
	}
	
	private void tikZegara() {
		// tik zegara czynnosci:
		// aktyklizownie czasu zamowien
		// ...
		aktywnyTikZegara = true;
		
		int id;
		zamowienia.tikZegara();
		int ilosc = zamowienia.getIlosc();
		if (ilosc > 0) {
			for(int i = 0; i < ilosc; i++) {
				if(!zamowienia.isAktywne(0)) {
					// popup usuniecia zamowienia
					id = zamowienia.getId(0);
					new PoupInformacja(id, RodzajPoupu.Wygaslo);
					System.out.println("Przedawnione zamowienie: " + Nazwa.sheka(id));
					zamowienia.usun(0);
				} else {
					break;
				}
			}
		}
		
		generatorZamowien.tikZegara();
		if(!generatorZamowien.isAktyny()) {
			if (ilosc < 10) {
				id = Generator.liczba(3);
				new PoupInformacja(id, RodzajPoupu.NoweZamowienie);
				zamowienia.dodaj(id, 0, 30);
			}
			generatorZamowien = new Minutnik(0, 5 + Generator.liczba(5));
		}
		aktywnyTikZegara = false;
		contentPane.updateUI();
	}
	
	private void zegar() {
		new Thread() {
			public void run() {
				while(true) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if (!aktywnyTikZegara) {
						tikZegara();
					}
				}
			}
		}.start();
	}
	
	private MouseAdapter produktyMouseAdapter() {
		return new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Kliknieto w liste produktow");
				JList<Produkt> lista = (JList<Produkt>) e.getSource();
				System.out.println("Kliknieto w indeks " + lista.getSelectedIndex());
				int id =  produkty.getId(lista.getSelectedIndex());
				System.out.println("Kliknieto w " + Nazwa.produktu(id));
			}
		};
	}
	
	

}
