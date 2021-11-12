package com.h2sm.springjpahibernate.entities;

import lombok.Data;
import lombok.SneakyThrows;

import javax.persistence.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

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

    public Client(String fullName, String passport, String phoneNumber, String dateOfBirth) {
        this.fullName=fullName;
        this.passport=passport;
        this.phoneNumber=phoneNumber;
        this.date_of_birth=convert(dateOfBirth);
    }

    public Client() {

    }
    @SneakyThrows
    private Date convert(String s) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        var date = formatter.parse(s);
        return new Date(date.getTime());
    }
}
