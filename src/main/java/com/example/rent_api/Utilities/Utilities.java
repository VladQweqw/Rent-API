package com.example.rent_api.Utilities;

import com.example.rent_api.Rent.Rent;
import com.example.rent_api.Utility.Utility;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Utilities {
    @Id
    private String  id;

    @DBRef(lazy = true)
    private Rent rent;

    @DBRef(lazy = true)
    private List<Utility> utilities;


}
