package renderery;

import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;

import dane.Nazwa;
import modele.Produkt;

public class RendererProduktu extends JPanel  implements ListCellRenderer<Produkt>{

	private static final long serialVersionUID = 1L;

	private JLabel eObrazek;
	private JLabel eNazwa;
	private JLabel eIlosc;
	
	
	public RendererProduktu() {
		setBorder(new EmptyBorder(2, 10, 2, 10));
		setLayout(new BorderLayout(10, 10));
		
		eObrazek = new JLabel("");
		eObrazek.setIcon(new ImageIcon(RendererProduktu.class.getResource("/obrazki/produty/produkt0.png")));
		add(eObrazek, BorderLayout.WEST);
		
		eNazwa = new JLabel("Nazwa");
		eNazwa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(eNazwa, BorderLayout.CENTER);
		
		eIlosc = new JLabel("XX");
		eIlosc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(eIlosc, BorderLayout.EAST);

	}


	@Override
	public Component getListCellRendererComponent(JList<? extends Produkt> list, Produkt produkt, int index,
			boolean isSelected, boolean cellHasFocus) {
		if (isSelected) {
			setBackground(Color.GREEN);
		} else {
			setBackground(Color.LIGHT_GRAY);
		}
		
		int id = produkt.getId();
		eObrazek.setIcon(new ImageIcon(RendererProduktu.class.getResource("/obrazki/produty/produkt" + id + ".png")));
		eNazwa.setText(Nazwa.produktu(id));
		eIlosc.setText(String.format("%02d", produkt.getIlosc()));
		return this;
	}



}
