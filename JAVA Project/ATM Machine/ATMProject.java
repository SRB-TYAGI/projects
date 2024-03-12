import java.util.Scanner;

class Account {
    public int accountNumber;
    public int pin;
    public double balance;

    public Account(int accountNumber, int pin, double balance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
    }

    public boolean validatePin(int pin) {
        return this.pin == pin;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public void deposit(double amount) {
        balance += amount;
    }
}



public class ATMProject {
    public static void showMenu(Account[]arr,int index) {
        System.out.println("\nATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Exit");

        System.out.print("Enter your choice: ");
        Scanner scanner  = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                checkBalance(arr,index);
                break;
            case 2:
                withdraw(arr,index);
                break;
            case 3:
                deposit(arr,index);
                break;
            case 4:
                exit();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                
                showMenu(arr,index);
                break;
        }
    }

    private static void checkBalance(Account[]arr,int index) {
        double balance = arr[index].getBalance();
        System.out.println("Your balance is: Rs" + balance);
        showMenu(arr,index);
    }

    private static void withdraw(Account[]arr,int index) {
        System.out.print("Enter the amount to withdraw: ");
        Scanner scanner = new Scanner(System.in);
        double amount = scanner.nextDouble();
       
            if(amount%100 == 0){

        if (amount > arr[index].getBalance()) {
            System.out.println("Insufficient Balance. Please try again.");
        } else {
            arr[index].withdraw(amount);
            System.out.println("Amount withdraw: Rs" + amount);
        }

        showMenu(arr,index);
    }
    else{
        System.out.println("Invalid input: Please enter multiple of 100:");
    }
    showMenu(arr,index);
}


    private static void deposit(Account[]arr,int index) {
        Scanner scanner =new Scanner(System.in);
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();
        if(amount%100 == 0){ 
            arr[index].deposit(amount);
            System.out.println("Amount deposited: Rs" + amount);

        showMenu(arr,index);
    }
    else{
        System.out.println("Invalid input: Please enter money multiple of 100:");
    }
    showMenu(arr,index);
}

    private static void exit() {
        System.out.println();
        System.out.println("Thank you for using Indian Bank ATM!");
        System.out.println("Have a nice day!");
        System.out.println();
        System.exit(0);
    }
    public static void main(String[] args) {
        Account account = new Account(123456, 1231, 2000.0);
        Account account2 = new Account(123457, 1232, 1000.0);
        Account account3 = new Account(123458, 1233, 3000.0);
        Account account4 = new Account(123459, 1234, 2000.1);
        Account [] arr = new Account[4];
        arr[0] = account;
        arr[1] = account2;
        arr[2] = account3;
        arr[3] = account4;
        System.out.println();
        System.out.println("Welcome to the Indian Bank ATM!");
        System.out.println();

        int i=0;

        Boolean correctAcc = false;
        while(!correctAcc){
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your Account Number : ");
            int acc = scanner.nextInt();
            for(i=0;i<arr.length;++i){ 
                if(arr[i].accountNumber == acc){  
                    correctAcc = true;
                    break;
                }
            }  
            if(correctAcc == true){
                break;
            }
            else{
                System.out.println("Invalid Account number:Please enter valid Account number");
            }
        }

        Boolean correctPin = false;
        while(!correctPin){
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your PIN: ");
            int pin = scanner.nextInt();

            if(arr[i].pin == pin){
                correctPin = true;
                break;
            }
            
            System.out.println("Invalid PIN. Please try again.");
        }

        showMenu(arr,i);
            
        
    }
}


