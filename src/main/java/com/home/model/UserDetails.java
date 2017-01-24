package com.home.model;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.*;

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
    private Collection<Company> companies = new ArrayList<>();
    private String description;
    private Vehicle vehicle;
    private Collection<Credentials> credentials = new ArrayList<>();

    public UserDetails(){}

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "USER_ID")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column (name = "USER_NAME")
    public String getUserName() {
        return userName;
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

    @ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(name = "USER_COMPANIES",
        joinColumns = @JoinColumn(name = "USER_ID")
    )
//    @GenericGenerator(name = "sequence-gen", strategy = "sequence")
//    @CollectionId(columns = {@Column(name = "COMPANY_ID")}, type = @Type(type = "long"), generator = "sequence-gen")
    public Collection<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(Collection<Company> companies) {
        this.companies = companies;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "VEHICLE_ID")
    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinTable is commented out due to mappedBy attribute in @OneToMany annotation
//    @JoinTable(joinColumns = @JoinColumn(name = "USER_ID"),
//        inverseJoinColumns = @JoinColumn(name = "CRED_ID")
//    )
    public Collection<Credentials> getCredentials() {
        return credentials;
    }

    public void setCredentials(Collection<Credentials> credentials) {
        this.credentials = credentials;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", joinedDate=" + joinedDate +
                ", address=" + address +
                ", officeAddress=" + officeAddress +
                ", companies=" + companies +
                ", description='" + description + '\'' +
                ", vehicle=" + vehicle +
                ", credentials=" + credentials +
                '}';
    }
}
