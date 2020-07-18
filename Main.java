import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    BankAccount samplePatron = new BankAccount("290v3m", "Elias Bouchard");
    samplePatron.displayMenu();
  }
}
class BankAccount {
  int currentBalance;
  int lastTransaction;
  String accountName;
  String accountID;

  BankAccount(String aID, String aN) {
    accountID = aID;
    accountName = aN;
  }
  void deposit(int amount) {
    if (amount > 0) {
      currentBalance = currentBalance + amount;
      lastTransaction = amount;
    }
  }

  void withdrawal(int amount) {
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

  void displayMenu() {
    int options = 0;
    Scanner scanner = new Scanner(System.in);

    System.out.println("Welcome, " + accountName + "!");
    System.out.println("\n");
    System.out.println("1) Check Your Balance");
    System.out.println("2) Deposit");
    System.out.println("3) Withdraw");
    System.out.println("4) Previous Transaction Details");
    System.out.println("5) Close");


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
        int amountD = scanner.nextInt();
        deposit(amountD);
        break;
      
      case 3:
        System.out.println("\n");
        System.out.println("Enter Amount to Withdraw: ");
        int amountW = scanner.nextInt();
        deposit(amountW);
        break;

      case 4:
        System.out.println("\n");
        displayLastTransaction();
        System.out.println("\n");
        break;
      
      case 5:
        break;

      default:
        System.out.println("That option isn't valid. Try again, butterfingers.");

    }
    } while (options != 5);
    System.out.println("Thanks for using our services at the world's least secure bank. Have a good one!");
  }
}
