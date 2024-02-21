package com.blog.payload;

import lombok.Data;

@Data
public class UserDto {
    private  long id;
    private String name;
    private String username;
    private String password;
    private String email;
    private String roles;
}
