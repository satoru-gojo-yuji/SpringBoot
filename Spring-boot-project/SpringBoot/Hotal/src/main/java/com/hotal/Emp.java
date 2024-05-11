package com.hotal;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;


@Entity
@Table(name = "user")
public class Emp {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @Column(name = "name")
    private String  name ;

    @Column(name = "email")
    private String emailid;

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
