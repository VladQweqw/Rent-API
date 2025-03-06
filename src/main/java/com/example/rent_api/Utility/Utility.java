package com.example.rent_api.Utility;

import com.example.rent_api.Utilities.Utilities;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.CrossOrigin;


@Data
@Document
public class Utility {

    @Id
    private String id;

    private String name;
    private Double value;
    private String units;
    private Integer index;
    private Double price_per_unit;
    private String currency;


}
