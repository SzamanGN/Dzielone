package app.renderery;

import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Component;

import javax.swing.border.LineBorder;

import app.pomoce.Kolor;
import app.pomoce.Opis;

public class RendererKolorow extends JPanel implements ListCellRenderer<Integer>{
	
	private JLabel eKolor;
	private JLabel eOpis;

	public RendererKolorow() {
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		
		eKolor = new JLabel("");
		eKolor.setBorder(new LineBorder(new Color(0, 0, 0)));
		eKolor.setBackground(new Color(255, 255, 255));
		eKolor.setOpaque(true);
		eKolor.setPreferredSize(new Dimension(20, 20));
		add(eKolor);
		
		eOpis = new JLabel("New label");
		eOpis.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(eOpis);

	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Integer> list, Integer ktory, int index,
			boolean isSelected, boolean cellHasFocus) {
		
		if(isSelected) {
			setBackground(Color.GRAY);
		} else {
			setBackground(Color.LIGHT_GRAY);
		}
		
		eKolor.setBackground(Kolor.get(ktory));
		eOpis.setText(Opis.getKolor(ktory));
		return this;
	}

}
