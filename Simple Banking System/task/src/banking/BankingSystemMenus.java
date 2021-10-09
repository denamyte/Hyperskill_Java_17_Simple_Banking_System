package banking;

import banking.dao.Card;

import java.util.Scanner;

/**
 * Contains all menus for the Banking System CLI interface
 * and abstract data layer invocations
 */
public class BankingSystemMenus {

    private final Scanner scanner = new Scanner(System.in);
    private final CurrentStateDataFacade dataFacade;

    public BankingSystemMenus(CurrentStateDataFacade dataFacade) {
        this.dataFacade = dataFacade;
    }

    public int mainMenu() {
        System.out.println("\n1. Create an account\n" +
                                   "2. Log into account\n" +
                                   "0. Exit");
        return userChoice();
    }

    public int createCard() {
        Card card = dataFacade.createCard();
        System.out.printf("\nYour card has been created\n" +
                                  "Your card number:\n" +
                                  "%s\n" +
                                  "Your card PIN:\n" +
                                  "%s\n", card.getNumber(), card.getPin());
        return 0;
    }

    public int logIntoAccount() {
        System.out.println("\nEnter your card number:");
        final String number = scanner.nextLine();
        System.out.println("Enter your PIN:");
        final String pin = scanner.nextLine();

        return dataFacade.getCurrentCard(number, pin) == null ? 0 : 1;
    }

    public int wrongCard() {
        System.out.println("\nWrong card number or PIN!");
        return 0;
    }

    public int loggedIn() {
        System.out.println("\nYou have successfully logged in!");
        return 0;
    }

    public int accountMenu() {
        System.out.println("\n1. Balance\n" +
                                   "2. Log out\n" +
                                   "0. Exit");
        return userChoice();
    }

    public int balance() {
        System.out.println("\nBalance: 0");
        return 0;
    }

    public int logOut() {
        System.out.println("\nYou have successfully logged out!");
        return 0;
    }

    private int userChoice() {
        return Integer.parseInt(scanner.nextLine());
    }
}
