import java.util.Scanner;

public class ATMInterface 
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount userAccount = new BankAccount(1000);

        System.out.println("*****Welcome To ATM*****");
        boolean isRunning = true;

        while(isRunning)
        {

        System.out.println("\nOptions");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("Exit");
        System.out.println("\n\n Enter your choice : ");
        int choice =sc.nextInt();

        switch(choice)
        {
            case 1:
            System.out.print("Enter the amout you want to withdraw : ");
            double withdrawAmount = sc.nextDouble();
            if(userAccount.withdraw(withdrawAmount))
            {
                System.out.println("Amount has been withdrawn!");
            }
            else
            {
                System.out.println("Insufficient Balance!");
            }
            break;

            case 2:
            System.out.print("Enter the amount you want to deposit : ");
            double depositAmount = sc.nextDouble();
            if(userAccount.deposit(depositAmount))
            {
                System.out.println("Amount has been deposited!");
            }
            else 
            {
                System.out.println("Invalid Amount!");
            }
            break;

            case 3:
            System.out.println("Your Account Balance is : $" + userAccount.getBalance());
            break;

            default:
            System.out.println("Invalid Choice!");
        }

     }
    }
}

class BankAccount
{
    private double balance;
    public BankAccount(double initialBalance)
    {
        balance = initialBalance;
    }

    public boolean withdraw(double amount)
    {
        if(amount > 0 && amount <= balance)
        {
            balance = balance - amount;
            return true;
        }
        return false;
    }

    public double getBalance()
    {
        return balance;
    }

    public boolean deposit(double amount)
    {
        if(amount > 0)
        {
            balance = balance + amount;
            return true;
        }
        return false;
    }
}
