package accountmanagement;

public class AccountManagement {

    public static void main(String[] args) {

        // Create few accounts
        Account a1=new Account(2345,"Ram",2600);
        Account a2=new Account(3654,"Shyam ",13600);
        Account a3=new Account(2638,"Ram",1400);
        Account a4=new Account(4892,"Ram",500);


        // Display the no. of accounts created
        System.out.println(Account.totalAccountsCreated());
        // Do the basic operations(deposit/withdraw)
        a1.withdraw(200);
        a3.deposit(400);
        a2.withdraw(500);
        a4.withdraw(200);


    }

}
