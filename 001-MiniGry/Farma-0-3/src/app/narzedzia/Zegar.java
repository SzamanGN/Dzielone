package app.narzedzia;

public class Zegar extends Thread{

	private int fps;
	private boolean dziala;
	
	public Zegar() {
		set(1);
	}
	
	public Zegar(int fps) {
		set(fps);
	}
	
	private void set(int fps) {
		this.fps = fps;
	}
	
	public void tikZegara() {
		System.out.println("Tik zegara");
	}
	
	public void run() {
		double czasCyklu = 1000000000 / fps;
        double delta = 0;
        long poprzedniCzas = System.nanoTime();
        long aktualnyCzas;
        dziala = true;
        while(dziala) {
            aktualnyCzas = System.nanoTime();
            delta += (aktualnyCzas - poprzedniCzas) / czasCyklu;
            poprzedniCzas = aktualnyCzas;
            if (delta >= 1) {
                tikZegara();
                delta -= 1;
            }
        }
        System.out.println("Zegar zatrzymany");
	}
	
	public void wylaczZegar() {
		dziala = false;
	}
}
