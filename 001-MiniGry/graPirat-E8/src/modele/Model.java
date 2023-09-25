package modele;

public abstract class Model {

	protected float x;
	protected float y;
	protected int szerokosc;
	protected int wysokosc;
	
	public Model(float x, float y, int szerokosc, int wysokosc) {
		this.x = x;
		this.y = y;
		this.szerokosc = szerokosc;
		this.wysokosc = wysokosc;		
	}
}
