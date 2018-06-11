package com.epam.tat.webdriver.bo;

public class UserBO {

    private String userName;
    private String password;
    private String clientName;
    private String server;

    public UserBO(String userName, String password, String clientName, String server) {
        this.userName = userName;
        this.password = password;
        this.clientName = clientName;
        this.server = server;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getClientName() {
        return clientName;
    }

    public String getServer() {
        return server;
    }
}
