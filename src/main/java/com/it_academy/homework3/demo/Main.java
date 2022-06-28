package com.it_academy.homework3.demo;


import com.it_academy.homework3.entity.Account;
import com.it_academy.homework3.entity.User;
import com.it_academy.homework3.services.AccountServices;
import com.it_academy.homework3.services.UsersServices;
import com.it_academy.homework3.util.PrintObjects;

import java.util.Scanner;

import static java.lang.Double.parseDouble;

public class Main {

    public static void main(String[] args) {
        int actionCode = 0;
        Scanner scanner = new Scanner(System.in);

        do {
            printMenu();
            actionCode = scanner.nextInt();
            switch (actionCode) {
                case 1:
                    System.out.println("Enter the user's name: ");
                    String nameWith = scanner.next();
                    System.out.println("Enter the user's address: ");
                    String address = scanner.next();
                    User userWithAddress = new User(nameWith, address);
                    UsersServices.saveUser(userWithAddress);
                    break;
                case 2:
                    System.out.println("Enter the user's name: ");
                    String name = scanner.next();
                    User user = new User(name);
                    UsersServices.saveUser(user);
                    break;
                case 3:
                    PrintObjects.printObjects(UsersServices.readAllUsers());
                    System.out.println("Enter the user's ID: ");
                    int id = scanner.nextInt();
                    System.out.println("Enter balance: ");
                    double balance = parseDouble(scanner.next());
                    System.out.println("Enter currency");
                    String currency = scanner.next();
                    Account account = new Account(id, balance);
                    AccountServices.saveNewAccount(account);
                    break;
                case 4:
                    PrintObjects.printObjects(AccountServices.readAllAccounts());
                    System.out.println("Enter account ID: ");
                    int accountId = scanner.nextInt();
                    System.out.println("Enter amount: ");
                    double amount = parseDouble(scanner.next());
                    AccountServices.accountReplenishment(accountId, amount);
                    break;
                case 5:
                    PrintObjects.printObjects(AccountServices.readAllAccounts());
                    System.out.println("Enter account ID: ");
                    int accountId_ = scanner.nextInt();
                    System.out.println("Enter amount: ");
                    double amount_ = parseDouble(scanner.next());
                    AccountServices.accountWithdrawal(accountId_, amount_);
                    break;
            }

        }
        while (actionCode != 6);
    }

    private static void printMenu() {
        System.out.println("Please select an action");
        System.out.println("1 - add user with address");
        System.out.println("2 - add user without address");
        System.out.println("3 - add an account to a user");
        System.out.println("4 - replenishment of an existing account");
        System.out.println("5 - withdrawing funds from an existing account");
        System.out.println("6 - quit");
    }
}
