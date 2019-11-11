/*
 * This class is responsible for processing game status of player
 */

public class Status
{
	// -- The main 4 characteristics used as status are:
	// -- health, hunger, thirst & warmth
	int health;
	int hunger;
	int thirst;
	int warmth;
	int healthCap = 100;
	int hungerCap = 2500;
	int thirstCap = 1600;
	int warmthCap = 800;
	
	
	public Status ( int a, int b, int c, int d )
	{
		health = a;
		hunger = b;
		thirst = c;
		warmth = d;
	}
	
	// -- Prints status of player
	public String printStatus()
	{
		return(
				"Health: " + health +
				"\nHunger: " + hunger +
				"\nThirst: " + thirst +
				"\nWarmth: " + warmth +
				"\n"
				);
	}
	
	// -- Updates status of player
	public void change( int type, int amount )
	{
		// -- If entity relates to health, change value of health
		if( type == 1)
		{
			if (health + amount <= healthCap) 
			{
				health += amount;
			}
			else {
				amount = healthCap - health;
				health += amount;
			}
		}
		// -- If entity relates to hunger, change value of hunger
		else if( type == 2)
		{
			if (hunger + amount <= hungerCap)
			{
				hunger += amount;
			}
			else {
				amount = hungerCap - hunger;
				hunger += amount;
			}
		}
		// -- If entity relates to thirst, change value of thirst
		else if( type == 3)
		{
			if (thirst + amount <= thirstCap) 
			{
				thirst += amount;
			}
			else {
				amount = thirstCap - thirst;
				thirst += amount;
			}
		}
		// -- If entity relates to warmth, change value of warmth
		else if( type == 4)
		{
			if (warmth + amount <= warmthCap)
			{
				warmth += amount;
			}
			else {
				amount = warmthCap - warmth;
				warmth += amount;
			}
		}
	}
	
	// -- Checks if player is dead
	// -- At least one of the 4 characteristics of status must be 0 for player to die
	public boolean isDead()
	{
		if( health <= 0 || hunger <= 0 || warmth <= 0 || thirst <= 0 )
		{
			return true;
		}
		return false;
	}
	
	int getHealth()
	{
		return health;
	}
	
	int getHunger()
	{
		return hunger;
	}
	
	int getThirst()
	{
		return thirst;
	}
	
	int getWarmth()
	{
		return warmth;
	}
}