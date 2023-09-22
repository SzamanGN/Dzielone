package app.okna;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;

public class PanelFarma extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelFarma() {
		setOpaque(false);
		setForeground(new Color(128, 255, 128));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		JLabel eKalendarz = new JLabel("Kalendarz: XXXX-XX-XX XX:XX");
		eKalendarz.setFont(new Font("Tahoma", Font.PLAIN, 16));
		eKalendarz.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(eKalendarz);
		
		JPanel panelInforamcyjny = new JPanel();
		add(panelInforamcyjny, BorderLayout.SOUTH);
		panelInforamcyjny.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panelInforamcyjny.add(panel_3, BorderLayout.SOUTH);
		
		JButton pWrucDoMenu = new JButton("Wruc do menu");
		panel_3.add(pWrucDoMenu);
		pWrucDoMenu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JScrollPane scrollPane_3 = new JScrollPane();
		panelInforamcyjny.add(scrollPane_3, BorderLayout.CENTER);
		
		JLabel eKomunikaty = new JLabel("Komunikaty");
		eKomunikaty.setHorizontalAlignment(SwingConstants.CENTER);
		eKomunikaty.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPane_3.setColumnHeaderView(eKomunikaty);
		
		JList listKomuniaty = new JList();
		listKomuniaty.setFont(new Font("Tahoma", Font.PLAIN, 13));
		listKomuniaty.setVisibleRowCount(10);
		listKomuniaty.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_3.setViewportView(listKomuniaty);
		
		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(0, 3, 5, 5));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane);
		
		JLabel eMagazyn = new JLabel("Magazyn");
		eMagazyn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		eMagazyn.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setColumnHeaderView(eMagazyn);
		
		JList lMagazyn = new JList();
		lMagazyn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lMagazyn.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(lMagazyn);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_2.add(scrollPane_1);
		
		JList lStajnia = new JList();
		lStajnia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lStajnia.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(lStajnia);
		
		JLabel eStajnia = new JLabel("Stajnia");
		eStajnia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		eStajnia.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane_1.setColumnHeaderView(eStajnia);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		panel_2.add(scrollPane_2);
		
		JList lKurnik = new JList();
		lKurnik.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lKurnik.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_2.setViewportView(lKurnik);
		
		JLabel eKurnik = new JLabel("Kurnik");
		eKurnik.setFont(new Font("Tahoma", Font.PLAIN, 16));
		eKurnik.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane_2.setColumnHeaderView(eKurnik);

	}

}
