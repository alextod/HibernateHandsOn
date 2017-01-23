package com.home.model;

import javax.persistence.Embeddable;

/**
 * Created by atodorov on 1/23/2017.
 */
@Embeddable
public class Company {
    private String title;
    private String city;

    public Company(){}

    public Company(String title, String city) {
        this.title = title;
        this.city = city;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Company{" +
                "title='" + title + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
