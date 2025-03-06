package com.example.rent_api.Rent;

import com.example.rent_api.User.User;
import com.example.rent_api.Utilities.Utilities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document
public class Rent {
    @Id
    private String id;

    private String name;
    private String rent_identification = "";

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonBackReference("landlordReference")
    @DBRef(lazy = true)
    private User landlord;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonBackReference("tenantReference")
    @DBRef(lazy = true)
    private User tenant;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonBackReference("utilitiesReference")
    @DBRef(lazy = true)
    private Utilities utilities;

}
