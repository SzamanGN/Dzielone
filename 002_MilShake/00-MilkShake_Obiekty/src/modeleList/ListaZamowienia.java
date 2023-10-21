package modeleList;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import modele.Zamowienie;
import renderery.RendereZamowienia;

public class ListaZamowienia {

	private DefaultListModel<Zamowienie> model;
	private JList<Zamowienie> lista;
	
	public ListaZamowienia(JList<Zamowienie> lista) {
		model = new DefaultListModel<Zamowienie>();
		lista.setModel(model);
		// renderer
		lista.setCellRenderer(new RendereZamowienia());
		this.lista = lista;
	}
	
	public void add(int id, int minuty, int sekundy) {
		model.addElement(new Zamowienie(id, minuty, sekundy));
		//lista.updateUI();
	}
	
	public void rem(int ktory) {
		model.remove(ktory);
		//lista.updateUI();
	}

	public void tikZegara() {
		int ilosc = model.size();
		if (ilosc > 0) {
			for (int i = 0; i < ilosc; i++) {
				model.get(i).tikZegara();
			}
			//lista.updateUI();
		}
	}

	public int getIlosc() {
		return model.size();
	}

	public boolean isAktywne(int ktore) {
		return model.get(ktore).isAktywne();
	}

	public Zamowienie get(int ktory) {
		return model.get(ktory);
	}

	
}
