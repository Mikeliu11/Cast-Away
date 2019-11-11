import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class IntroScreen extends BaseScreen{

	private BaseActor background;
	private BaseActor gameStart;
	private BaseActor start;
	
	private Action fadeIn;
	
	private Sound click;

	
	private float volume = 1;
	
	public IntroScreen(Game game) {
		super(game);
	}
	
	@Override
	public void create() {
				
		fadeIn = Actions.sequence( Actions.alpha(0), Actions.show(), Actions.fadeIn(8));
				
		// -- Background
		background = new BaseActor();
		background.setTexture( new Texture( Gdx.files.internal("assets/background_intro.png")));
		background.setPosition(0, 0);
		background.setVisible(true);
		background.addAction(fadeIn);
		mainStage.addActor(background);
		
		gameStart = new BaseActor();
		gameStart.setTexture(new Texture(Gdx.files.internal("assets/background_start.png")));
		gameStart.setPosition(0, 0);
		gameStart.setVisible(false);
		uiStage.addActor(gameStart);
		
		// -- Start button
		start = new BaseActor();
		start.setTexture(new Texture( Gdx.files.internal("assets/button_start.png")));
		start.setPosition(500, 40);
		start.setVisible(false);
		start.addListener(
            new InputListener()
            {
                public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) 
                {  
                	click.play(volume);

                	// -- CHANGE SCREEN
                	game.setScreen(new MainMenuScreen(game));
                    return true;
                }
            }
        );
		uiStage.addActor(start);
		
		click = Gdx.audio.newSound(Gdx.files.internal("assets/button push sound.mp3"));
		GameState.song = Gdx.audio.newMusic(Gdx.files.internal("assets/139 Crickets Chirping In The Meadow.mp3"));
		GameState.song.setLooping(true);
		GameState.song.play();
		
	}

	public void update(float dt) {
		
	}
	
    // InputProcessor methods for handling discrete input
    public boolean keyDown(int keycode)
    {
		if(keycode == Keys.ESCAPE)
		{	
			Gdx.app.exit();
		}
		if(keycode == Keys.SPACE)
		{	
			background.setVisible(false);
			gameStart.setVisible(true);
			start.setVisible(true);
		}
		           
        return false;
    }

}
