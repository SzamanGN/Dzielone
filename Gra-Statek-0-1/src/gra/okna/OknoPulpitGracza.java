package gra.okna;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;

import gra.dane.DaneGracza;
import gra.dane.Statek;
import gra.dane.Wyspa;
import gra.dane.Wyspy;
import gra.komunikaty.ObslugaKomunikatow;
import gra.narzedzia.GeneratorLiczb;
import gra.narzedzia.Nazwy;
import gra.okna.panele.PanelDanychGracza;
import gra.okna.panele.PanelMapy;
import gra.okna.panele.PanelStatku;
import gra.okna.panele.PanelWyspa;
import gra.rotatory.RotatorSurowcow;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class OknoPulpitGracza extends JFrame {

	private JPanel contentPane;
	private ObslugaKomunikatow komunikaty;
	private PanelMapy panelMapy;
	private PanelDanychGracza panelDaneGracza;
	private PanelStatku panelStatku;
	private PanelWyspa panelWyspa;
	private DaneGracza daneGracza;
	private Statek statek;
	private Wyspy wyspy;
	private int wybranaWyspa;
	private JButton bPlynDoWyspy;

	/**
	 * Create the frame.
	 */
	public OknoPulpitGracza() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(OknoPulpitGracza.class.getResource("/obrazki/statek.jpg")));
		setTitle("Statek");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1154, 786);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mapa");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 579, 23);
		contentPane.add(lblNewLabel);
		
		panelMapy = new PanelMapy(this);
		panelMapy.setBackground(Color.BLUE);
		panelMapy.setBounds(10, 33, 579, 427);
		contentPane.add(panelMapy);
		
		
		
		JLabel lblDaneGracza = new JLabel("Dane gracza");
		lblDaneGracza.setHorizontalAlignment(SwingConstants.CENTER);
		lblDaneGracza.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDaneGracza.setBounds(599, 11, 539, 23);
		contentPane.add(lblDaneGracza);
		
		panelDaneGracza = new PanelDanychGracza();
		panelDaneGracza.setBackground(Color.GRAY);
		panelDaneGracza.setBounds(599, 33, 539, 125);
		contentPane.add(panelDaneGracza);

		JLabel lblStatek = new JLabel("Statek");
		lblStatek.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatek.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStatek.setBounds(599, 155, 539, 23);
		contentPane.add(lblStatek);
		
		panelStatku = new PanelStatku();
		panelStatku.setBounds(599, 177, 539, 153);
		contentPane.add(panelStatku);

		// -----------------------
		
		panelWyspa = new PanelWyspa(this);
		panelWyspa.setBounds(599, 351, 539, 147);
		contentPane.add(panelWyspa);
		
		
		
		// -----------------------
		
		JLabel lblWyspa = new JLabel("Wyspa");
		lblWyspa.setHorizontalAlignment(SwingConstants.CENTER);
		lblWyspa.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWyspa.setBounds(599, 327, 539, 23);
		contentPane.add(lblWyspa);
		
		JButton btnNewButton = new JButton("Nowa tura");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dodajKomunikat("Nowa tura!");
				/*
				panelMapy.zmianObrazek(2, false);
				
				panelDaneGracza.aktualizacjaOpisuStanuKonta(12345);
				panelDaneGracza.aktualizacjaOpisuZasiedlenia(7);
				
				panelStatku.aktualizacjaStatusu(true, "Alfa");
				panelStatku.aktualizacjaLadunku(8, "Złoto");
				panelStatku.aktualizacjaCenyLadunku(156);
				

				panelWyspa.aktualizacjaNazwy(2);
				dodajKomunikat("Wybrano wyspę " + Nazwy.wyspa(2));
				
				RotatorSurowcow rs = new RotatorSurowcow();
				
				panelWyspa.aktualizacjaOpisuKupnaSurowca(0, rs.pobierz(), (5 + GeneratorLiczb.losowa(10)));
				panelWyspa.aktualizacjaOpisuKupnaSurowca(1, rs.pobierz(), (5 + GeneratorLiczb.losowa(10)));
				panelWyspa.aktualizacjaOpisuKupnaSurowca(2, rs.pobierz(), (5 + GeneratorLiczb.losowa(10)));
				dodajKomunikat("Zaktualizowano ceny kupna surowcow.");
				panelWyspa.aktualizacjaOpisuSprzedazySurowca(0, rs.pobierz(), (5 + GeneratorLiczb.losowa(10)));
				panelWyspa.aktualizacjaOpisuSprzedazySurowca(1, rs.pobierz(), (5 + GeneratorLiczb.losowa(10)));
				panelWyspa.aktualizacjaOpisuSprzedazySurowca(2, rs.pobierz(), (5 + GeneratorLiczb.losowa(10)));
				dodajKomunikat("Zaktualizowano ceny sprzedazy surowcow.");
				 */
				
				//Nowa tura
				
				//Aktualizacja cen surowcow:
				aktualizacjaCenSurowcow();
				
				//Aktualizacja polozenia statku:
				aktualizacjaPolozeniaStatku();
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(10, 471, 198, 28);
		contentPane.add(btnNewButton);
		
		JLabel lblKomunikat = new JLabel("Komunikaty");
		lblKomunikat.setHorizontalAlignment(SwingConstants.CENTER);
		lblKomunikat.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblKomunikat.setBounds(10, 510, 1128, 23);
		contentPane.add(lblKomunikat);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 532, 1128, 216);
		contentPane.add(scrollPane);
		
		
		JList<String> lKomunikaty = new JList<String>();
		komunikaty = new ObslugaKomunikatow(lKomunikaty);
		lKomunikaty.setVisibleRowCount(10);
		lKomunikaty.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(lKomunikaty);
		
		bPlynDoWyspy = new JButton("Plyn do wyspy ");
		bPlynDoWyspy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				statek.plynDo(wybranaWyspa, 2);
				bPlynDoWyspy.setEnabled(false);
				panelStatku.aktualizacjaStatusu(statek.isPlynie(), statek.getWyspa());
				dodajKomunikat("Wybrano rejs do wyspy " + Nazwy.wyspa(wybranaWyspa));
			}
		});
		bPlynDoWyspy.setFont(new Font("Tahoma", Font.BOLD, 16));
		bPlynDoWyspy.setBounds(218, 470, 371, 28);
		contentPane.add(bPlynDoWyspy);
		
		inicjowanieDanychGry();
		
		komunikaty.dodaj("Witaj w grze!");
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void inicjowanieDanychGry() {
		daneGracza = new DaneGracza();
		panelDaneGracza.aktualizacjaOpisuStanuKonta(daneGracza.getStanKonta());
		panelDaneGracza.aktualizacjaOpisuZasiedlenia(daneGracza.getZasiedloneWyspy());
		
		statek = new Statek(0);
		panelStatku.aktualizacjaStatusu(statek.isPlynie(), statek.getWyspa());
		panelStatku.aktualizacjaLadunku(statek.getPojemnosc(), statek.getIloscTowaru(), statek.getNazwaTowaru());
		panelStatku.aktualizacjaCenyLadunku(statek.getCenaTowaru());
		
		wyspy = new Wyspy();
		pokazWyspe(0);
	}

	public void pokazWyspe(int indeks) {
		wybranaWyspa = indeks;
		panelWyspa.pokazDane(wyspy.get(wybranaWyspa));
		if (wybranaWyspa == statek.getWyspa() || statek.isPlynie()) {
			bPlynDoWyspy.setEnabled(false);
		} else {
			bPlynDoWyspy.setText("Plyn do wyspy " + Nazwy.wyspa(wybranaWyspa));
			bPlynDoWyspy.setEnabled(true);
		}
	}
	
	public void dodajKomunikat(String komunikat) {
		komunikaty.dodaj(komunikat);
	}
	
	private void aktualizacjaCenSurowcow() {
		String zmianyCen;
		Wyspa aw;
		for (int w = 0; w < Nazwy.iloscWysp(); w++) {
			zmianyCen = "";
			aw = wyspy.get(w);
			for (int i = 0; i < 3; i++) {
				if (aw.aktualizacjaCenySurowcaDoKupna(i, GeneratorLiczb.deltaCeny())) {
					zmianyCen += Nazwy.wyspa(w) + ": " + Nazwy.surowiec(aw.getNazwaSurowcaDoKupna(i)) + " nowa cena " + aw.getCenaSurowcaDOKupna(i) + " | "; 
				}
				if (aw.aktualizacjaCenySurowcaDoSprzedazy(i, GeneratorLiczb.deltaCeny())) {
					zmianyCen += Nazwy.wyspa(w) + ": " + Nazwy.surowiec(aw.getNazwaSurowcaDoSprzedazy(i)) + " nowa cena " + aw.getCenaSurowcaDoSprzedazy(i) + " | ";
				}
			}
			dodajKomunikat(zmianyCen);
			//
		}
		pokazWyspe(wybranaWyspa);
	}
	
	private void aktualizacjaPolozeniaStatku() {
		//Plyniecie statku
		if (statek.isPlynie()) {
			statek.rejsTurowy();
			if (statek.isPlynie()) {
				dodajKomunikat("Statek plynie do wyspy " + Nazwy.wyspa(statek.getWyspa()));
			} else {
				dodajKomunikat("Statek doplynal do wyspy " + Nazwy.wyspa(statek.getWyspa()));
				panelStatku.aktualizacjaStatusu(statek.isPlynie(), statek.getWyspa());
				pokazWyspe(statek.getWyspa());
			}
		}
	}
	
	public void tranzakcja(boolean kupno, int indeksSurowca) {
		//Czy statek jest w prawidlowym porcie:
		int surowiec;
		if (wybranaWyspa == statek.getWyspa()) {
			if (kupno) {
				//Kupowanie
				if (statek.isTowar()) {
					surowiec = statek.getNazwaTowaru();
				} else {
					surowiec = -1;
				}
				if (!statek.isPelnaLadownia()) {
					if (wyspy.get(wybranaWyspa).getNazwaSurowcaDoKupna(indeksSurowca) == surowiec || surowiec == -1) {
						surowiec = wyspy.get(wybranaWyspa).getNazwaSurowcaDoKupna(indeksSurowca);
						if (daneGracza.zakup(wyspy.get(wybranaWyspa).getCenaSurowcaDOKupna(indeksSurowca))) {
							//Kupiono
							panelDaneGracza.aktualizacjaOpisuStanuKonta(daneGracza.getStanKonta());
							statek.zaladunek(surowiec);
							panelStatku.aktualizacjaLadunku(statek.getPojemnosc(), statek.getIloscTowaru(), statek.getNazwaTowaru());
							dodajKomunikat("Kupiono " + Nazwy.surowiec(surowiec) + " na wyspie " + Nazwy.wyspa(wybranaWyspa));
						} else {
							//Nie mozna kupic.
							dodajKomunikat("Nie masz zasobow do kupna surowcow!");
						}
					}
				} else {
					dodajKomunikat("Ladownia jest pelna!");
				}
			} else {
				//Sprzedaz
				if (statek.isTowar()) {
					surowiec = statek.getNazwaTowaru();
					if (wyspy.get(wybranaWyspa).getNazwaSurowcaDoSprzedazy(indeksSurowca) == surowiec) {
						daneGracza.sprzedaz(wyspy.get(wybranaWyspa).getCenaSurowcaDoSprzedazy(indeksSurowca));
						panelDaneGracza.aktualizacjaOpisuStanuKonta(daneGracza.getStanKonta());
						statek.rozladunek();
						panelStatku.aktualizacjaLadunku(statek.getPojemnosc(), statek.getIloscTowaru(), statek.getNazwaTowaru());
						dodajKomunikat("Sprzedano " + Nazwy.surowiec(surowiec) + " na wyspie "  + Nazwy.wyspa(wybranaWyspa));
					}
				} else {
					dodajKomunikat("Ladownia jest pusta!");
				}
			}
		}
	}
}
