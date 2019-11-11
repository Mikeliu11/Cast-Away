import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

public class LabelActor extends BaseActor{
	
	private String text;
	private BitmapFont font;
	private GlyphLayout glyphLayout;
	private Color color;
	private float xPos, yPos;
	
	public LabelActor(BitmapFont font, Color color, float xPos, float yPos )
	{
		super();
		this.font = font;
		this.color = color;
		this.xPos = xPos;
		this.yPos = yPos;
		
		glyphLayout = new GlyphLayout();
		text = "";
	}
	
	public void setText(String text)
	{
		this.text = text;
	}
	
    public void draw(Batch batch, float parentAlpha) 
    {
        font.setColor(color);
    	glyphLayout.setText(font, text);
        if ( isVisible() )
        {
        	font.draw( batch, glyphLayout, xPos + glyphLayout.width/3, yPos + glyphLayout.height/3 );
        }
    }

}
