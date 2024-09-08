import java.util.Scanner;

class bankAccount {
    int balance;

    bankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    void deposite(int amt) {
        balance = balance + amt;
        System.out.println("DEPOSITE SUCCESSFUL!");
    }

    void withdraw(int amt) {
        balance = balance - amt;
        System.out.println("WITHDRAWAL SUCCESSFUL!");
        System.out.println("NEW BALANCE:"+balance);
    }

    double checkBalance() {
        return balance;
    }
}

class ATM{

    bankAccount account;
    ATM(bankAccount account) {
        this.account = account;
    }

    void displayMenu() {
        Scanner sc = new Scanner(System.in);
        boolean b = true;
        while (b) {
            System.out.println();
            System.out.println("1.CHECK BALANCE 2. DEPOSITE 3.WITHDRAW 4.EXIT");
            System.out.println("ENTER YOUR CHOICE:");
            int choice = sc.nextInt();

            switch (choice) {
                 case 1:
                     System.out.println("CURRENT BALANCE:"+account.checkBalance());
                        break;
                case 2:
                    System.out.println("ENTER DEPOSITE AMOUNT:");
                    int depositeAmt = sc.nextInt();
                    account.deposite(depositeAmt);
                        break;
                case 3:
                    System.out.println("ENTER WITHDRAWAL AMOUNT:");
                    int withdrawalAmt = sc.nextInt();
                    account.withdraw(withdrawalAmt);
                         break;
                case 4:
                    System.out.println("EXITING ..");
                    sc.close();
                    b = false;
                        break;
                default:
                    System.out.println("INVALID CHOICE. TRY AGAIN ..");
                        break;
            }
        }
    }
}

public class task_1 {
    public static void main(String[] args) {
        bankAccount userAc = new bankAccount(5000);
        ATM ac = new ATM(userAc);
        ac.displayMenu();
    }
}
