package app.okna;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Frame;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OknoFarmy extends JFrame {

	private JPanel contentPane;

	public OknoFarmy() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1062, 745);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelInforamyjny = new JPanel();
		contentPane.add(panelInforamyjny, BorderLayout.NORTH);
		
		JPanel panelAkccji = new JPanel();
		contentPane.add(panelAkccji, BorderLayout.SOUTH);
		
		JButton pWurcDoMenu = new JButton("Wruc do menu");
		pWurcDoMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				powrotDoMenu();
			}
		});
		pWurcDoMenu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelAkccji.add(pWurcDoMenu);
		setVisible(true);
	}
	
	private void powrotDoMenu() {
		new OknoMenu();
		dispose();
	}

}
