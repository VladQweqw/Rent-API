package com.example.rent_api.User;


import com.example.rent_api.Rent.Rent;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Document
public class User {
    private String  id;

    private String name;

//    @Indexed(unique = true)
    private String email;

    private String password;
    private String phone_number;

    @DBRef(lazy = true)
    private List<Rent> rents = new ArrayList<>();

    // landlord / tenant
    private String type;



}
