abstract class BankAccount implements BankAccountInterface {
  private String name;
  private double balance;

  public void addInterest() throws Exception {
  }

  public int getWithdrawCount() {
    return 0;
  }

  public void withdraw(double amount, String parentName) throws Exception {
  }

  public BankAccount(String name, double initialDeposit) throws Exception {
    if (name.length() <= 2) {
      throw new Exception("Name must be more than 2 characters.");
    } else if (initialDeposit <= 0) {
      throw new Exception("Balance must be positive.");
    } else {
      this.name = name;
      balance = initialDeposit;
    }
  }

  // With the same logic, throw an Exception in the deposit
  // method if the amount is negative or equal to zero.
  // Think and implement a condition that could throw an
  // exception in the methods: withdrawal and transfer.
  public double getBalance() {
    return this.balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public String getName() {
    return this.name;
  }

  public void deposit(double amount) throws Exception {
    if (amount <= 0) {
      throw new Exception("You must deposit a positive amount of money.");
    } else {
      balance += amount;
      System.out.println(amount + " was deposited. Balance is now " + balance + ".");
    }
  }

  public void withdraw(double amount) throws Exception {
    if (balance - amount < 0) {
      throw new Exception("You can't withdraw more money than you have.");
    } else if (amount <= 0) {
      throw new Exception("You must withdraw a positive amount of money.");
    } else {
      balance -= amount;
      System.out.println(amount + " was withdrawn. Balance is now " + balance + ".");
    }
  }

  public void transfer(double amount, BankAccount destination) throws Exception {
    if (balance - amount < 0) {
      throw new Exception("You can't transfer more money than you have.");
    } else if (amount <= 0) {
      throw new Exception("You must transfer a positive amount of money.");
    } else {
      balance -= amount;
      destination.balance += amount;
      System.out
          .println(amount + " was transferred to " + destination.getName() + ". Your balance is now " + balance + ".");
    }
  }
}
