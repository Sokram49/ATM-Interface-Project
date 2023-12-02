//Program that performs as an interface for an ATM

import java.util.Scanner;
import java.util.Date;

public class ATMInterface {

    //Item "H" (Say goodbye)
    static void goodbye() {
        System.out.println("Thank you for choosing us to serve your financial needs. Please visit us again soon!");
        System.exit(0);
    }

    //Method that makes sure the user can't withdraw an amount over the selected account balance
    private static boolean checkWithdraw(int amount, String account, int checking, int savings) {
        if (account.equals("checking")) {

            if (amount > checking) {
                System.out.println("Withdrawal denied.");
                return false;
            }
            else {
                System.out.println("Withdrawal approved!");
                return true;
            }

        }
        else {
            
            if (amount > savings) {
                System.out.println("Withdrawal denied.");
                return false;
            }
            else {
                System.out.println("Withdrawal approved!");
                return true;
            }
        }
    }

    public static void main(String[] args) {
        Date date = new Date();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Your Bank: Providing For All Your Financial Needs Today and Tomorrow."); //Item "A" (Greet)

        //Variable declarations
        int pinNumber;
        String account;
        String transactionType;
        String receipt;
        int trys = 0;
        boolean verified = false;
        String transaction;
        int transactionNum = 0;
        String withdraw = "";
        int amount = 0;
        String fastCash;
        int checking = 120;
        int savings = 65;

        //Item "B" (Ask for and verify PIN)
        while (trys < 3) {
            System.out.print("Enter PIN number: ");
            pinNumber = scanner.nextInt();

            if (pinNumber == 6565) {
                System.out.println("Thank you for verifying!");
                verified = true;
                break;
            }
            else {
                if (trys == 2) {
                    System.out.println("Too many wrong attempts, we will be keeping your card for security reasons.");
                    System.out.println("Plase contact our account services agents at 1-800-555-1234.");
                    goodbye();
                    break;
                }
                else {
                    System.out.println("Please try again.");
                }
            }
            trys++;
        }
        scanner.nextLine();

        while (verified) {

            //Item "C" (Choose account)
            while (true) {
                System.out.print("Which account would you like to select? (Checking or Savings): ");
                account = scanner.nextLine().toLowerCase();

                if (account.equals("checking")) {
                    System.out.println("Checking account selected!");
                    break;
                }
                else if (account.equals("savings")) {
                    System.out.println("Savings account selected!");
                    break;
                }
                else {
                    System.out.println("Please enter a valid account type.");
                }

            }

            //Item "D" (Ask for transaction to perform)
            while (true) {
                System.out.print("What would you like to do with the selected account? (Withdraw or Look up): ");
                transactionType = scanner.nextLine().toLowerCase();

                if (transactionType.equals("withdraw")) {
                    while (true) {
                        System.out.print("How would you like to withdraw? (Check or Cash): ");
                        withdraw = scanner.nextLine().toLowerCase();

                        if (withdraw.equals("check")) {
                            System.out.print("Please enter a withdrawal amount: ");
                            amount = scanner.nextInt();

                            //Method call and also keeps track of the account balance
                            if (checkWithdraw(amount, account, checking, savings)) {
                                if (account.equals("checking")) {
                                    checking -= amount;
                                }
                                else {
                                    savings -= amount;
                                }
                            }
                            else {
                                goodbye();
                            }

                            scanner.nextLine();
                            break;
                        }
                        else if (withdraw.equals("cash")) {
                            while (true) {
                                System.out.print("Would you like to use Fast Cash? (Yes or No): ");
                                fastCash = scanner.nextLine().toLowerCase();

                                if (fastCash.equals("yes")) {

                                    while (true) {
                                        System.out.print("Select Fast Cash option ($20, $40, $80, $100): ");
                                        amount = scanner.nextInt();

                                        if (amount == 20) {
                                            System.out.println("$20 Fast Cash selected.");

                                            if (checkWithdraw(amount, account, checking, savings)) {
                                                if (account.equals("checking")) {
                                                    checking -= amount;
                                                }
                                                else {
                                                    savings -= amount;
                                                }
                                            }
                                            else {
                                                goodbye();
                                            }

                                            scanner.nextLine();
                                            break;
                                        }
                                        else if (amount == 40) {
                                            System.out.println("$40 Fast Cash selected.");

                                            if (checkWithdraw(amount, account, checking, savings)) {
                                                if (account.equals("checking")) {
                                                    checking -= amount;
                                                }
                                                else {
                                                    savings -= amount;
                                                }
                                            }
                                            else {
                                                goodbye();
                                            }

                                            scanner.nextLine();
                                            break;
                                        }
                                        else if (amount == 80) {
                                            System.out.println("$80 Fast Cash selected.");

                                            if (checkWithdraw(amount, account, checking, savings)) {
                                                if (account.equals("checking")) {
                                                    checking -= amount;
                                                }
                                                else {
                                                    savings -= amount;
                                                }
                                            }
                                            else {
                                                goodbye();
                                            }

                                            scanner.nextLine();
                                            break;
                                        }
                                        else if (amount == 100) {
                                            System.out.println("$100 Fast Cash selected.");
                                            
                                            if (checkWithdraw(amount, account, checking, savings)) {
                                                if (account.equals("checking")) {
                                                    checking -= amount;
                                                }
                                                else {
                                                    savings -= amount;
                                                }
                                            }
                                            else {
                                                goodbye();
                                            }

                                            scanner.nextLine();
                                            break;
                                        }
                                        else {
                                            System.out.println("Please select a valid Fast Cash option.");
                                        }
                                    }
                                }
                                else if (fastCash.equals("no")) {
                                    System.out.print("Please enter a withdrawal amount: ");
                                    amount = scanner.nextInt();

                                    if (checkWithdraw(amount, account, checking, savings)) {
                                        if (account.equals("checking")) {
                                            checking -= amount;
                                        }
                                        else {
                                            savings -= amount;
                                        }
                                    }
                                    else {
                                        goodbye();
                                    }

                                    scanner.nextLine();
                                    break;
                                }
                                break;
                            }
                        }
                        else {
                            System.out.println("Please enter a valid withdraw method.");
                            continue;
                        }
                        break;
                    }
                }
                else if (transactionType.equals("look up")) {
                    System.out.println("Looking up balance for selected account.");
                    break;
                }
                else {
                    System.out.println("Please enter a valid transaction type.");
                    continue;
                }
                break;
            }

            //Item "E" (Print receipt)
            System.out.print("Would you like a receipt? (Yes or No): ");
            receipt = scanner.nextLine().toLowerCase();

            if (receipt.equals("yes")) {
                System.out.println("Here is your receipt:");
                System.out.println("--------------------------");
                System.out.println("Transaction Type: " + transactionType);

                if (transactionType.equals("look up")) {
                    amount = 0;
                }

                System.out.println("Withdrawal Amount: " + amount);

                if (account.equals("checking")) {
                    System.out.println("Account Balance: " + checking);
                }
                else {
                    System.out.println("Account Balance: " + savings);
                }

                System.out.println(date);
                System.out.println("--------------------------");
            }

            //Item "F" (Instruct to take cash / Show balance)
            if (transactionType.equals("withdraw")) {

                if (withdraw.equals("cash")) {
                System.out.println("Please take your cash amount of $" + amount);
                }
                else {
                    System.out.println("Please take your check amount of $" + amount);
                }

            }
            else {
                System.out.print("Here is the balance for the selected account: ");

                if (account.equals("checking")) {
                    System.out.println(checking);
                }
                else {
                    System.out.println(savings);
                }

            }

            //Item "G" (Allow for multiple transactions)
            if (transactionNum == 2) {
                goodbye();
            }

            System.out.print("Would you like to make another transaction? (Yes or No): ");
            transaction = scanner.nextLine().toLowerCase();

            if (transaction.equals("yes")) {
                transactionNum++;
            }
            else {
                goodbye();
            }
        }
    }
}
