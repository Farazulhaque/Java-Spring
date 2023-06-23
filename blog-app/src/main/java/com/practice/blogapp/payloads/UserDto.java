package com.practice.blogapp.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private int id;

    @NotEmpty
    @Size(min = 5, message = "Username is not Valid!!!")
    private String name;

    @Email(message = "Email Address is not Valid!!!")
    @NotNull
    private String email;

    @NotEmpty
    @Size(min = 3, max = 10, message = "Password must be minimum of 3 chars and maximum of 10 chars")
    private String password;

    @NotEmpty
    private String about;
}
