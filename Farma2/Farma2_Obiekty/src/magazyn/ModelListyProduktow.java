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
		// sprawdzenie czy taki produkt jest i jezli jest dodajemy ilosc produtkow
		int rozmiar = model.size();
		boolean zaktulizowano = false;
		if(rozmiar > 0) {
			for(int p = 0; p < rozmiar; p++) {
				if(model.get(p).getId() == id) {
					model.get(p).updateIlosc(ilosc);
					zaktulizowano = true;
					break;
				}
			}
		}
		if (!zaktulizowano) {
			model.addElement(new Produkt(id, ilosc));
		}
	}
	
	public JList<Produkt> getLista(){
		return lista;
	}
}
