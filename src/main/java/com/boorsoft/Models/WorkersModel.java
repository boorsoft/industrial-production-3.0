package com.boorsoft.Models;

public class WorkersModel {
    private String login;
    private String password;
    private String accType;

    public WorkersModel(String login, String password, String accType) {
        this.login = login;
        this.password = password;
        this.accType = accType;
    }

    public WorkersModel() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }
}
