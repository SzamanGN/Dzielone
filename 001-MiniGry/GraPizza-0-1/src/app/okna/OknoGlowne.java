package app.okna;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;

public class OknoGlowne extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public OknoGlowne() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1305, 744);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelStanu = new JPanel();
		contentPane.add(panelStanu, BorderLayout.NORTH);
		
		JLabel eStanKonta = new JLabel("Stan konta: XX");
		eStanKonta.setHorizontalAlignment(SwingConstants.CENTER);
		eStanKonta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelStanu.add(eStanKonta);
		
		JScrollPane scrollPaneKomunikaty = new JScrollPane();
		contentPane.add(scrollPaneKomunikaty, BorderLayout.SOUTH);
		
		JLabel eKomunikaty = new JLabel("Komunikaty\r\n");
		eKomunikaty.setHorizontalAlignment(SwingConstants.CENTER);
		eKomunikaty.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scrollPaneKomunikaty.setColumnHeaderView(eKomunikaty);
		
		JList lKomunikaty = new JList();
		lKomunikaty.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lKomunikaty.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPaneKomunikaty.setViewportView(lKomunikaty);
		
		JScrollPane scrollPaneZamowienia = new JScrollPane();
		contentPane.add(scrollPaneZamowienia, BorderLayout.WEST);
		
		JLabel lblZamowienia = new JLabel("Zamowienia\r\n");
		lblZamowienia.setHorizontalAlignment(SwingConstants.CENTER);
		lblZamowienia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scrollPaneZamowienia.setColumnHeaderView(lblZamowienia);
		
		JList lZamowienia = new JList();
		scrollPaneZamowienia.setViewportView(lZamowienia);
		
		JScrollPane scrollPaneProdukty = new JScrollPane();
		contentPane.add(scrollPaneProdukty, BorderLayout.EAST);
		
		JLabel lblProdukty = new JLabel("Produkty\r\n");
		lblProdukty.setHorizontalAlignment(SwingConstants.CENTER);
		lblProdukty.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scrollPaneProdukty.setColumnHeaderView(lblProdukty);
		
		JList lProdukty = new JList();
		lProdukty.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPaneProdukty.setViewportView(lProdukty);
		
		JPanel panelPicerii = new JPanel();
		contentPane.add(panelPicerii, BorderLayout.CENTER);
		panelPicerii.setLayout(new GridLayout(2, 0, 5, 5));
		
		JPanel panelStol = new JPanel();
		panelPicerii.add(panelStol);
		panelStol.setLayout(new BorderLayout(0, 0));
		
		JLabel lblStol = new JLabel("Stol\r\n");
		lblStol.setHorizontalAlignment(SwingConstants.CENTER);
		lblStol.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelStol.add(lblStol, BorderLayout.NORTH);
		
		JPanel panelAkcjiStolu = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelAkcjiStolu.getLayout();
		flowLayout.setVgap(10);
		flowLayout.setHgap(10);
		panelStol.add(panelAkcjiStolu, BorderLayout.SOUTH);
		
		JButton pWyszyscStol = new JButton("Wyczysc stol");
		pWyszyscStol.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelAkcjiStolu.add(pWyszyscStol);
		
		JButton pDoPieca = new JButton("Do pieca\r\n");
		pDoPieca.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelAkcjiStolu.add(pDoPieca);
		
		JButton pSklep = new JButton("Sklep\r\n");
		pSklep.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelAkcjiStolu.add(pSklep);
		
		JScrollPane spPanelStoluPicy = new JScrollPane();
		panelStol.add(spPanelStoluPicy, BorderLayout.CENTER);
		
		JPanel panelStoluPicy = new JPanel();
		spPanelStoluPicy.setViewportView(panelStoluPicy);
		
		JPanel panelPiec = new JPanel();
		panelPicerii.add(panelPiec);
		panelPiec.setLayout(new BorderLayout(0, 0));
		
		JLabel lblPiec = new JLabel("Piec\r\n");
		lblPiec.setHorizontalAlignment(SwingConstants.CENTER);
		lblPiec.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelPiec.add(lblPiec, BorderLayout.NORTH);
		
		JScrollPane scrollPanePieca = new JScrollPane();
		panelPiec.add(scrollPanePieca, BorderLayout.CENTER);
		
		JPanel panelPiecaDoPizzy = new JPanel();
		scrollPanePieca.setViewportView(panelPiecaDoPizzy);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
