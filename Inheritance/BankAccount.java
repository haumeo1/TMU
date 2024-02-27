 
public class BankAccount 
{
	private long   accountNumber;    
	protected double balance;
    private static int numberOfAccounts = 0;
	
	public BankAccount()
	{
	    accountNumber = 0;
	    balance = 0;
	    numberOfAccounts++;
	}
	
	public BankAccount(long accountNumber)
	{
	    this.accountNumber = accountNumber;
	    balance = 0;
	    numberOfAccounts++;
	}
	
	public BankAccount(long accountNumber, double initialBalance)
	{
	    this.accountNumber = accountNumber;
	    balance = initialBalance;
	    numberOfAccounts++;
	}
	
	public static int getNumberOfAccounts()
	{
		return numberOfAccounts;
	}

	public double getBalance() 
	{
	  return balance;
	}
	
	public void deposit(double amount) 
	{
	   balance += amount;
	}

	public void withdraw(double amount) 
	{
	   balance -= amount;
	}

	public void transfer(double amount, BankAccount targetAccount)
	{
	   this.withdraw(amount);
	   targetAccount.deposit(amount);
	}

}
