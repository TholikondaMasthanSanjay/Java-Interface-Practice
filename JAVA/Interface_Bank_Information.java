import java.util.Scanner;
interface BankAccount {
    void deposit(double amount);
    void withdraw(double amount);
    void checkBalance();
    void accountDetails();
}
// SBI 
class SbiBank implements BankAccount {
private String name;
 private String accNo;
 private double balance;

    public SbiBank(String name, String accNo, double balance)
    {
        this.name = name;
        this.accNo = accNo;
        this.balance = balance;
    }

    public void deposit(double amount){
        if(amount <= 0){
            System.out.println("Invalid amount!");
            return;
        }
        balance += amount;
        System.out.println("SBI Deposited " + amount);
    }

    public void withdraw(double amount){
        if(amount > balance){
            System.out.println("SBI Insufficient balance");
            return;
        }
        balance -= amount;
        System.out.println(" Withdrawn" + amount);
    }

    public void checkBalance(){
        System.out.println("SBI Balance: " + balance);
    }

    public void accountDetails(){
        System.out.println("\n--- SBI ACCOUNT ---");
        System.out.println("Name : " + name);
        System.out.println("AccNo: " + accNo);
    }
}

// HDFC Implementation
class HdfcBank implements BankAccount {
    private String name;
    private String accNo;
    private double balance;

    public HdfcBank(String name, String accNo, double balance){
        this.name = name;
        this.accNo = accNo;
        this.balance = balance;
    }

    public void deposit(double amount){
        if(amount <= 0){
            System.out.println("Invalid amount");
            return;
        }
        balance += amount;
        System.out.println("HDFC Deposited " + amount);
    }

    public void withdraw(double amount){
        if(amount > balance){
            System.out.println("HDFC Insufficient balance");
            return;
        }
        balance -= amount;
        System.out.println("HDFC  Withdrawn " + amount);
    }

    public void checkBalance(){
        System.out.println("HDFC Balance: " + balance);
    }

    public void accountDetails(){
        System.out.println("\n--- HDFC ACCOUNT ---");
        System.out.println("Name : " + name);
        System.out.println("AccNo: " + accNo);
    }
}

public class  Interface_Bank_Information {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        BankAccount account;   // Interface reference Polymorphism

        System.out.println("Choose Bank: 1.SBI  2.HDFC");
        int choice = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();

        if(choice == 1)
            account = new SbiBank(name, accNo, 2000);
        else
            account = new HdfcBank(name, accNo, 3000);

        int option;
        do{
            System.out.println("1.Deposit");
            System.out.println("2.Withdraw");
             System.out.println("3.Check Balance");
              System.out.println("4.Account Details");
               System.out.println("0.Exit");
               System.out.println("********** Select the Option **********");
                  option = sc.nextInt();

            switch(option){
                case 1:
                    System.out.print("Enter amount: ");
                    account.deposit(sc.nextDouble());
                    break;

                case 2:
                    System.out.print("Enter amount: ");
                    account.withdraw(sc.nextDouble());
                    break;

                case 3:
                    account.checkBalance();
                    break;

                case 4:
                    account.accountDetails();
                    break;
            }

        }while(option != 0);

      
}
} 