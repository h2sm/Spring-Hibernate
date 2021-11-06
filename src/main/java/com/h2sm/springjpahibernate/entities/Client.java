package com.h2sm.springjpahibernate.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name="client")
@Data
public class Client {
    @Id
    @GeneratedValue
    private int id;
    private String full_name;
    private String passport;
    private String tel_name;
    private Date date_of_birth;
}
