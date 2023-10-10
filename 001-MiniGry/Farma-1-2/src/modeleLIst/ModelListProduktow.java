package modeleLIst;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import modele.Produkt;
import renerery.RendererProduktu;

public class ModelListProduktow {
	
	private DefaultListModel<Produkt> model;
	private JList<Produkt> lista;
	
	public ModelListProduktow() {
		model = new DefaultListModel<Produkt>();
		lista = new JList<Produkt>();
		lista.setModel(model);
		//renderer
		lista.setCellRenderer(new RendererProduktu());
	}

	public void add(int id, int ilosc) {
		model.addElement(new Produkt(id, ilosc));
		// metoda zostanie aktulizowana pozniej 
		// sprawdzenie czy taki produkt istnieje to zwiekszemy ilosc
		// jesli nie to tworzymy nowy obiekt
	}
	
	public JList<Produkt> getLista(){
		return lista;
	}
}
