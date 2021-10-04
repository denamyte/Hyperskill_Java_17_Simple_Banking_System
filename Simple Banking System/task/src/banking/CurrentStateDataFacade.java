package banking;

import banking.dao.Card;
import banking.utils.Utils;

import java.util.LinkedHashMap;
import java.util.Map;

public class CurrentStateDataFacade {

    private final Map<String, Card> cardMap = new LinkedHashMap<>();

    // TODO: 10/4/21 Dao interfaces go into this constructor
    public CurrentStateDataFacade() {
    }

    public Card createCard() {
        String number = "";
        while (number.isEmpty() || cardMap.containsKey(number)) {
            number = Utils.createCardNumber();
        }
        return new Card(number, Utils.createPin());
    }
}
