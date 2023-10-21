package jListy;

import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import modele.Zamowienie;
import modeleList.ListaZamowienia;

import javax.swing.JList;
import javax.swing.ListSelectionModel;

public class ListaZamowien extends JScrollPane{
	
	private ListaZamowienia zamowienia;
	
	public ListaZamowien() {
		setPreferredSize(new Dimension(350, 250));
		
		JLabel lblNewLabel = new JLabel("Zamowienia");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		setColumnHeaderView(lblNewLabel);
		
		JList<Zamowienie> listaZamowienia = new JList<Zamowienie>();
		zamowienia = new ListaZamowienia(listaZamowienia);
		listaZamowienia.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setViewportView(listaZamowienia);
	}
	
	public void dodaj(int id, int minuty, int sekundy) {
		zamowienia.add(id, minuty, sekundy);
	}
	
	public void usun(int ktory) {
		zamowienia.rem(ktory);
	}
	
	public void tikZegara() {
		zamowienia.tikZegara();
	}
	
	public int getIlosc() {
		return zamowienia.getIlosc();
	}

	public boolean isAktywne(int ktore) {
		return zamowienia.isAktywne(ktore);
	}

	public int getId(int ktory) {
		return zamowienia.get(ktory).getId();
	}
}
