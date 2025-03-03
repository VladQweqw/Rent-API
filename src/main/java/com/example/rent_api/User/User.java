package com.example.rent_api.User;


import com.example.rent_api.Rent.Rent;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Table
@Entity
public class User {
    @Id
    private String  id;

    private String name;
    private String email;
    @Transient
    private String password;
    private String phone_number;

    @OneToMany(mappedBy = "rents" , cascade = CascadeType.ALL)
    private List<Rent> rents = new ArrayList<>();

    // landlord / tenant
    private String type;

    public User() {

    }

    public User(String name, String email, String password, String phone_number, List<Rent> rents, String type) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone_number = phone_number;
        this.rents = rents;
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", rents=" + rents +
                ", type='" + type + '\'' +
                '}';
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setRents(List<Rent> rents) {
        this.rents = rents;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public List<Rent> getRents() {
        return rents;
    }

    public String getType() {
        return type;
    }
}
