/* Name Samuel McGinnis:
 Course: CNT 4714 Summer 2020
 Assignment title: Project 2 – Synchronized, Cooperating Threads Under Locking
 Due Date: June 10, 2020
*/
package project2;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class Transactions {
	
	public static void main(String[] args) {
		
		Bank sharedLocation = new Sync();
		
		Deposit D1 = new Deposit(sharedLocation, "D1");
		Deposit D2 = new Deposit(sharedLocation, "D2");
		Deposit D3 = new Deposit(sharedLocation, "D3");
		Deposit D4 = new Deposit(sharedLocation, "D4");
		Deposit D5 = new Deposit(sharedLocation, "D5");
		
		Withdraw W1 = new Withdraw(sharedLocation, "W1");
		Withdraw W2 = new Withdraw(sharedLocation, "W2");
		Withdraw W3 = new Withdraw(sharedLocation, "W3");
		Withdraw W4 = new Withdraw(sharedLocation, "W4");
		Withdraw W5 = new Withdraw(sharedLocation, "W5");
		Withdraw W6 = new Withdraw(sharedLocation, "W6");
		Withdraw W7 = new Withdraw(sharedLocation, "W7");
		Withdraw W8 = new Withdraw(sharedLocation, "W8");
		Withdraw W9 = new Withdraw(sharedLocation, "W9");	
		
		ExecutorService TE = Executors.newFixedThreadPool(14);
		
		System.out.printf("%-40s%s\t\t%s\n", "Deposit Threads", "Withdrawl Threads", "Balance");
		System.out.printf("%-40s%s\t\t%s\n","----------------", "------------------","---------------");
		try 
		{		
			TE.execute(D1);
			TE.execute(D2);
			TE.execute(D3);
			TE.execute(D4);
			TE.execute(D5);
			TE.execute(W1);
			TE.execute(W2);
			TE.execute(W3);
			TE.execute(W4);
			TE.execute(W5);
			TE.execute(W6);
			TE.execute(W7);
			TE.execute(W8);
			TE.execute(W9);
			
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
	}
}
