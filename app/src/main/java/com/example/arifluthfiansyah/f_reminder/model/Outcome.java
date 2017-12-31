package com.example.arifluthfiansyah.f_reminder.model;

import java.io.Serializable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Arif Luthfiansyah on 11-Dec-17.
 */

public class Outcome extends RealmObject implements Serializable{

    @PrimaryKey
    private long id;

    private String title;

    private String content;

    private int price;

    private String date;

    public Outcome() {
        // Blank constructor
    }

    public Outcome(long id, String title, String content, int price, String date) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.price = price;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
