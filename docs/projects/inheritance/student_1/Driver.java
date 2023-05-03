public class Driver {
    public static void main(String[] args) {
        try {
            BankAccount checkingAccount = new CheckingAccount("hi", 100);
            // Expecting error message "Name must be more than 2 characters."
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            BankAccount checkingAccount = new CheckingAccount("Aidan", 0);
            // Expecting error message "Balance must be positive."
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            BankAccount checkingAccount = new CheckingAccount("Aidan", 5000);
            checkingAccount.deposit(0);
            // Expecting error message "You must deposit a positive amount of money."
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            BankAccount checkingAccount = new CheckingAccount("Aidan", 5000);
            checkingAccount.withdraw(0);
            // Expecting error message "You must withdraw a positive amount of money."
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            BankAccount checkingAccount = new CheckingAccount("Aidan", 5000);
            checkingAccount.withdraw(6000);
            // Expecting error message "You can't withdraw more money than you have."
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            BankAccount checkingAccount = new CheckingAccount("Aidan", 5000);
            BankAccount msNovilloAccount = new CheckingAccount("Ms. Novillo", 20000);
            checkingAccount.transfer(0, msNovilloAccount);
            // Expecting error message "You must transfer a positive amount of money."
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            BankAccount checkingAccount = new CheckingAccount("Aidan", 5000);
            BankAccount msNovilloAccount = new CheckingAccount("Ms. Novillo", 20000);
            checkingAccount.transfer(6000, msNovilloAccount);
            // Expecting error message "You can't transfer more money than you have."
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            BankAccount savingsAccount = new SavingsAccount("Aidan", 5000, .05);
            savingsAccount.withdraw(500);
            savingsAccount.withdraw(500);
            savingsAccount.withdraw(500);
            savingsAccount.withdraw(500);
            savingsAccount.withdraw(500);
            savingsAccount.withdraw(500);
            savingsAccount.withdraw(500);
            // Expecting error "You can't withdraw more than 6 times."
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            BankAccount childSavingsAccount = new SavingsAccountChild("Aidan", 5000,
                    .05, "Mom");
            childSavingsAccount.deposit(500);
            childSavingsAccount.withdraw(1000, "Not the right parent");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try { // This should not throw an error.
            BankAccount checkingAccount = new CheckingAccount("Aidan", 5000);
            BankAccount msNovilloAccount = new CheckingAccount("Ms. Novillo", 20000);
            checkingAccount.deposit(500);
            checkingAccount.withdraw(1000);
            checkingAccount.transfer(1500, msNovilloAccount);
            System.out.println("Name: " + checkingAccount.getName()); // Expecting "Aidan"
            System.out.println("Balance: " + checkingAccount.getBalance()); // Expecting "3000.0"
            System.out.println("Name: " + msNovilloAccount.getName()); // Expecting "Ms. Novillo"
            System.out.println("Balance: " + msNovilloAccount.getBalance()); // Expecting "21500.0"

            BankAccount savingsAccount = new SavingsAccount("Aidan", 5000, .05);
            savingsAccount.deposit(500);
            savingsAccount.withdraw(1000);
            savingsAccount.addInterest();
            System.out.println("Balance: " + savingsAccount.getBalance()); // Expecting "4725.0"
            System.out.println("Withdraw Count: " + savingsAccount.getWithdrawCount()); // Expecting 1
            savingsAccount.transfer(2000, msNovilloAccount);
            System.out.println("Balance: " + msNovilloAccount.getBalance()); // Expecting "23500.0"
            System.out.println("Name: " + savingsAccount.getName()); // Expecting "Aidan"

            BankAccount childSavingsAccount = new SavingsAccountChild("Aidan", 5000,
                    .05, "Mom");
            childSavingsAccount.deposit(500);
            childSavingsAccount.withdraw(1000, "Mom");
            childSavingsAccount.addInterest();
            childSavingsAccount.transfer(100, msNovilloAccount);
            System.out.println("Name: " + childSavingsAccount.getName()); // Expecting "Aidan"
            System.out.println("Balance: " + childSavingsAccount.getBalance()); // Expecting "4625.0"
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
