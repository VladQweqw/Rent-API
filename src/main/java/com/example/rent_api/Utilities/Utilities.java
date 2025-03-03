package com.example.rent_api.Utilities;

import com.example.rent_api.Rent.Rent;
import com.example.rent_api.Utility.Utility;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Utilities {

    @Id
    private String  id;

    // oneToMany
    @OneToMany(mappedBy = "rent_id", cascade = CascadeType.ALL)
    private Rent rent_id;

    @OneToMany(mappedBy = "utilities", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Utility> utilities;

    public Utilities() {

    }

    public Utilities(Rent rent_id, List<Utility> utilities) {
        this.rent_id = rent_id;
        this.utilities = utilities;
    }

    @Override
    public String toString() {
        return "Utilities{" +
                "id=" + id +
                ", rent_id=" + rent_id +
                ", utilities=" + utilities +
                '}';
    }

    public void setId(String  id) {
        this.id = id;
    }

    public void setRent_id(Rent rent_id) {
        this.rent_id = rent_id;
    }

    public void setUtilities(List<Utility> utilities) {
        this.utilities = utilities;
    }

    public String  getId() {
        return id;
    }

    public Rent getRent_id() {
        return rent_id;
    }

    public List<Utility> getUtilities() {
        return utilities;
    }
}
