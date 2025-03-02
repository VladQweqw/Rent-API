package com.example.rent_api.Rent;

import org.springframework.stereotype.Service;

@Service
public class RentService {

    private final RentRepository rentRepository;

    public RentService(RentRepository rentRepository) {
        this.rentRepository = rentRepository;
    }


    public String check() {
        return "Success";
    }
}
