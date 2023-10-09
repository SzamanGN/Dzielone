package renerery;

import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import modele.Produkt;
import narzedzia.Nazwa;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Component;

public class RendererProduktu extends JPanel implements ListCellRenderer<Produkt> {

	private JLabel eNazwa;
	private JLabel eIlosc;
	
	public RendererProduktu() {
		setBackground(new Color(128, 64, 64));
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setVgap(10);
		flowLayout.setHgap(10);
		flowLayout.setAlignment(FlowLayout.LEFT);
		
		eNazwa = new JLabel("(nazwa)");
		eNazwa.setForeground(new Color(255, 255, 0));
		eNazwa.setFont(new Font("Tahoma", Font.PLAIN, 30));
		eNazwa.setIcon(new ImageIcon(RendererProduktu.class.getResource("/obrazki/magazyn/wiadroM.png")));
		add(eNazwa);
		
		eIlosc = new JLabel("x (ilosc)");
		eIlosc.setForeground(new Color(255, 255, 0));
		eIlosc.setFont(new Font("Tahoma", Font.PLAIN, 30));
		add(eIlosc);
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Produkt> list, Produkt produkt, int index,
			boolean isSelected, boolean cellHasFocus) {
		if (isSelected) {
			setBackground(Color.BLUE);
		} else {
			setBackground(new Color(128, 64, 64));
		}
		eNazwa.setIcon(new ImageIcon(RendererProduktu.class.getResource("/obrazki/magazyn/" + Nazwa.obrazkaProduktu(produkt.getId()) + ".png")));
		eNazwa.setText(Nazwa.produktu(produkt.getId()));
		eIlosc.setText("x " + produkt.getIlosc());
		return this;
	}
	
	

}
