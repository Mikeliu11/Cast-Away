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
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

public class MainMenuScreen extends BaseScreen{

	private BaseActor background;
	private BaseActor inventory;
	private BaseActor craft;
	private BaseActor rest;
	private BaseActor explore;
	private BaseActor useItem;
	private BaseActor help;
	private BaseActor collectWood;
	private BaseActor status;
	
	private Action fadeOut;
	
	private Sound click;
	private float volume = 1;
	
	private LabelActor label1;
	private LabelActor label2;
	private BitmapFont font;
	private LabelStyle style;
	private float x1, x2, y1, y2;
	private String message1 = "";
	private String message2 = "";
	
	public MainMenuScreen(Game game) {
		super(game);
	}

	
	@Override
	public void create() {
		
		fadeOut = Actions.sequence(Actions.alpha(0), Actions.show(), Actions.fadeOut(4));
		click = Gdx.audio.newSound(Gdx.files.internal("assets/button push sound.mp3"));
		
		font = game.skin.getFont( "uiFont" );
		x1 = 0;
		x2 = -50;
		y1 = 450;
		y2 = 447;
		
		message1 = "DAY: " + GameState.time.dayCounter();
		label1 = new LabelActor(font,Color.ORANGE, x1, y1);
		label1.setText(message1);
		uiStage.addActor(label1);
		
		message2 = "\nTIME: " + GameState.time.getTime() + " " + GameState.time.getAMPM();
		label2 = new LabelActor(font,Color.CHARTREUSE, x2, y2);
		label2.setText(message2);
		uiStage.addActor(label2);
		
		// -- Background
		background = new BaseActor();
		background.setTexture( new Texture( Gdx.files.internal("assets/background_main.png")));
		background.setPosition(0, 0);
		background.setVisible(true);
		mainStage.addActor(background);
		
		// -- Help button
		help = new BaseActor();
		help.setTexture(new Texture( Gdx.files.internal("assets/button_help.png")));
		help.setPosition(0, 0);
		help.setVisible(true);
		help.addListener(
            new InputListener()
            {
                public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) 
                {  
                	click.play(volume);
                	game.setScreen(new HelpScreen(game));
                    return true;
                }
            }
        );
		uiStage.addActor(help);
		
		// -- Status button
		status = new BaseActor();
		status.setTexture(new Texture( Gdx.files.internal("assets/button_status.png")));
		status.setPosition(600, 0);
		status.setVisible(true);
		status.addListener(
            new InputListener()
            {
                public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) 
                {  
                	click.play(volume);

                	// -- CHANGE SCREEN
                	game.setScreen(new StatusScreen(game));
                    return true;
                }
            }
        );
		uiStage.addActor(status);
		
		// -- Inventory Button
		inventory = new BaseActor();
		inventory.setTexture(new Texture(Gdx.files.internal("assets/button_inventory.png")));
		inventory.setPosition(650, 200);
		inventory.setVisible(true);
		inventory.addListener(
            new InputListener()
            {
                public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) 
                {  
                	click.play(volume);
                	game.setScreen( new InventoryScreen(game));
                    return true;
                }
            }
        );
		uiStage.addActor(inventory);
		
		// -- Craft Button
		craft = new BaseActor();
		craft.setTexture(new Texture(Gdx.files.internal("assets/button_craft.png")));
		craft.setPosition(490, 150);
		craft.setVisible(true);
		craft.addListener(
            new InputListener()
            {
                public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) 
                {  
                	click.play(volume);
                	game.setScreen( new CraftScreen(game));
                    return true;
                }
            }
        );
		uiStage.addActor(craft);
		
		// -- Rest Button
		rest = new BaseActor();
		rest.setTexture(new Texture(Gdx.files.internal("assets/button_rest.png")));
		rest.setPosition(200, 0);
		rest.setVisible(true);
		rest.addListener(
            new InputListener()
            {
                public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) 
                {  
                	click.play(volume);
                	game.setScreen( new RestScreen(game));
                    return true;
                }
            }
        );
		uiStage.addActor(rest);
		
		// -- Explore Button
		explore = new BaseActor();
		explore.setTexture(new Texture(Gdx.files.internal("assets/button_explore.png")));
		explore.setPosition(150, 150);
		explore.setVisible(true);
		explore.addListener(
            new InputListener()
            {
                public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) 
                {  
                	click.play(volume);
                	game.setScreen( new ExploreScreen(game));
                    return true;
                }
            }
        );
		uiStage.addActor(explore);
		
		// -- Use Item Button
		useItem = new BaseActor();
		useItem.setTexture(new Texture(Gdx.files.internal("assets/button_use_item.png")));
		useItem.setPosition(450, 0);
		useItem.setVisible(true);
		useItem.addListener(
            new InputListener()
            {
                public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) 
                {  
                	click.play(volume);
                	game.setScreen( new UseItemScreen(game));
                    return true;
                }
            }
        );
		uiStage.addActor(useItem);
		
		// -- Collect Wood button
		collectWood = new BaseActor();
		collectWood.setTexture(new Texture( Gdx.files.internal("assets/button_collectWood.png")));
		collectWood.setPosition(0, 200);
		collectWood.setVisible(true);
		collectWood.addListener(
            new InputListener()
            {
                public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) 
                {  
                	click.play(volume);
                	// -- CHANGE SCREEN
                	game.setScreen(new CollectWoodScreen(game));
                    return true;
                }
            }
        );
		uiStage.addActor(collectWood);

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

		if ( GameState.status.isDead() )
		{
			GameState.song.stop();
			game.setScreen( new GameOverScreen(game));
		}
		
	}

}
