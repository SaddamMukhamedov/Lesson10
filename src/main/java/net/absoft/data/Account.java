package net.absoft.data;

public enum Account {
    STANDART_USER("standard_user", "secret_sauce");
    private String login;
    private String password;

    Account(String login, String password){
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }
    public String getPassword(){
        return password;
    }

    @Override
    public String toString() {
        return "Account{" +
                "login='" + login +
                "', password ='" + password + "'" +
                "}";
    }
}
