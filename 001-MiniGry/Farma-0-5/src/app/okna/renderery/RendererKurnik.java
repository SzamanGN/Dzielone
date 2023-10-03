package app.okna.renderery;

import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import app.danestatyczne.Nazwa;
import app.modele.Drub;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ImageIcon;
import java.awt.Font;

public class RendererKurnik extends JPanel implements ListCellRenderer<Drub> {
	
	private JLabel eObrazek;
	private JLabel eNazwa;
	private JLabel eIlosc;
	
	public RendererKurnik() {
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setVgap(10);
		flowLayout.setHgap(10);
		flowLayout.setAlignment(FlowLayout.LEFT);
		
		eObrazek = new JLabel("");
		eObrazek.setIcon(new ImageIcon(RendererKurnik.class.getResource("/obrazki/kogutD.png")));
		add(eObrazek);
		
		eNazwa = new JLabel("Nazwa");
		eNazwa.setFont(new Font("Tahoma", Font.PLAIN, 30));
		add(eNazwa);
		
		eIlosc = new JLabel("x XX");
		eIlosc.setFont(new Font("Tahoma", Font.PLAIN, 30));
		add(eIlosc);
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Drub> list, Drub drub, int index, boolean isSelected,
			boolean cellHasFocus) {
		if(isSelected) {
			setBackground(Color.GREEN);
		}else {
			setBackground(Color.GRAY);
		}
		eObrazek.setIcon(new ImageIcon(RendererKurnik.class.getResource("/obrazki/" + Nazwa.obrazkaDrobiu(drub.getRodzaj()) + "D.png")));
		eNazwa.setText(Nazwa.drobiu(drub.getRodzaj()));
		eIlosc.setText("x " + drub.getIlosc());
		return this;
	}

}
