package gra.okna;

import java.awt.BorderLayout;
import java.awt.EventQueue;

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

public class OknoPulpitGracza extends JFrame {

	private JPanel contentPane;



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
		
		JPanel panelMapy = new JPanel();
		panelMapy.setBackground(Color.BLUE);
		panelMapy.setBounds(10, 33, 579, 427);
		contentPane.add(panelMapy);
		
		JLabel lblDaneGracza = new JLabel("Dane gracza");
		lblDaneGracza.setHorizontalAlignment(SwingConstants.CENTER);
		lblDaneGracza.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDaneGracza.setBounds(599, 11, 539, 23);
		contentPane.add(lblDaneGracza);
		
		JPanel panelDaneGracza = new JPanel();
		panelDaneGracza.setBackground(Color.GRAY);
		panelDaneGracza.setBounds(599, 33, 539, 125);
		contentPane.add(panelDaneGracza);
		panelDaneGracza.setLayout(null);
		
		JLabel lObrazekGracza = new JLabel("");
		lObrazekGracza.setIcon(new ImageIcon(OknoPulpitGracza.class.getResource("/obrazki/gracz01.png")));
		lObrazekGracza.setHorizontalAlignment(SwingConstants.CENTER);
		lObrazekGracza.setBounds(10, 10, 100, 94);
		panelDaneGracza.add(lObrazekGracza);
		
		JLabel lStanKonat = new JLabel("Stan konta : 1000000000C");
		lStanKonat.setFont(new Font("Tahoma", Font.BOLD, 14));
		lStanKonat.setHorizontalAlignment(SwingConstants.CENTER);
		lStanKonat.setBounds(120, 10, 409, 36);
		panelDaneGracza.add(lStanKonat);
		
		JLabel lZasiedloneWyspy = new JLabel("Zasiedlone wyspy: 0");
		lZasiedloneWyspy.setHorizontalAlignment(SwingConstants.CENTER);
		lZasiedloneWyspy.setFont(new Font("Tahoma", Font.BOLD, 14));
		lZasiedloneWyspy.setBounds(120, 57, 409, 36);
		panelDaneGracza.add(lZasiedloneWyspy);
		
		JLabel lblStatek = new JLabel("Statek");
		lblStatek.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatek.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStatek.setBounds(599, 155, 539, 23);
		contentPane.add(lblStatek);
		
		JPanel panelStatku = new JPanel();
		panelStatku.setBackground(Color.GRAY);
		panelStatku.setBounds(599, 177, 539, 153);
		contentPane.add(panelStatku);
		panelStatku.setLayout(null);
		
		JLabel lStatek = new JLabel("");
		lStatek.setIcon(new ImageIcon(OknoPulpitGracza.class.getResource("/obrazki/Statek.png")));
		lStatek.setHorizontalAlignment(SwingConstants.CENTER);
		lStatek.setBounds(10, 10, 100, 69);
		panelStatku.add(lStatek);
		
		JLabel lStausStatku = new JLabel("Status statku: w porcie A");
		lStausStatku.setHorizontalAlignment(SwingConstants.CENTER);
		lStausStatku.setFont(new Font("Tahoma", Font.BOLD, 14));
		lStausStatku.setBounds(120, 10, 409, 36);
		panelStatku.add(lStausStatku);
		
		JLabel lLadownosc = new JLabel("Ladownosc: 10");
		lLadownosc.setHorizontalAlignment(SwingConstants.CENTER);
		lLadownosc.setFont(new Font("Tahoma", Font.BOLD, 14));
		lLadownosc.setBounds(120, 41, 409, 36);
		panelStatku.add(lLadownosc);
		
		JLabel lCenaLadunku = new JLabel("Cena ladunku: 15000C");
		lCenaLadunku.setHorizontalAlignment(SwingConstants.CENTER);
		lCenaLadunku.setFont(new Font("Tahoma", Font.BOLD, 14));
		lCenaLadunku.setBounds(120, 74, 409, 36);
		panelStatku.add(lCenaLadunku);
		
		JButton bZaladunek = new JButton("Zaladunek");
		bZaladunek.setFont(new Font("Tahoma", Font.BOLD, 16));
		bZaladunek.setBounds(130, 121, 119, 23);
		panelStatku.add(bZaladunek);
		
		JButton bRozladunek = new JButton("Rozladunek");
		bRozladunek.setFont(new Font("Tahoma", Font.BOLD, 16));
		bRozladunek.setBounds(259, 121, 143, 23);
		panelStatku.add(bRozladunek);
		
		JPanel panelWyspa = new JPanel();
		panelWyspa.setBackground(Color.GRAY);
		panelWyspa.setBounds(599, 363, 539, 135);
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
		panelSurowcow.setBounds(120, 47, 409, 63);
		panelWyspa.add(panelSurowcow);
		panelSurowcow.setLayout(new GridLayout(0, 3, 5, 5));
		
		JLabel lSurowiec0 = new JLabel("<html><center><b>Drzewo</b><br>Ilość: 5<br>Cena: 15C</center></html>");
		lSurowiec0.setOpaque(true);
		lSurowiec0.setBackground(Color.YELLOW);
		lSurowiec0.setForeground(Color.BLACK);
		lSurowiec0.setBorder(new LineBorder(Color.RED, 2));
		lSurowiec0.setHorizontalAlignment(SwingConstants.CENTER);
		lSurowiec0.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelSurowcow.add(lSurowiec0);
		
		JLabel lSurowiec1 = new JLabel("<html><center><b>Żelazo</b><br>Ilość: 5<br>Cena: 15C</center></html>");
		lSurowiec1.setOpaque(true);
		lSurowiec1.setBackground(Color.YELLOW);
		lSurowiec1.setForeground(Color.BLACK);
		lSurowiec1.setBorder(new LineBorder(Color.RED, 2));
		lSurowiec1.setHorizontalAlignment(SwingConstants.CENTER);
		lSurowiec1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelSurowcow.add(lSurowiec1);
		
		JLabel lSurowiec2 = new JLabel("<html><center><b>Skóry</b><br>Ilość: 5<br>Cena: 15C</center></html>");
		lSurowiec2.setOpaque(true);
		lSurowiec2.setBackground(Color.YELLOW);
		lSurowiec2.setForeground(Color.BLACK);
		lSurowiec2.setBorder(new LineBorder(Color.RED, 2));
		lSurowiec2.setHorizontalAlignment(SwingConstants.CENTER);
		lSurowiec2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelSurowcow.add(lSurowiec2);
		
		JLabel lblWyspa = new JLabel("Wyspa");
		lblWyspa.setHorizontalAlignment(SwingConstants.CENTER);
		lblWyspa.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWyspa.setBounds(599, 341, 539, 23);
		contentPane.add(lblWyspa);
		
		JButton btnNewButton = new JButton("Nowa tura");
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
		
		JList lKomunikaty = new JList();
		lKomunikaty.setVisibleRowCount(10);
		lKomunikaty.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(lKomunikaty);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
