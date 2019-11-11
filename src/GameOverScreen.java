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
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

public class GameOverScreen extends BaseScreen{

	private BaseActor background;
	private BaseActor exit;
	private BaseActor midLabel;
	
	private float x, y;
	
	private Action fadeIn;
	
	private Sound click;
	private float volume = 1;

	
	public GameOverScreen(Game game) {
		super(game);
	}

	@Override
	public void create() {
		
		fadeIn = Actions.sequence( Actions.alpha(0), Actions.show(), Actions.fadeIn(8));
		click = Gdx.audio.newSound(Gdx.files.internal("assets/button push sound.mp3"));
		
		// -- Background
		background = new BaseActor();
		background.setTexture( new Texture( Gdx.files.internal("assets/background_gameOver1.png")));
		background.setPosition(0, 0);
		mainStage.addActor(background);
		
		midLabel = new BaseActor();
		midLabel.setTexture(new Texture(Gdx.files.internal("assets/text_gameOver.png")));
		midLabel.setPosition(150, 150);
		midLabel.setVisible(true);
		midLabel.addAction(fadeIn);
		uiStage.addActor(midLabel);
		
		// -- Exit button
		exit = new BaseActor();
		exit.setTexture(new Texture( Gdx.files.internal("assets/button_exit.png")));
		exit.setPosition(300, 10);
		exit.setVisible(true);
		exit.addListener(
	            new InputListener()
	            {
	                public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) 
	                {  
	                	click.play(volume);
	                	Gdx.app.exit();
	                    return true;
	                }
	            }
	        );
		uiStage.addActor(exit);
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
