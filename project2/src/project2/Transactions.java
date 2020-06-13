/* Name Samuel McGinnis:
 Course: CNT 4714 Summer 2020
 Assignment title: Project 2 – Synchronized, Cooperating Threads Under Locking
 Due Date: June 10, 2020
*/
package project2;

public class Transactions {
	
	public static void main(String[] args) {
		
		Bank sharedLocation = new Sync();
		
		System.out.printf("%-40s%s\t\t%s\n", "Deposit Threads", "Withdrawl Threads", "Balance");
		System.out.printf("%-40s%s\t\t%s\n","----------------", "------------------","---------------");
		try 
		{		
			new Deposit(sharedLocation, "D1");
			new Deposit(sharedLocation, "D2");
			new Deposit(sharedLocation, "D3");
			new Deposit(sharedLocation, "D4");
			new Deposit(sharedLocation, "D5");
			
			new Withdraw(sharedLocation, "W1");
			new Withdraw(sharedLocation, "W2");
			new Withdraw(sharedLocation, "W3");
			new Withdraw(sharedLocation, "W4");
			new Withdraw(sharedLocation, "W5");
			new Withdraw(sharedLocation, "W6");
			new Withdraw(sharedLocation, "W7");
			new Withdraw(sharedLocation, "W8");
			new Withdraw(sharedLocation, "W9");	
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
	}
}
