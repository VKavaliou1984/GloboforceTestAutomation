package com.epam.tat.webdriver.bo;

public class UserBO {

    private String userName;
    private String password;
    private String clientName;
    private String server;

    private UserBO() {
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

    public static class Builder {
        private String userName;
        private String password;
        private String clientName;
        private String server;

        public Builder(String userName, String password, String server) {
            this.userName = userName;
            this.password = password;
            this.server = server;
        }

        public Builder enterClientName(String clientName) {
            this.clientName = clientName;
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
}
