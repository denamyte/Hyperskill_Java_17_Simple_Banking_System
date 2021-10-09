package banking;

import banking.dao.Card;
import banking.dao.CardDao;
import banking.utils.Utils;

public class CurrentStateDataFacade {
    private CardDao cardDao;
    private Card currentCard;


    public CurrentStateDataFacade(CardDao cardDao) {
        this.cardDao = cardDao;
    }

    public Card createCard() {
        String number = "";
        while (number.isEmpty() || !cardDao.numberIsUnique(number)) {
            number = Utils.createCardNumber();
        }
        final Card card = new Card(number, Utils.createPin());
        cardDao.saveCard(card);
        return card;
    }

    public Card getCurrentCard(String number, String pin) {
        final Card card = cardDao.getCard(number);
        boolean matches = card != null && pin.equals(card.getPin());
        if (matches) {
            this.currentCard = card;
            return card;
        } else {
            this.currentCard = null;
            return null;
        }
    }
}
