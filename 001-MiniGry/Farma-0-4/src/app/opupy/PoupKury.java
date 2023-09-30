package app.opupy;

import javax.swing.JList;

import app.modele.SamicaDrobiu;
import app.okna.OknoFarmy;

public class PoupKury  extends PopupWzorzecListy {
	
	private JList<SamicaDrobiu> lista;
	
	public PoupKury(OknoFarmy oknoFarmy) {
		super(oknoFarmy);
	}

	@Override
	protected void nakarm() {
		int indeks = lista.getSelectedIndex();
		if (indeks >= 0) {
			System.out.println("Nakarmiono kure: " + indeks);
		}
	}

	@Override
	protected void ustawListe() {
		setTitle("Wyakaz kur");
		eTytul.setText("Kury");
		lista = oknoFarmy.listy.kury.getLista();
		scrollPane.setViewportView(lista);
		addPopup(lista, popupMenu);
	}

	
}
