class SavingsAccountChild extends SavingsAccount {
  private String parentName;

  public SavingsAccountChild(String name, double initialDeposit,
      double interestRate, String parentName) throws Exception {
    super(name, initialDeposit, interestRate);
    this.parentName = parentName;
  }

  public void withdraw(double amount, String parentName) throws Exception {
    if (parentName == this.parentName) {
      super.withdraw(amount);
    } else {
      throw new Exception("Parent is needed to withdraw.");
    }
  }
}
