package banking.dao;

public interface CardDao {

    Card getCard(String number);

    boolean numberIsUnique(String number);

    void saveCard(Card card);
}
