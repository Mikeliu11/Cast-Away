/*
 * This class is responsible for manipulating entities
 */

public class Entity
{

	// -- Retrieves the name of each item selected
	public String getName( int itemID,int type )
	{
		itemID = itemID - 1;
		if( type == 1 )
		{
			Food food = GameState.entityList.foods.get( itemID );
			return food.name;
		}
		else if( type == 2 )
		{
			Drink drink = GameState.entityList.drinks.get( itemID );
			return drink.name;
		}
		else if( type == 3 )
		{
			Material material = GameState.entityList.materials.get( itemID );
			return material.name;
		}
		else if( type == 4 )
		{
			Tool tool = GameState.entityList.tools.get( itemID );
			return tool.name;
		}
		else if( type == 5 )
		{
			Clothing clothing = GameState.entityList.clothings.get( itemID );
			return clothing.name;
		}
		return "Not Found";
	}
	
	// -- Checks if all required items are collected to craft selected item
	//boolean craft(String function, int item )
	boolean craft( int item )
	{
		if( item == 1 )
		{
			// -- Need 3 pieces of wood to start fire
			// -- Items for fire
			if( haveItems( 1, 3, 1 ) )
			{
				return true;
			}
		}
		else if (item == 2) {
			// -- Stone Axe
			// -- Need 1 stone, 1 piece of wood, and 1 piece of string
			if (haveItems(2,3,1) && haveItems(1,3,1) && haveItems(5, 3, 1)) {
				return true;
			}
		}
		else if (item == 3) {
			// -- Hat
			// -- Need 2 pieces of cotton, 1 piece of cloth, and 2 pieces of string
			if (haveItems(4, 3, 2) && haveItems(3,3,1) && haveItems(5, 3, 2)) {
				return true;
			}
		}
		else if (item == 4) {
			// -- Sweater
			// -- Need 3 pieces of cotton, 2 pieces of cloth, and 2 pieces of string
			if (haveItems(4, 3, 3) && haveItems(3,3,2) && haveItems(5, 3, 2)) {
				return true;
			}
		}
		return false;
	}
	
	// -- Checks if item requested is in inventory
	public boolean haveItems( int itemId, int type, int amount )
	{
		itemId = itemId - 1;
		if( type == 1 )
		{
			// -- Food
			if( GameState.inventory.foodArray[itemId] >= amount )
			{
				return true;
			}
		}
		else if( type == 2 )
		{
			// -- Drinks
			if( GameState.inventory.drinkArray[itemId] >= amount )
			{
				return true;
			}
		}
		else if( type == 3 )
		{
			// -- Materials
			if( GameState.inventory.materialArray[itemId] >= amount )
			{
				return true;
			}
		}
		else if( type == 4 )
		{
			// -- Tools
			if( GameState.inventory.toolArray[itemId] >= amount )
			{
				return true;
			}
		}
		else if( type == 4 )
		{
			// -- Clothing
			if( GameState.inventory.clothingArray[itemId] >= amount )
			{
				return true;
			}
		}
		return false;
	}
	
	// -- Alerts player of action taken
	public void add( int index, int type, int amount )
	{
		index -= 1;
		if( type == 1 )
		{
			Food food = GameState.entityList.foods.get( index );
		}
		else if( type == 2 )
		{
			Drink drink = GameState.entityList.drinks.get( index );
		}
		else if( type == 3 )
		{
			Material material = GameState.entityList.materials.get( index );
		}
		else if( type == 4 )
		{
			Tool tool = GameState.entityList.tools.get( index );
		}
		else if( type == 5 )
		{
			Clothing clothing = GameState.entityList.clothings.get( index );
		}
		GameState.inventory.addItemToInventory( index, type, amount );	
	}
	
	// -- Alerts player of action taken for eating and drinking
	void use( int index, int type, int amount )
	{
		index -= 1;
		if( type == 1 )
		{
			Food food = GameState.entityList.foods.get( index );
			//System.out.print( "Ate " + amount + " " + food.name + ". " );
		}
		else if( type == 2 )
		{
			Drink drink = GameState.entityList.drinks.get( index );
			//System.out.print( "Drank " + amount + " " + drink.name + ". " );
		}
		else if( type == 3 )
		{
			Material material = GameState.entityList.materials.get( index );
			//System.out.print( "Drank " + amount + " " + Material.name + ". " );
		}
		else if( type == 4 )
		{
			Tool tool = GameState.entityList.tools.get( index );
			//System.out.print( "Drank " + amount + " " + Material.name + ". " );
		}
		else if( type == 5 )
		{
			Clothing clothing = GameState.entityList.clothings.get( index );
			//System.out.print( "Drank " + amount + " " + Material.name + ". " );
		}
		GameState.inventory.useItemInInventory( index, type, amount );
	}
}