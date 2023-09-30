package app.opupy;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import app.okna.OknoFarmy;

public class PopupWzorzecListy extends JDialog {

	private static final long serialVersionUID = 1L;
	protected JScrollPane scrollPane;
	protected JLabel eTytul;
	protected JPopupMenu popupMenu;
	protected OknoFarmy oknoFarmy;

	public PopupWzorzecListy(OknoFarmy oknoFarmy) {
		this.oknoFarmy = oknoFarmy;
		setTitle("Wzorzec");
		setBounds(100, 100, 649, 560);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton bZakmnij = new JButton("Zamknij");
				bZakmnij.setFont(new Font("Tahoma", Font.PLAIN, 20));
				bZakmnij.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						zamknij();
					}
				});
				bZakmnij.setToolTipText("");
				bZakmnij.setActionCommand("Cancel");
				buttonPane.add(bZakmnij);
			}
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBorder(null);
			getContentPane().add(scrollPane, BorderLayout.CENTER);
			{
				eTytul = new JLabel("Tytul");
				eTytul.setFont(new Font("Tahoma", Font.PLAIN, 22));
				eTytul.setHorizontalAlignment(SwingConstants.CENTER);
				scrollPane.setColumnHeaderView(eTytul);
			}
			{
				// deklaracja i incjacja listy
				//scrollPane.setViewportView(list);
				{
					popupMenu = new JPopupMenu();
					// dopisujemy poupap menu do listy
					//addPopup(list, popupMenu);
					{
						JMenuItem pmiNakarm = new JMenuItem("Nakarm");
						pmiNakarm.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								nakarm();
							}
						});
						popupMenu.add(pmiNakarm);
					}
				}
			}
		}
		
		ustawListe();
		
		setModal(true);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	protected static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	private void zamknij() {
		System.out.println("Zamykanie poupu");
		dispose();
	}
	
	protected void nakarm() {
		
	}
	
	protected void ustawListe() {
		
	}
}
