package com.blog.payload;

import lombok.Data;

@Data
public class SigninDto {
    private String UsernameOrEmail;
    private  String Password;
}
