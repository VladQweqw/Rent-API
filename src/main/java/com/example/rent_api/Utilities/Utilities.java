package com.example.rent_api.Utilities;

import com.example.rent_api.Rent.Rent;
import com.example.rent_api.Utility.Utility;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Utilities {

    @Id
    private String  id;

    // oneToMany
    private Rent rent_id;

    private List<Utility> utilities;


}
