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

public class UseItemScreen extends BaseScreen{

	private BaseActor background;
	private BaseActor back;
	private BaseActor title;
	
	// -- Inventory Items
	private BaseActor apple;
	private BaseActor berries;
	private BaseActor meat;
	private BaseActor fish;
	private BaseActor water;
	private BaseActor soup;
	private BaseActor hat;
	private BaseActor sweater;
	private BaseActor stoneAxe;
	
	private Action fadeIn;
	private Sound click;
	private float volume = 1;
	
	public UseItemScreen(Game game) {
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
		title.setTexture( new Texture( Gdx.files.internal("assets/title_use.png")));
		title.setPosition(180, 380);
		title.setVisible(true);
		mainStage.addActor(title);
		
		// -- Apple button
		apple = new BaseActor();
		apple.setTexture(new Texture( Gdx.files.internal("assets/button_apples.png")));
		apple.setPosition(40, 280);
		apple.setVisible(true);
		apple.addListener(
            new InputListener()
            {
                public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) 
                {  
                	click.play(volume);
                	if( GameState.entity.haveItems(1, 1, 1))
                	{
                    	GameState.entity.use(1, 1, 1);
                    	GameState.status.change(2, 140);
                		game.setScreen(new UseItemSuccessfully(game));
                	}
                	else
                	{
                		game.setScreen(new UseItemUnsuccessfully(game));
                	}
                    return true;
                }
            }
        );
		uiStage.addActor(apple);
		
		// -- Berries button
		berries = new BaseActor();
		berries.setTexture(new Texture( Gdx.files.internal("assets/button_berries.png")));
		berries.setPosition(40, 180);
		berries.setVisible(true);
		berries.addListener(
            new InputListener()
            {
                public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) 
                {  
                	click.play(volume);
                	if( GameState.entity.haveItems(2, 1, 1))
                	{
                    	GameState.entity.use(2, 1, 1);
                    	GameState.status.change(2, 120);
                		game.setScreen(new UseItemSuccessfully(game));
                	}
                	else
                	{
                		game.setScreen(new UseItemUnsuccessfully(game));
                	}
                    return true;
                }
            }
        );
		uiStage.addActor(berries);
		
		// -- Meat button
		meat = new BaseActor();
		meat.setTexture(new Texture( Gdx.files.internal("assets/button_meat.png")));
		meat.setPosition(40, 80);
		meat.setVisible(true);
		meat.addListener(
            new InputListener()
            {
                public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) 
                {  
                	click.play(volume);
                	if( GameState.entity.haveItems(3, 1, 1))
                	{
                    	GameState.entity.use(3, 1, 1);
                    	GameState.status.change(2, 280);
                		game.setScreen(new UseItemSuccessfully(game));
                	}
                	else
                	{
                		game.setScreen(new UseItemUnsuccessfully(game));
                	}
                    return true;
                }
            }
        );
		uiStage.addActor(meat);
		
		// -- Fish button
		fish = new BaseActor();
		fish.setTexture(new Texture( Gdx.files.internal("assets/button_fish.png")));
		fish.setPosition(300, 280);
		fish.setVisible(true);
		fish.addListener(
            new InputListener()
            {
                public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) 
                {  
                	click.play(volume);
                	if( GameState.entity.haveItems(4, 1, 1))
                	{
                    	GameState.entity.use(4, 1, 1);
                    	GameState.status.change(2, 240);
                		game.setScreen(new UseItemSuccessfully(game));
                	}
                	else
                	{
                		game.setScreen(new UseItemUnsuccessfully(game));
                	}
                    return true;
                }
            }
        );
		uiStage.addActor(fish);
		
		// -- Water button
		water = new BaseActor();
		water.setTexture(new Texture( Gdx.files.internal("assets/button_water.png")));
		water.setPosition(300, 180);
		water.setVisible(true);
		water.addListener(
            new InputListener()
            {
                public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) 
                {  
                	click.play(volume);
                	if( GameState.entity.haveItems(1, 2, 1))
                	{
                    	GameState.entity.use(1, 2, 1);
                    	GameState.status.change(3, 200);
                		game.setScreen(new UseItemSuccessfully(game));
                	}
                	else
                	{
                		game.setScreen(new UseItemUnsuccessfully(game));
                	}
                    return true;
                }
            }
        );
		uiStage.addActor(water);
		
		// -- Soup button
		soup = new BaseActor();
		soup.setTexture(new Texture( Gdx.files.internal("assets/button_soup.png")));
		soup.setPosition(300, 80);
		soup.setVisible(true);
		soup.addListener(
            new InputListener()
            {
                public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) 
                {  
                	click.play(volume);
                	if( GameState.entity.haveItems(2, 2, 1))
                	{
                    	GameState.entity.use(2, 2, 1);
                    	GameState.status.change(3, 100);
                		game.setScreen(new UseItemSuccessfully(game));
                	}
                	else
                	{
                		game.setScreen(new UseItemUnsuccessfully(game));
                	}
                    return true;
                }
            }
        );
		uiStage.addActor(soup);
		
		// -- Hat button
		hat = new BaseActor();
		hat.setTexture(new Texture( Gdx.files.internal("assets/button_hat_inventory.png")));
		hat.setPosition(560, 280);
		hat.setVisible(true);
		hat.addListener(
            new InputListener()
            {
                public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) 
                {  
                	click.play(volume);
                	if( GameState.entity.haveItems(1, 5, 1))
                	{
                    	GameState.entity.use(1, 5, 1);
                    	GameState.status.change(4, 5);
                		game.setScreen(new UseItemSuccessfully(game));
                	}
                	else
                	{
                		game.setScreen(new UseItemUnsuccessfully(game));
                	}
                    return true;
                }
            }
        );
		uiStage.addActor(hat);
		
		// -- Sweater button
		sweater = new BaseActor();
		sweater.setTexture(new Texture( Gdx.files.internal("assets/button_sweater_inventory.png")));
		sweater.setPosition(560, 180);
		sweater.setVisible(true);
		sweater.addListener(
            new InputListener()
            {
                public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) 
                {  
                	click.play(volume);
                	if( GameState.entity.haveItems(2, 5, 1))
                	{
                    	GameState.entity.use(2, 5, 1);
                    	GameState.status.change(4, 10);
                		game.setScreen(new UseItemSuccessfully(game));
                	}
                	else
                	{
                		game.setScreen(new UseItemUnsuccessfully(game));
                	}
                    return true;
                }
            }
        );
		uiStage.addActor(sweater);
		
		// -- Stone Axe button
		stoneAxe = new BaseActor();
		stoneAxe.setTexture(new Texture( Gdx.files.internal("assets/button_axe_inventory.png")));
		stoneAxe.setPosition(560, 80);
		stoneAxe.setVisible(true);
		stoneAxe.addListener(
            new InputListener()
            {
                public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) 
                {  
                	click.play(volume);
                	if( GameState.entity.haveItems(1, 4, 1))
                	{
                    	GameState.entity.use(1, 4, 1);
                    	GameState.changeToolLevel(1);
                		game.setScreen(new UseItemSuccessfully(game));
                	}
                	else
                	{
                		game.setScreen(new UseItemUnsuccessfully(game));
                	}
                    return true;
                }
            }
        );
		uiStage.addActor(stoneAxe);

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
