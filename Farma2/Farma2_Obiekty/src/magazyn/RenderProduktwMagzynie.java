package magazyn;

import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import java.awt.Color;
import java.awt.Component;

import javax.swing.border.EmptyBorder;

import modele.Produkt;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.Font;

public class RenderProduktwMagzynie extends JPanel implements ListCellRenderer<Produkt> {

	private static final long serialVersionUID = 1L;
	private JLabel lObrazek;
	private JLabel eIlosc;
	private JLabel eNazwa;
	
	public RenderProduktwMagzynie() {
		setBorder(new EmptyBorder(2, 5, 2, 5));
		setBackground(new Color(128, 0, 255));
		setLayout(new BorderLayout(5, 5));
		
		lObrazek = new JLabel("X");
		lObrazek.setHorizontalAlignment(SwingConstants.CENTER);
		lObrazek.setPreferredSize(new Dimension(64, 64));
		add(lObrazek, BorderLayout.WEST);
		
		eIlosc = new JLabel("XXX");
		eIlosc.setFont(new Font("Tahoma", Font.PLAIN, 18));
		eIlosc.setHorizontalAlignment(SwingConstants.RIGHT);
		add(eIlosc, BorderLayout.EAST);
		
		eNazwa = new JLabel("Nazwa");
		eNazwa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		eNazwa.setHorizontalAlignment(SwingConstants.LEFT);
		add(eNazwa, BorderLayout.CENTER);

	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Produkt> list, Produkt produkt, int index,
			boolean isSelected, boolean cellHasFocus) {
		if (isSelected) {
			setBackground(Color.GREEN);
		} else {
			setBackground(Color.LIGHT_GRAY);
		}
		
		lObrazek.setText(String.valueOf(produkt.getId()));
		eNazwa.setText("Nazwa-" + produkt.getId());
		eIlosc.setText(String.valueOf(produkt.getIlosc()));
		
		return this;
	}

}
