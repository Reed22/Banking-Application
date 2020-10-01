import javax.swing.plaf.synth.SynthSpinnerUI;
import java.util.Scanner;
import java.lang.*;

public class Main {

    public static void main(String[] args) {
        BankingAccount myBank = new BankingAccount(20);
        myBank.menu();
    }
}

class BankingAccount {
    int balance;
    int previousTransaction;

    BankingAccount(int initialDeposit){
        balance = initialDeposit;
        previousTransaction = 0;
    }
    void deposit(int amount){
        if(amount <= 0){
            System.out.println("Sorry, you can only deposit a positive amount");
        }
        else{
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    void withdraw(int amount){
        if(amount <= 0){
            System.out.println("Sorry, you can only withdraw a positive amount");
        }
        else{
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction(){
        if(previousTransaction > 0){
            System.out.println("Deposit: " + previousTransaction);
        }
        else if(previousTransaction < 0) {
            System.out.println("Withdraw: " + Math.abs(previousTransaction));
        }
        else {
            System.out.println("You have not made any transactions.");

        }
    }

    void getBalance(){
        System.out.println("Current Balance is $" + balance + ".");
    }

    void menu(){
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("A: Deposit");
        System.out.println("B: Withdraw");
        System.out.println("C: See Previous Transaction");
        System.out.println("D: Current Balance");
        System.out.println("E: Exit");

        do{
            System.out.println("Please Select An Option");
            option = scanner.next().charAt(0);
            option = Character.toLowerCase(option);
            switch(option){
                case 'a':
                    System.out.println("Enter an amount to deposit");
                    int amountDeposit = scanner.nextInt();
                    deposit(amountDeposit);
                    break;
                case 'b':
                    System.out.println("Enter an amount to withdraw");
                    int amountWithdraw = scanner.nextInt();
                    withdraw(amountWithdraw);
                    break;
                case 'c':
                    getPreviousTransaction();
                    break;
                case 'd':
                    getBalance();
                    break;
            }
        } while(option != 'e');




    }
}