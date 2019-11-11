import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

public class StatusScreen extends BaseScreen{

	private BaseActor background;
	private BaseActor back;
	private BaseActor title;
	
	private LabelActor label;
	private BitmapFont font;
	private LabelStyle style;
	private float x, y;
	
	private Action fadeIn;
	private Sound click;
	private float volume = 1;
	
	private String message = "";

	public StatusScreen(Game game) {
		super(game);
	}

	public void createGameLogic()
	{		
    	message = GameState.status.printStatus();
	}
	
	@Override
	public void create() {
		
		createGameLogic();
		
		font = game.skin.getFont( "uiFont" );
		x = 150;
		y =  230;
		label = new LabelActor(font,Color.ORANGE, x, y);
		label.setText(message);
		uiStage.addActor(label);
		
		fadeIn = Actions.sequence(Actions.alpha(0), Actions.show(), Actions.fadeIn(5));
		click = Gdx.audio.newSound(Gdx.files.internal("assets/button push sound.mp3"));
		
		// -- Background
		background = new BaseActor();
		background.setTexture( new Texture( Gdx.files.internal("assets/background_main.png")));
		mainStage.addActor(background);
		
		// -- Title
		title = new BaseActor();
		// -- change
		title.setTexture( new Texture( Gdx.files.internal("assets/title_status.png")));
		title.setPosition(180, 380);
		title.setVisible(true);
		mainStage.addActor(title);
		
		// -- Back button
		back = new BaseActor();
		back.setTexture(new Texture( Gdx.files.internal("assets/button_back.png")));
		back.setPosition(620, 0);
		back.setVisible(true);
		back.addListener(
	            new InputListener()
	            {
	                public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) 
	                {  
	                	click.play(volume);
	                	game.setScreen(new MainMenuScreen(game));
	                    return true;
	                }
	            }
	        );
		uiStage.addActor(back);
	}
	
	// InputProcessor methods for handling discrete input
    public boolean keyDown(int keycode)
    {
		// -- process input
		if(keycode == Keys.ESCAPE )
		{	
			Gdx.app.exit();
		}
        return false;
    }
    
	@Override
	public void update(float dt) {
		
	}

}
