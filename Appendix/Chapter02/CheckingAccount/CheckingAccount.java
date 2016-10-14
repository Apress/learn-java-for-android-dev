// CheckingAccount.java

public class CheckingAccount
{
   private String owner;
   private int balance;
   public static int counter;
   public CheckingAccount(String acctOwner, int acctBalance)
   {
      owner = acctOwner;
      balance = acctBalance;
      counter++; // keep track of created CheckingAccount objects
   }
   public CheckingAccount(String acctOwner)
   {
      this(acctOwner, 100); // New account requires $100 minimum balance
   }
   public CheckingAccount printBalance()
   {
      System.out.println(owner+"'s balance:");
      int magnitude = (balance < 0) ? -balance : balance;
      String balanceRep = (balance < 0) ? "(" : "";
      balanceRep += magnitude;
      balanceRep += (balance < 0) ? ")" : "";
      System.out.println(balanceRep);
      return this;      
   }
   public CheckingAccount deposit(int amount)
   {
      if (amount <= 0.0)
         System.out.println("cannot deposit a negative or zero amount");
      else
         balance += amount;
      return this;
   }
   public CheckingAccount withdraw(int amount)
   {
      if (amount <= 0.0)
         System.out.println("cannot deposit a negative or zero amount");
      else
      if (balance-amount < 0)
         System.out.println("cannot withdraw more funds than are available");
      else
         balance -= amount;
      return this;
   }
   public static void main(String[] args)
   {
      new CheckingAccount("Jane Doe", 1000).withdraw(2000).printBalance();
      CheckingAccount ca = new CheckingAccount("John Doe");
      ca.printBalance().withdraw(50).printBalance().deposit(80).printBalance();
      System.out.println ("Number of created CheckingAccount objects = "+
                          ca.counter);
   }
}
