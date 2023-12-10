package start.okna;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import narzedzia.Generator;
import panele.PanelPunktacja;
import silnik.Pojedynek;
import silnik.StanPojedynku;
import silnik.WynikPojedynku;
import silnik.Wyniki;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class OknoPojedynku extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private PanelPunktacja panelPunktacji;
	private Wyniki wyniki;
	private Pojedynek pojedynek;
	private JTextField tfWyborPrzeciwnika;
	private JTextField tfWyborGracza;
	private JLabel lblWyborGracza;
	

	
	public OknoPojedynku() {
		setTitle("Pojedynek");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 811, 546);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panelPunktacji = new PanelPunktacja();
		contentPane.add(panelPunktacji, BorderLayout.NORTH);
		wyniki =  new Wyniki();
		panelPunktacji.aktulizacjaPuntow(wyniki.getPunkty());
		panelPunktacji.aktulizacjaWygrane(wyniki.getWygrane());
		panelPunktacji.aktulizacjaRemisy(wyniki.getRemisy());
		panelPunktacji.aktulizacjaPrzegrane(wyniki.getPrzegrane());
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton bWalcz = new JButton("Walcz");
		bWalcz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				walcz();
			}
		});
		
		lblWyborGracza = new JLabel("Wybor gracza");
		lblWyborGracza.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblWyborGracza);
		
		tfWyborGracza = new JTextField();
		tfWyborGracza.setText("PKNNK");
		tfWyborGracza.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfWyborGracza.setColumns(5);
		panel.add(tfWyborGracza);
		
		JLabel lblNewLabel = new JLabel("Wybor przeciwnika");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblNewLabel);
		
		tfWyborPrzeciwnika = new JTextField();
		tfWyborPrzeciwnika.setText("PPKNN");
		tfWyborPrzeciwnika.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(tfWyborPrzeciwnika);
		tfWyborPrzeciwnika.setColumns(5);
		bWalcz.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(bWalcz);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void walcz() {
		pojedynek = new Pojedynek(
				tfWyborGracza.getText(),
				Generator.wyboru()
				);
		WynikPojedynku wynikPojedynku = pojedynek.walcz();
		wyniki.aktulizacjaPuktow(wynikPojedynku.getPunkty());
		panelPunktacji.aktulizacjaPuntow(wyniki.getPunkty());
		if(wynikPojedynku.getStan() == StanPojedynku.Wygrana) {
			wyniki.zwiekszWygrane();
			panelPunktacji.aktulizacjaWygrane(wyniki.getWygrane());
		} else if(wynikPojedynku.getStan() == StanPojedynku.Przegrana) {
			wyniki.zwiekszPrzegrane();
			panelPunktacji.aktulizacjaPrzegrane(wyniki.getPrzegrane());
		} else {
			wyniki.zwiekszRemisy();
			panelPunktacji.aktulizacjaRemisy(wyniki.getRemisy());
		}
	}

}
