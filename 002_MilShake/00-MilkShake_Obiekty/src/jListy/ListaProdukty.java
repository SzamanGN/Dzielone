package jListy;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import modele.Produkt;
import modeleList.ListaProduktow;

import java.awt.Font;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListaProdukty  extends JScrollPane{
	
	private ListaProduktow produkty;
	
	
	public ListaProdukty() {
		ustaw(null);
	}

	
	public ListaProdukty(MouseAdapter mouseAdapter) {
		ustaw(mouseAdapter);
		
	}
	
	private void ustaw(MouseAdapter mouseAdapter) {
		
		JLabel lblNewLabel = new JLabel("Produkty");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		setColumnHeaderView(lblNewLabel);
		
		JList<Produkt> lProdukty = new JList<Produkt>();
		lProdukty.addMouseListener(mouseAdapter);
		produkty = new ListaProduktow(lProdukty);
		lProdukty.setPreferredSize(new Dimension(300, 250));
		lProdukty.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lProdukty.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setViewportView(lProdukty);
	}
	
	public void addProdukt(int id, int ilosc) {
		produkty.add(id, ilosc);
	}

	public boolean isDotepny(int ktory) {
		return produkty.isDostepny(ktory);
	}
	
	public void ubdateIlosc(int ktory, int delta) {
		produkty.updateIlosc(ktory, delta);
	}
	
	public int getId(int ktory) {
		return produkty.get(ktory).getId();
	}
}
