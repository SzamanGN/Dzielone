package app.narzedzia;

public class ZegarKalendarza extends Zegar{
	
	private Kalendarz kalendarz;
	
	public ZegarKalendarza(Kalendarz kalendarz) {
		super();
		this.kalendarz = kalendarz;
	}

	@Override
	public void tikZegara() {
		//super.tikZegara();
		kalendarz.tikZegara();
		if (!Dane.aktywnaGra) {
			wylaczZegar();
		}
	}

	@Override
	public void wylaczZegar() {
		super.wylaczZegar();
	}

	
}
