package banking.state;

import java.util.Map;

public class StateSwitcher {
    private final Map<String, StateTransition> transitionMap;
    private String state;

    public StateSwitcher(Map<String, StateTransition> transitionMap, String startingStateName) {
        this.transitionMap = transitionMap;
        this.state = startingStateName;
    }

    public void run() {
        while (state != null && !state.isEmpty()) {
            state = transitionMap.get(state).nextState();
        }
    }
}
