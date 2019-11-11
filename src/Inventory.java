/*
 * This class is responsible for processing the inventory
 */

public class Inventory
{
	// -- Initializes arrays for each entity
	EntityListFactory entityList = new EntityListFactory();
	public int[]foodArray = new int[entityList.foods.size()];
	public int[]drinkArray = new int[entityList.drinks.size()];
	public int[]materialArray = new int [entityList.materials.size()];
	public int[]toolArray = new int[entityList.tools.size()];
	public int[]clothingArray = new int[entityList.clothings.size()];
	
	// -- Cleans out inventory by initializing all array lists to 0
	void cleanInventory()
	{
		// -- Cleans food array
		for( int i = 0; i < foodArray.length; i ++ )
		{
			foodArray[i] = 0;
		}
		// -- Cleans drink array
		for( int i = 0; i < drinkArray.length; i ++ )
		{
			drinkArray[i] = 0;
		}
		// -- Cleans material array
		for ( int i = 0; i < materialArray.length; i ++ )
		{
			materialArray[i] = 0;
		}
		// -- Cleans tool array
		for ( int i = 0; i < toolArray.length; i ++ )
		{
			toolArray[i] = 0;
		}
		// -- Cleans clothing array
		for ( int i = 0; i < clothingArray.length; i ++ )
		{
			clothingArray[i] = 0;
		}
	}
	
	// -- Adds an entity item to inventory
	void addItemToInventory( int index, int type, int amount )
	{
		// -- Adds entity to food array
		if( type == 1 )
		{
			foodArray[index] += amount;
		}
		// -- Adds entity to drink array
		else if( type == 2 )
		{
			drinkArray[index] += amount;
		}
		// -- Adds entity to material array
		else if( type == 3 )
		{
			materialArray[index] += amount;
		}
		// -- Adds entity to tool array
		else if( type == 4 )
		{
			toolArray[index] += amount;
		}
		// -- Adds entity to clothing
		else if( type == 5 )
		{
			clothingArray[index] += amount;
		}
	}
	
	// -- Allows player to use item in inventory
	String useItemInInventory( int index, int type, int amount )
	{
		String msg = "";
		// -- If user selects food, reduce quantity in food array
		if( type == 1 )
		{
			if( foodArray[index] - amount >= 0 )
			{
				foodArray[index] -= amount;
			}
			else
			{
				msg = ( "Well at least you tried to anyways. You don't have any more of this item.\n" );
			}
		}
		// -- If user selects drink, reduce quantity in drink array
		else if( type == 2 )
		{
			if( drinkArray[index] - amount >= 0 )
			{
				drinkArray[index] -= amount;
			}
			else
			{
				msg = ( "Well, at least you tried to anyways. You don't have any more of this item.\n" );
			}
		}
		// -- If user selects material, reduce quantity in material array
		else if( type == 3 )
		{
			if ( materialArray[index] - amount >= 0 )
			{
				materialArray[index] -= amount;
			}
			else
			{
				msg = ( "Well, at least you tried to anyways. You don't have any more of this item.\n" );
			}
		}
		return msg;
	}
}