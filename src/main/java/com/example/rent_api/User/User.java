package com.example.rent_api.User;


import com.example.rent_api.Rent.Rent;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Data
@Document
public class User {

    private String  id;

    private String name;

    @Indexed(unique = true)
    private String email;

    private String password;
    private String phone_number;

    private List<Rent> rents = new ArrayList<>();

    // landlord / tenant
    private String type;



}
