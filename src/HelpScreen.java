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
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

public class HelpScreen extends BaseScreen{

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
	
	public HelpScreen(Game game) {
		super(game);
	}

	@Override
	public void create() {
		
		fadeIn = Actions.sequence(Actions.alpha(0), Actions.show(), Actions.fadeIn(5));
		click = Gdx.audio.newSound(Gdx.files.internal("assets/button push sound.mp3"));
		
		message = "Click on the options\nto perform an action.\nPress ESC to quit.";
		font = game.skin.getFont( "uiFont" );
		x = -20;
		y = 280;
		label = new LabelActor(font,Color.WHITE, x, y);
		label.setText(message);
		uiStage.addActor(label);
		
		// -- Background
		background = new BaseActor();
		background.setTexture( new Texture( Gdx.files.internal("assets/background_main.png")));
		mainStage.addActor(background);
		
		// -- Title
		title = new BaseActor();
		// -- change
		title.setTexture( new Texture( Gdx.files.internal("assets/title_help.png")));
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
		
/*    	Skin uiSkin = new Skin();
    	Dialog dialog = 
    	new Dialog( GameState.status.printStatus(), uiSkin, "dialog" )
    	{
    		protected void result( Object object){

    		}
    	};
    	TextButton okButton = new TextButton("Ok", uiSkin, "dialog");
    	dialog.button(okButton, true);
    	dialog.show(uiStage);*/
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
