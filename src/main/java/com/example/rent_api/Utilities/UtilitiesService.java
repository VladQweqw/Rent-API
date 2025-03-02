package com.example.rent_api.Utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilitiesService {

    private final UtilitiesRepository utilitiesRepository;

    @Autowired
    public UtilitiesService(UtilitiesRepository utilitiesRepository) {
        this.utilitiesRepository = utilitiesRepository;
    }

    public String check() {
        return "Success";
    }
}
