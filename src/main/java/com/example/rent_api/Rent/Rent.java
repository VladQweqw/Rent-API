package com.example.rent_api.Rent;

import com.example.rent_api.User.User;
import com.example.rent_api.Utilities.Utilities;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Rent {
    @Id
    private String id;

    private String name;
    private User landlord;
    private User tenant;
    private Utilities utilities;

    public Rent() {

    }


}
