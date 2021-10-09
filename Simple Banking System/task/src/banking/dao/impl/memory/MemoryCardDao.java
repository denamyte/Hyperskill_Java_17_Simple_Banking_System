package banking.dao.impl.memory;

import banking.dao.Card;
import banking.dao.CardDao;

import java.util.LinkedHashMap;
import java.util.Map;

public class MemoryCardDao implements CardDao {

    private final Map<String, Card> cardMap = new LinkedHashMap<>();

    @Override
    public Card getCard(String number) {
        return cardMap.get(number);
    }

    @Override
    public boolean numberIsUnique(String number) {
        return !cardMap.containsKey(number);
    }

    @Override
    public void saveCard(Card card) {
        cardMap.put(card.getNumber(), card);
    }
}
