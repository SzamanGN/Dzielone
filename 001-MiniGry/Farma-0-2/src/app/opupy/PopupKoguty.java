package app.opupy;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.modele.SamiecDrobiu;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

public class PopupKoguty extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public PopupKoguty() {
		setUndecorated(true);
		setBounds(100, 100, 843, 661);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JLabel lbKkok = new JLabel("Koguty");
			lbKkok.setFont(new Font("Tahoma", Font.BOLD, 26));
			lbKkok.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lbKkok, BorderLayout.NORTH);
		}
		{
			JScrollPane spKoguty = new JScrollPane();
			contentPanel.add(spKoguty, BorderLayout.CENTER);
			{
				JList<SamiecDrobiu> lKoguty = new JList<SamiecDrobiu>();
				
				lKoguty.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				spKoguty.setViewportView(lKoguty);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton bZamknij = new JButton("Zamknij");
				bZamknij.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						zamknij();
					}
				});
				bZamknij.setFont(new Font("Tahoma", Font.PLAIN, 16));
				bZamknij.setActionCommand("OK");
				buttonPane.add(bZamknij);
				getRootPane().setDefaultButton(bZamknij);
			}
		}
		setModal(true);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void zamknij() {
		System.out.println("Zamykamy okno kogotow");
		dispose();
	}

}
