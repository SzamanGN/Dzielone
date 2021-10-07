package gra.okna;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;
import gra.komunikaty.ObslugaKomunikatow;
import gra.okna.panele.PanelDanychGracza;
import gra.okna.panele.PanelMapy;
import gra.okna.panele.PanelStatku;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class OknoPulpitGracza extends JFrame {

	private JPanel contentPane;
	private ObslugaKomunikatow komunikaty;
	private PanelMapy panelMapy;
	private PanelDanychGracza panelDaneGracza;
	private PanelStatku panelStatku;


	/**
	 * Create the frame.
	 */
	public OknoPulpitGracza() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(OknoPulpitGracza.class.getResource("/obrazki/statek.jpg")));
		setTitle("Statek");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1154, 786);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mapa");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 579, 23);
		contentPane.add(lblNewLabel);
		
		panelMapy = new PanelMapy(this);
		panelMapy.setBackground(Color.BLUE);
		panelMapy.setBounds(10, 33, 579, 427);
		contentPane.add(panelMapy);
		
		
		
		JLabel lblDaneGracza = new JLabel("Dane gracza");
		lblDaneGracza.setHorizontalAlignment(SwingConstants.CENTER);
		lblDaneGracza.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDaneGracza.setBounds(599, 11, 539, 23);
		contentPane.add(lblDaneGracza);
		
		panelDaneGracza = new PanelDanychGracza();
		panelDaneGracza.setBackground(Color.GRAY);
		panelDaneGracza.setBounds(599, 33, 539, 125);
		contentPane.add(panelDaneGracza);

		JLabel lblStatek = new JLabel("Statek");
		lblStatek.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatek.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStatek.setBounds(599, 155, 539, 23);
		contentPane.add(lblStatek);
		
		// -----------------------
		
		panelStatku = new PanelStatku();
		panelStatku.setBounds(599, 177, 539, 153);
		contentPane.add(panelStatku);

		// -----------------------
		
		JPanel panelWyspa = new JPanel();
		panelWyspa.setBackground(Color.GRAY);
		panelWyspa.setBounds(599, 351, 539, 147);
		contentPane.add(panelWyspa);
		panelWyspa.setLayout(null);
		
		JLabel lWyspa = new JLabel("");
		lWyspa.setIcon(new ImageIcon(OknoPulpitGracza.class.getResource("/obrazki/wyspaSama.png")));
		lWyspa.setHorizontalAlignment(SwingConstants.CENTER);
		lWyspa.setBounds(10, 10, 100, 100);
		panelWyspa.add(lWyspa);
		
		JLabel lNazwaWyspy = new JLabel("Wyspa: Nazwa");
		lNazwaWyspy.setHorizontalAlignment(SwingConstants.CENTER);
		lNazwaWyspy.setFont(new Font("Tahoma", Font.BOLD, 14));
		lNazwaWyspy.setBounds(120, 10, 409, 36);
		panelWyspa.add(lNazwaWyspy);
		
		JPanel panelSurowcow = new JPanel();
		panelSurowcow.setBackground(Color.GRAY);
		panelSurowcow.setBounds(120, 47, 409, 89);
		panelWyspa.add(panelSurowcow);
		panelSurowcow.setLayout(new GridLayout(2, 3, 5, 5));
		
		JLabel lSurowiecP0 = new JLabel("<html><center><b>Drzewo</b><br>Kup: 15C</center></html>");
		lSurowiecP0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		lSurowiecP0.setOpaque(true);
		lSurowiecP0.setBackground(Color.YELLOW);
		lSurowiecP0.setForeground(Color.BLACK);
		lSurowiecP0.setBorder(new LineBorder(Color.RED, 2));
		lSurowiecP0.setHorizontalAlignment(SwingConstants.CENTER);
		lSurowiecP0.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelSurowcow.add(lSurowiecP0);
		
		JLabel lSurowiecP1 = new JLabel("<html><center><b>Żelazo</b><br>Kup: 15C</center></html>");
		lSurowiecP1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		lSurowiecP1.setOpaque(true);
		lSurowiecP1.setBackground(Color.YELLOW);
		lSurowiecP1.setForeground(Color.BLACK);
		lSurowiecP1.setBorder(new LineBorder(Color.RED, 2));
		lSurowiecP1.setHorizontalAlignment(SwingConstants.CENTER);
		lSurowiecP1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelSurowcow.add(lSurowiecP1);
		
		JLabel lSurowiecP2 = new JLabel("<html><center><b>Skóry</b><br>Kup: 15C</center></html>");
		lSurowiecP2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		lSurowiecP2.setOpaque(true);
		lSurowiecP2.setBackground(Color.YELLOW);
		lSurowiecP2.setForeground(Color.BLACK);
		lSurowiecP2.setBorder(new LineBorder(Color.RED, 2));
		lSurowiecP2.setHorizontalAlignment(SwingConstants.CENTER);
		lSurowiecP2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelSurowcow.add(lSurowiecP2);
		
		JLabel lSurowiecW0 = new JLabel("<html><center><b>Drzewo</b><br>Sprzedaj: 15C</center></html>");
		lSurowiecW0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		lSurowiecW0.setOpaque(true);
		lSurowiecW0.setBackground(Color.GREEN);
		lSurowiecW0.setForeground(Color.BLACK);
		lSurowiecW0.setBorder(new LineBorder(Color.RED, 2));
		lSurowiecW0.setHorizontalAlignment(SwingConstants.CENTER);
		lSurowiecW0.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelSurowcow.add(lSurowiecW0);
		
		JLabel lSurowiecW1 = new JLabel("<html><center><b>Żelazo</b><br>Sprzedaj: 15C</center></html>");
		lSurowiecW1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		lSurowiecW1.setOpaque(true);
		lSurowiecW1.setBackground(Color.GREEN);
		lSurowiecW1.setForeground(Color.BLACK);
		lSurowiecW1.setBorder(new LineBorder(Color.RED, 2));
		lSurowiecW1.setHorizontalAlignment(SwingConstants.CENTER);
		lSurowiecW1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelSurowcow.add(lSurowiecW1);
		
		JLabel lSurowiecW2 = new JLabel("<html><center><b>Skóry</b><br>Sprzedaj: 15C</center></html>");
		lSurowiecW2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		lSurowiecW2.setOpaque(true);
		lSurowiecW2.setBackground(Color.GREEN);
		lSurowiecW2.setForeground(Color.BLACK);
		lSurowiecW2.setBorder(new LineBorder(Color.RED, 2));
		lSurowiecW2.setHorizontalAlignment(SwingConstants.CENTER);
		lSurowiecW2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelSurowcow.add(lSurowiecW2);
		
		JLabel lblWyspa = new JLabel("Wyspa");
		lblWyspa.setHorizontalAlignment(SwingConstants.CENTER);
		lblWyspa.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWyspa.setBounds(599, 327, 539, 23);
		contentPane.add(lblWyspa);
		
		JButton btnNewButton = new JButton("Nowa tura");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//panelMapy.zmianObrazek(2, false);
				komunikaty.dodaj("Nowa tura!");
				panelDaneGracza.aktualizacjaOpisuStanuKonta(12345);
				panelDaneGracza.aktualizacjaOpisuZasiedlenia(7);
				
				panelStatku.aktualizacjaStatusu(true, "Alfa");
				panelStatku.aktualizacjaLadunku(8, "Złoto");
				panelStatku.aktualizacjaCenyLadunku(156);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(10, 471, 579, 28);
		contentPane.add(btnNewButton);
		
		JLabel lblKomunikat = new JLabel("Komunikaty");
		lblKomunikat.setHorizontalAlignment(SwingConstants.CENTER);
		lblKomunikat.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblKomunikat.setBounds(10, 510, 1128, 23);
		contentPane.add(lblKomunikat);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 532, 1128, 216);
		contentPane.add(scrollPane);
		
		
		JList<String> lKomunikaty = new JList<String>();
		komunikaty = new ObslugaKomunikatow(lKomunikaty);
		lKomunikaty.setVisibleRowCount(10);
		lKomunikaty.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(lKomunikaty);
		
		komunikaty.dodaj("Witaj w grze!");
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void dodajKomunikat(String komunikat) {
		komunikaty.dodaj(komunikat);
	}
}
