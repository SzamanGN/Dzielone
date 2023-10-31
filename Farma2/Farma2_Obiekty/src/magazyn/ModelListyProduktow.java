package magazyn;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import modele.Produkt;

public class ModelListyProduktow {
	
	private DefaultListModel<Produkt> model;
	private JList<Produkt> lista;

	public ModelListyProduktow() {
		model = new DefaultListModel<Produkt>();
		lista = new JList<Produkt>();
		lista.setModel(model);
	}
	
	public void add(int id, int ilosc) {
		model.addElement(new Produkt(id, ilosc));
	}
	
	public JList<Produkt> getLista(){
		return lista;
	}
}
