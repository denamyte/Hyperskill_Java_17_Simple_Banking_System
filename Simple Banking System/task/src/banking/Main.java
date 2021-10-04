package banking;

import banking.factories.StateSwitcherFactory;
import banking.state.StateSwitcher;

public class Main {
    public static void main(String[] args) {
        StateSwitcher switcher = StateSwitcherFactory.getStateSwitcher();
        switcher.run();
    }
}