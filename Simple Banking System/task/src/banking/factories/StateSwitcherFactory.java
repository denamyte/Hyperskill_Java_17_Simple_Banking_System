package banking.factories;

import banking.BankingSystemMenus;
import banking.CurrentStateDataFacade;
import banking.state.StateSwitcher;

public class StateSwitcherFactory {

    static public StateSwitcher getStateSwitcher() {
        CurrentStateDataFacade dataFacade = new CurrentStateDataFacade();
        BankingSystemMenus menus = new BankingSystemMenus(dataFacade);
        return new StateMachineFactory(menus).createStateSwitcher();
    }
}
