package gra.okna.panele;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import gra.narzedzia.Nazwy;
import gra.okna.OknoPulpitGracza;

import java.awt.Color;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class PanelMapy extends JPanel {

	private JLabel lWyspa0, lWyspa1, lWyspa2;
	private OknoPulpitGracza pulpit;
	
	/**
	 * Create the panel.
	 */
	public PanelMapy(OknoPulpitGracza pulpit) {
		this.pulpit = pulpit;
		setBackground(Color.BLUE);
		setPreferredSize(new Dimension(579, 427));
		
		setLayout(null);
		
		lWyspa0 = new JLabel("");
		lWyspa0.setBorder(new LineBorder(Color.RED, 3));
		lWyspa0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pulpit.dodajKomunikat("Wybrano wyspę " + Nazwy.wyspa(0));
				usunRamki();
				lWyspa0.setBorder(new LineBorder(Color.RED, 3));
				pulpit.pokazWyspe(0);
			}
		});
		lWyspa0.setIcon(new ImageIcon(OknoPulpitGracza.class.getResource("/obrazki/wyspaSama.png")));
		lWyspa0.setHorizontalAlignment(SwingConstants.CENTER);
		lWyspa0.setBounds(29, 33, 100, 100);
		add(lWyspa0);
		
		lWyspa1 = new JLabel("");
		lWyspa1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pulpit.dodajKomunikat("Wybrano wyspę " + Nazwy.wyspa(1));
				usunRamki();
				lWyspa1.setBorder(new LineBorder(Color.RED, 3));
				pulpit.pokazWyspe(1);
			}
		});
		lWyspa1.setIcon(new ImageIcon(OknoPulpitGracza.class.getResource("/obrazki/wyspaSama.png")));
		lWyspa1.setHorizontalAlignment(SwingConstants.CENTER);
		lWyspa1.setBounds(436, 33, 100, 100);
		add(lWyspa1);
		
		lWyspa2 = new JLabel("");
		lWyspa2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pulpit.dodajKomunikat("Wybrano wyspę " + Nazwy.wyspa(2));
				usunRamki();
				lWyspa2.setBorder(new LineBorder(Color.RED, 3));
				pulpit.pokazWyspe(2);
			}
		});
		lWyspa2.setIcon(new ImageIcon(OknoPulpitGracza.class.getResource("/obrazki/wyspaSama.png")));
		lWyspa2.setHorizontalAlignment(SwingConstants.CENTER);
		lWyspa2.setBounds(236, 289, 100, 100);
		add(lWyspa2);
	}

	private void usunRamki() {
		lWyspa0.setBorder(null);
		lWyspa1.setBorder(null);
		lWyspa2.setBorder(null);
	}
	
	public void zmianObrazek(int indeksWyspy, boolean jestPort) {
		String opis = "/obrazki/wyspaSama";
		if (jestPort) {
			opis += "Port";
		}
		opis += ".png";
		switch(indeksWyspy) {
			case 0:
				lWyspa0.setIcon(new ImageIcon(OknoPulpitGracza.class.getResource(opis)));
				break;
			case 1:
				lWyspa1.setIcon(new ImageIcon(OknoPulpitGracza.class.getResource(opis)));
				break;
			case 2:
				lWyspa2.setIcon(new ImageIcon(OknoPulpitGracza.class.getResource(opis)));
				break;
		}
	}
}