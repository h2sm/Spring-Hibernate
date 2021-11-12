package com.h2sm.springjpahibernate.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name="client")
@Data
public class Client {
    @Id
    @GeneratedValue
    @Column(name = "client_id")
    private int id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "passport")
    private String passport;
    @Column(name = "tel_name")
    private String phoneNumber;
    @Column(name = "date_of_birth")
    private Date date_of_birth;

    public Client(String fullName, String passport, String phoneNumber, Date dateOfBirth) {
        this.fullName=fullName;
        this.passport=passport;
        this.phoneNumber=phoneNumber;
        this.date_of_birth=dateOfBirth;
    }

    public Client() {

    }

    public Client updateClient(String fullName, String passport, String phoneNumber, Date dateOfBirth){
        setPhoneNumber(phoneNumber);
        setDate_of_birth(dateOfBirth);
        setFullName(fullName);
        setPassport(passport);
        return this;
    }
}
