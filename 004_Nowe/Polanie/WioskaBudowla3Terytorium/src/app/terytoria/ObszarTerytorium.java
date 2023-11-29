package app.terytoria;

public class ObszarTerytorium {
	private int rozmiar;
    private boolean[][] zajete;

    public ObszarTerytorium(int rozmiar) {
        this.rozmiar = rozmiar;
        this.zajete = new boolean[rozmiar][rozmiar];
    }

    public boolean zajmijObszar(int x, int y) {
        if (x >= 0 && x < rozmiar && y >= 0 && y < rozmiar && !zajete[x][y]) {
            zajete[x][y] = true;
            return true;
        } else {
            return false;
        }
    }
}
