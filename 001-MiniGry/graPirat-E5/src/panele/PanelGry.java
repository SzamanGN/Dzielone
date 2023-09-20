package panele;

import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import dodatki.GraczStale;
import dodatki.Kierunek;
import kontrolery.Myszka;

public class PanelGry  extends JPanel{
	
	
	private GraczStale graczstale;
	private Kierunek kierunek;
	private Myszka myszka;
	private float xDelta = 100;
	private float yDelta = 100;
	private BufferedImage obraz;
	private BufferedImage[][] animacja;
	private int aniZegar;
	private int adniIndex;
	private int aniPredkosc = 15;
	private boolean ruch = false;

}
