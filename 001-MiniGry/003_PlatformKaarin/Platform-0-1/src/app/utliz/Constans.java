package app.utliz;

public class Constans {
	public static class Directions{
		public static final int LEFT = 0;
		public static final int RIGHT = 1;
		public static final int UP = 2;
		public static final int DOWN = 3;
	}
	
	public static class playerConstans{
		public static final int IDLE = 0;
		public static final int RUNNIG = 1;
		public static final int JUMP = 2;
		public static final int FALLING = 3;
		public static final int GROUND = 4;
		public static final int HIT = 5;
		public static final int ATTACK_01 = 6;
		public static final int ATTACK_jump01 = 7;
		public static final int ATTACK_jump02 = 8;
	
	
	public static int getSpriteAmount(int player_action) {
		
		switch(player_action) {
		case RUNNIG:
			return 6;
		case IDLE:
			return 5;
		case HIT:
			return 4;
		case JUMP:
		case ATTACK_01:
		case ATTACK_jump01:
		case ATTACK_jump02:
			return 3;
		case GROUND:
			return 2;
		case FALLING:
		default:
			return 1;
		}
	}
	}
}
  

