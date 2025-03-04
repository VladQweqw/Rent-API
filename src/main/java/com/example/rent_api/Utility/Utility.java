package com.example.rent_api.Utility;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Utility {

    @Id
    private String id;

    private String name;
    private Double value;
    private Double price_per_unit;
    private String currency;


}
