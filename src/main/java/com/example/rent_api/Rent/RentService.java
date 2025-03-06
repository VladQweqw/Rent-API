package com.example.rent_api.Rent;

import com.example.rent_api.User.User;
import com.example.rent_api.User.UserRepository;
import com.example.rent_api.Utilities.UtilitiesRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RentService {
    private final RentRepository rentRepository;
    private final UserRepository userRepository;
    private final UtilitiesRepository utilitiesRepository;

    public String check() {
        return "Success";
    }

    public Rent get_by_id(String id) {
        return rentRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid Rent ID");
        });
    }

    public Rent create_rent(RentRequest request) {
        User landlord = userRepository.findById(request.getLandlord()).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid Landlord ID");
        });

        Rent rent = new Rent();

        rent.setLandlord(landlord);
        rent.setName(request.getName());

        long ms = System.currentTimeMillis();
        rent.setRent_identification(ms + "");

        if(request.getTenant() != null) {
            rent.setTenant(
                userRepository.findById(request.getTenant()).orElse(null));
        }

        if(request.getUtilities() != null) {
            rent.setUtilities(
                    utilitiesRepository.findById(request.getUtilities()).orElse(null)
            );
        }

        List<Rent> rents = landlord.getLandlord_rents();
        Rent created_rent = rentRepository.save(rent);


        rents.add(created_rent);
        landlord.setLandlord_rents(rents);
        userRepository.save(landlord);

        return created_rent;
    }

    public Rent update_rent(String id, RentRequest request) {
        Rent new_rent = rentRepository.findById(id).orElseThrow(() -> {
            throw new IllegalStateException("Invalid rent ID");
        });

        if(request.getUtilities() != null) {
            new_rent.setUtilities(
                    utilitiesRepository.findById(request.getUtilities()).orElseThrow(() -> {
                        throw new IllegalStateException("Invalid utilities ID");
                    })
            );
        }

        if(request.getLandlord() != null) {
            new_rent.setLandlord(
                    userRepository.findById(request.getLandlord()).orElseThrow(() -> {
                        throw new IllegalStateException("Invalid landlord ID");
                    })
            );
        }

        if(request.getTenant() != null) {
            new_rent.setTenant(
                    userRepository.findById(request.getTenant()).orElseThrow(() -> {
                        throw new IllegalStateException("Invalid tenant ID");

                    })
            );
        }

        if(request.getName() != null) {
            new_rent.setName(request.getName());
        }

        return rentRepository.save(new_rent);
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
