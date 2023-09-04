package app.modele;

import java.awt.Image;

public class Kafelek {
	private Image img;
	private String nazwa;
	
	public Kafelek() {
		ustaw(null, "brak");
	}
	
	public Kafelek(Image img, String nazwa) {
		ustaw(img, nazwa);
	}

	private void ustaw(Image img, String nazwa) {
		this.img = img;
		this.nazwa = nazwa;
		
	}

	public Image getImg() {
		return img;
	}

	public String getNazwa() {
		return nazwa;
	}
	

}
