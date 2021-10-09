package banking.factories;

import banking.BankingSystemMenus;
import banking.CurrentStateDataFacade;
import banking.dao.CardDao;
import banking.dao.impl.memory.MemoryCardDao;
import banking.state.StateSwitcher;

public class StateSwitcherFactory {

    static public StateSwitcher getMemoryStateSwitcher() {
        CardDao cardDao = new MemoryCardDao();
        return getStateSwitcher(cardDao);
    }

    static public StateSwitcher getStateSwitcher(CardDao cardDao) {
        CurrentStateDataFacade dataFacade = new CurrentStateDataFacade(cardDao);
        BankingSystemMenus menus = new BankingSystemMenus(dataFacade);
        return new StateMachineFactory(menus).createStateSwitcher();
    }
}
