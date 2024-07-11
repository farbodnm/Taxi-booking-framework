package com.taxi.framework.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BaseUserSigninDTO {
    private String username;
    private String email;
    private String phone;
    private String password;
}