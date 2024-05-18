import java.util.*;

class BankAccount {
    private float balance;

    public float getBalance() {
        return balance;
    }

    public void deposit(float amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(float amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}


class ATM{
    BankAccount account;
    private int pin = 7052;

    ATM(BankAccount account){
        this.account = account;
        authenticateUser();
    }

    private void authenticateUser(){
        boolean authenticated = false;

        while(!authenticated){
            System.out.print("Enter a pin: ");
            Scanner sc = new Scanner(System.in);
            int enteredPin = sc.nextInt();
    
            if(enteredPin == pin){
                authenticated = true;
                System.out.println();
                menu();
            }
            else{
                System.out.println("Invalid pin. Please try again");
            }
        }
    }

    private void menu(){
        System.out.println("Enter a choice: ");
        System.out.println("1. Check Balace");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        if(choice == 1){
            System.out.println();
            checkBalance();
        }
        else if(choice == 2){
            System.out.println();
            depositMoney();
        }
        else if(choice == 3){
            System.out.println();
            withdrawMoney();
        }
        else if(choice == 4){
            return;
        }
        else{
            System.out.println("Enter a valid choice");
            menu();
        }
        System.out.println();
    }

    private void checkBalance(){
        System.out.println("Balance: " + account.getBalance());
        System.out.println();
        menu();
    }

    private void depositMoney(){
        System.out.println("Enter Amount: ");
        Scanner sc = new Scanner(System.in);
        Float amount = sc.nextFloat();
        account.deposit(amount);
        System.out.println("Your money has been successfully deposited.");
        System.out.println();
        menu();
    }

    private void withdrawMoney(){
        System.out.println("Enter Amount to withdraw: ");
        Scanner sc = new Scanner(System.in);
        Float amount = sc.nextFloat();

        if(account.withdraw(amount)){
            System.out.println("Your money withdrawl successfully .");
        }
        else{
            System.out.println("Insufficient Balance");
        }
        System.out.println();
        menu();
    }
}

public class atmMachine {
    public static void main(String args[]){
        BankAccount myAcc = new BankAccount();

        ATM ob = new ATM(myAcc);
    }
}
