import java.util.*;
import java.text.*;

class Main {
  public static void main(String[] args) {
    BankAccount samplePatron = new BankAccount("290v3m", "Elias Bouchard", 8.96);
    samplePatron.displayMenu();
  }
}
class BankAccount {
  double currentBalance;
  double lastTransaction;
  double accountRate;
  String accountName;
  String accountID;
  NumberFormat us = NumberFormat.getCurrencyInstance(Locale.US);

  BankAccount(String aID, String aN, double aR) {
    accountID = aID;
    accountName = aN;
    accountRate = aR;
  }
  void deposit(double amount) {
    if (amount > 0) {
      currentBalance = currentBalance + amount;
      lastTransaction = amount;
    }
  }

  void withdrawal(double amount) {
    if ((amount > 0) & ((currentBalance - amount) > 0)) {
      currentBalance = currentBalance - amount;
      lastTransaction = -amount;
    }
  }

  void displayLastTransaction() {
    if (lastTransaction > 0) {
      System.out.println("Deposited: " + lastTransaction);
    } else if (lastTransaction < 0) {
      System.out.println("Withdrawn: " + lastTransaction);
    } else {
      System.out.println("You didn't do anything! Changed your mind?");
    }
  }

  public double calculateSavings(double principle, int years, double rate) {
    double totalAmount = 0;
    totalAmount = principle * ((1 + rate / 100) * (1 + rate / 100) * (1 + rate / 100));
    return totalAmount;
  }

  void displayMenu() {
    int options = 0;
    Scanner scanner = new Scanner(System.in);

    System.out.println("Welcome, " + accountName + "!");
    System.out.println("\n");
    System.out.println("1) Check Your Balance");
    System.out.println("2) Deposit");
    System.out.println("3) Withdraw");
    System.out.println("4) Previous Transaction Details");
    System.out.println("5) Calculate Current Compound Interest");
    System.out.println("6) Close");


    do {
      System.out.println("Please Enter an Option: ");
      options = scanner.nextInt();

      switch (options) {
      case 1:
        System.out.println("\n");
        System.out.println("Your Current Balance is $" + currentBalance + ".");
        break;

      case 2:
        System.out.println("\n");
        System.out.println("Enter Amount to Deposit: ");
        double amountD = scanner.nextDouble();
        deposit(amountD);
        break;
      
      case 3:
        System.out.println("\n");
        System.out.println("Enter Amount to Withdraw: ");
        double amountW = scanner.nextDouble();
        deposit(amountW);
        break;

      case 4:
        System.out.println("\n");
        displayLastTransaction();
        System.out.println("\n");
        break;
      
      case 5:
        System.out.println("\n");
        System.out.println("Welcome to the Compound Interest Calculator! This nifty widget lets you see how much money could be in your specific account after a certain amount of years!");
        System.out.println("(Don't worry, we already know the amount in your account and your savings rate!)");
        System.out.println("\n");
        System.out.println("Enter Time in Years: ");
        int yearsCI = scanner.nextInt();
        System.out.println("The amount in your account after " + yearsCI + " years will be: ");
        System.out.println(us.format(calculateSavings(currentBalance, yearsCI, accountRate)));
        break;
      
      case 6:
        break;

      default:
        System.out.println("That option isn't valid. Try again, butterfingers.");

    }
    } while (options != 6);
    System.out.println("Thanks for using our services at the world's least secure bank. Have a good one!");
  }
}
