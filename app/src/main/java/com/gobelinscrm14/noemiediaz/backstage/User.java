package com.gobelinscrm14.noemiediaz.backstage;

import android.graphics.Color;

import java.util.Random;

public class User {

    private String pseudo;
    private String email;
    private String password;

    Random rnd = new Random();
    private int color;

    public User(){}

    public User(String pseudo, String email, String password) {
        this.email = email;
        this.pseudo = pseudo;
        this.password = password;
        color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
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

    public int getColor() {
        return color;
    }
}
