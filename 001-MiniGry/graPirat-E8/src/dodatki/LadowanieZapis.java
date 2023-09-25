package dodatki;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import gra.Gra;

public class LadowanieZapis {

	public static final String GRACZ_ATLAS = "/obrazki/player_sprites.png";
	public static final String POZIOM_ATLAS = "/obrazki/outside_sprites.png";
	public static final String POZIOM_JEDEN_DATA = "/obrazki/level_one_data.png";

	public static BufferedImage GetDuszekAtlas(String nazwaPliku) {
		BufferedImage obraz = null;
		InputStream ten = LadowanieZapis.class.getResourceAsStream("/obrazki/" + nazwaPliku);
		try {
			obraz = ImageIO.read(ten);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				ten.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return obraz;
	}

	public static int[][] GetPoziomData() {
		int[][] pozData = new int[Gra.plytka_in_wysokosc][Gra.plytka_in_szerokosc];
		BufferedImage ob = GetDuszekAtlas(POZIOM_JEDEN_DATA);

		for (int j = 0; j < ob.getHeight(); j++) {
			for (int i = 0; i < ob.getWidth(); i++) {
				Color kolor = new Color(ob.getRGB(i, j));
				int wartosc = kolor.getRed();
				if (wartosc >= 48) {
					wartosc = 0;
					pozData[j][i] = wartosc;
				}
			}
		}
		return pozData;
	}
}
