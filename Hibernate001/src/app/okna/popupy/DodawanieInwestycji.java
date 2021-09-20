package app.okna.popupy;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import java.awt.Checkbox;
import java.awt.Choice;

public class DodawanieInwestycji extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JFrame oknoGlowne;

	/**
	 * Create the dialog.
	 */
	public DodawanieInwestycji(JFrame oknoGlowne) {
		this.oknoGlowne = oknoGlowne;
		setBounds(100, 100, 690, 194);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		{
			Choice choice = new Choice();
			contentPanel.add(choice);
		}
		{
			JLayeredPane layeredPane = new JLayeredPane();
			contentPanel.add(layeredPane);
		}
		{
			JLabel lblNewLabel = new JLabel("Wprowadz Nazwe Inwestycji");
			contentPanel.add(lblNewLabel);
		}
		{
			textField = new JTextField();
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Dodaj");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						zamknijPopup();
					}
				});
			}
			{
				JButton cancelButton = new JButton("Anuluj");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(new FlowLayout());
			{
				JLayeredPane layeredPane = new JLayeredPane();
				panel.add(layeredPane);
			}
			{
				JLabel lblWprowadzCeneZakupy = new JLabel("Wprowadz Cene Zakupy Inwestycji");
				panel.add(lblWprowadzCeneZakupy);
			}
			{
				textField_2 = new JTextField();
				textField_2.setColumns(10);
				panel.add(textField_2);
			}
			{
				JLabel lblKosztMiesiecznyInwestycji = new JLabel("Koszt miesieczny  Inwestycji");
				panel.add(lblKosztMiesiecznyInwestycji);
			}
			{
				textField_1 = new JTextField();
				textField_1.setColumns(10);
				panel.add(textField_1);
			}
		}
	}
	
	private void zamknijPopup() {
		setVisible(false);
		oknoGlowne.setVisible(true);
	}

}
