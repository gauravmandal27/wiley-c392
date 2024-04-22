package accountmanagement;

public class Account {

    private long accountNo;
    private String customerName;
    private double balance;
    private static int totalAccount;


    public Account(long accountNo, String customerName, double balance) {
        this.accountNo = accountNo;
        this.customerName = customerName;
        this.balance = balance;
        totalAccount+=1;
    }

    public void deposit(double amount){
        this.balance+=amount;
        System.out.println("Deposit of "+amount+" complete, Updated Balance is:"+balance);

    }

    public void withdraw(double amount){

        if((this.balance-=amount)>0){
            this.balance-=amount;
            System.out.println("Withdrawal of "+amount+" complete, Updated Balance is:"+balance);
        }
        else{
            System.out.println("Low Balance!!");
        }
    }
    public static String totalAccountsCreated(){
        return "Total number of accounts is "+totalAccount;
    }
    public String showAccountInfo(){
        return "Account{" +
                "accountNo=" + accountNo +
                ", customerName='" + customerName + '\'' +
                ", balance=" + balance +
                '}';
    }

}
