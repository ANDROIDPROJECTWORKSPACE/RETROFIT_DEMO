package com.example.phearun.retrofitdemo;

/**
 * Created by Phearun on 1/6/2017.
 */

public class Feed {
    private String id;
    private String text;
    private String username;
    private int like;

    public Feed(){
        this.username = "Phearun";
        this.text = "Hello World!";
    }

    public Feed(String username, String text){
        this.username = username;
        this.text = text;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Feed{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", username='" + username + '\'' +
                ", like=" + like +
                '}';
    }
}
