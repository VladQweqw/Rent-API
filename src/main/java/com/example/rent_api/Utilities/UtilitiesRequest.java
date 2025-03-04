package com.example.rent_api.Utilities;

import lombok.Data;

import java.util.List;

@Data
public class UtilitiesRequest {
    private String rent;
    private List<String> utilities;
}
