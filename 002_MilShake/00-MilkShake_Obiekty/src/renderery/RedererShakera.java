package renderery;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.SwingConstants;

import dane.Nazwa;
import modele.Produkt;

public class RedererShakera extends JLabel implements ListCellRenderer<Produkt>{
	public RedererShakera() {
		setHorizontalAlignment(SwingConstants.CENTER);
		setFont(new Font("Tahoma", Font.PLAIN, 20));
		setText("Produkt\r\n");
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(255, 0, 255));
		setOpaque(true);
		setPreferredSize(new Dimension(200, 50));
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Produkt> list, Produkt produkt, int index,
			boolean isSelected, boolean cellHasFocus) {
		if (produkt.getId() >= 0) {
			setText(Nazwa.produktu(produkt.getId()));
		} else {
			setText("");
		}
		setBackground(produkt.getTlo());
		setForeground(produkt.getTusz());
		return this;
	}

}
