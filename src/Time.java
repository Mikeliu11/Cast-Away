/*
 * This class is responsible for processing time
 */

public class Time
{
	int time;
	int fullDayClock;
	static int counter = 1;
	
	public Time ( int time )
	{
		this.time = time;
		this.fullDayClock = time;
	}
	
	int getTime()
	{
		return time;
	}
	
	// -- Adds time to clock
	// -- Uses 24 hour style
	public void add( int amount )
	{
		fullDayClock = fullDayClock + amount;
		time = time + amount;
		if( time > 12 )
		{
			time = time - 12;
		}
		if( fullDayClock > 24 )
		{
			fullDayClock = fullDayClock - 24;
		}
	}
	
	// -- Counts number of days passed
	public int dayCounter()
	{
		if( fullDayClock >= 23 && fullDayClock <= 24  )
		{
			counter = counter + 1;
		}
		return counter;
	}
	
	// -- Checks if it is daytime
	public boolean isDayTime()
	{
		if( time > 6 && time < 19 )
		{
			return true;
		}
		return false;
	}
	
	// -- Determines to label time as AM or PM
	String getAMPM()
	{
		// -- Fix for am and pm at 12
		if( fullDayClock < 13 && fullDayClock >= 12 )
		{
			return "pm";
		}
		if( fullDayClock > 23 && fullDayClock <= 24)
		{
			return "am";
		}
		
		if( fullDayClock >= 0 && fullDayClock <= 12 )
		{
			return "am";
		}
		else
		{
			return "pm";
		}
	}
}