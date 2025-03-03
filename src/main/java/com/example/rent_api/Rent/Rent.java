package com.example.rent_api.Rent;

import com.example.rent_api.User.User;
import com.example.rent_api.Utilities.Utilities;
import jakarta.persistence.*;

@Entity
@Table
public class Rent {
    @Id
    private String id;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User landlord;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User tenant;

    @ManyToOne()
    @JoinColumn(name = "utilities")
    private Utilities utilities;

    public Rent() {

    }

    public Rent(User landlord, User tenant, Utilities utilities) {
        this.landlord = landlord;
        this.tenant = tenant;
        this.utilities = utilities;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "id=" + id +
                ", landlord=" + landlord +
                ", tenant=" + tenant +
                ", utilities=" + utilities +
                '}';
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLandlord(User landlord) {
        this.landlord = landlord;
    }

    public void setTenant(User tenant) {
        this.tenant = tenant;
    }

    public void setUtilities(Utilities utilities) {
        this.utilities = utilities;
    }

    public String getId() {
        return id;
    }

    public User getLandlord() {
        return landlord;
    }

    public User getTenant() {
        return tenant;
    }

    public Utilities getUtilities() {
        return utilities;
    }
}
