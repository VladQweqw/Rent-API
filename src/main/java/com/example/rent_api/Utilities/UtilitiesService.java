package com.example.rent_api.Utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public Utilities get_by_id(String id) {
        return utilitiesRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid Utilities ID");
        });
    }

    public Utilities create_utiltiies(Utilities utilities) {
        return utilitiesRepository.save(utilities);
    }
}
