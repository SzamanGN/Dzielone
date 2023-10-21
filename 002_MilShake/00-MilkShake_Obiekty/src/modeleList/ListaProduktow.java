package modeleList;

import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import modele.Produkt;
import renderery.RendererProduktu;

public class ListaProduktow {
	
	private DefaultListModel<Produkt> model;
	private JList<Produkt> lista;
	

	public ListaProduktow(JList<Produkt> lista) {
		model =  new DefaultListModel<Produkt>();
		lista.setModel(model);
		lista.setCellRenderer(new RendererProduktu());
		this.lista = lista;
	}
	
	public void add(int id, int ilosc, Color tlo, Color tusz) {
		model.addElement(new Produkt(id, ilosc, tlo, tusz));
		//lista.updateUI();
	}

	public boolean isDostepny(int ktory) {
		return  model.get(ktory).getIlosc() > 0;
	}
	
	public void updateIlosc(int ktory, int delta) {
		model.get(ktory).updateIlosc(delta);
		//lista.updateUI();
	}
	
	public Produkt get(int ktory) {
		return model.get(ktory);
	}
}
