package model;

import java.io.Serializable;

public class Account implements Serializable {

    //private static final long serialVersionUID = -3334572924775156124l;
    private static final long serialVersionUID = 6529685098267757690L;

    int accountId;
    static int accountIdStatic = 1;
    String username;
    String password;
    int ordersNumber;

    public Account(String username, String password) {
        this.accountId = accountIdStatic++;
        this.username = username;
        this.password = password;
        this.ordersNumber = 0;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getOrdersNumber() {
        return ordersNumber;
    }

    public void setOrdersNumber(int ordersNumber) {
        this.ordersNumber = ordersNumber;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "account id= " + accountId + " || " +
                "username= " + username + " || " +
                "password= " + password + "\n";
    }
}
