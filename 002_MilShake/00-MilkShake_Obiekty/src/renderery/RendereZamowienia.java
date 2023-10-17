package renderery;

import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.border.EmptyBorder;

import dane.Nazwa;
import modele.Zamowienie;

public class RendereZamowienia extends JPanel implements ListCellRenderer<Zamowienie> {

	private static final long serialVersionUID = 1L;

	private JLabel eObrazek;
	private JLabel eCzas;
	private JLabel eNazwa;
	
	public RendereZamowienia() {
		setBorder(new EmptyBorder(2, 10, 2, 10));
		setLayout(new BorderLayout(10, 10));
		
		eObrazek = new JLabel("");
		eObrazek.setIcon(new ImageIcon(RendereZamowienia.class.getResource("/obrazki/zamowienia/shakeM0.png")));
		add(eObrazek, BorderLayout.WEST);
		
		eCzas = new JLabel("XX:XX");
		eCzas.setFont(new Font("Tahoma", Font.PLAIN, 24));
		add(eCzas, BorderLayout.EAST);
		
		eNazwa = new JLabel("Nazwa");
		eNazwa.setFont(new Font("Tahoma", Font.PLAIN, 24));
		add(eNazwa, BorderLayout.CENTER);

	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Zamowienie> list, Zamowienie zamowienie, int index,
			boolean isSelected, boolean cellHasFocus) {
		if (isSelected) {
			setBackground(Color.GREEN);
		} else {
			setBackground(Color.LIGHT_GRAY);
		}
		int id = zamowienie.getId();
		eObrazek.setIcon(new ImageIcon(RendereZamowienia.class.getResource("/obrazki/zamowienia/shakeM" + id + ".png")));
		eNazwa.setText(Nazwa.sheka(id));
		eCzas.setText(zamowienie.getCzas());
		return this;
	}

}
