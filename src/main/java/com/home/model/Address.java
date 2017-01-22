package com.home.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by Alex on 23.01.2017.
 */
@Embeddable
public class Address {
    private String street;
    private String city;
    private String country;
    private String zipcode;

    public Address() {}

    public Address(String street, String city, String country, String zipcode) {
        this.street = street;
        this.city = city;
        this.country = country;
        this.zipcode = zipcode;
    }

    @Column(name = "STREET_NAME")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Column(name = "CITY_NAME")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "COUNTRY_NAME")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name = "ZIP_CODE")
    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
