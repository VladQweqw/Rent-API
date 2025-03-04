package com.example.rent_api.Rent;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class RentService {

    private final RentRepository rentRepository;

    public RentService(RentRepository rentRepository) {
        this.rentRepository = rentRepository;
    }


    public String check() {
        return "Success";
    }

    public Rent get_by_id(String id) {
        return rentRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid Rent ID");
        });
    }

    public Rent create_rent(Rent rent) {

        return rentRepository.save(rent);
    }

    public Rent update_rent(String id, Rent rent) {
        Rent new_rent = rentRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid Rent ID");
        });

        new_rent.setLandlord(rent.getLandlord());
        new_rent.setTenant(rent.getTenant());
        new_rent.setUtilities(rent.getUtilities());

        return rentRepository.save(rent);
    }

    public void delete_rent(String id) {
        Optional<Rent> exists = rentRepository.findById(id);

        if(exists.isPresent()) {
            rentRepository.deleteById(id);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid Rent ID");
        }
    }
}
