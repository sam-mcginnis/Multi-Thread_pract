package project2;

import java.util.Random;

public class Withdraw implements Runnable 
{
	private static Random generator = new Random();

	private Bank sharedLocation;
	
	String name;
	
	public Withdraw(Bank shared, String threadName)
	{
		name = threadName;
		sharedLocation = shared;
	}
		
	public void run() {
			
		int withdrawl;
	
		while(true) 
		{
			withdrawl = generator.nextInt((50) + 1);
			
			try 
			{	
				sharedLocation.setStatement(withdrawl, true, name);	
				Thread.sleep(1);
			}
			catch(InterruptedException exception) 
			{
				exception.printStackTrace();
			}
		}
	}
}