package project2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Sync implements Bank{
	
	private Lock obtainLock = new ReentrantLock(false);
	
	private Condition makeTransaction = obtainLock.newCondition();
	private Condition showTransaction = obtainLock.newCondition();
	
	private int bank = 0;
	
	public void setStatement( int depValue, boolean engaged, String name) throws InterruptedException {		
		obtainLock.lock();
		int revert = bank;
		
		if(!engaged) 
		{
			while(engaged) 
			{
				makeTransaction.await();
			}
			bank += depValue;
			System.out.printf("Thread " + name + " deposits $" + depValue + "\t\t\t\t\t\t\t" + "(+) Balance is $" + bank + "\n");
			showTransaction.signal();

		}
		else if(engaged) 
		{
			while(!engaged)
			{
				showTransaction.await();
			}
		
			bank -= depValue;
			
			if(bank <0)
			{
				System.out.printf("\t\t\t\t\t" +"Thread " + name + " withrawls $" + depValue +  "\t\t(***) Withdrawl - Blocked - Insuffcient Funds!!!\n");
				bank = revert;
			}
			else
				System.out.printf("\t\t\t\t\t" +"Thread " + name + " withrawls $" + depValue +  "\t\t(-) Balance is $" + bank + "\n");
				
			makeTransaction.signal();
			
		}
		else
		{
			System.out.println("Function malfunction... resuming...");
		}
		obtainLock.unlock();
			
	}
}