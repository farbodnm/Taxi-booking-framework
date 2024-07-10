package com.taxi.framework.user.dao;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "passengers")
public class PassengerDao extends UserDao {
    @Enumerated(EnumType.STRING)
    private MembershipType membership;

    private String homeAddress;

    @Override
    public String toString() {
        return "PassengerDao{" +
                "membership='" + membership + '\'' +
                ", homeAddress='" + homeAddress + '\'' +
                '}';
    }
}
