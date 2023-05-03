interface BankAccountInterface {
  double getBalance();

  String getName();

  void setBalance(double balance);

  void deposit(double amount) throws Exception;

  void withdraw(double amount) throws Exception;

  void addInterest() throws Exception;

  int getWithdrawCount();

  void withdraw(double amount, String parentName) throws Exception;

  void transfer(double amount, BankAccount destination) throws Exception;
}
