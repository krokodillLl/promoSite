package com.krokodillLl.promoSite.domain;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name = "usr_table")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Email
    private String email;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User() {}
}
