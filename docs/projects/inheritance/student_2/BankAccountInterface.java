interface BankAccountInterface{
    double getBalance();
    String getName();
    void deposit(double ammount) throws Exception;
    void withdraw(double ammount) throws Exception;
    void transfer(double ammount, BankAccount destination) throws Exception;
}
//-----------------------------------------------------------------------------------------------------------------------------------
abstract class BankAccount {
    private String name;
    private double balance;
    //*************************************************************************************************************/
    public BankAccount(String name, double initialDeposit) throws Exception{
        try{
            if(name.length() <= 2){
                throw new Exception("Error: name.length <= 2");
            } else if (initialDeposit <= 0){
                throw new Exception("Error: intitalDeposit <= 0");
            }else{
                this.name = name;
                this.balance = initialDeposit;
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    //*************************************************************************************************************/
    @Override
    public double getBalance() {
        return balance;
    }
    //*************************************************************************************************************/
    @Override
    public String getName() {
        return name;
    }
    //*************************************************************************************************************/
    @Override
    public void deposit(double ammount) throws Exception {
        try{
            if(ammount <= 0){
                throw new Exception("Can not deposit 0 or less dollars");
            }else{
                balance += ammount;
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    //*************************************************************************************************************/
    @Override
    public void withdraw(double ammount) throws Exception{
        try{
            if(ammount <= 0){
                throw new Exception("Error: Can not withdraw 0 or less dollars");
            }else if(balance - ammount <0){
                throw new Exception("Error: Not enough money in account");
            }else{
                balance -= ammount;
            }  
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    //*************************************************************************************************************/
    @Override
    public void transfer(double ammount, BankAccount destination) throws Exception{
        try{
            if(ammount <= 0){
                throw new Exception("Error: Can not transfer 0 or less dollars");
            }else if(balance - ammount <0){
                throw new Exception("Error: Not enough money in account");
            }else{
                balance -= ammount;
                destination.deposit(ammount);
            }  
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    } 
    }
//-----------------------------------------------------------------------------------------------------------------------------------
class CheckingAccount extends BankAccount{
    public CheckingAccount(String name, double initialDeposit) throws Exception{
        super(name, initialDeposit);
    }
}
//-----------------------------------------------------------------------------------------------------------------------------------
class SavingsAccount extends BankAccount{
    private double intrestRate;
    private int withdrawCount;
    public SavingsAccount(String name, double initialDeposit, double intrestRate) throws Exception{
        super(name, initialDeposit);
        try{
            if(intrestRate < 0){
                throw new Exception("Error: Interest rate can not be less than 0");
            }else{
            this.intrestRate = intrestRate;
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void addInterest() throws Exception{
        try{
            if(intrestRate <= 0){
                throw new Exception("Error: Can not calculate interest for an account with a rate less than 0");
            }else{
                deposit(getBalance()*intrestRate);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void withdraw(double ammount) throws Exception {
        try{
            if(getWithdrawCount()<5){
                super.withdraw(ammount);
                ++withdrawCount;
            }else{
                throw new Exception("Error: Can not withdraw more than 5 times");
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage()); 
        }
    }

    public int getWithdrawCount(){
        return withdrawCount;
    }
}
//-----------------------------------------------------------------------------------------------------------------------------------
class SavingsAccountKid extends BankAccount{
    private String parentName;
    public SavingsAccountKid(String name, double initialDeposit, String parentName) throws Exception{
        super(name, initialDeposit);
        try{
            if(parentName.length()<=2){
                throw new Exception("Error: parent name can not be shorter than 3 characters");
            }else{
                this.parentName = parentName;
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage()); 
        }
    }
    public void withdraw(double ammount, String parentName) throws Exception{
        try{
            if(parentName.equals(this.parentName)){
                super.withdraw(ammount);
            }else{
                throw new Exception("Error: invalid parent name");
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage()); 
        }
    }
}
