package app.okna;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.etykiety.Etykieta;
import app.modele.CenaAkcji;
import app.modele.ObslugaKonta;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OknoGlowne extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelTranzakcji;
	private CenaAkcji cena;
	private JLabel eAtualnaCena;
	private ObslugaKonta konto;
	private JLabel eStanKonta;

	public OknoGlowne() {
		cena = new CenaAkcji();
		konto =  new ObslugaKonta();
		setTitle("Mini gielda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 732, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelOperacji = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelOperacji.getLayout();
		flowLayout.setHgap(20);
		contentPane.add(panelOperacji, BorderLayout.SOUTH);
		
		eStanKonta = new JLabel("Stan konta: XXXX");
		eStanKonta.setFont(new Font("Tahoma", Font.PLAIN, 23));
		panelOperacji.add(eStanKonta);
		
		eAtualnaCena = new JLabel("Aktulana cena: XXXX");
		eAtualnaCena.setFont(new Font("Tahoma", Font.PLAIN, 23));
		panelOperacji.add(eAtualnaCena);
		
		JButton bZakup = new JButton("Kup");
		bZakup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kupAkcje();
			}
		});
		bZakup.setFont(new Font("Tahoma", Font.PLAIN, 23));
		panelOperacji.add(bZakup);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		panelTranzakcji = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panelTranzakcji.getLayout();
		flowLayout_1.setHgap(25);
		panelTranzakcji.setBorder(new EmptyBorder(15, 15, 15, 15));
		scrollPane.setViewportView(panelTranzakcji);
		
		aktulizacjaCeny();
		aktulizacjaStanuKonta();
		new Thread(this).start();
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private MouseAdapter etykietaMouseAdapter() {
		return new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Kliknieto w etykiete");
				panelTranzakcji.remove(
						(Etykieta) e.getSource()
						);
				konto.wplata(cena.getCena());
				aktulizacjaStanuKonta();
				contentPane.updateUI();
			}
		};
	}
	
	private void kupAkcje() {
		if(konto.wyplata(cena.getCena())) {
			aktulizacjaStanuKonta();
			panelTranzakcji.add(new Etykieta(cena.getCena(), etykietaMouseAdapter()));
			contentPane.updateUI();
		}

	}
	
	private void aktulizacjaCeny() {
		int delta = 0;
		switch((int) System.currentTimeMillis() % 3) {
			case 0:
				delta = -1;
				break;
			case 2:
				delta = 1;
				break;
		}
		cena.aktualizacjaCeny(delta);
		eAtualnaCena.setText("Aktualna cena: " + cena.getCena());
	}
	
	private void aktulizacjaStanuKonta() {
		eStanKonta.setText("Stan konta: " + konto.getStan());
	}

	@Override
	public void run() {
		
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			aktulizacjaCeny();
		}
		
	}

}
