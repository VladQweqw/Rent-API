package com.example.rent_api.Utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

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

    public Utility create_utility(Utility utility) {
        return utilityRepository.save(utility);
    }

    public Utility get_utility_by_id(String id) {
        return utilityRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid Utility ID");
        });
    }

    public Utility update_utility(String id, Utility updated) {
        Utility utility = utilityRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid Utility ID");
        });

        utility.setCurrency(updated.getCurrency());
        utility.setName(updated.getName());
        utility.setValue(updated.getValue());
        utility.setPrice_per_unit(updated.getPrice_per_unit());


        return utilityRepository.save(utility);
    }
}
