/*
*
* @author Samet SENTURK
* @version 2.0
* @date 20.10.2024
*
* */

import java.util.Scanner;

public class Assignment2_20240808033 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter your first name >> ");
        String first_name = scanner.nextLine();

        System.out.print("Please enter your surname >> ");
        String surname = scanner.nextLine();

        System.out.print("Please enter your starting balance >> ");
        double balance = scanner.nextDouble();

        while (balance < 0) {
            System.out.println("ERROR: Invalid Balance");

            System.out.print("Please enter your starting balance >> ");
            balance = scanner.nextDouble();
        }


        first_name = first_name.substring(0, 1).toUpperCase() + first_name.substring(1).toLowerCase();

        String selection;
        scanner.nextLine();

        do {
            selection = menu(scanner, first_name, surname);

            switch (selection.substring(0,1).toUpperCase()) {
                case "B":
                    System.out.println("Your account balance is " + balance);
                    break;

                case "W":
                    System.out.print("How much are you withdrawing? ");
                    double w = scanner.nextDouble();

                    if (w <= 0) {
                        System.out.println("ERROR: Invalid withdrawal amount");

                    } else if (balance >= w) {
                        balance = balance - w;
                        payment(w);
                    }
                    else {
                        System.out.println("ERROR: Invalid withdrawal amount");
                    }
                    scanner.nextLine();
                    break;

                case "D":
                    System.out.print("How much are you depositing? ");
                    double deposit = scanner.nextDouble();

                    if (deposit > 0) {
                        balance = balance + deposit;
                    }
                    else {
                        System.out.println("ERROR: Invalid deposit amount");
                    }
                    scanner.nextLine();
                    break;

                case "P":

                    double electricity_bill_nonformatted = 0.01 + Math.random() * 99.9;
                    double water_bill_nonformatted = 0.01 + Math.random() * 99.9;
                    double internet_bill_nonformatted = 0.01 + Math.random() * 99.9;

                    double electricity_bill = Math.round(electricity_bill_nonformatted * 100.0) / 100.0;
                    double water_bill = Math.round(water_bill_nonformatted * 100.0) / 100.0;
                    double internet_bill = Math.round(internet_bill_nonformatted * 100.0) / 100.0;

                    balance = bill(balance, electricity_bill, water_bill, internet_bill, first_name, surname);
                    break;

                case "Q":
                    System.out.println("Thank you for using our ATM. Have a nice day!");
                    return;

                default:
                    System.out.println("ERROR: Invalid Selection");
                    return;
            }
        } while (!selection.equals("Q"));
    }

    // It's been 2 days I know about functions. I hope nothing is wrong.
    // --------------------------FUNCTIONS ---------------------------//

    public static String menu(Scanner scanner, String first_name, String surname) {

        System.out.println("Hello " + first_name + " " + surname.toUpperCase());

        System.out.println("What would you like to do today? ");
        System.out.println("B to see (B)alance in your account ");
        System.out.println("W to (W)ithdraw cash ");
        System.out.println("D to (D)eposit cash ");
        System.out.println("P to (P)ay a bill ");
        System.out.println("Q to (Q)uit ");
        System.out.print("Please enter your selection >> ");
        String r = scanner.nextLine();
        return r.toUpperCase();
    }

    public static void payment(double w) {
        double[] money = {200, 100, 50, 20, 10, 5, 1, 0.5, 0.25, 0.1, 0.05, 0.01};

        System.out.println("You will receive the following: ");

        for (int i = 0; i < money.length; i++) {
            if (w >= money[i]) {
                int adet = (int) (w / money[i]);
                w = w - adet * money[i];
                System.out.println(adet + " - " + money[i]);
            }
        }
    }

    public static double bill(double balance, double electricity_bill, double water_bill, double internet_bill, String first_name, String surname) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Which of the following bills would you like to pay? ");
            System.out.println("1 - Electricity ");
            System.out.println("2 - Water");
            System.out.println("3 - Internet");
            System.out.print("Enter your selection >> ");
            String bill_selection = scanner.nextLine();

            switch (bill_selection) {
                case "1":
                    if (balance >= electricity_bill) {
                        System.out.println("Your Electricity bill is " + electricity_bill);
                        System.out.print("Do you wish to pay right now (Y/N)? ");
                        String payYN = scanner.nextLine().toUpperCase();

                        if (payYN.equals("Y")) {
                            balance -= electricity_bill;
                            System.out.println("Thank you for your payment.");
                        }
                    }
                    else {
                        System.out.println("Your Electricity bill is " + electricity_bill);
                        System.out.println("You do not have sufficient funds to pay this pill.");
                    }
                    break;
                case "2":
                    if (balance >= water_bill) {
                        System.out.println("Your Water bill is " + water_bill);
                        System.out.print("Do you wish to pay right now (Y/N)? ");
                        String payYN = scanner.nextLine().toUpperCase();

                        if (payYN.equals("Y")) {
                            balance -= water_bill;
                            System.out.println("Thank you for your payment.");
                        }
                    }
                    else {
                        System.out.println("Your Water bill is " + water_bill);
                        System.out.println("You do not have sufficient funds to pay this pill.");
                    }
                    break;
                case "3":
                    if (balance >= internet_bill) {
                        System.out.println("Your Internet bill is " + internet_bill);
                        System.out.print("Do you wish to pay right now (Y/N)? ");
                        String payYN = scanner.nextLine().toUpperCase();

                        if (payYN.equals("Y")) {
                            balance -= internet_bill;
                            System.out.println("Thank you for your payment");
                        }
                    }
                    else {
                        System.out.println("Your Internet bill is " + internet_bill);
                        System.out.println("You do not have sufficient funds to pay this pill.");
                    }
                    break;
                default:
                    System.out.println("Invalid Selection");
                    break;
            }
            return balance;
        }

}