package app.model;

public class Account {
    private String id;
    private int number;
    private String client_id;

    public Account(String id, int number, String client_id) {
        this.id = id;
        this.number = number;
        this.client_id = client_id;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
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
}
