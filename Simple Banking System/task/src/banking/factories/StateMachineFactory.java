package banking.factories;

import banking.BankingSystemMenus;
import banking.state.StateSwitcher;
import banking.state.StateTransition;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class StateMachineFactory {

    private final BankingSystemMenus menus;

    enum State {
        MAIN_MENU,

        CREATE_ACCOUNT,
        LOG_INTO_ACCOUNT,

        EXIT
    }

    public StateMachineFactory(BankingSystemMenus menus) {
        this.menus = menus;
    }

    StateSwitcher createStateSwitcher() {
        return new StateSwitcher(createTransitionMap(), State.MAIN_MENU.name());
    }

    private Map<String, StateTransition> createTransitionMap() {
        List<StateTransition> transList = List.of(
                new StateTransition(State.MAIN_MENU.name(),
                                    Map.of(1, State.CREATE_ACCOUNT.name(),
                                           2, State.LOG_INTO_ACCOUNT.name(),
                                           0, State.EXIT.name()),
                                    menus::mainMenu
                ),

                new StateTransition(State.CREATE_ACCOUNT.name(),
                                    Map.of(0, State.MAIN_MENU.name()),
                                    menus::createCard
                ),
                new StateTransition(State.LOG_INTO_ACCOUNT.name(),
                                    Map.of(0, State.MAIN_MENU.name()),
                                    () -> {
                                        System.out.println("\nUnder construction");
                                        return 0;
                                    }
                ),

                // TODO: 10/4/21 Other StateTransition instances go here

                new StateTransition(State.EXIT.name(),
                                    Map.of(0, ""),
                                    () -> 0
                )
        );
        return Collections.unmodifiableMap(
                transList.stream().collect(Collectors.toMap(StateTransition::getStateName, s -> s)));
    }


}
