package com.example.rent_api.User;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin()
@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("check")
    public String check() {
        return userService.check();
    }

    @PostMapping("register")
    public User create_user(
            @RequestBody User user
    ) {
        return userService.register_user(user);
    }

    @PostMapping("login")
    public User login_user(
            @RequestBody UserLoginRequest user
    ) {
        return userService.login_user(user);
    }

    @GetMapping(path = "{id}")
    public User get_user_by_id(
            @PathVariable("id") String id
    ) {
        return userService.get_by_id(id);
    }

    @PutMapping(path = "{id}")
    public User update_user(
            @PathVariable("id") String id,
            @RequestBody User new_user,
            @RequestParam String type
    ) {
        return userService.update_user(id, new_user, type);
    }

    @PutMapping(path = "rent/{id}")
    public User add_rent_to_user(
            @PathVariable("id") String user_id,
            @RequestParam String rent_id
    ) {
        return userService.add_rent_to_user(user_id, rent_id);
    }


    @DeleteMapping(path = "rent/{id}")
    public User remove_rent_from_user(
            @PathVariable("id") String user_id,
            @RequestParam String rent_id
    ) {
        return userService.remove_rent_from_user(user_id, rent_id);
    }

    @DeleteMapping(path = "{id}")
    public void delete_user(
            @PathVariable("id") String id
    ) {
        userService.delete_user(id);
    }

}
