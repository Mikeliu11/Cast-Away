/*
 * This class is responsible for initializing each entity
 */

import java.util.ArrayList;

public class EntityListFactory
{
	public ArrayList<Food> foods;
	public ArrayList<Drink> drinks;
	public ArrayList<Material> materials;
	public ArrayList<Tool> tools;
	public ArrayList<Clothing>clothings;
	
	public EntityListFactory()
	{
		// -- Food entities
		foods = new ArrayList<Food>();
		Food f;
		f = new Food( "Apples", 140 );
		foods.add( f );
		f = new Food( "Berries", 120 );
		foods.add( f );
		f = new Food( "Meat", 280 );
		foods.add( f );
		f = new Food( "Fish", 240 );
		foods.add( f );
		
		// -- Drink entities
		drinks = new ArrayList<Drink>();
		Drink d;
		d = new Drink( "Water", 200 );
		drinks.add( d );
		d = new Drink( "Soup", 100 );
		drinks.add( d );
		
		// -- Material entities
		materials = new ArrayList<Material>();
		Material m;
		m = new Material( "Wood" );
		materials.add( m );
		m = new Material( "Stone" );
		materials.add( m );
		m = new Material( "Cloth" );
		materials.add( m );
		m = new Material( "Cotton" );
		materials.add( m );
		m = new Material( "String" );
		materials.add( m );
		
		// -- Tool entities
		tools = new ArrayList<Tool>();
		Tool t;
		t = new Tool( "Stone Axe" , 1 );
		tools.add( t );
		
		// -- Clothing entities
		clothings = new ArrayList<Clothing>();
		Clothing c;
		c = new Clothing( "Hat" , 5 );
		clothings.add( c );
		c = new Clothing( "Sweater" , 10 );
		clothings.add( c );
	}
}