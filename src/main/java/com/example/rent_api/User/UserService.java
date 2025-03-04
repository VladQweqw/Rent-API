package com.example.rent_api.User;

import com.example.rent_api.Rent.Rent;
import com.example.rent_api.Rent.RentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RentRepository rentRepository;

    public String check() {
        return "Success";
    }
    public User create_user(User user) {
        return userRepository.save(user);
    }

    public User get_by_id(String id) {
        return userRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid User ID");
        });
    }

    // not to be used when chanign rents
    public User update_user(String id, User new_user) {
        User user = userRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid User ID");
        });

        user.setEmail(new_user.getEmail());
        user.setName(new_user.getName());
        user.setPassword(new_user.getPassword());
        user.setPhone_number(new_user.getPhone_number());

        return userRepository.save(user);
    }

    public User add_rent_to_user(String userId, String rentId) {
        User user = userRepository.findById(userId).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid User ID");
        });

        Rent rent = rentRepository.findById(rentId).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid Rent ID");
        });

        user.getRents().add(rent);
        return userRepository.save(user);
    }

    public User remove_rent_from_user(String userId, String rentId) {
        User user = userRepository.findById(userId).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid User ID");
        });

        Rent rent = rentRepository.findById(rentId).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid Rent ID");
        });


        user.getRents().remove(rent);
        return userRepository.save(user);
    }

    public void delete_user(String id) {
        User user = userRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid User ID");
        });

        userRepository.delete(user);
    }
}
