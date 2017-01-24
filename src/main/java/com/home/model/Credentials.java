package com.home.model;

import javax.persistence.*;

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
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private UserDetails user;

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

    public UserDetails getUser() {
        return user;
    }

    public void setUser(UserDetails user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Credentials{" +
                "credId=" + credId +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", user=" + user.getUserId() +
                '}';
    }
}
