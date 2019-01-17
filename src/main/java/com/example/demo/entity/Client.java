package com.example.demo.entity;

import org.springframework.lang.NonNull;

import javax.persistence.*;

/**
 * Created by dsm2061 on 11/23/18.
 */
@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long clientId;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String telephoneNumber;
    @Column
    private String city;
    @Column
    private String street;
    @Column
    private Integer zipCode;

    public Client() {
    }

    public Client(String firstName, String lastName, String telephoneNumber, String city, String street, Integer zipCode) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = telephoneNumber;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

}
