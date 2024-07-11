package com.taxi.user.repository;

import com.taxi.framework.user.dao.PassengerDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface PassengerRepository extends UserRepository<PassengerDao> {
    @Modifying
    @Transactional
    @Query("UPDATE PassengerDao u SET u.signInStatus = :status WHERE u.username = :username OR u.email = :email OR u.phone = :phone")
    void updateSignInStatusByUsername(@Param("username") String username, @Param("email") String email, @Param("phone") String phone, @Param("status") String status);

    @Modifying
    @Transactional
    @Query("UPDATE PassengerDao u SET u.signInStatus = :status WHERE u.id = :id")
    void updateSignInStatusByID(@Param("id") Long id, @Param("status") String status);

    @Modifying
    @Transactional
    @Query("UPDATE PassengerDao u SET u.username = :username, u.password = :password, u.email = :email, u.phone = :phone, u.fullName = :fullName, u.membership = :membership, u.homeAddress = :homeAddress WHERE u.id = :id")
    void updateUserInfoById(@Param("id") Long id, @Param("username") String username, @Param("password") String password, @Param("email") String email, @Param("phone") String phone, @Param("fullName") String fullName, @Param("membership") String membership, @Param("homeAddress") String homeAddress);
}