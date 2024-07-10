package com.taxi.framework.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BaseUserSignupDTO {
    private String username;
    private String password;
    private Date dateOfBirth;
    private String token;
}
