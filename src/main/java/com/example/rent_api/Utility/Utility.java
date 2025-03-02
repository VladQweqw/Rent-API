package com.example.rent_api.Utility;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Utility {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Double value;
    private Double price_per_unit;
    private String currency;


    public Utility() {

    }

    public Utility( String name, Double value, Double price_per_unit, String currency) {
        this.name = name;
        this.value = value;
        this.price_per_unit = price_per_unit;
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Utility{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", price_per_unit=" + price_per_unit +
                ", currency='" + currency + '\'' +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public void setPrice_per_unit(Double price_per_unit) {
        this.price_per_unit = price_per_unit;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getValue() {
        return value;
    }

    public Double getPrice_per_unit() {
        return price_per_unit;
    }

    public String getCurrency() {
        return currency;
    }
}
