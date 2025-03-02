package com.example.rent_api.Utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilityService {

    private final UtilityRepository utilityRepository;

    @Autowired
    UtilityService(UtilityRepository utilityRepository) {
        this.utilityRepository = utilityRepository;
    }

    public String check() {
        return "Success";
    }
}
