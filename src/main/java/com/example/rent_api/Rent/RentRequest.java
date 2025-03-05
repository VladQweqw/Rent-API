package com.example.rent_api.Rent;


import lombok.Data;

@Data
public class RentRequest {
    private String name;
    private String landlord;
    private String tenant;
    private String utilities;
}
