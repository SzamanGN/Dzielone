package app.entity;

import java.util.Random;

import app.panele.GamePanel;

public class NPC_OldMan extends Entity {

	public NPC_OldMan(GamePanel gp) {
		super(gp);
		
		direction = "down";
		speed = 1;
		
		getImage();
		setDialog();
	}

	public void getImage() {
		
		up1 = setup("/npc/oldman_up_1");
		up2 = setup("/npc/oldman_up_2");
		down1 = setup("/npc/oldman_down_1");
		down2 = setup("/npc/oldman_down_2");
		left1 = setup("/npc/oldman_left_1");
		left2 = setup("/npc/oldman_left_2");
		right1 = setup("/npc/oldman_right_1");
		right2 = setup("/npc/oldman_right_2");
	}
	
	public void setDialog() {
		dialogues[0] = "Hello, lad.";
		dialogues[1] = "So you come to this island to \n find the treasuer?";
		dialogues[2] = "I used to be  agreat wizard but now...\n Im a bit to old for taking am adveture.";
		dialogues[3] = "Well, good luck on you.";
		
	}
	
	public void setAction() {
		
		actionLockCounter++;
		
		if(actionLockCounter == 120) {
			Random random =  new Random();
			int i =  random.nextInt(100) + 1; // pick up o number from 1 to 100
			
			if (i <= 25) {
				direction = "up";
			}
			
			if (i > 25 && i <= 50) {
				direction = "down";
			}
			
			if (i > 50 && i <= 75) {
				direction = "left";
			}
			
			if (i > 75 && i <= 100) {
				direction = "right";
			}
			
			actionLockCounter = 0;
		}
	}
	
	public void speak() {
		super.speak();
	}
}