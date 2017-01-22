package com.home.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Alex on 21.01.2017.
 */
@Entity
@Table(name = "USER_DETAILS")
public class UserDetails {

    private int userId;
    private String userName;
    private Date joinedDate;
    private Address address;
    private Address officeAddress;
    private String description;

    public UserDetails(){}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column (name = "USER_NAME")
    public String getUserName() {
        return "Mr/Ms " + userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "JOINED_DATE")
    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    @Embedded
    @Column(name = "ADDRESS")
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Lob
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "OFFICE_STREET_NAME")),
            @AttributeOverride(name = "city", column = @Column(name = "OFFICE_CITY_NAME")),
            @AttributeOverride(name = "country", column = @Column(name = "OFFICE_COUNTRY_NAME")),
            @AttributeOverride(name = "zipcode", column = @Column(name = "OFFICE_ZIP_CODE"))

    })
    public Address getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(Address officeAddress) {
        this.officeAddress = officeAddress;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", joinedDate=" + joinedDate +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
