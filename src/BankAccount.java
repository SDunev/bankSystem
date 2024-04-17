import java.util.Scanner;

public class  BankAccount implements Operations {

    private int balance;
    private int previousTransaction;
    private final String customerName;
    private final String customerID;

    public BankAccount(String customerName, String customerID) {
        this.customerName = customerName;
        this.customerID = customerID;
    }


    @Override
    public void deposit(int amount) {
        if (amount !=0){
            balance+= amount;
            previousTransaction = amount;
        }

    }

    @Override
    public void withdraw(int amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            previousTransaction = -amount;
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance!");
        }
    }


    @Override
    public void getPreviousTransaction() {
        if (previousTransaction >0){
            System.out.println("Deposited: " + previousTransaction);
        }else if (previousTransaction<0){
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        }else {
            System.out.println("No transaction is occured!");
        }
    }

    @Override
    public void showMenu() {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome: " + customerName);
        System.out.println("Your ID is: " + customerID);
        System.out.println();
        System.out.println("A. Check balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous Transaction");
        System.out.println("E. Exit");

        do {
            System.out.println("=========================================");
            System.out.println("Enter option");
            System.out.println("=========================================");
            option = scanner.next().charAt(0);
            Character.toUpperCase(option);

            switch (option){
                case 'A':
                    System.out.println("=========================================");
                    System.out.println("Balance is: " + balance);
                    System.out.println("=========================================");
                    System.out.println();
                    break;
                case 'B':
                    System.out.println("=========================================");
                    System.out.println("Enter the amount to deposit:");
                    System.out.println("=========================================");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println();
                    break;
                case 'C':
                    System.out.println("=========================================");
                    System.out.println("Enter the amount to withdraw:");
                    System.out.println("=========================================");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println();
                    break;
                case 'D':
                    System.out.println("=========================================");
                    getPreviousTransaction();
                    System.out.println("=========================================");
                    System.out.println();
                    break;
                case 'E':
                    System.out.println("=========================================");
                    break;
                default:
                    System.out.println("Invalid operation! Please try again.");
                    break;
            }
        }while (option != 'E');
    }
}
