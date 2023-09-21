package kontrolery;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import panele.PanelGry;
import static dodatki.GraczStale.Kierunek.*;

public class Klawiatura  implements KeyListener{
	
	private PanelGry panelGry;
	
	public Klawiatura(PanelGry panelGry) {
		this.panelGry = panelGry ;
	}
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			panelGry.ustawKierunek(GORA);
			break;
		case KeyEvent.VK_A:
			panelGry.ustawKierunek(LEWO);
			break;
		case KeyEvent.VK_S:
			panelGry.ustawKierunek(DOL);
			break;
		case KeyEvent.VK_D:
			panelGry.ustawKierunek(PRAWO);
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
		case KeyEvent.VK_A:
		case KeyEvent.VK_S:
		case KeyEvent.VK_D:
			panelGry.ustawRuch(false);
			break;
		}
	}

}
