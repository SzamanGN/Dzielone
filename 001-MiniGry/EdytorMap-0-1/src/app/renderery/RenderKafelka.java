package app.renderery;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.Component;

import javax.swing.SwingConstants;

import app.modele.Kafelek;
import javax.swing.border.EmptyBorder;

public class RenderKafelka extends JLabel implements ListCellRenderer<Kafelek> {
	public RenderKafelka() {
		setBorder(new EmptyBorder(2, 2, 2, 2));
		setHorizontalAlignment(SwingConstants.LEFT);
		setBackground(new Color(0, 255, 128));
		setOpaque(true);
		setFont(new Font("Tahoma", Font.PLAIN, 20));
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Kafelek> list, Kafelek kafelek, int index,
			boolean isSelected, boolean cellHasFocus) {
		if(isSelected) {
			setBackground(Color.YELLOW);
		} else {
			setBackground(Color.LIGHT_GRAY);
		}
		setIcon(new ImageIcon(kafelek.getImg()));
		setText(kafelek.getNazwa());
		
		return this;
	}

	
}
