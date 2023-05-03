class SavingsAccount extends BankAccount {
  private double interestRate;
  private int withdrawCount = 0;

  public SavingsAccount(String name, double initialDeposit, double interestRate) throws Exception {
    super(name, initialDeposit);
    this.interestRate = interestRate;
  }

  public void addInterest() throws Exception {
    double interestAdded = this.getBalance() * interestRate;
    this.setBalance(this.getBalance() + interestAdded);
  }

  public void withdraw(double amount) throws Exception {
    if (withdrawCount < 6) {
      super.withdraw(amount);
      withdrawCount += 1;
    } else {
      throw new Exception("You can't withdraw more than 6 times.");
    }
  }

  public int getWithdrawCount() {
    return this.withdrawCount;
  }
}
