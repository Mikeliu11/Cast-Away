import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class CraftScreen extends BaseScreen{

	private BaseActor background;
	private BaseActor back;
	private BaseActor sweater;
	private BaseActor fire;
	private BaseActor stoneAxe;
	private BaseActor hat;
	private BaseActor title;
	
	private Action fadeIn;
	private Sound click;
	private float volume = 1;
	
	public CraftScreen(Game game) {
		super(game);
	}
	
	@Override
	public void create() {
		
		fadeIn = Actions.sequence(Actions.alpha(0), Actions.show(), Actions.fadeIn(5));
		click = Gdx.audio.newSound(Gdx.files.internal("assets/button push sound.mp3"));
		
		// -- Background
		background = new BaseActor();
		background.setTexture( new Texture( Gdx.files.internal("assets/background_main.png")));
		mainStage.addActor(background);
		
		// -- Title
		title = new BaseActor();
		title.setTexture( new Texture( Gdx.files.internal("assets/title_craft.png")));
		title.setPosition(180, 380);
		title.setVisible(true);
		mainStage.addActor(title);
		
		// -- Craft Fire
		fire = new BaseActor();
		fire.setTexture(new Texture( Gdx.files.internal("assets/button_fire.png")));
		fire.setPosition(20, 150);
		fire.setVisible(true);
		fire.addListener(
            new InputListener()
            {
                public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) 
                {  
                	click.play(volume);
                	
                	if( GameState.entity.craft(1) )
                	{
                		GameState.haveFire = true;
                		GameState.entity.use(1, 3, 1);
                		game.setScreen(new CraftedSuccessfullyScreen(game));
                	}
                	else
                	{
                		game.setScreen(new CraftedUnsuccessfullyScreen(game));
                	}
            		GameState.timePass(1);
                    return true;
                }
            }
        );
		uiStage.addActor(fire);
		
		// -- Craft Stone Axe
		stoneAxe = new BaseActor();
		stoneAxe.setTexture(new Texture( Gdx.files.internal("assets/button_axe.png")));
		stoneAxe.setPosition(220, 150);
		stoneAxe.setVisible(true);
		stoneAxe.addListener(
			new InputListener()
            {
                public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) 
                {  
                	click.play(volume);
 
                	if( GameState.entity.craft(2) )
                	{
                		GameState.inventory.addItemToInventory(0, 4, 1);
                		GameState.entity.use(2,3,1);
                		GameState.entity.use(1,3,1);
                		GameState.entity.use(5,3,1);
                		game.setScreen(new CraftedSuccessfullyScreen(game));
                	}
                	else
                	{
                		game.setScreen(new CraftedUnsuccessfullyScreen(game));
                	}
            		GameState.timePass(1);
                    return true;
                }
            }
        );
		uiStage.addActor(stoneAxe);
		
		// -- Craft hat
		hat = new BaseActor();
		hat.setTexture(new Texture( Gdx.files.internal("assets/button_hat.png")));
		hat.setPosition(420, 150);
		hat.setVisible(true);
		hat.addListener(
			new InputListener()
            {
                public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) 
                {  
                	click.play(volume);
                	if( GameState.entity.craft(3))
                	{
                		GameState.inventory.addItemToInventory(0, 5, 1);
                		GameState.entity.use(4, 3, 2);
                		GameState.entity.use(3,3,1);
                		GameState.entity.use(5, 3, 2);
                		game.setScreen(new CraftedSuccessfullyScreen(game));
                	}
                	else
                	{
                		game.setScreen(new CraftedUnsuccessfullyScreen(game));
                	}
            		GameState.timePass(1);
                    return true;
                }
            }
        );
		uiStage.addActor(hat);
		
		// -- Craft sweater
		sweater = new BaseActor();
		sweater.setTexture(new Texture( Gdx.files.internal("assets/button_sweater.png")));
		sweater.setPosition(620, 150);
		sweater.setVisible(true);
		sweater.addListener(
			new InputListener()
            {
                public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) 
                {  
                	click.play(volume);
                	if( GameState.entity.craft(4))
                	{
                		GameState.inventory.addItemToInventory(1, 5, 1);
                		GameState.entity.use(4, 3, 3);
                		GameState.entity.use(3,3,2);
                		GameState.entity.use(5, 3, 2);
                		game.setScreen(new CraftedSuccessfullyScreen(game));
                	}
                	else
                	{
                		game.setScreen(new CraftedUnsuccessfullyScreen(game));
                	}
            		GameState.timePass(1);
                    return true;
                }
            }
        );
		uiStage.addActor(sweater);
		
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
