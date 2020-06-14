package project2;

import java.util.Random;

public class Deposit implements Runnable 
{

	private static Random generator = new Random();
	private Bank sharedLocation;
	String name;
	public Deposit(Bank shared, String threadName) 
	{
		name = threadName;
		sharedLocation = shared;
	}
	
	public void run() 
	{
		int money;

		while(true) 
		{
			money = generator.nextInt((250) + 1);
			
			try 
			{
				sharedLocation.setStatement(money, false, name);
				Thread.sleep(generator.nextInt(10));
			}
			catch(InterruptedException exception) {
				exception.printStackTrace();
			}
		}
	}		
}
