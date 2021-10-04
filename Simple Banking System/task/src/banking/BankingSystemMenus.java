package banking;

import banking.dao.Card;

import java.util.Scanner;

/**
 * Contains all menus for the Banking System CLI interface
 * and abstract data layer invocations
 */
public class BankingSystemMenus {

    private static final Scanner scanner = new Scanner(System.in);
    private CurrentStateDataFacade dataFacade;

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

    private int userChoice() {
        return Integer.parseInt(scanner.nextLine());
    }
}
