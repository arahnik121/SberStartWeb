package app.storage;

import app.Config;
import app.model.Account;
import app.model.Card;
import app.model.Client;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class MainClass {
    public static void main(String[] args) {
        Storage storage = Config.get().getStorage();

        Client client1 = new Client("1d664308-0887-11eb-adc1-0242ac120002", "Ivan", "Ivanov");
        Account account1 = new Account("90350cb2-0886-11eb-adc1-0242ac120002", 123321, client1.getId());
        Account account2 = new Account("12314123-0886-11eb-adc1-0242ac120002", 123532563, client1.getId());
        Card card1 = new Card("9b2661d4-0886-11eb-adc1-0242ac120002", 123123, "14aa7075-7077-49d6-a621-9d91fa65ef79", BigDecimal.valueOf(120));

        System.out.println(storage.getCard("4c0f8a96-e193-4a92-bd34-9dcfb02c276a").getBalance());
        storage.saveCard(card1);
        System.out.println(storage.getCard("9b2661d4-0886-11eb-adc1-0242ac120002").getBalance());
        card1.changeBalance((SQLStorage) storage,BigDecimal.valueOf(300));
        System.out.println(storage.getCard("9b2661d4-0886-11eb-adc1-0242ac120002").getBalance());
        List<Card> list = storage.getAllCardsSorted();

        for (Card card : list) {
            System.out.println(card.getId());
        }



        System.out.println(account1.getId().toString().equals(card1.getAccount_id().toString()));
        System.out.println("Account ID: " + account1.getId().toString() + " and Card_ID: " + card1.getId());
        System.out.println("Hello");
    }
}
