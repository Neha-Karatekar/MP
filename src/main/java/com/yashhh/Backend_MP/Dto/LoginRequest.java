package com.yashhh.Backend_MP.Dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
