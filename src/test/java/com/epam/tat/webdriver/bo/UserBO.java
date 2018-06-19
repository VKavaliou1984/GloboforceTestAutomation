package com.epam.tat.webdriver.bo;

public class UserBO {

    private String userName;
    private String password;
    private String clientName;
    private String server;

    private UserBO() {
    }

    public static class Builder {
        private String userName;
        private String password;
        private String clientName;
        private String server;

        public Builder(String userName, String password) {
            this.userName = userName;
            this.password = password;
        }

        public Builder enterClientName(String clientName) {
            this.clientName = clientName;
            return this;
        }

        public Builder enterServer(String server) {
            this.server = server;
            return this;
        }

        public UserBO build() {
            UserBO userBO = new UserBO();
            userBO.userName = this.userName;
            userBO.password = this.password;
            userBO.clientName = this.clientName;
            userBO.server = this.server;
            return userBO;
        }
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
