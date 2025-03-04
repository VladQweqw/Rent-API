package com.example.rent_api.Utilities;

import com.example.rent_api.Rent.RentRepository;
import com.example.rent_api.Utility.Utility;
import com.example.rent_api.Utility.UtilityRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UtilitiesService {
    private final UtilitiesRepository utilitiesRepository;
    private final UtilityRepository utilityRepository;
    private final RentRepository rentRepository;

    public String check() {
        return "Success";
    }

    public Utilities get_by_id(String id) {
        return utilitiesRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid Utilities ID");
        });
    }

    public Utilities create_utiltiies(UtilitiesRequest request) {
        Utilities utilities = new Utilities();
        List<Utility> utils = new ArrayList<>();

        utilities.setRent(
            rentRepository.findById(request.getRent()).orElseThrow(() -> {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid Rent ID");
            })
        );

        request.getUtilities().forEach((String util) -> {
            utils.add(
              utilityRepository.findById(util).orElseThrow(() -> {
                  throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid Utility ID");
              })
            );
        });

        utilities.setUtilities(utils);


        return utilitiesRepository.save(utilities);
    }
}
