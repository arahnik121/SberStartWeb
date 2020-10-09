package app.storage;

import app.model.Account;
import app.model.Card;
import app.model.Client;

import java.util.List;

public interface Storage {

    void clearCards();

    void saveCard(Card c);

    void updateCardBalance(Card c);

    Card getCard(String id);

    List<Card> getAllCardsSorted();

    void deleteCard(String id);

    int getNumberOfCards();

    void saveClient(Client a);

    void updateClient(Client a);

    Client getClient(String id);

    List<Client> getAllClientsSorted();

    void deleteClient(String id);

    void saveAccount(Account a);

    Account getAccount(String id);

    List<Account> getAllAccountsSorted();

    void deleteAccount(String id);
}
