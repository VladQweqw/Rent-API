package com.example.rent_api.User;

import lombok.Data;

@Data
public class UserLoginRequest {
    private String email;
    private String password;
}
