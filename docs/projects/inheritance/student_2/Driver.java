public class Driver {
    public static void main(String[]args){
    try{
        //expecting errors in constructor
        BankAccount bankAccount0 = new CheckingAccount("aa", 100); //expected:Error: name.length <= 2
        BankAccount bankAccount1 = new CheckingAccount("aaaa", -7);//expected: Error: intitalDeposit <= 0
        SavingsAccount bankAccount2 = new SavingsAccount("aaaa", 100, -5); //expected: Error: Interest rate can not be less than 0
        SavingsAccountKid bankAccount3 = new SavingsAccountKid("aaaa", 100, "aa");//expected: Error: Can not calculate interest for an account with a rate less than 0
        
        //expected to work for constructor
        //testing for errors thrown in the methods
        //deposit withdraw transfer
        //interest rate
        //parent name thing
        bankAccount0 = new CheckingAccount("aaaa", 100);
        bankAccount1 = new CheckingAccount("aaaa", 100);
        bankAccount2 = new SavingsAccount("aaaa", 100, 0.1);
        bankAccount3 = new SavingsAccountKid("aaaa", 100, "aaaa");
        
        //works
        System.out.println(bankAccount2.getBalance());
        System.out.println(bankAccount2.getName());
        bankAccount2.addInterest();
        System.out.println(bankAccount2.getBalance());

        //returns errors
        bankAccount0.deposit(-1);//Expecting:Can not deposit 0 or less dollars
        bankAccount1.withdraw(-1);//error:Can not withdraw 0 or less dollars
        bankAccount1.withdraw(10000);//error:can't withdraw a negative ammount
        bankAccount1.transfer(-1, bankAccount0);//error:can't transfer negative ammount
        bankAccount1.transfer(1000, bankAccount0);//Error: Not enough money in account
        bankAccount3.withdraw(0.2,"aa");//Error: invalid parent name

        System.out.println(bankAccount2.getWithdrawCount());
        bankAccount2.withdraw(1);
        System.out.println(bankAccount2.getWithdrawCount());
        bankAccount2.withdraw(1);
        System.out.println(bankAccount2.getWithdrawCount());
        bankAccount2.withdraw(1);
        System.out.println(bankAccount2.getWithdrawCount());
        bankAccount2.withdraw(1);
        System.out.println(bankAccount2.getWithdrawCount());
        bankAccount2.withdraw(1);
        System.out.println(bankAccount2.getWithdrawCount());
        bankAccount2.withdraw(1);//this one returns error

    }   
    catch(Exception e){
        System.out.println(e.getMessage());
    }
}
}
