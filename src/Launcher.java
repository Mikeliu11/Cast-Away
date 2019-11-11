/*
 * The class is responsible for launching the game and configuring window...
 * 
 * This game (Beta Release), is integrated with libGDX framework and game control 
 * logic. For this implementation, simple graphics were used for testing.
 * It will be replaced with proper graphics in the final release. Also in the 
 * final release, the useItem screen will be made with all entities created. 
 * Currently, it works for the entity, apples.
 */

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Launcher {

	public static void main(String[] args) {
		
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.title = "Cast Away!";
		config.width = BaseScreen.viewWidth;
		config.height = BaseScreen.viewHeight;
		
		// -- Sets up game state
		GameState.setupGame();
		
		// -- Start game with graphics
		CastAwayGame myGame = new CastAwayGame();
		LwjglApplication launcher = new LwjglApplication( myGame, config );
	}
}
