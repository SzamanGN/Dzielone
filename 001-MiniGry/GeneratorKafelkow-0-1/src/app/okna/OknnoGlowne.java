package app.okna;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.modeleList.ModelListyKolorow;
import app.okna.panele.PanelEdytoraKafelka;
import app.renderery.RendererKolorow;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OknnoGlowne extends JFrame {

	private JPanel contentPane;
	private JTextField tfNazwaPliku;
	private PanelEdytoraKafelka panelEdytoraKafelka;
	private int kolorTuszu;


	public OknnoGlowne() {
		setResizable(false);
		setTitle("GeneratorKafelkow-0-1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 758, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(10, 10));
		
		JPanel panelFormulrza = new JPanel();
		contentPane.add(panelFormulrza, BorderLayout.NORTH);
		
		JLabel lblNewLabe = new JLabel("Kafelek");
		lblNewLabe.setFont(new Font("Tahoma", Font.BOLD, 16));
		panelFormulrza.add(lblNewLabe);
		
		JLabel eKafelek = new JLabel("");
		eKafelek.setOpaque(true);
		eKafelek.setBackground(new Color(128, 255, 128));
		eKafelek.setPreferredSize(new Dimension(32, 32));
		eKafelek.setFont(new Font("Tahoma", Font.BOLD, 16));
		panelFormulrza.add(eKafelek);
		
		JLabel lblZapiszJako = new JLabel("zapisz jako");
		lblZapiszJako.setFont(new Font("Tahoma", Font.BOLD, 16));
		panelFormulrza.add(lblZapiszJako);
		
		tfNazwaPliku = new JTextField();
		tfNazwaPliku.setText("kafelek");
		tfNazwaPliku.setFont(new Font("Tahoma", Font.BOLD, 16));
		panelFormulrza.add(tfNazwaPliku);
		tfNazwaPliku.setColumns(10);
		
		JButton bZapisz = new JButton("Zapisz");
		bZapisz.setFont(new Font("Tahoma", Font.BOLD, 16));
		panelFormulrza.add(bZapisz);
		
		JScrollPane spKolory = new JScrollPane();
		contentPane.add(spKolory, BorderLayout.WEST);
		
		JLabel lblKolory = new JLabel("Kolory");
		lblKolory.setHorizontalAlignment(SwingConstants.CENTER);
		lblKolory.setFont(new Font("Tahoma", Font.BOLD, 16));
		spKolory.setColumnHeaderView(lblKolory);
		
		JList<Integer> lKolory = new JList<Integer>();
		lKolory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ustawKolorTuszu(lKolory.getSelectedIndex());
			}
		});
		new ModelListyKolorow(lKolory);
		lKolory.setCellRenderer(new RendererKolorow());
		lKolory.setSelectedIndex(1);
		lKolory.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lKolory.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spKolory.setViewportView(lKolory);
		
		JPanel panelGlowny = new JPanel();
		panelGlowny.setBorder(new EmptyBorder(50, 0, 0, 0));
		contentPane.add(panelGlowny, BorderLayout.CENTER);
		
		panelEdytoraKafelka = new PanelEdytoraKafelka();
		panelEdytoraKafelka.setPreferredSize(new Dimension(320, 320));
		panelGlowny.add(panelEdytoraKafelka);
		setLocationRelativeTo(null);
		
		// incjowanie danych
		incjowanieDanych();
		
		setVisible(true);
	}


	private void ustawKolorTuszu(int selectedIndex) {
		kolorTuszu = selectedIndex;
		panelEdytoraKafelka.ustawKolorTuszu(kolorTuszu);
	}


	private void incjowanieDanych() {
		kolorTuszu = 1;
	}

}
