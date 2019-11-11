import java.util.Random;

import com.badlogic.gdx.audio.Music;

// -- Bridges graphics with game logic

public class GameState {

	static EntityListFactory entityList;
	static Entity entity;
	static Inventory inventory;
	static Status status;
	static Time time;
	static Random random;
	static Boolean haveFire;
	static int toolLevel;
	static int clothingLevel;
	static boolean rain;
	static int rainTime;
	static int type;
	static Music song;
	
	public static void setupGame()
	{
		entityList = new EntityListFactory();
		entity = new Entity();
		inventory = new Inventory();
		random = new Random();
		time = new Time(1);
		status = new Status( 10, 2000, 1400, 600 );
		haveFire = false;
		toolLevel = 0;
		clothingLevel = 10;
		rain = false;
		rainTime = 0;
		type = 0;
	}
	
	static boolean getFire() {
		if (haveFire == true) {
			return true;
		}
		return false;
	}
	
	static int getToolLevel() {
		return toolLevel;
	}
	
	static void changeToolLevel( int level )
	{
		toolLevel = level;
	}
	
	static int getClothingLevel() {
		clothingLevel = 10;
		if (entity.haveItems(3, 5, 1)) {
			clothingLevel -= 1;
		}
		if (entity.haveItems(1, 5, 1)) {
			clothingLevel -= 2;
		}
		if (entity.haveItems(2, 5, 1)) {
			clothingLevel -= 2;
		}
		if (entity.haveItems(4, 5, 1)) {
			clothingLevel -= 4;
		}
		return clothingLevel / 10;
	}
	
	static void timePass(int amount) {
		if (haveFire == false) {
			status.change(4, (-amount * 12) * getClothingLevel());
			if (time.isDayTime() == false) {
				status.change(4, (-amount * 23) * getClothingLevel());
			}
		}
		else {
			status.change(4, amount * 33);
		}
		status.change(2, -amount * 52);
		status.change(3, -amount * 56);
		time.add(amount);
		rainTime -= amount;
		if (rainTime >= 0) {
			rain = false;
		}
		for (int i = 0; i < amount; i ++) {
			int rainChance = random.nextInt(36) + 1;
			if (rainChance == 1) {
				rain = true;
				rainTime = random.nextInt(8) + 3;
			}
		}
	}
}
