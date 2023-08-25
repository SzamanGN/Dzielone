package utilz;

import main.Game;

public class HelpMethods {

	public static boolean CanMoveHere(float x, float y, int width, int height, int[][]lvlDtata) {
		if(!IsSolid(x, y, lvlDtata))
			if(!IsSolid(x + width, y + height, lvlDtata))
				if(!IsSolid(x + width, y, lvlDtata))
					if(!IsSolid(x, y + height, lvlDtata))
						return true;
		return false;
	}
	
public static boolean IsSolid(float x,float y, int[][]lvlData) {
		if(x <0 || x >= Game.GAME_WIDTH)
			return true;
		if(y < 0 || y >= Game.GAME_HEIGHT)
			return true;
		float xIndex = x / Game.TILES_SIZE;
		float yIndex = y / Game.TILES_SIZE;
		int value = lvlData[(int)yIndex][(int) xIndex];
		if (value >= 48 || value < 0 || value != 11)
			return true;
		return false;
	}
}
