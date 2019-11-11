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
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

public class RestScreen extends BaseScreen{

	private BaseActor background;
	private BaseActor back;
	private BaseActor woodBoard;
	private BaseActor title;
	
	private LabelActor label;
	private BitmapFont font;
	private LabelStyle style;
	private float x, y;
	private String message = "";
	
	private Action fadeIn;
	private Sound click;
	private float volume = 1;

	public RestScreen(Game game) {
		super(game);
	}

	public void createGameLogic()
	{		
		// -- Increase health value
		GameState.status.change( 1, 10 );
		// -- Decrease hunger value
		GameState.status.change( 2, ( -10 ) );
		// -- Decrease thirst value
		GameState.status.change( 3, ( -10 ) );
		if (GameState.haveFire == false)
		{
			GameState.status.change(4, (-2 * 12) * GameState.getClothingLevel());
			
			if (GameState.time.isDayTime() == false)
			{
				GameState.status.change(4, (-2 * 23) * GameState.getClothingLevel());
			}
		}
		else
		{
			GameState.status.change(4, 2 * 33);
		}
		// -- Add 2 hours to time
		GameState.time.add( 2 );
		message = "You rested. Your health\nincreased,but now you\n are hungry and thirsty.";
	}
	
	@Override
	public void create() {
		
		createGameLogic();
		
		font = game.skin.getFont( "uiFont" );
		x = -80;
		y =  280;
		label = new LabelActor(font,Color.WHITE, x, y);
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
		title.setTexture( new Texture( Gdx.files.internal("assets/title_rest.png")));
		title.setPosition(180, 380);
		title.setVisible(true);
		mainStage.addActor(title);
		
		// -- Wooden Board
		woodBoard = new BaseActor();
		woodBoard.setTexture( new Texture( Gdx.files.internal("assets/wood.png")));
		woodBoard.setPosition(20, 100);
		woodBoard.setVisible(true);
		mainStage.addActor(woodBoard);
		
		// -- Back button
		back = new BaseActor();
		back.setTexture(new Texture( Gdx.files.internal("assets/button_back.png")));
		back.setPosition(580, 0);
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
		// TODO Auto-generated method stub
		
	}

}
