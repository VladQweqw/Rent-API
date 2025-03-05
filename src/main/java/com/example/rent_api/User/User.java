package com.example.rent_api.User;


import com.example.rent_api.Rent.Rent;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Data
@Document
public class User {
    @Id
    private String  id;

    private String name;

    @Indexed(unique = true)
    private String email;

    private String password;
    private String phone_number;

    @JsonManagedReference()
    @DBRef(lazy = true)
    private List<Rent> rents = new ArrayList<>();

    // landlord / tenant
    private String type;
}
