package com.example.rent_api.User;

import com.example.rent_api.Rent.Rent;
import com.example.rent_api.Rent.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RentRepository rentRepository;

    public String check() {
        return "Success";
    }

    @Autowired
    public UserService(UserRepository userRepository, RentRepository rent) {
        this.rentRepository = rent;
        this.userRepository = userRepository;
    }

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public Boolean check_password(String encrypted, String decrypted) {

        return encoder.matches(decrypted, encrypted);
    }

    public User register_user(User user) {
        if(user.getEmail() == null) {
            throw new IllegalStateException("Invalid email");
        }

        String encrypted = encoder.encode(user.getPassword()) ;
        user.setPassword(encrypted);

        return userRepository.save(user);
    }

    public User login_user(UserLoginRequest credentials) {
        User found = userRepository.findbyEmail(credentials.getEmail()).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid User ID");
        });


        if(check_password(found.getPassword(), credentials.getPassword())) {
            return found;
        }else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Wrong password");
        }
    }


    public User get_by_id(String id) {
        return userRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid User ID");
        });
    }

    // not to be used when chanign rents
    public User update_user(String id, User new_user, String type) {
        User user = userRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid User ID");
        });

        if(!type.isEmpty()) {
            user.setType(type);
        }else {
            user.setEmail(new_user.getEmail());
            user.setName(new_user.getName());
            user.setPassword(new_user.getPassword());
            user.setPhone_number(new_user.getPhone_number());
        }


        return userRepository.save(user);
    }

    public User add_rent_to_user(String userId, String rentId) {
        User user = userRepository.findById(userId).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid User ID");
        });

        Rent rent = rentRepository.findById(rentId).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid Rent ID");
        });


        if(user.getType().equals("tenant")) {
            user.getTenant_rents().add(rent);
        }else {
            user.getLandlord_rents().add(rent);
        }

        return userRepository.save(user);
    }

    public User remove_rent_from_user(String userId, String rentId) {
        User user = userRepository.findById(userId).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid User ID");
        });

        Rent rent = rentRepository.findById(rentId).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid Rent ID");
        });

        if(user.getType().equals("tenant")) {
            user.getTenant_rents().remove(rent);
        }else {
            user.getLandlord_rents().remove(rent);
        }

        return userRepository.save(user);
    }

    public void delete_user(String id) {
        User user = userRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid User ID");
        });

        userRepository.delete(user);
    }
}
