import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class CastAwayGame extends Game{

	public Skin skin;
	
	public CastAwayGame()
	{
		skin = new Skin();
	}
	
	@Override
	public void create()
	{
		// -- Initialize resources common to multiple screens
        // -- Bitmap font
        BitmapFont uiFont = new BitmapFont(Gdx.files.internal("assets/v.fnt"));
        uiFont.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
        skin.add("uiFont", uiFont);
        
        // -- FOR INVENTORY ONLY
        BitmapFont uiInventoryFont = new BitmapFont(Gdx.files.internal("assets/inventory.fnt"));
        uiInventoryFont.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
        skin.add("uiInventoryFont", uiInventoryFont);
		
        // -- Sets initial screen when game starts
		IntroScreen is = new IntroScreen(this);
		setScreen( is );
	}
	
	public void dispose()
	{
		skin.dispose();
	} 
}
