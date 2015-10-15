package com.gobelinscrm14.noemiediaz.backstage;

/**
 * Created by noemiediaz on 15/10/15.
 */
public class User {

    private String pseudo;
    private String email;
    private String password;

    public User(){}

    public User(String pseudo, String email, String password) {
        this.email = email;
        this.pseudo = pseudo;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
