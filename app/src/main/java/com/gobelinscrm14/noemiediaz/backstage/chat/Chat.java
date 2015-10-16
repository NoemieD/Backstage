package com.gobelinscrm14.noemiediaz.backstage.chat;

/**
 * Created by noemiediaz on 16/10/15.
 */
public class Chat {

    private String message;
    private String author;

    public Chat(){

    }

    public Chat(String message, String author) {
        this.message = message;
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
