package gra.komunikaty;

import javax.swing.DefaultListModel;
import javax.swing.JList;

public class ObslugaKomunikatow {

	private DefaultListModel<String> komunikaty;
	private int limit;
	
	public ObslugaKomunikatow(JList<String> lista) {
		komunikaty = new DefaultListModel<String>();
		lista.setModel(komunikaty);
		limit = 20;
	}
	
	public void dodaj(String komunikat) {
		komunikaty.add(0, komunikat);
		if (komunikaty.size() > limit) {
			komunikaty.remove(limit);
		}
	}
}
