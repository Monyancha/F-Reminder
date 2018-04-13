package com.example.arifluthfiansyah.f_reminder.data.db.model;

import java.io.Serializable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Income extends RealmObject implements Serializable {

    @PrimaryKey
    private long id;

    private String title;

    private int price;

    private String date;

    public Income() {
        // Blank constructor
    }

    public Income(long id, String title, int price, String date) {
        this.id = id;
        this.title = title;
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
