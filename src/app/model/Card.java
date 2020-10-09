package app.model;

import app.storage.SQLStorage;

import java.math.BigDecimal;


public class Card {
    private String id;
    private int number;
    private String account_id;
    private BigDecimal balance;

    public Card(String id, int number, String account_id, BigDecimal balance) {
        this.id = id;
        this.number = number;
        this.account_id = account_id;
        this.balance = balance;
    }

    public Card(String id, String account_id) {
        this.id = id;
        this.account_id = account_id;
    }

    private void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void changeBalance(SQLStorage storage, BigDecimal money) {
        setBalance(getBalance().add(money));
        storage.updateCardBalance(this);
    }
}
