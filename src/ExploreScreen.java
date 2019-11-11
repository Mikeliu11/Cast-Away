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

public class ExploreScreen extends BaseScreen{

	private BaseActor background;
	private BaseActor back;
	private BaseActor woodBoard;
	private BaseActor bag;
	private BaseActor snake;
	private BaseActor title;
	
	private LabelActor label;
	private BitmapFont font;
	private LabelStyle style;
	private float x, y;
	private String message = "";
	
	private Action fadeIn;
	private Sound click;
	private float volume = 1;

	public ExploreScreen(Game game) {
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
		title.setTexture( new Texture( Gdx.files.internal("assets/title_explore.png")));
		title.setPosition(180, 380);
		title.setVisible(true);
		mainStage.addActor(title);
		
		// -- Wooden Board
		woodBoard = new BaseActor();
		woodBoard.setTexture( new Texture( Gdx.files.internal("assets/wood.png")));
		woodBoard.setPosition(20, 80);
		woodBoard.setVisible(true);
		mainStage.addActor(woodBoard);

		// -- Bag
		bag = new BaseActor();
		bag.setTexture( new Texture( Gdx.files.internal("assets/explore_bag.png")));
		bag.setPosition(500, 180);
		bag.setVisible(false);
		mainStage.addActor(bag);
		
		// -- Snake
		snake = new BaseActor();
		snake.setTexture( new Texture( Gdx.files.internal("assets/explore_snake.png")));
		snake.setPosition(550, 190);
		snake.setVisible(false);
		mainStage.addActor(snake);
		
		// -- Determines if user collects items, or confronts a predator
		int fate = (int) (Math.random() * 2) + 1;
		if( fate == 1 )
		{
			// -- Randomize number of items collected
			int items = GameState.random.nextInt( 3 ) + 1;
			int itemID = 1;
			for( int i = 0; i < items; i++ )
				// -- Randomize type of entity discovered
				GameState.type = GameState.random.nextInt( 3 ) + 1;
				
				if( GameState.type == 1 )
				{
					itemID = GameState.random.nextInt( GameState.entityList.foods.size() );
					itemID = itemID + 1;
				}
				else if( GameState.type == 2 )
				{
					itemID = GameState.random.nextInt( GameState.entityList.drinks.size() );
					itemID = itemID + 1;
				}
				else if ( GameState.type == 3 )
				{
					itemID = GameState.random.nextInt( GameState.entityList.materials.size() );
					itemID = itemID + 1;
				}

				bag.setVisible(true);
				GameState.entity.add( itemID, GameState.type, 1 );
				message = "After exploring,\nyou found: " + GameState.entity.getName( itemID, GameState.type ) + "." ;
		}
		else
		{
			snake.setVisible(true);
			message = "You are attacked by\na vicious predator!\nYou lose health.";
			GameState.status.change(1, -10);
		}		
		// -- Add 3 hours to time
		GameState.timePass(3);
		
		font = game.skin.getFont( "uiFont" );
		x = -80;
		y =  260;
		label = new LabelActor(font,Color.WHITE, x, y);
		label.setText(message);
		uiStage.addActor(label);
		
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
