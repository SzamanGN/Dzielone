package gra.dane;

public class DaneGracza {

	private long stanKonta;
	private int zasiedloneWyspy;
	
	public DaneGracza() {
		ustaw(1000, 1);
	}

	public DaneGracza(long stanKonta, int zasiedloneWyspy) {
		ustaw(stanKonta, zasiedloneWyspy);
	}
	
	private void ustaw(long stanKonta, int zasiedloneWyspy) {
		this.stanKonta = stanKonta;
		this.zasiedloneWyspy = zasiedloneWyspy;
	}

	public long getStanKonta() {
		return stanKonta;
	}

	public int getZasiedloneWyspy() {
		return zasiedloneWyspy;
	}
	
}
