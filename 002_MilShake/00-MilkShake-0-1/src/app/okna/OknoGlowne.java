package app.okna;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dane.Nazwa;
import enumy.RodzajPoupu;
import jListy.ListaZamowien;
import modeleList.ListaZamowienia;
import popupy.PoupInformacja;

import java.awt.BorderLayout;

public class OknoGlowne extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private ListaZamowien zamowienia;
	private boolean aktywnyTikZegara; 

	public OknoGlowne() {
		setTitle("Shake-0-1\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 919, 665);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		// nasza lista zamowien
		zamowienia = new ListaZamowien();
		contentPane.add(zamowienia, BorderLayout.WEST);
		
		ladownaieDanychStartowych();
		zegar();
		
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void ladownaieDanychStartowych() {
		//dodanie testowe zamowienia
		zamowienia.dodaj(0, 0, 3);
		zamowienia.dodaj(1, 1, 5);
		zamowienia.dodaj(2, 2, 30);
		
		aktywnyTikZegara = false;
	}
	
	private void tikZegara() {
		// tik zegara czynnosci:
		// aktyklizownie czasu zamowien
		// ...
		aktywnyTikZegara = true;
		
		zamowienia.tikZegara();
		int ilosc = zamowienia.getIlosc();
		if (ilosc > 0) {
			for(int i = 0; i < ilosc; i++) {
				if(!zamowienia.isAktywne(0)) {
					// popup usuniecia zamowienia
					int id = zamowienia.getId(0);
					new PoupInformacja(id, RodzajPoupu.Wygaslo);
					System.out.println("Przedawnione zamowienie: " + Nazwa.sheka(id));
					zamowienia.usun(0);
				} else {
					break;
				}
			}
		}
		
		aktywnyTikZegara = false;
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

}
