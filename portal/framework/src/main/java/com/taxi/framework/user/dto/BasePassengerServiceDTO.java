package com.taxi.framework.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
public class BasePassengerServiceDTO {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String fullName;

    private String membership;
    private String homeAddress;
}