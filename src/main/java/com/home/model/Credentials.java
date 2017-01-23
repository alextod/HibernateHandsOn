package com.home.model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by atodorov on 1/23/2017.
 */
@Entity
@Embeddable
public class Credentials {
    @Id
    @GeneratedValue
    private int credId;
    private String login;
    private String password;

    public Credentials(){}

    public Credentials(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public int getCredId() {
        return credId;
    }

    public void setCredId(int credId) {
        this.credId = credId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Credentials{" +
                "credId=" + credId +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
