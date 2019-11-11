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

public class InventoryScreen extends BaseScreen{

	private BaseActor background;
	private BaseActor back;
	private BaseActor title;
	
	private SingleLineLabelActor[] foods;
	private SingleLineLabelActor[] drinks;
	private SingleLineLabelActor[] material;
	private SingleLineLabelActor[] clothing;
	private SingleLineLabelActor[] tools;
	
	private String message= "";
	
	private Action fadeIn;
	private Sound click;
	private float volume = 1;
	

	public InventoryScreen(Game game) {
		super(game);
	}
	
	@Override
	public void create() {
		
		BitmapFont font = game.skin.getFont( "uiInventoryFont" );
		float x, y, w, h;
		
		// -- Start inventory screen arrangement
		x = 100;
		y = 380;
		w = 128;
		h = 50;
		
		// -- Create foods array
		foods = new SingleLineLabelActor[GameState.entityList.foods.size()];
		for( int i = 0; i < GameState.entityList.foods.size(); i++ )
		{
			foods[i] = new SingleLineLabelActor(font,Color.ORANGE, x + ( 0 * w ) , y - ( (i + 1) * h ) );
			foods[i].setText(GameState.entityList.foods.get(i).name + " (" + GameState.inventory.foodArray[i] + ")" );
			foods[i].toFront();
			foods[i].addListener(
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
			uiStage.addActor(foods[i]);
		}
		
		// -- Create drinks array
		drinks = new SingleLineLabelActor[GameState.entityList.drinks.size()];
		for( int i = 0; i < GameState.entityList.drinks.size(); i++ )
		{
			drinks[i] = new SingleLineLabelActor(font,Color.WHITE, x + ( 1 * w ), y - ( (i + 1) * h ) ); 
			drinks[i].setText(GameState.entityList.drinks.get(i).name + " (" + GameState.inventory.drinkArray[i] + ")" );
			uiStage.addActor(drinks[i]);
		}
		
		// -- Create materials array
		material = new SingleLineLabelActor[GameState.entityList.materials.size()];
		for( int i = 0; i < GameState.entityList.materials.size(); i++ )
		{
			material[i] = new SingleLineLabelActor(font,Color.ORANGE, x + ( 2 * w ), y - ( (i + 1) * h )); 
			material[i].setText(GameState.entityList.materials.get(i).name + " (" + GameState.inventory.materialArray[i] + ")" );
			uiStage.addActor(material[i]);
		}
		
		// -- Create tools array
		tools = new SingleLineLabelActor[GameState.entityList.tools.size()];
		for( int i = 0; i < GameState.entityList.tools.size(); i++ )
		{
			tools[i] = new SingleLineLabelActor(font,Color.WHITE, x + ( 3 * w ), y - ( (i + 1) * h )); 
			tools[i].setText(GameState.entityList.tools.get(i).name + " (" + GameState.inventory.toolArray[i] + ")" );
			uiStage.addActor(tools[i]);
		}
		
		// -- Create Clothing array
		clothing = new SingleLineLabelActor[GameState.entityList.clothings.size()];
		for( int i = 0; i < GameState.entityList.clothings.size(); i++ )
		{
			clothing[i] = new SingleLineLabelActor(font,Color.ORANGE, x + ( 4 * w ), y - ( (i + 1) * h )); 
			clothing[i].setText(GameState.entityList.clothings.get(i).name + " (" + GameState.inventory.clothingArray[i] + ")" );
			uiStage.addActor(clothing[i]);
		}
		
		fadeIn = Actions.sequence(Actions.alpha(0), Actions.show(), Actions.fadeIn(5));
		click = Gdx.audio.newSound(Gdx.files.internal("assets/button push sound.mp3"));
		
		// -- Background
		background = new BaseActor();
		background.setTexture( new Texture( Gdx.files.internal("assets/background_main.png")));
		mainStage.addActor(background);
		
		// -- Title
		title = new BaseActor();
		title.setTexture( new Texture( Gdx.files.internal("assets/title_inventory.png")));
		title.setPosition(180, 380);
		title.setVisible(true);
		mainStage.addActor(title);
		
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
